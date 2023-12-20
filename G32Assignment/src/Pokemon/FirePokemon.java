package Pokemon;

public class FirePokemon extends Pokemon {
  
  //Constructors
  public FirePokemon(String name, String status, String type, int grade, int health, int damage, String design) {
    super(name, status, type, grade, health, damage, design);
  }
  
  //toString
  @Override
  public String toString() {
      return String.format("Fire Pokemon | [%s]",
        super.toString());
  }

  
  //Method


}
