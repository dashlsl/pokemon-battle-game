package Pokemon;

public class Pokemon {

    private String name;
    private String design;
    private String type;
    private int damage;
    private int health;
    private int grade;

    //Constructors
    public Pokemon(){
        this.name = "Squirtle";
        this.design = "";
        this.type = "Water";
        this.damage = 0;
        this.health = 100;
        this.grade = 1; //1 is highest, 3 is lowest
    }
    
    public Pokemon(String name, String design, String type, int damage, int health, int grade) {
        this.name = name;
        this.design = design;
        this.type = type;
        this.damage = damage;
        this.health = health;
        this.grade = grade;
    }
    
    //Setter Getter
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setDesign(String design) {
        this.design = design;
    }
    public String getDesign() {
        return design;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getGrade() {
        return grade;
    }

    //toString
    @Override
    public String toString() {
        return String.format("name= %s \n %s \n type= %s, damage= %d, health= %d, grade %d",
            getName(), getDesign(), getType(), getDamage(), getHealth(), getGrade());
    }
    
    //Method
    public void attack(int health, int damage) {
    	health =- getDamage();
    }
}
