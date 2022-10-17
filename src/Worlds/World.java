package Worlds;

import Entities.Creature.Enemy;
import Entities.Creature.Player;
import Entities.EntityManager;
import Entities.Static.Anchor;
import Launcher.Handler;
import Tiles.Tile;
import Util.Utils;

import java.awt.*;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private EntityManager entityManager;
    private Player player;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public World(Handler handler, String path) {
        this.handler = handler;
        Player player = Player.getInstance(handler);
        entityManager = new EntityManager(handler, player);
        loadWorld(path);
        player.setContor(0);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }

    public void tick() {
        entityManager.tick();
    }

    public void render(Graphics g) {
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
            }
        }
        entityManager.render(g);

    }

    public Tile getTile(int x, int y) {
        if(x < 0 || y < 0 || x >= width || y >= height)
            return Tile.blank_tile;

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.blank_tile;
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public Player getPlayer(){
        return this.player;
    }
}
