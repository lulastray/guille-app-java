package com.GuilleApp.model.points;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="points")
public class Points implements Serializable {

    private static final long serialVersionUID = -1514576145594310735L;
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="total_points")
    private Long totalPoints;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Long totalPoints) {
        this.totalPoints = totalPoints;
    }
}
