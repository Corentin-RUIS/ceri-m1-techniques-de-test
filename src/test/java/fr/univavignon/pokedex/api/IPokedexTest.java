package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;


public class IPokedexTest {
    private IPokedex pokedex;
    public Pokemon pokemon = new Pokemon(3, "Jules", 3, 2000, 1,
            0, 1000, 4, 2, 2);

}