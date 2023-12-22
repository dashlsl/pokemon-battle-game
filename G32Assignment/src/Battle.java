import java.util.*;
import Pokemon.*;
import Score.*;
import Balls.*;

public class Battle {
    private static Scanner scanner = new Scanner(System.in);

    public static void startBattle(ArrayList<Pokemon> pokemonList, ArrayList<Pokemon> savedPokemon, TopScore topScore) {
        // User chooses first pokemon
        Pokemon poke1 = chooseUserPokemon(savedPokemon);
        poke1.setStatus("Caught");
        savedPokemon.add(poke1);

        // Create 3 random enemies
        Pokemon poke2 = getRandomPoke(pokemonList);
        Pokemon poke3 = getRandomPoke(pokemonList);
        Pokemon poke4 = getRandomPoke(pokemonList);

        // Initialize original health
        int poke1OriginalHealth = poke1.getHealth();
        int poke2OriginalHealth = poke2.getHealth();
        int poke3OriginalHealth = poke3.getHealth();
        int poke4OriginalHealth = poke4.getHealth();

        boolean battleLost = false;

        // First battle
        System.out.println("\nFirst Battle:");
        poke1.attack(poke2);
        if (poke2.getHealth() <= 0) {
            System.out.println("\nYour " + poke1.getName() + " defeated Enemy " + poke2.getName() + "!");
            if (catchPokemonPrompt()) {
                Ball ball = getRandomBall();
                catchPokemon(poke2, ball, savedPokemon);
            }
        } else if (poke1.getHealth() <= 0) {
            System.out.println("\nBattle lost! Your " + poke1.getName() + " couldn't defeat Enemy " + poke2.getName() + ".");
            battleLost = true;         
        }

        if (!battleLost) {
            System.out.println("\nSecond Battle:");
    
            // Reset Pokemon original health
            resetPokemonHealth(poke1, poke1OriginalHealth);
            resetPokemonHealth(poke2, poke2OriginalHealth);
            resetPokemonHealth(poke3, poke3OriginalHealth);
            resetPokemonHealth(poke4, poke4OriginalHealth);
    
            ArrayList<Pokemon> userTeam = selectTeam(savedPokemon);
            
            int opponentIndex = 0;
            
            System.out.println("");
            for (Pokemon user : userTeam) {
                Pokemon currentOpponent = (opponentIndex == 0) ? poke3 : poke4;
    
                user.attack(currentOpponent);
    
                if (currentOpponent.getHealth() <= 0) {
                    System.out.println("\nYour " + user.getName() + " defeated Enemy " + currentOpponent.getName() + "!");
                    if (catchPokemonPrompt()) {
                        Ball ball = getRandomBall();
                        catchPokemon(currentOpponent, ball, savedPokemon);
                    }
                    opponentIndex++;
                } else {
                    System.out.println("\nYour " + user.getName() + " couldn't defeat Enemy " + currentOpponent.getName() + ".");
                    battleLost = true;
                    break;
                }
            }
    
            if (!battleLost && opponentIndex >= 2) {
                System.out.println("\nCongratulations! You defeated all opponents!");
            }
        }

        if (battleLost) {
            System.out.println("\nReturning to the main menu...");
            savedPokemon.remove(poke1);
        }
    }

    private static void resetPokemonHealth(Pokemon pokemon, int originalHealth) {
        pokemon.setHealth(originalHealth);
    }

    // First pokemon
    private static Pokemon chooseUserPokemon(ArrayList<Pokemon> savedPokemon) {
        System.out.println("\nChoose your first Pokemon!"
                            + "\n[1] Squirtle"
                            + "\n[2] Charmander"
                            + "\n[3] Bulbasaur");

        int firstChoice;
        do {
            System.out.print("Enter the number of your chosen Pokemon: ");
            firstChoice = scanner.nextInt();
        } while (firstChoice < 1 || firstChoice > 3);

        // Return the user's chosen Pokemon
        switch (firstChoice) {
            case 1:
                return new WaterPokemon("Squirtle", "Caught", "Water", 1, 100, 20);
            case 2:
                return new FirePokemon("Charmander", "Caught", "Fire", 1, 100, 20);
            case 3:
                return new GrassPokemon("Bulbasaur", "Caught", "Grass", 1, 100, 20);
            default:
                throw new IllegalArgumentException("Invalid selection");
        }
    }

