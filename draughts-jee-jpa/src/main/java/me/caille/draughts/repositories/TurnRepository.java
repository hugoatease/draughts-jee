package me.caille.draughts.repositories;

import me.caille.draughts.entities.GameEntity;
import me.caille.draughts.entities.PlayerEntity;
import me.caille.draughts.entities.TurnEntity;
import me.caille.draughts.model.Turn;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class TurnRepository {
    @PersistenceContext(name = "db-manager", type = PersistenceContextType.EXTENDED)
    private EntityManager em;


    public List<TurnEntity> getAll() {
        Query query = em.createQuery("SELECT x FROM turns x");
        List<TurnEntity> result = query.getResultList();
        return result;
    }

    public TurnEntity getById(int id) {
        return em.find(TurnEntity.class, id);
    }


    public TurnEntity create(GameEntity game, PlayerEntity player, int srcRow, int srcCol, int dstRow, int dstCol) {
        Turn turn = new Turn(srcRow, srcCol, dstRow, dstCol);
        TurnEntity entity = new TurnEntity();
        entity.setGame(game);
        entity.setPlayer(player);
        entity.setTurn(turn);
        em.persist(entity);
        return entity;
    }
}
