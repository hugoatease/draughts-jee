package me.caille.draughts.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "players")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    public int getId() {
        return id;
    }

    @Column(name="nickname", length=30)
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @OneToMany(mappedBy = "player", targetEntity = TurnEntity.class)
    private List<TurnEntity> turns;

    @OneToMany(mappedBy = "whitePlayer", targetEntity = GameEntity.class)
    private List<GameEntity> gamesInWhite;

    @OneToMany(mappedBy = "blackPlayer", targetEntity = GameEntity.class)
    private List<GameEntity> gamesInBlack;

    @Override
    public String toString() {
        return "User " + getId() + ": " + getNickname();
    }

    public List<TurnEntity> getTurns() {
        return turns;
    }
}
