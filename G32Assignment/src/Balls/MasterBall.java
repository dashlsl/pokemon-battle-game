package Balls;

public class MasterBall extends Ball {
    private boolean masterCalChance;

    public MasterBall(String name, float catchChance, float useChance, boolean calculation, float smallMultiplier, float bigMultiplier){
        this.masterCalChance = masterCalChance;
    }
}
