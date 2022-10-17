package States;

import Entities.Creature.Enemy;
import Entities.Creature.FishEnemy;
import Graphics.ImageLoader;
import Launcher.Handler;
import Worlds.World;

import java.util.Random;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Level2State extends State {

    Random rand = new Random();
    private World world;
    private BufferedImage Level2_Image;
    private boolean active2 = false;

    public Level2State(Handler handler) {
        super(handler);
        active2 = true;
        Level2_Image = ImageLoader.loadImage("/textures/HartaLevel_2.png");
        world = new World(handler,"resources/Worlds/world2.txt");
        handler.setWorld(world);

        world.getEntityManager().addEntity(new Enemy(handler, 900 + rand.nextInt(500), rand.nextInt(500), 64, 40, 0));
        world.getEntityManager().addEntity(new Enemy(handler, -100 - rand.nextInt(500), rand.nextInt(500), 64, 40, 1));
        world.getEntityManager().addEntity(new Enemy(handler, 900 + rand.nextInt(500), rand.nextInt(500), 64, 40, 2));
        world.getEntityManager().addEntity(new Enemy(handler, -100 - rand.nextInt(500), rand.nextInt(500), 64, 40, 3));

        world.getEntityManager().addEntity(new FishEnemy(handler, 1000 + rand.nextInt(500), rand.nextInt(530), 80, 64, 0));
        world.getEntityManager().addEntity(new FishEnemy(handler, -500 - rand.nextInt(500), rand.nextInt(530), 80, 64, 1));
        world.getEntityManager().getPlayer().setWidth(100);
        world.getEntityManager().getPlayer().setHeight(50);
    }

    public void tick() {
        world.tick();
    }

    public void render(Graphics g) {
        g.drawImage(Level2_Image, 0, 0, null);
        world.render(g);
        handler.getWorld().getEntityManager().getPlayer().drawScore(g);
    }

    public boolean isActive() {
        return active2;
    }

    public void setActive(boolean active) {
        this.active2 = active;
    }
}
