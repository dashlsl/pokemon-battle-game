package Pokemon;

public class WaterPokemon extends Pokemon {

  //Constructors
  public WaterPokemon(String name, String status, String type, int grade, int health, int damage, String design) {
    super(name, status, type, grade, health, damage, design);
  }
  
  //toString
  @Override
  public String toString() {
      return String.format("Water Pokemon | [%s]",
        super.toString());
  }

  //Method
  public void increaseDamageToWeakTypes(Pokemon opponent) {
    if ("Caught".equals(this.getStatus()) && "Wild".equals(opponent.getStatus())) {
      // Check if the opponent is Weak to Water
      if ("Fire".equals(opponent.getType())) {
          // Increase damage by 50%
          int increasedDamage = (int) (this.getDamage() * 1.5);
          super.setDamage(increasedDamage);

          System.out.println("Increased damage by 50% against " + opponent.getName() + " (Weak to Water)!");
      } else {
          System.out.println("No damage increase. Opponent is not Weak to Water.");
      }
    }
  }

  @Override
  public void attack(Pokemon opponent) {
    increaseDamageToWeakTypes(opponent);
    super.attack(opponent);
  }
}
