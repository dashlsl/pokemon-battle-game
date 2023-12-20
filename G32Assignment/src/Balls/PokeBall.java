package Balls;
public class PokeBall extends Ball {
    private float pokeCalChance;
    
    public PokeBall(String name, float pokeCalChance, float useChance) {
        super(name, pokeCalChance, useChance);
        this.pokeCalChance = 0.5f;
    }  

}