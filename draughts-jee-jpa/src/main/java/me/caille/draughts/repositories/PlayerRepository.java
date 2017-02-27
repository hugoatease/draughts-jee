package me.caille.draughts.repositories;

import me.caille.draughts.entities.PlayerEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class PlayerRepository {
    @PersistenceContext(name = "db-manager", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public List<PlayerEntity> getAll() {
        Query query = em.createQuery("SELECT x FROM players x");
        List<PlayerEntity> result = query.getResultList();
        return result;
    }

    public PlayerEntity getById(int id) {
        return em.find(PlayerEntity.class, id);
    }

    public PlayerEntity getByNickname(String nickname) {
        Query query = em.createQuery("SELECT x FROm players x WHERE x.nickname = :nickname");
        query.setParameter("nickname", nickname);
        PlayerEntity result = (PlayerEntity) query.getSingleResult();
        return result;
    }

    public PlayerEntity create(String nickname) {
        PlayerEntity player = new PlayerEntity();
        player.setNickname(nickname);
        em.persist(player);
        return player;
    }
}
