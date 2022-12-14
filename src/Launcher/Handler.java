package Launcher;

import Input.KeyManager;
import Input.MouseManager;
import Worlds.World;

public class Handler {

    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() { return game.getMouseManager(); }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Game getGame() {
        return game;
    }

    public World getWorld() {
        return world;
    }
}
