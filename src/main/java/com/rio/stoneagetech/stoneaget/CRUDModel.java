package com.rio.stoneagetech.stoneaget;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CRUDModel{
    private String documentId;
    private String username;
    private String email;
    private String password;
    private String created_date;
}