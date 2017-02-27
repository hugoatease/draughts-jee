package me.caille.draughts.repositories;

import me.caille.draughts.entities.PlayerEntity;
import org.ajbrown.namemachine.NameGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;

import static org.junit.Assert.*;

public class PlayerRepositoryTest {
    private EJBContainer ejbContainer;
    private PlayerRepository repository;
    private PlayerEntity player;
    private NameGenerator nameGenerator;

    @Before
    public void setUp() throws Exception {
        ejbContainer = EJBContainer.createEJBContainer();
        repository = (PlayerRepository) ejbContainer.getContext().lookup("java:global/draughts-jee-jpa/PlayerRepository");
        nameGenerator = new NameGenerator();
        player = repository.create(nameGenerator.generateName().toString());
    }

    @After
    public void tearDown() throws Exception {
        ejbContainer.close();
    }

    @Test
    public void canCreatePlayer() {
        String name = nameGenerator.generateName().toString();
        PlayerEntity created = repository.create(name);
        assertNotNull(created);
        assertEquals(name, created.getNickname());
    }

    @Test
    public void canRetrievePlayerById() {
        PlayerEntity retrieved = repository.getById(player.getId());
        assertEquals(player, retrieved);
    }
}