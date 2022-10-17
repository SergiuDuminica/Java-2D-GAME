package Entities.Creature;

import Launcher.Handler;
import Graphics.Assets;

import java.awt.*;
import java.util.Random;

public class FishEnemy extends Creature {

    private int id;
    private Random rand = new Random();

    public FishEnemy(Handler handler, float x, float y, int width, int height, int id) {
        super(handler, x, y, width, height);
        this.id = id;
    }

    @Override
    public void die() {

    }

    @Override
    public void tick() {
        move_fishEnemy();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bad_enemy[id], (int) x, (int) y, width, height, null);
    }

    private void move_fishEnemy() {
        if (id % 2 == 0) {
            x += 3;
            if (x > 900)
                x = -1000 + rand.nextInt(500);
        } else {
            x -= 3;
            if (x < -100)
                x = 900 + rand.nextInt(1000);
        }
    }
}
