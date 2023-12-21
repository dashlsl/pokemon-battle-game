package Balls;

public class PokeBall extends Ball {

    public PokeBall(String name, float catchChance, float useChance, boolean calculation, float smallMultiplier, float bigMultiplier) {
        super(name, catchChance, useChance, calculation, smallMultiplier, bigMultiplier);
        // PokeBall poke = new PokeBall("Pokeball", getCatchChance(), getUseChance(), calculation, smallMultiplier, bigMultiplier);
        // poke.setSmallMultiplier(0.7f);
        // poke.setBigMultiplier(0.5f);
    }
}