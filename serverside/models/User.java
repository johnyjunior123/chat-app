package models;

import java.util.ArrayList;

public class User {
    private String name;
    private String login;
    private String hash_password;
    private ArrayList<String> amigos;

    public User(String name, String login, String hash_password){
        this.name = name;
        this.login = login;
        this.hash_password = hash_password;
        this.amigos = new ArrayList<String>();
    }

    
}
