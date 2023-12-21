import java.util.*;
import Pokemon.*;
import Score.*;
import Balls.*;

public class Game {
    // public static void main(String[] args) {
    //     WaterPokemon poke1 = new WaterPokemon("Squirtle", "Caught", "Water", 1, 100, 20, "Design1");
    //     Pokemon enem1 = new Pokemon("Charmander", "Wild", "Fire", 1, 100, 15, "Design2");

    //     // Attack opponent with myPokemon
    //     poke1.attack(enem1);

    //     // Display opponent's health after the attack
    //     System.out.println(enem1.getName() + "'s Health: " + enem1.getHealth());
    //     System.out.println(poke1.getName() + "'s Health: " + poke1.getHealth());
        
    // }

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Pokemon> pokemonList = new ArrayList<>();
    private static ArrayList<Pokemon> savedPokemon = new ArrayList<>();
    private static TopScore topScore = new TopScore();

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("1. Battle");
            System.out.println("2. View Top Scores");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    Battle.startBattle(pokemonList, savedPokemon, topScore);
                    break;
                case 2:
                    viewTopScores();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 3);
    }

    private static void viewTopScores() {
        System.out.println(topScore);
    }
}