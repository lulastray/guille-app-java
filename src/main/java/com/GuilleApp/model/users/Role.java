package com.GuilleApp.model.users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1724148672800734688L;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
