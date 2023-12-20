package Pokemon;

public class Pokemon {

    private String name;
    private String status;
    private String type;
    private int grade;
    private int health;
    private int damage;
    private String design;

    //Constructors
    public Pokemon(){
        this.name = "Squirtle";
        this.status = "Wild"; //Wild or Caught
        this.type = "Water"; //Water, Fire, or Grass
        this.grade = 1; //Range of 1-3. 1 is highest, 3 is lowest
        this.health = 100;
        this.damage = 0;
        this.design = "";
    }
    
    public Pokemon(String name, String status, String type, int grade, int health, int damage, String design) {
        this.name = name;
        this.status = status;
        this.type = type;
        this.grade = grade;
        this.health = health;
        this.damage = damage;
        this.design = design;
    }
    
    //Setter Getter
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        if ("Wild".equals(status) || "Caught".equals(status)) {
            this.status = status;
        } else {
            System.out.println("Error! Invalid status.");
        }
    }
    public String getStatus() {
        return status;
    }

    public void setType(String type) {
        if ("Water".equals(type) || "Fire".equals(type) || "Grass".equals(type)) {
            this.type = type;
        } else {
            System.out.println("Error! Invalid Pokemon Type.");
        }
    }
    public String getType() {
        return type;
    }

    public void setGrade(int grade) {
        if (grade > 0 && grade < 4) {
            this.grade = grade;
        } else {
            System.out.println("Error! Grade must be in range 1-3."); 
        }
    }
    public int getGrade() {
        return grade;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public void setDesign(String design) {
        this.design = design;
    }
    public String getDesign() {
        return design;
    }

    //toString
    @Override
    public String toString() {
        return String.format("name= %s \n %s \n type= %s, damage= %d, health= %d, grade %d",
            getName(), getDesign(), getType(), getDamage(), getHealth(), getGrade());
    }
    
    //Method
    private void takeDamage(int damage) {
        this.health -= damage;
    }

    public void attack(Pokemon opponent) {
        // Check if status of own pokemon is "Caught" and opponent is "Wild"
        if ("Caught".equals(this.getStatus()) && "Wild".equals(opponent.getStatus())) {
            // Check if own Pokemon is still alive
            if (this.getHealth() > 0) {
                // Deal damage to the opponent based on own damage attribute
                int damageToOpponent = this.getDamage();
                opponent.takeDamage(damageToOpponent);
                System.out.printf("Dealt %d damage to %s\n", this.getDamage(), opponent.getName());
            } else {
                System.out.println("Pokemon has fainted! Send another pokemon");
            }

            // Check if opponent Pokemon is still alive
            if (opponent.getHealth() > 0) {
                // Opponent pokemon counter-attacks based on their damage attribute
                int damageToPlayer = opponent.getDamage();
                this.takeDamage(damageToPlayer);
                System.out.printf("Opponent deals %d damage to %s\n", opponent.getDamage(), this.getName());
            } else {
                System.out.println("Opponent has fainted! They are unable to counter-attack.");
            }

        } else {
            System.out.println("Error! Unable to attack.");
        }
    }
}
