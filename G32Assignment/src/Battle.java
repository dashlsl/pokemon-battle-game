import java.util.*;
import Pokemon.*;
import Score.*;
import Balls.*;

public class Battle {
    private static Scanner scanner = new Scanner(System.in);

    public static void startBattle(ArrayList<Pokemon> pokemonList, ArrayList<Pokemon> savedPokemon, TopScore topScore) {
        Pokemon poke1 = chooseUserPokemon(savedPokemon);
        poke1.setStatus("Caught");
        savedPokemon.add(poke1);

        Pokemon enemy1 = new Pokemon("Charmander", "Wild", "Fire", 1, 100, 20, "Enemy1Design");
        Pokemon enemy2 = new Pokemon("Blastoise", "Wild", "Water", 1, 100, 20, "Enemy2Design");

        int userOriginalHealth = poke1.getHealth();
        int enemy1OriginalHealth = enemy1.getHealth();
        int enemy2OriginalHealth = enemy2.getHealth();

        //First battle
        System.out.println("First Battle:");

        simulateBattle(poke1, enemy1);
        // simulateBattle(poke1, enemy2);

        if (catchPokemonPrompt()) {
            Ball ball = getRandomBall();
            catchPokemon(enemy1, ball, savedPokemon);
        }

        int continueOption = battleMenu();

        while (continueOption == 1) {
            
            Pokemon enemy3 = getRandomEnemy(pokemonList);
            Pokemon enemy4 = getRandomEnemy(pokemonList);
            
            int enemy3OriginalHealth = enemy3.getHealth();
            int enemy4OriginalHealth = enemy4.getHealth();

            resetPokemonHealth(poke1, userOriginalHealth);
            resetPokemonHealth(enemy1, enemy1OriginalHealth);
            resetPokemonHealth(enemy2, enemy2OriginalHealth);
            resetPokemonHealth(enemy3, enemy3OriginalHealth);
            resetPokemonHealth(enemy4, enemy4OriginalHealth);

            ArrayList<Pokemon> userTeam = selectTeam(savedPokemon);

            simulateBattle(userTeam, enemy3);
            simulateBattle(userTeam, enemy4);

            if (catchPokemonPrompt()) {
                Ball ball = getRandomBall();
                catchPokemon(enemy3, ball, savedPokemon);
                catchPokemon(enemy4, ball, savedPokemon);
            }

            continueOption = battleMenu();
        }
    }

    // Battle Menu
    private static int battleMenu() {
        System.out.println("1. Continue Battle");
        System.out.println("2. Back to Main Menu");
        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    private static void resetPokemonHealth(Pokemon pokemon, int originalHealth) {
        pokemon.setHealth(originalHealth);
    }

    // First battle
    private static void simulateBattle(Pokemon attacker, Pokemon defender) {
        attacker.attack(defender);
        defender.attack(attacker);
    }
    // Multiple own pokemon
    private static void simulateBattle(ArrayList<Pokemon> attackers, Pokemon defender) {
        for (Pokemon attacker : attackers) {
            simulateBattle(attacker, defender);
        }
    }

    // First pokemon
    private static Pokemon chooseUserPokemon(ArrayList<Pokemon> savedPokemon) {
        // Display the available Pokemon for the user to choose from
        System.out.println("Choose your first Pokemon!");
        System.out.println("1. Squirtle");
        System.out.println("2. Charmander");
        System.out.println("3. Bulbasaur");

        int selectedIndex;
        do {
            System.out.print("Enter the number of your chosen Pokemon: ");
            selectedIndex = scanner.nextInt();
        } while (selectedIndex < 1 || selectedIndex > 3);

        // Return the user's chosen Pokemon
        switch (selectedIndex) {
            case 1:
                return new WaterPokemon("Squirtle", "Caught", "Water", 1, 100, 20, "SquirtleDesign");
            case 2:
                return new FirePokemon("Charmander", "Caught", "Fire", 1, 100, 20, "CharmanderDesign");
            case 3:
                return new GrassPokemon("Bulbasaur", "Caught", "Grass", 1, 100, 20, "BulbasaurDesign");
            default:
                throw new IllegalArgumentException("Invalid selection");
        }
    }

    // Multiple pokemon
    private static ArrayList<Pokemon> selectTeam(ArrayList<Pokemon> savedPokemon) {
        System.out.println("Select 2 Pokemon for your team:");
    
        ArrayList<Pokemon> userTeam = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Pokemon selectedPokemon;
            do {
                selectedPokemon = choosePokemonFromSaved(savedPokemon);
            } while (userTeam.contains(selectedPokemon));  // Check if the selected Pokemon is already in the team
            userTeam.add(selectedPokemon);
            savedPokemon.remove(selectedPokemon);
        }
    
        return userTeam;
    }

