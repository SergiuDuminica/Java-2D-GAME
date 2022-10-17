package Tiles;

import Graphics.Assets;

public class Anchor_level2_Tile extends Tile {

    public Anchor_level2_Tile(int id) {
        super(Assets.Level2_Anchor, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
