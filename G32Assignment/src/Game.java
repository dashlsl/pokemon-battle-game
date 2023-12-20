import Pokemon.*;
import Balls.*;

public class Game {
    public static void main(String[] args) {
        WaterPokemon myPokemon = new WaterPokemon("Squirtle", "Caught", "Water", 1, 100, 20, "Design1");
        Pokemon opponentPokemon = new Pokemon("Charmander", "Wild", "Fire", 1, 100, 15, "Design2");

        // Attack opponent with myPokemon
        myPokemon.attack(opponentPokemon);

        // Display opponent's health after the attack
        System.out.println(opponentPokemon.getName() + "'s Health: " + opponentPokemon.getHealth());
        System.out.println(myPokemon.getName() + "'s Health: " + myPokemon.getHealth());
    }
}
