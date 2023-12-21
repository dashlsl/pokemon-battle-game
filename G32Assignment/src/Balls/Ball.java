package Balls;
public class Ball {

    private String name;
    private float catchChance;
    private float useChance;
    private float smallMultiplier;
    private float bigMultiplier;
    private boolean calculation;

    public Ball(){
        this.name = "Pokeball";
        this.catchChance = 0.5f;
        this.useChance = 0.5f;
        this.calculation = true;
        this.smallMultiplier = 0.0f;
        this.bigMultiplier = 0.0f;
    }

    public Ball(String name, float catchChance, float useChance, boolean calculation, float smallMultiplier, float bigMultiplier) {
        this.name = name;
        this.catchChance = catchChance;
        this.useChance = useChance;
        this.calculation = calculation;
        this.smallMultiplier = smallMultiplier;
        this.bigMultiplier = bigMultiplier;
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
        this.useChance = 0.0f;
    }

    public float getSmallCalculation(){
        return smallMultiplier;
    }

    public void setSmallMultiplier(float smallMultiplier){
        this.smallMultiplier = 1.0f;
    }

    public float getBigCalculation(){
        return bigMultiplier;
    }

    public void setBigMultiplier(float bigMultiplier){
        this.bigMultiplier = 1.0f;
    }

    @Override
    public String toString() {
        return "Ball [name=" + name + ", catchChance=" + catchChance + ", useChance=" + useChance + "]";
    }

    public boolean calculation(int grade, float useChance, float catchChance, float smallMultiplier, float bigMultiplier){
        if (grade == 1) {
            catchChance = catchChance * smallMultiplier;
            return true;
        }
        if (grade == 2 || grade == 3) {
            catchChance = getCatchChance() * bigMultiplier;
            return true;
        } 
        else {
            System.out.println("Pokemon was freed");
            return false;
        }
    }
}