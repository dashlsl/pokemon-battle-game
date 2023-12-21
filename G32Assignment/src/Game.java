import Pokemon.*;
import Balls.*;

public class Game {
    public static void main(String[] args) {
        WaterPokemon poke1 = new WaterPokemon("Squirtle", "Caught", "Water", 1, 100, 20, "Design1");
        Pokemon enem1 = new Pokemon("Charmander", "Wild", "Fire", 1, 100, 15, "Design2");

        // Attack opponent with myPokemon
        poke1.attack(enem1);

        // Display opponent's health after the attack
        System.out.println(enem1.getName() + "'s Health: " + enem1.getHealth());
        System.out.println(poke1.getName() + "'s Health: " + poke1.getHealth());
        
        
    }
}
