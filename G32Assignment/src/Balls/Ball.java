package Balls;

import java.util.Random;
public class Ball {

    private String name;
    private float catchChance;
    private float useChance;

    public Ball(){
        this.name = "Pokeball";
        this.catchChance = 0.5f;
        this.useChance = 0.5f;
    }

    public Ball(String name, float catchChance, float useChance) {
        this.name = name;
        this.catchChance = catchChance;
        this.useChance = useChance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCatchChance() {
        return catchChance;
    }

    public void setCatchChance(float catchChance) {
        this.catchChance = 1.0f;
    }

    public float getUseChance() {
        return useChance;
    }

    public void setUseChance(float useChance) {
        double randomValue = Math.random();
    }

    @Override
    public String toString() {
        return "Ball [name=" + name + ", catchChance=" + catchChance + ", useChance=" + useChance + "]";
    }
}