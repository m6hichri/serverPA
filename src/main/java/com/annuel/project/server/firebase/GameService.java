package com.annuel.project.server.firebase;

import com.annuel.project.server.entites.Compteur;
import com.annuel.project.server.entites.Game;
import com.annuel.project.server.entites.Team;
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
public class GameService {

    public void saveGame(Game game) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Game")
                .document(Integer.toString(Compteur.nbGames)).set(game);
        Compteur.nbGames ++;
    }

    public ResponseEntity<?> getGames() throws ExecutionException, InterruptedException {

        int x =0;
        Compteur.collectGames.clear();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference;

        while(x<Compteur.getNbGameTotal)
        {
            documentReference = dbFirestore.collection("Game").document(Integer.toString(x));
            ApiFuture<DocumentSnapshot> future1 = documentReference.get();
            DocumentSnapshot documentSnapshot = future1.get();
            Game game = null;


            if(documentSnapshot.exists() )
            {
                game = documentSnapshot.toObject(Game.class);
                Compteur.collectGames.add(game);

            }else{
                x=50;
            }

            x++;
        }

        if(Compteur.collectGames.size() >0)
            return new ResponseEntity<>(Compteur.collectGames, HttpStatus.OK);
        else
            return new ResponseEntity<>("No Game ", HttpStatus.FORBIDDEN);
    }
}
