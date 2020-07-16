package com.annuel.project.server.firebase;

import com.annuel.project.server.entites.Account;
import com.annuel.project.server.entites.Users;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public String saveUser(Users user) throws ExecutionException, InterruptedException {

        /*
        String passwordCrypt = Users.setPasswordCrypt(user.getPassword());
        user.setPassword(passwordCrypt);
         */
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("users")
                .document(user.getLogin()).set(user);

        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public Users getUserDetail(String login) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = dbFirestore.collection("users").document(login);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot documentSnapshot = future.get();

        Users user = null;

        if(documentSnapshot.exists())
        {
            user = documentSnapshot.toObject(Users.class);
            return  user;
        }
        else {
            return null;
        }
    }

    public ResponseEntity<?> updateUserDetails(Users user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("users")
                //.document(user.getLogin()).update("email",user.getEmail());
                .document(user.getLogin()).set(user);

        String response = collectionApiFuture.get().getUpdateTime().toString();

        return new ResponseEntity<>("Time : " + response, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteUser(String login) throws FirebaseAuthException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("users")
                .document(login).delete();
        String response =  "Documents with login:" + login + "has been deleted";

        return new ResponseEntity<>( response, HttpStatus.OK);
    }

    public ResponseEntity<?> connectAccount(Account account) throws ExecutionException, InterruptedException {

        Boolean accepted = false;

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(account.getLogin());
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot documentSnapshot = future.get();

        Users user = null;

        if(documentSnapshot.exists())
        {
            user = documentSnapshot.toObject(Users.class);

            /*
            if(Users.checkPass(account.getPassword(),user.getPassword()))
            {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }

             */
        }
        return new ResponseEntity<>("Informations incorrect", HttpStatus.FORBIDDEN);
    }

}
