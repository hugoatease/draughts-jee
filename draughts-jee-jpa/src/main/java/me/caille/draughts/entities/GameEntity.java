package me.caille.draughts.entities;

import javax.persistence.*;

@Entity(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "white_id")
    private PlayerEntity whitePlayer;

    public PlayerEntity getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(PlayerEntity whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    @ManyToOne
    @JoinColumn(name = "black_id")
    private PlayerEntity blackPlayer;

    public PlayerEntity getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(PlayerEntity blackPlayer) {
        this.blackPlayer = blackPlayer;
    }
}
