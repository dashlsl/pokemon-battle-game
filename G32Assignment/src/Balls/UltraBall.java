package Balls;

public class UltraBall extends Ball {
    private float ultraCalChance;

    public UltraBall(String name, float ultraCalChance, float useChance) {
        super(name, ultraCalChance, useChance);
        this.ultraCalChance = ultraCalChance;
    }

    public void calculateCatchChance(int grade, float useChance, float catchChance) {
        if (useChance > 0.7) {
            if (grade == 1) {
                catchChance = catchChance * 0.9f;
            } else {
                System.out.println("Pokemon was freed");
            }

            if (grade == 2 || grade == 3) {
                catchChance = catchChance * 0.6f;
            } else {
                System.out.println("Pokemon was freed");
            }
        } else {
            System.out.println("Use chance is too low. Ball may fail to work.");
        }
    }
}