package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy){
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        try {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
            int iv; // pas pratique car il faudra un if par pokemon, mais ici ça fait le boulot
            if (index == 0) {
                iv = 56; // Iv de bulbizarre
            }
            if (index == 133){
                iv = 100; // Iv de d'aquali
            }
            else{iv = 0;}
            return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
        } catch (PokedexException e) {
            return null;
        }
    }
}



