package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    @Mock
    public IPokedex myPokedex;

    @Mock
    public IPokemonFactory pokemonFactory;

    Pokemon myBulbizarre;

    Pokemon myAquali;

    @Mock
    public IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    public IPokedexFactory pokedexFactory;

    @Before
    public void initTestEnvironment() throws PokedexException {
        MockitoAnnotations.initMocks(this);

        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(myPokedex);

        myBulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        myAquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        when(myPokedex.createPokemon(0, 613, 64, 4000, 4)).thenReturn(myBulbizarre);
        when(myPokedex.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(myAquali);

        when(myPokedex.addPokemon(myBulbizarre)).thenReturn(0);
        when(myPokedex.addPokemon(myAquali)).thenReturn(1);
    }
    @Test
    public void addPokemonTest() throws PokedexException {
        int index = myPokedex.addPokemon(myBulbizarre);
        assertEquals(1, index);
    }

    @Test
    public void sizeTest() {
        assertEquals(myPokedex.size(), 0);
    }



    @Test
    public void getUnmodifiableList() {
        assertNotNull(myPokedex.getPokemons());
        assertNotNull(myPokedex.getPokemons(PokemonComparators.NAME));
    }
}
