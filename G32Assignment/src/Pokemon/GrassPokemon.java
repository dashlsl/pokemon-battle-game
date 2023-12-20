package Pokemon;

public class GrassPokemon extends Pokemon {
  
  //Constructors
  public GrassPokemon(String name, String design, String type, int damage, int health, int grade){
    super(name, design, type, damage, health, grade);
  }
  
  //toString
  @Override
  public String toString() {
      return String.format("Grass Pokemon | [%s]",
        super.toString());
  }

  
  //Method

}
