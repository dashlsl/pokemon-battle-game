package Pokemon;

public class GrassPokemon extends Pokemon {
  
  //Constructors
  public GrassPokemon(String name, String status, String type, int grade, int health, int damage, String design) {
    super(name, status, type, grade, health, damage, design);
  }
  
  //toString
  @Override
  public String toString() {
      return String.format("Grass Pokemon | [%s]",
        super.toString());
  }

  
  //Method

}
