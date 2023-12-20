package Pokemon;

public class WaterPokemon extends Pokemon {

  //Constructors
  public WaterPokemon(String name, String design, String type, int damage, int health, int grade){
    super(name, design, type, damage, health, grade);
  }
  
  //toString
  @Override
  public String toString() {
      return String.format("Water Pokemon | [%s]",
        super.toString());
  }

  
  //Method

}
