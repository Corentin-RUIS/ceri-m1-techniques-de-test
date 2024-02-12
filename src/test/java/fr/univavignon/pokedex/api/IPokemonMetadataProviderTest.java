package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest
{
    @Mock
    public IPokemonMetadataProvider metadataProvider;


    @BeforeEach
    public void setUp() throws PokedexException{
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata( 1, "Salamèche", 10,10, 10));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        assertEquals(0, metadataProvider.getPokemonMetadata(1).getIndex());
    }
}
