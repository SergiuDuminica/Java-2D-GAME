package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Entities.Creature.Enemy;
import Entities.Creature.FishEnemy;
import Entities.Creature.OctopusEnemy;
import Launcher.Handler;

public abstract class Entity {

    private Random rand = new Random();
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;

    public float getX() {
        return x;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public boolean checkEntityCollisions (float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0f,0f).intersects((getCollisionBounds(xOffset, yOffset)))) {
                if (e instanceof Enemy) {
                    handler.getWorld().getEntityManager().getPlayer().isDead = true;
                    handler.getWorld().getEntityManager().deleteEntity(e);
                    handler.getWorld().getEntityManager().getPlayer().contor++;
                    handler.getWorld().getEntityManager().addEntity(new Enemy(handler, 900 + rand.nextInt(1000), 100 + rand.nextInt(500), 64, 40, rand.nextInt(16)));
                }
                if (e instanceof FishEnemy) {
                    handler.getWorld().getEntityManager().getPlayer().die();
                }
                if (e instanceof OctopusEnemy) {
                    handler.getWorld().getEntityManager().getPlayer().die();
                }
                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

}
