package com.rio.stoneagetech.stoneaget;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class CRUDService {

    Firestore dbFirestore = FirestoreClient.getFirestore();
    public String createUser(CRUDModel crud) throws InterruptedException, ExecutionException{
        ApiFuture<WriteResult> collectionApiFuture =  dbFirestore.collection("users").document(crud.getUsername()).set(crud);
        return collectionApiFuture.get().getUpdateTime().toString();  
    }

    public CRUDModel getUser(String documentId) throws InterruptedException, ExecutionException {
        DocumentReference documentReference = dbFirestore.collection("users").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        CRUDModel crud;
        if(document.exists()){
            crud = document.toObject(CRUDModel.class);
            
            return crud;
        }
        return null;

    }


    public String updateUser(CRUDModel crud) throws InterruptedException, ExecutionException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> cApiFuture = dbFirestore.collection("users").document(crud.getUsername()).set(crud);
        
        return cApiFuture.get().getUpdateTime().toString();  
    }

    public String deleteUser(String documentId) throws InterruptedException, ExecutionException {
         dbFirestore.collection("users").document(documentId).delete();
       
        return "Successfully user deleted" + documentId;
    }

}
