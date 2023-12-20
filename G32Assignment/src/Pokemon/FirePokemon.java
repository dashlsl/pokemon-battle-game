package Pokemon;

public class FirePokemon extends Pokemon {
  
  //Constructors
  public FirePokemon(String name, String design, String type, int damage, int health, int grade){
    super(name, design, type, damage, health, grade);
  }
  
  //toString
  @Override
  public String toString() {
      return String.format("Fire Pokemon | [%s]",
        super.toString());
  }

  
  //Method
  public void attack(int health, int damage) {
	  while (health > 0) {
  		if (getType() == "Water") {
  			health =- (int) (1.5 * getDamage());
  		}
  		else if (getType() == "Grass") {
  			health =- (int) (2 * getDamage());
  		}
  	}
	  health =- getDamage();
  }

}
