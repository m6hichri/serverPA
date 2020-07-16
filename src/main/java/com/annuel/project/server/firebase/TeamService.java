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
public class TeamService {
    public ResponseEntity<?> getTeams() throws ExecutionException, InterruptedException {

            int x =0;
            Compteur.collectTeam.clear();
            Firestore dbFirestore = FirestoreClient.getFirestore();
            DocumentReference documentReference;

            while(x<Compteur.getNbTeamTotal)
            {
                documentReference = dbFirestore.collection("Team").document(Integer.toString(x));
                ApiFuture<DocumentSnapshot> future1 = documentReference.get();
                DocumentSnapshot documentSnapshot = future1.get();
                Team team = null;


                if(documentSnapshot.exists() )
                {
                    team = documentSnapshot.toObject(Team.class);
                    Compteur.collectTeam.add(team);

                }else{
                    x=50;
                }

                x++;
            }

            if(Compteur.collectTeam.size() >0)
                return new ResponseEntity<>(Compteur.collectTeam, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Team ", HttpStatus.FORBIDDEN);
    }

    public void saveTeams(Team team) {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("Team")
                .document(Integer.toString(Compteur.nbTeam)).set(team);
        Compteur.nbTeam ++;
    }


    public void saveTeamStat(TeamStat teamStat) {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("TeamStat")
                .document(Long.toString(teamStat.getTEAM_ID())).set(teamStat);


    }

    public  ResponseEntity<?> getTeamStat(String teamId) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("TeamStat").document(teamId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();

        TeamStat teamStat = null;

        if (documentSnapshot.exists()) {
            teamStat = documentSnapshot.toObject(TeamStat.class);
            return new ResponseEntity<>(teamStat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No teamStat ", HttpStatus.FORBIDDEN);
        }
    }


}
