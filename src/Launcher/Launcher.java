package Launcher;


import Entities.Creature.Player;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("FISH IN THE WILD", 800, 600);
        game.start();
    }
}
