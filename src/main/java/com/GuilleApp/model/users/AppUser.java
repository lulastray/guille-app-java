package com.GuilleApp.model.users;

import com.GuilleApp.model.points.Points;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
public class AppUser implements Serializable {

    private static final long serialVersionUID = 6332531687788591349L;

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "points_id", referencedColumnName = "id")
    private Points points;



}
