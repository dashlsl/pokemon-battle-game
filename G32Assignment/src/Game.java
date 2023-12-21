import Pokemon.*;
import Balls.*;

public class Game {
    public static void main(String[] args) {
        WaterPokemon poke1 = new WaterPokemon("Squirtle", "Caught", "Water", 1, 100, 20, "Design7");
        FirePokemon enem1 = new FirePokemon("Charmander", "Wild", "Fire", 1, 90, 25, "Design4");

        // Attack opponent with myPokemon
        poke1.attack(enem1);

        // Display opponent's health after the attack
        System.out.println("Opponent " + enem1.getName() + "'s Health: " + enem1.getHealth());
        System.out.println(poke1.getName() + "'s Health: " + poke1.getHealth());
        
        
    }
}
