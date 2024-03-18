package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory myTrainerFactory;
    IPokedexFactory myPokedexFactory;
    PokemonTrainer myPokemonTrainer;
    String name;
    Team team;

    @Before
    public void initTestEnvironment() {
        // Création des mocks
        myTrainerFactory = mock(IPokemonTrainerFactory.class);
        myPokedexFactory = mock(IPokedexFactory.class);
        IPokedex myPokedex = mock(IPokedex.class);
        team = Team.MYSTIC;
        name = "TrainerName";

        // Définition du comportement du mock myTrainerFactory
        when(myTrainerFactory.createTrainer(name, team, myPokedexFactory)).thenReturn(new PokemonTrainer(name, team, myPokedex));

        // Appel de la méthode createTrainer pour obtenir le mock de PokemonTrainer
        myPokemonTrainer = myTrainerFactory.createTrainer(name, team, myPokedexFactory);

    }

    @Test
    public void createTrainerTest() {
        myPokemonTrainer = myTrainerFactory.createTrainer(name, team, myPokedexFactory);
        assertNotNull(myPokemonTrainer);
    }


    @Test
    public void getNameTest() {
        assertEquals(name, myPokemonTrainer.getName());
    }

    @Test
    public void getTeam() {
        assertEquals(team, myPokemonTrainer.getTeam());
    }

    @Test
    public void getPokedex() {
        assertNotNull(myPokemonTrainer.getPokedex());
    }
}
