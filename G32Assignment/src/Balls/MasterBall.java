package Balls;

public class MasterBall extends Ball {

    public MasterBall(String name, float catchChance, float useChance, boolean calculation, float smallMultiplier, float bigMultiplier){
        super(name, catchChance, useChance, calculation, smallMultiplier, bigMultiplier);
    }

    @Override
    public String toString() {
        return String.format("Master Ball | [%s]",
          super.toString());
    }
}
