package com.rio.stoneagetech.stoneaget;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUDController {

    public CRUDService crudService;

    public CRUDController(CRUDService crudService){
        this.crudService = crudService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody CRUDModel crud) throws InterruptedException, ExecutionException{
        return crudService.createUser(crud);
    }

    @GetMapping("/get")
    public CRUDModel getUser(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return crudService.getUser(documentId);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody CRUDModel crud) throws InterruptedException, ExecutionException{
        return crudService.updateUser(crud);
    }

    @PutMapping("/delete")
    public String deleteUser(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return crudService.deleteUser(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetResponse(){
        return ResponseEntity.ok("Test End Point is Working Fine");
    }
    
}
