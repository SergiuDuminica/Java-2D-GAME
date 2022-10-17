package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[10];
    public static Tile Anchor1 = new Anchor_level1_Tile(1);
    public static Tile Anchor2 = new Anchor_level2_Tile(2);
    public static Tile blank_tile = new BlankTile(0);

    public static final int TILEWIDTH = 160, TILEHEIGHT = 200;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {

    }

    public boolean isSolid() {
        return false;
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public int getId() {
        return id;
    }
}
