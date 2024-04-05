package fr.univavignon.pokedex.api;

import java.util.ArrayList;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    ArrayList<PokemonMetadata> metadataList;

    public PokemonMetadataProvider() {
        this.metadataList = new ArrayList<PokemonMetadata>();
        metadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataList.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Erreur : Index non compris entre 0 et 150");
        }
        for (PokemonMetadata pokemon : metadataList) {
            if (pokemon.getIndex() == index) {
                return pokemon;
            }
        }
        return null;
    }
}
