package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider myDataProvider;
    PokemonMetadata bulbizarreMetadata;
    PokemonMetadata aqualiMetadata;
    @Before
    public void initTestEnvironment() throws PokedexException {
        myDataProvider = new PokemonMetadataProvider();

        bulbizarreMetadata = myDataProvider.getPokemonMetadata(0);
        aqualiMetadata = myDataProvider.getPokemonMetadata(133);
    }

    @Test
    public void TestGetPokemonMetadata() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(0), bulbizarreMetadata);
        assertEquals(myDataProvider.getPokemonMetadata(133), aqualiMetadata);
    }
    @Test
    public void TestGetPokemonMetadataIndex() throws PokedexException {
        assertEquals(myDataProvider.getPokemonMetadata(0).getIndex(), bulbizarreMetadata.getIndex());
    }
    @Test
    public void TestPokedexException() {
        assertThrows(PokedexException.class, () -> {myDataProvider.getPokemonMetadata(-58);
        });
        assertThrows(PokedexException.class, () -> {myDataProvider.getPokemonMetadata(1000);
        });
    }

}