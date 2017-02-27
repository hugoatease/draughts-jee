package me.caille.draughts.repositories;

import me.caille.draughts.entities.GameEntity;

import javax.ejb.Stateful;
import javax.persistence.*;
import java.util.List;

public class GameRepository {
    private EntityManagerFactory emf;
    private EntityManager em;

    public GameRepository() {
        emf = Persistence.createEntityManagerFactory("db-manager");
        em = emf.createEntityManager();
    }

    public List<GameEntity> getAll() {
        Query query = em.createQuery("SELECT x FROM games x");
        List<GameEntity> result = query.getResultList();
        return result;
    }

    public GameEntity getById(int id) {
        return em.find(GameEntity.class, id);
    }

    public GameEntity createGame() {
        EntityTransaction t = em.getTransaction();
        t.begin();
        GameEntity game = new GameEntity();
        em.persist(game);
        t.commit();
        return game;
    }
}
