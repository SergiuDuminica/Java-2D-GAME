package Entities.Creature;

import Launcher.Handler;

import java.awt.*;
import java.util.Random;

import Graphics.*;

public class Enemy extends Creature {

    Random rand = new Random();
    private int id;
    public boolean isDead = false;

    public Enemy(Handler handler, float x, float y, int width, int height, int id) {

        super(handler, x, y, width, height);
        this.id = id;
    }

    @Override
    public void tick() {
        move_Enemy();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bots[id], (int) x, (int) y, width, height, null);
    }

    public void die() { }

    private void move_Enemy() {
        if (id % 2 == 0) {
            x += 3;
            if (x > 900) {
                x = -1000 + rand.nextInt(500);
            }
        } else {
            x -= 3;
            if (x < -100) {
                x = 900 + rand.nextInt(1000);
            }
        }
    }
}