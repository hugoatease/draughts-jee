package me.caille.draughts.repositories;

import me.caille.draughts.entities.GameEntity;
import me.caille.draughts.entities.PlayerEntity;
import org.ajbrown.namemachine.NameGenerator;
import org.junit.After;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;

import static javassist.util.proxy.ProxyFactory.nameGenerator;
import static org.junit.Assert.*;

public class GameRepositoryTest {
    private GameRepository repository;
    private PlayerRepository playerRepository;
    private EJBContainer ejbContainer;
    private GameEntity game;
    private NameGenerator nameGenerator;
    private PlayerEntity whitePlayer;
    private PlayerEntity blackPlayer;

    @org.junit.Before
    public void setUp() throws Exception {
        ejbContainer = EJBContainer.createEJBContainer();
        repository = (GameRepository) ejbContainer.getContext().lookup("java:global/draughts-jee-jpa/GameRepository");
        playerRepository = (PlayerRepository) ejbContainer.getContext().lookup("java:global/draughts-jee-jpa/PlayerRepository");
        game = repository.createGame();
        nameGenerator = new NameGenerator();
        whitePlayer = playerRepository.create(nameGenerator.generateName().toString());
        blackPlayer = playerRepository.create(nameGenerator.generateName().toString());
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

    @Test
    public void canJoinWhitePlayer() {
        game.setWhitePlayer(whitePlayer);
        GameEntity retrieved = repository.getById(game.getId());
        assertEquals(game.getWhitePlayer(), retrieved.getWhitePlayer());
    }

    @Test
    public void canJoinBlackPlayer() {
        game.setBlackPlayer(blackPlayer);
        GameEntity retrieved = repository.getById(game.getId());
        assertEquals(game.getBlackPlayer(), retrieved.getBlackPlayer());
    }
}