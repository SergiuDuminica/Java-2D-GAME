package Tiles;

import Graphics.Assets;

public class Anchor_level1_Tile extends Tile {

    public Anchor_level1_Tile(int id) {
        super(Assets.Level1_Anchor, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
