package me.caille.draughts.repositories;

import me.caille.draughts.entities.GameEntity;
import org.junit.After;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;

import static org.junit.Assert.*;

public class GameRepositoryTest {
    private GameRepository repository;
    private EJBContainer ejbContainer;
    private GameEntity game;

    @org.junit.Before
    public void setUp() throws Exception {
        ejbContainer = EJBContainer.createEJBContainer();
        repository = (GameRepository) ejbContainer.getContext().lookup("java:global/draughts-jee-jpa/GameRepository");
        game = repository.createGame();
    }

    @After
    public void tearDown() throws Exception {
        ejbContainer.close();
    }

    @Test
    public void canCreateGame() {
        GameEntity game = repository.createGame();
        assertNotNull(game);
    }

    @Test
    public void canRetrieveGame() {
        GameEntity retrieved = repository.getById(game.getId());
        assertEquals(game, retrieved);
    }
}