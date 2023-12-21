package Balls;

public class GreatBall extends Ball {
    private float greatCalChance;

    public GreatBall(String name, float greatCalChance, float useChance) {
        super(name, greatCalChance, useChance);
        this.greatCalChance = greatCalChance;
    }

    public void calculateCatchChance(int grade, float useChance, float catchChance) {
        if (useChance > 0.5) {
            if (grade == 1) {
                catchChance = catchChance * 0.8f;
            } else {
                System.out.println("Pokemon was freed");
            }

            if (grade == 2 || grade == 3) {
                catchChance = catchChance * 0.4f;
            } else {
                System.out.println("Pokemon was freed");
            }
        } else {
            System.out.println("Use chance is too low. Ball may fail to work.");
        }
    }
}