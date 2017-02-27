package me.caille.draughts.repositories;

import org.junit.After;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;

import static org.junit.Assert.*;

public class GameRepositoryTest {
    private GameRepository repository;
    private EJBContainer ejbContainer;

    @org.junit.Before
    public void setUp() throws Exception {
        ejbContainer = EJBContainer.createEJBContainer();
        repository = new GameRepository();
    }

    @After
    public void tearDown() throws Exception {
        ejbContainer.close();
    }

    @Test
    public void canCreateGame() {
        repository.createGame();
    }
}