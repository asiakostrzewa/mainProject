package mainProject.user;


import lombok.Data;
import mainProject.BaseEntity;

import javax.persistence.Entity;

@Data
@Entity
public class User extends BaseEntity {
    private String firstName;
    private String surName;
    private String username;
    private String password;
    private boolean isAdmin;

}
