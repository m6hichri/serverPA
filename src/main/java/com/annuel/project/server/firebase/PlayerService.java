package com.annuel.project.server.firebase;

import com.annuel.project.server.entites.*;
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
public class PlayerService {

    public void savePlayerStat(PlayerStat playerStat) {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("PlayerStat")
                .document(Long.toString(playerStat.getPLAYER_ID())).set(playerStat);
    }

    public ResponseEntity<?> getPlayerStat(String playerId) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("PlayerStat").document(playerId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();

        PlayerStat playerStat = null;

        if (documentSnapshot.exists()) {
            playerStat = documentSnapshot.toObject(PlayerStat.class);
            return new ResponseEntity<>(playerStat, HttpStatus.OK);

        } else
            return new ResponseEntity<>("No playerStat ", HttpStatus.FORBIDDEN);
    }

    public void savePlayer(Player player) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Player")
                .document(Integer.toString(Compteur.nbPlayer)).set(player);
        Compteur.nbPlayer ++;
    }

    public ResponseEntity<?> getPlayer() throws ExecutionException, InterruptedException {

        int x =0;
        Compteur.collectPlayer.clear();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference;



        while(x<Compteur.nbPlayerTotal)
        {
            documentReference = dbFirestore.collection("Player").document(Integer.toString(x));
            ApiFuture<DocumentSnapshot> future1 = documentReference.get();
            DocumentSnapshot documentSnapshot = future1.get();
            Player player = null;

            if(documentSnapshot.exists() )
            {
                    player = documentSnapshot.toObject(Player.class);
                    Compteur.collectPlayer.add(player);

            }
            else
            {
                x=50;
            }
            x++;
        }

        if(Compteur.collectPlayer.size() >0)
            return new ResponseEntity<>(Compteur.collectPlayer, HttpStatus.OK);
        else
            return new ResponseEntity<>("No Player ", HttpStatus.FORBIDDEN);
    }
}
