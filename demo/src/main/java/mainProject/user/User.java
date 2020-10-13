package mainProject.user;


import lombok.Data;
import mainProject.BaseEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class User extends BaseEntity {
    private String firstName;
    private String surName;
    private String username;
    private String password;
    private boolean isAdmin;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "user_role")
    private Set<Role> roles;

}
