package com.annuel.project.server.firebase;

import com.annuel.project.server.entites.Compteur;
import com.annuel.project.server.entites.Game;
import com.annuel.project.server.entites.Prevision;
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
public class PrevisionService {
    public void savePrevision(Prevision prevision) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Prevision")
                .document(prevision.getId()).set(prevision);
    }

    public ResponseEntity<?> getPrevion( String id) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("Prevision").document(id);
        ApiFuture<DocumentSnapshot> future1 = documentReference.get();
        DocumentSnapshot documentSnapshot = future1.get();

        Prevision prevision = null;

        if(documentSnapshot.exists() )
        {
            prevision = documentSnapshot.toObject(Prevision.class);
            return new ResponseEntity<>(prevision, HttpStatus.OK);
        }

            return new ResponseEntity<>("No Prevision ", HttpStatus.FORBIDDEN);
    }
}
