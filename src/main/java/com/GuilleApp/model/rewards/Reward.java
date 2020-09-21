package com.GuilleApp.model.rewards;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="rewards")
public class Reward implements Serializable {

    private static final long serialVersionUID = 2637410737396748406L;
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private Boolean exchanged;

    private Long value;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getExchanged() {
        return exchanged;
    }

    public void setExchanged(Boolean exchanged) {
        this.exchanged = exchanged;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
