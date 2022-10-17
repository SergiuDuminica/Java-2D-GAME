package Entities.Creature;

import Launcher.Handler;

import java.awt.*;
import java.util.Random;

import Graphics.Animation;
import Graphics.Assets;

public class OctopusEnemy extends Creature {

    Random rand = new Random();
    private Animation octo;

    public OctopusEnemy(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        octo = new Animation(500, Assets.octopus);
    }

    @Override
    public void tick() {
        move_OctopusEnemy();
        octo.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.octo.getCurrentFrame(), (int) x, (int) y, width, height, null);
    }

    @Override
    public void die() { }

    private void move_OctopusEnemy() {
        y -= 2;
        if (y < -120)
            y = 900 + rand.nextInt(500);
    }
}
