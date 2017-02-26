package me.caille.draughts.entities;

import me.caille.draughts.model.Turn;

import javax.persistence.*;

@Entity(name = "turn")
public class TurnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    @Column(name = "player")
    @OneToOne
    private PlayerEntity entity;

    public PlayerEntity getEntity() {
        return entity;
    }

    public void setEntity(PlayerEntity entity) {
        this.entity = entity;
    }

    @Embedded
    private Turn turn;

    public Turn getTurn() {
        return turn;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }
}
