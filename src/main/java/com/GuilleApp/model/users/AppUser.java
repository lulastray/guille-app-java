package com.GuilleApp.model.users;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class AppUser implements Serializable {

    private static final long serialVersionUID = 6332531687788591349L;

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String username;

    @Column
    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;


    private Long points;

    @PrePersist
    public void prePersist() {
        roles = new ArrayList();
        roles.add(new Role("ROLE_USER"));
        points = 0L;

    }

    public AppUser (){
    }

    public AppUser(UUID id,String username, String password, List<Role> roles, Long points){
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.points = points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Long getPoints() {
        return points;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean hasRoles() {
        return !roles.isEmpty();
    }


}
