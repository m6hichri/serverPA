package com.annuel.project.server.firebase;

import com.annuel.project.server.entites.Compteur;
import com.annuel.project.server.model.Matches;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MatchService {

    public void saveMatches(Matches matches) throws ExecutionException, InterruptedException {

        Compteur.modifyDate(matches.getMatchDate());

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("NbaMatches")
                .document(Compteur.nbMatches+" : " + Compteur.nbMatchesMemeDate).set(matches);

        Compteur.nbMatchesMemeDate ++;

    }



    public ResponseEntity<?> getMatches() throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        int x =1, y=1;
        Compteur.listMatchs.clear();

        while(x<Compteur.nbMatchesTotal)
        {
            DocumentReference documentReference = dbFirestore.collection("NbaMatches").document(x+" : "+y);
            ApiFuture<DocumentSnapshot> future1 = documentReference.get();
            DocumentSnapshot documentSnapshot = future1.get();

            Matches matches = null;

            if(documentSnapshot.exists())
            {
                matches = documentSnapshot.toObject(Matches.class);
                Compteur.listMatchs.add(matches);
                y++;
            }
            else {
                y=1;
                x++;
            }
        }

        x=1;
        y=1;

        if(Compteur.listMatchs.size()>0)
            return new ResponseEntity<>(Compteur.listMatchs, HttpStatus.OK);
        else
            return new ResponseEntity<>("No matches ", HttpStatus.FORBIDDEN);
    }
}
