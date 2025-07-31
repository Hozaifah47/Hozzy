package PokeThree;

import java.util.*;

public class Pokemon {
    public String name, type;
    public int health, maxHealth, defense, attack;

    public String[] moves = new String[4];
    public int[] movePowers = new int[4];
    public String[] moveTypes = new String[4];

    public Pokemon(String name, int health, String type, int defense, int attack,
            String m1, int p1, String t1,
            String m2, int p2, String t2,
            String m3, int p3, String t3,
            String m4, int p4, String t4) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.type = type;
        this.defense = defense;
        this.attack = attack;

        moves[0] = m1;
        movePowers[0] = p1;
        moveTypes[0] = t1;
        moves[1] = m2;
        movePowers[1] = p2;
        moveTypes[1] = t2;
        moves[2] = m3;
        movePowers[2] = p3;
        moveTypes[2] = t3;
        moves[3] = m4;
        movePowers[3] = p4;
        moveTypes[3] = t4;
    }

    public Pokemon clonePokemon() {
        return new Pokemon(name, maxHealth, type, defense, attack,
                moves[0], movePowers[0], moveTypes[0],
                moves[1], movePowers[1], moveTypes[1],
                moves[2], movePowers[2], moveTypes[2],
                moves[3], movePowers[3], moveTypes[3]);
    }

    public boolean isFainted() {
        return health <= 0;
    }
}

class PokemonFactory {

    private static Pokemon[] pokedex = new Pokemon[4];

    static {
        pokedex[0] = new Pokemon("Pikachu", 200, "Electric", 120, 240,
                "Thunderbolt", 90, "Electric",
                "Quick Attack", 60, "Normal",
                "Iron Tail", 80, "Steel",
                "Electro Ball", 100, "Electric");

        pokedex[1] = new Pokemon("Charmander", 200, "Fire", 140, 270,
                "Ember", 60, "Fire",
                "Scratch", 50, "Normal",
                "Flamethrower", 90, "Fire",
                "Dragon Breath", 90, "Dragon");

        pokedex[2] = new Pokemon("Bulbasaur", 200, "Grass", 150, 250,
                "Vine Whip", 70, "Grass",
                "Tackle", 60, "Normal",
                "Razor Leaf", 70, "Grass",
                "Sleep Powder", 0, "Grass");

        pokedex[3] = new Pokemon("Squirtle", 200, "Water", 170, 220,
                "Water Gun", 80, "Water",
                "Bite", 70, "Dark",
                "Bubble", 80, "Water",
                "Skull Bash", 75, "Normal");
    }

    public static Pokemon create(String name) {
        for (int i = 0; i < pokedex.length; i++) {
            if (pokedex[i].name.equalsIgnoreCase(name)) {
                return pokedex[i].clonePokemon();
            }
        }
        System.out.println("Pokemon " + name + " not found!");
        return null;
    }

    public static Pokemon getRandomPokemon() {
        Random rand = new Random();
        int index = rand.nextInt(pokedex.length);
        return pokedex[index].clonePokemon();
    }

    public static void listAll() {
        System.out.println("Available Pokémon:");
        for (int i = 0; i < pokedex.length; i++) {
            System.out.println("- " + pokedex[i].name);
        }
    }
}

class Battle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to Pokémon Battle!");
        PokemonFactory.listAll();

        System.out.print("\nChoose your Pokémon: ");
        String playerChoice = sc.nextLine();
        Pokemon player = PokemonFactory.create(playerChoice);

        if (player == null) {
            System.out.println("Could not create your Pokémon. Exiting...");
            sc.close();
            return;
        }

        Pokemon enemy = PokemonFactory.getRandomPokemon();
        System.out.println("\nEnemy Pokémon is " + enemy.name + "!");

        System.out.println("\nBattle Start! " + player.name + " vs. " + enemy.name);
        System.out.println("your stats atk=" + player.attack + "defense=" + player.defense);

        while (!player.isFainted() && !enemy.isFainted()) {
            // Player's turn
            System.out.println("\nYour turn! Choose a move:");
            for (int i = 0; i < 4; i++) {
                System.out.println((i + 1) + ". " + player.moves[i] + " (" + player.movePowers[i] + " base power)");
            }

            int move = 0;
            if (sc.hasNextInt()) {
                move = sc.nextInt();
            } else {
                System.out.println("Invalid input. Turn skipped.");
                sc.next(); // clear invalid input
                move = -1;
            }

            if (move < 1 || move > 4) {
                System.out.println("Invalid move. Turn skipped.");
            } else {
                useMove(player, enemy, move - 1);
            }

            if (enemy.isFainted()) {
                System.out.println(enemy.name + " fainted! You win!");
                break;
            }

            // Enemy's turn (random move)
            System.out.println("\nEnemy's turn...");
            int enemyMove = rand.nextInt(4);
            useMove(enemy, player, enemyMove);

            if (player.isFainted()) {
                System.out.println(player.name + " fainted! You lose!");
                break;
            }

            System.out.println("\n" + player.name + " HP: " + player.health);
            System.out.println(enemy.name + " HP: " + enemy.health);
        }

        sc.close();
    }

    public static void useMove(Pokemon attacker, Pokemon target, int moveIndex) {
        String moveName = attacker.moves[moveIndex];
        int bp = attacker.movePowers[moveIndex];
        int a = attacker.attack;
        int d = target.defense;
        int damage = (int) ((((2 * 100 / 5 + 2) * bp * (a / d)) / 50) + 2);
        System.out.println(attacker.name + " used " + moveName + "!" + "it dealt " + damage + " damage");
        target.health -= damage;
        if (target.health < 0)
            target.health = 0;
    }
}