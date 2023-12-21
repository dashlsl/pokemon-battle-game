package Balls;

public class MasterBall extends Ball {
    private float masterCalChance;

    public MasterBall(String name, float masterCalChance, float useChance) {
        super(name, masterCalChance, useChance);
        this.masterCalChance = masterCalChance;
    }

    public void masterCalChance(int grade, float useChance, float catchChance) {
        if (useChance > 0.9) {
            if (grade >= 1) {
                catchChance = catchChance * 1.0f;
            } else {
                System.out.println("Pokemon was freed");
            }
        } else {
            System.out.println("Use chance is too low. Ball may fail to work.");
        }
    }
}