    // User's Pokemon team
    private static ArrayList<Pokemon> selectTeam(ArrayList<Pokemon> savedPokemon) {
        System.out.println("\nSelect 2 Pokemon for your team.");
    
        ArrayList<Pokemon> userTeam = new ArrayList<>();
    
        for (int i = 0; i < 2; i++) {
            Pokemon selectedPokemon;
            do {
                System.out.println("\nChoose a Pokemon from your saved list:");
                for (int j = 0; j < savedPokemon.size(); j++) {
                    System.out.println((j + 1) + ". " + savedPokemon.get(j));
                }
                int choice;
                do {
                    System.out.print("Enter the number of the Pokemon: ");
                    choice = scanner.nextInt();
                } while (choice < 1 || choice > savedPokemon.size());
                selectedPokemon = savedPokemon.get(choice - 1);
            } while (userTeam.contains(selectedPokemon));  // Check if the selected Pokemon is already in the team

            userTeam.add(selectedPokemon);
            savedPokemon.remove(selectedPokemon);
        }
        return userTeam;
    }

    private static Pokemon getRandomPoke(ArrayList<Pokemon> pokemonList) {
        // Create Pokemon objects and add them to the pokemonList
        createPokemon(pokemonList);
    
        // Check if the list is not empty
        if (pokemonList.isEmpty()) {
            throw new IllegalArgumentException("No available Pokemon to choose from.");
        }
    
        // Return a randomly chosen Pokemon from the list
        Random random = new Random();
        return pokemonList.get(random.nextInt(pokemonList.size()));
    }
    
    private static void createPokemon(ArrayList<Pokemon> pokemonList) {
        // You can customize the attributes of these Pokemon objects
        FirePokemon pokemon1 = new FirePokemon("Charmander", "Wild", "Fire", 1, 100, 20);
        GrassPokemon pokemon2 = new GrassPokemon("Bulbasaur", "Wild", "Grass", 1, 100, 20);
        WaterPokemon pokemon3 = new WaterPokemon("Squirtle", "Wild", "Water", 1, 100, 20);
        FirePokemon pokemon4 = new FirePokemon("Vulpix", "Wild", "Fire", 1, 100, 20);
        GrassPokemon pokemon5 = new GrassPokemon("Oddish", "Wild", "Grass", 1, 100, 20);
        WaterPokemon pokemon6 = new WaterPokemon("Psyduck", "Wild", "Water", 1, 100, 20);
    
        // Add the Pokemon objects to the pokemonList
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);
        pokemonList.add(pokemon5);
        pokemonList.add(pokemon6);
    }

    private static boolean catchPokemonPrompt() {
        System.out.print("\nDo you want to try catching the enemy Pokemon? (1. Yes, 2. No): ");
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
        boolean isCaught = ball.ballCalculation(enemyPokemon.getGrade(), ball.getCatchChance(), ball.getUseChance(), ball.getSmallMultiplier(), ball.getBigMultiplier());

        if (isCaught) {
            pokemonList.add(enemyPokemon);  // Add the caught Pokemon to the list
            System.out.println("Congratulations! You caught the enemy Pokemon with a(n) " + ball);
            enemyPokemon.setStatus("Caught");
        } else {
            System.out.println("Oh no! The enemy Pokemon broke free. Better luck next time!");
        }
    }

    private static Ball getRandomBall() {
        ArrayList<Ball> availableBalls = new ArrayList<>();
        availableBalls.add(new PokeBall("Pokeball", 0.5f, 0.4f, true, 0.7f, 0.5f));
        availableBalls.add(new GreatBall("Great Ball", 0.5f, 0.3f, true, 0.8f, 0.6f));
        availableBalls.add(new UltraBall("Ultra Ball", 0.9f, 0.2f, true, 0.9f, 0.7f));
        availableBalls.add(new MasterBall("Master Ball", 1.0f, 0.1f, true, 1.0f, 1.0f));

        Random random = new Random();
        return availableBalls.get(random.nextInt(availableBalls.size()));
    }

}
