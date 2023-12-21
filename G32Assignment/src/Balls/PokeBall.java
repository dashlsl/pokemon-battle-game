package Balls;

public class PokeBall extends Ball {
    private float pokeCalChance;

    public PokeBall(String name, float catchChance, float useChance, float pokeCalChance) {
        super(name, catchChance, useChance);
        this.pokeCalChance = pokeCalChance;
    }

    public void pokeCalChance(int grade, float useChance, float catchChance) {
        if (useChance > 0.3) {
            if (grade == 1) {
                catchChance = catchChance * 0.7f;
            } else {
                System.out.println("Pokemon was freed");
            }

            if (grade == 2 || grade == 3) {
                catchChance = catchChance * 0.2f;
            } else {
                System.out.println("Pokemon was freed");
            }
        } else {
            System.out.println("Use chance is too low. Ball may fail to work.");
        }
    }
}