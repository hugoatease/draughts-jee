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
        repository = new GameRepository();
    }

    @Test
    public void canCreateGame() {
        repository.createGame();
    }
}