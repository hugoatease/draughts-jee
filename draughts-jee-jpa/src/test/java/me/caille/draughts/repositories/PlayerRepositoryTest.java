package me.caille.draughts.repositories;

import me.caille.draughts.entities.PlayerEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;

import static org.junit.Assert.*;

public class PlayerRepositoryTest {
    private EJBContainer ejbContainer;
    private PlayerRepository repository;
    private PlayerEntity player;

    @Before
    public void setUp() throws Exception {
        ejbContainer = EJBContainer.createEJBContainer();
        repository = (PlayerRepository) ejbContainer.getContext().lookup("java:global/draughts-jee-jpa/PlayerRepository");
        player = repository.create("hugoatease");
    }

    @After
    public void tearDown() throws Exception {
        ejbContainer.close();
    }

    @Test
    public void canCreatePlayer() {
        PlayerEntity created = repository.create("hugoatease");
        assertNotNull(created);
        assertEquals("hugoatease", created.getNickname());
    }

    @Test
    public void canRetrievePlayerById() {
        PlayerEntity retrieved = repository.getById(player.getId());
        assertEquals(player, retrieved);
    }
}