    private static Pokemon choosePokemonFromSaved(ArrayList<Pokemon> savedPokemon) {
        System.out.println("Choose a Pokemon from your saved list:");
        for (int i = 0; i < savedPokemon.size(); i++) {
            System.out.println((i + 1) + ". " + savedPokemon.get(i));
        }

        int selectedIndex;
        do {
            System.out.print("Enter the number of the Pokemon: ");
            selectedIndex = scanner.nextInt();
        } while (selectedIndex < 1 || selectedIndex > savedPokemon.size());

        return savedPokemon.get(selectedIndex - 1);
    }

    private static Pokemon getRandomEnemy(ArrayList<Pokemon> pokemonList) {
        // Create 6 Pokemon objects and add them to the pokemonList
        createAndAddPokemons(pokemonList);
    
        // Check if the list is not empty
        if (pokemonList.isEmpty()) {
            throw new IllegalArgumentException("No available Pokemon to choose from.");
        }
    
        // Return a randomly chosen Pokemon from the list
        Random random = new Random();
        return pokemonList.get(random.nextInt(pokemonList.size()));
    }
    
    private static void createAndAddPokemons(ArrayList<Pokemon> pokemonList) {
        // You can customize the attributes of these Pokemon objects
        Pokemon pokemon1 = new Pokemon("Charmander", "Wild", "Fire", 1, 100, 20, "Design1");
        Pokemon pokemon2 = new Pokemon("Bulbasaur", "Wild", "Grass", 1, 100, 20, "Design2");
        Pokemon pokemon3 = new Pokemon("Squirtle", "Wild", "Water", 1, 100, 20, "Design3");
        Pokemon pokemon4 = new Pokemon("Vulpix", "Wild", "Fire", 1, 100, 20, "Design4");
        Pokemon pokemon5 = new Pokemon("Oddish", "Wild", "Grass", 1, 100, 20, "Design5");
        Pokemon pokemon6 = new Pokemon("Psyduck", "Wild", "Water", 1, 100, 20, "Design6");
    
        // Add the Pokemon objects to the pokemonList
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);
        pokemonList.add(pokemon5);
        pokemonList.add(pokemon6);
    }

    private static boolean catchPokemonPrompt() {
        System.out.println("Do you want to try catching the enemy Pokemon? (1. Yes, 2. No)");
        int choice = scanner.nextInt();
    
        if (choice == 1) {
            return true;     // Indicate that the user wants to catch the Pokemon
        } else {
            return false;    // Indicate that the user does not want to catch the Pokemon
        }
    }

    private static void catchPokemon(Pokemon enemyPokemon, Ball ball, ArrayList<Pokemon> pokemonList) {
        System.out.println("Attempting to catch the enemy Pokemon...");

        // Get a random ball
        ball = getRandomBall();

        // Use the catch logic based on the random ball
        boolean isCaught = ball.calculation(enemyPokemon.getGrade(), ball.getCatchChance(), ball.getUseChance(), ball.getSmallCalculation(), ball.getBigCalculation());

        if (isCaught) {
            pokemonList.add(enemyPokemon);  // Add the caught Pokemon to the list
            System.out.println("Congratulations! You caught the enemy Pokemon with a " + ball);
        } else {
            System.out.println("Oh no! The enemy Pokemon broke free. Better luck next time!");
        }
    }

    private static Ball getRandomBall() {
        ArrayList<Ball> availableBalls = new ArrayList<>();
        availableBalls.add(new PokeBall("Pokeball", 0.5f, 0.5f, false, 0.7f, 0.5f));
        availableBalls.add(new GreatBall("Great Ball", 0.5f, 0.8f, false, 0.8f, 0.6f));
        availableBalls.add(new UltraBall("Ultra Ball", 0.9f, 0.7f, false, 0.9f, 0.7f));
        availableBalls.add(new MasterBall("Master Ball", 1.0f, 0.9f, false, 1f, 1f));

        Random random = new Random();
        return availableBalls.get(random.nextInt(availableBalls.size()));
    }

}
