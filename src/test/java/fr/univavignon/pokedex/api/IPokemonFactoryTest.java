package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;
    Pokemon myBulbizarre;
    Pokemon myAquali;


    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
        myBulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        myAquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void testCreatePokemon() {
        assertNotNull(pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        assertNotNull(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
    }
    @Test
    public void TestGetHP() {
        assertEquals(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp(), myBulbizarre.getCp());
    }
    @Test
    public void TestGetCP(){
        assertEquals(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp(), myBulbizarre.getHp());
    }
    @Test
    public void TestGetDust(){
        assertEquals(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust(), myBulbizarre.getDust());
    }
    @Test
    public void TestGetCandy(){
        assertEquals(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy(), myBulbizarre.getCandy());
    }

    @Test
    public void TestPokedexException() {
        pokemonFactory.createPokemon(-58, 0, 0, 0, 0);
    }

}

