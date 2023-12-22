package Balls;

public class GreatBall extends Ball {

    public GreatBall(String name, float catchChance, float useChance, boolean calculation, float smallMultiplier, float bigMultiplier){
        super(name, catchChance, useChance, calculation, smallMultiplier, bigMultiplier);
    }

    @Override
    public String toString() {
        return String.format("Great Ball | [%s]",
          super.toString());
    }
}