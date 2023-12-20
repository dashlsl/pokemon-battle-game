package Balls;

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
        this.catchChance = catchChance;
    }

    public float getUseChance() {
        return useChance;
    }

    public void setUseChance(float useChance) {
        this.useChance = useChance;
    }

    @Override
    public String toString() {
        return "Ball [name=" + name + ", catchChance=" + catchChance + ", useChance=" + useChance + "]";
    }

    public void pokeCalChance(int grade, float catchChance){  
        if(grade == 1){
            catchChance = catchChance * 0.8f;
        }else if ((grade == 2) || (grade == 3)){
            catchChance = catchChance * 0.4f;
        }else {
            catchChance = catchChance * 0.2f;
        }
    }
    
    public void greatCalChance(float catchChance){  
        
    }

    public void ultraCalChance(float catchChance){  
        
    }

    public void masterCalChance(float catchChance){  
        
    }
}
