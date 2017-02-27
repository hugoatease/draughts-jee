package me.caille.draughts.repositories;

import me.caille.draughts.entities.GameEntity;

import javax.ejb.Stateful;
import javax.persistence.*;
import java.util.List;

@Stateful
public class GameRepository {
    @PersistenceContext(name = "db-manager", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public List<GameEntity> getAll() {
        Query query = em.createQuery("SELECT x FROM games x");
        List<GameEntity> result = query.getResultList();
        return result;
    }

    public GameEntity getById(int id) {
        return em.find(GameEntity.class, id);
    }

    public GameEntity createGame() {
        GameEntity game = new GameEntity();
        em.persist(game);
        return game;
    }
}
