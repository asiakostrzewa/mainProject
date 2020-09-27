package mainProject.user;


import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class User {
    private String firstName;
    private String surName;
    private String username;
    private String password;
    private boolean isAdmin;

}
