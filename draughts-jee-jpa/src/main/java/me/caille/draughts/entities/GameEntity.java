package me.caille.draughts.entities;

import me.caille.draughts.model.Turn;

import javax.persistence.*;
import java.util.List;

@Entity(name = "games")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "game", targetEntity = TurnEntity.class)
    private List<TurnEntity> turns;

    public List<TurnEntity> getTurns() {
        return turns;
    }
}
