public class Game {
    public static void main(String[] args) {
        // Create a WaterPokemon object for Squirtle
        Pokemon.WaterPokemon squirtle = new Pokemon.WaterPokemon("Squirtle","","Water", 20, 100, 1);
        
        squirtle.setDesign(
        "               _,........__\n" +
        "            ,-'            \"`-.\n" +
        "          ,'                   `-. \n" +
        "        ,'                        \\\n" +
        "      ,'                           .\n" +
        "      .'\\               ,\"\".       `\n" +
        "     ._.'|             / |  `       \\\n" +
        "     |   |            `-.'  ||       `.\n" +
        "     |   |            '-._,'||       | \\\n" +
        "     .`.,'             `..,'.'       , |`-.\n" +
        "     l                       .'`.  _/  |   `.\n" +
        "     `-.._'-   ,          _ _'   -\" \\  .     `\n" +
        "`.''''''-.`-...,---------','         `. `....__.\n" +
        ".'        `\"-..___      __,'\\          \\  \\     \\\n" +
        "\\_ .          |   `\"\"\"'    `.           . \\     \\\n" +
        "  `.          |              `.          |  .     L\n" +
        "    `.        |`--...________.'.        j   |     |\n" +
        "      `._    .'      |          `.     .|   ,     |\n" +
        "         `--,\\       .            `7\"' |  ,      |\n" +
        "            ` `      `            /     |  |      |    _,-'\"\"\"`-.\n" +
        "             \\ `.     .          /      |  '      |  ,'          `.\n" +
        "              \\  v.__  .        '       .   \\    /| /              \\\n" +
        "               \\/    `\"\"\"\"\"\"`.       \\   \\  /.''                |\n" +
        "                `        .        `._ ___,j.  `/ .-       ,---.     |\n" +
        "                 ,`-.      \\         .\"     `.  |/        j     `    |\n" +
        "                /    `.     \\       /         \\ /         |     /    j\n" +
        "               |       `-.   7-.._ .          |\"          '         /\n" +
        "               |          `./_    `|          |            .     _,'\n" +
        "               `.           / `----|          |-............`---'\n" +
        "                 \\          \\      |          |\n" +
        "                ,'           )     `.         |\n" +
        "                 7____,,..--'      /          |\n" +
        "                                  `---.__,--.'");

        // Display the Squirtle Pokemon information
        System.out.println(squirtle);

        // You can replace [placeholder] with ASCII art later
    }
}
