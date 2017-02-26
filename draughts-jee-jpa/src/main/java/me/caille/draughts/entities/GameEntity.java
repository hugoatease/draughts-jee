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

    @Column(name="white_player")
    @OneToOne
    private PlayerEntity whitePlayer;

    public PlayerEntity getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(PlayerEntity whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    @Column(name="black_player")
    @OneToOne
    private PlayerEntity blackPlayer;

    public PlayerEntity getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(PlayerEntity blackPlayer) {
        this.blackPlayer = blackPlayer;
    }
}
