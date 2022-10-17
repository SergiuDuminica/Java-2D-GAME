package Entities.Static;

import Launcher.Handler;
import Tiles.Tile;
import Graphics.Assets;

import java.awt.*;

public class Anchor extends StaticEntity {

    public Anchor (Handler handler, float x , float y, int width, int height) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
        this.width = width;
        this.height = height;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Level1_Anchor, (int) (x), (int) (y), width, height, null);
    }
}
