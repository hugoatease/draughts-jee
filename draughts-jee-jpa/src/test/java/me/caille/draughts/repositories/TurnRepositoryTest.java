package me.caille.draughts.repositories;

import me.caille.draughts.entities.GameEntity;
import me.caille.draughts.entities.PlayerEntity;
import me.caille.draughts.entities.TurnEntity;
import org.ajbrown.namemachine.NameGenerator;
import org.apache.openjpa.persistence.jdbc.EagerFetchMode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;

import static org.junit.Assert.*;

public class TurnRepositoryTest {
    private EJBContainer ejbContainer;
    private TurnRepository repository;
    private PlayerRepository playerRepository;
    private GameRepository gameRepository;
    private NameGenerator nameGenerator;
    private PlayerEntity player;

    @Before
    public void setUp() throws Exception {
        ejbContainer = EJBContainer.createEJBContainer();
        repository = (TurnRepository) ejbContainer.getContext().lookup("java:global/draughts-jee-jpa/TurnRepository");
        playerRepository = (PlayerRepository) ejbContainer.getContext().lookup("java:global/draughts-jee-jpa/PlayerRepository");
        gameRepository = (GameRepository) ejbContainer.getContext().lookup("java:global/draughts-jee-jpa/GameRepository");
        nameGenerator = new NameGenerator();
        player = playerRepository.create(nameGenerator.generateName().toString());
    }

    @After
    public void tearDown() throws Exception {
        ejbContainer.close();
    }

    @Test
    public void canCreateTurn() {
        GameEntity game = gameRepository.createGame();
        TurnEntity created = repository.create(game, player, 4, 2, 5, 3);
        TurnEntity retrieved = repository.getById(created.getId());
        assertEquals(created, retrieved);
        assertEquals(retrieved.getPlayer(), player);
        assertEquals(retrieved.getGame(), game);
        assertEquals(4, retrieved.getTurn().getSrcRow());
        assertEquals(2, retrieved.getTurn().getSrcCol());
        assertEquals(5, retrieved.getTurn().getDstRow());
        assertEquals(3, retrieved.getTurn().getDstCol());
    }
}