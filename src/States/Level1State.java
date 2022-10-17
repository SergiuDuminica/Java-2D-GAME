package States;

import Entities.Creature.Enemy;
import Entities.Creature.FishEnemy;
import Entities.Static.Anchor;
import Graphics.ImageLoader;
import Launcher.Handler;
import Worlds.World;

import java.util.Random;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Level1State extends State {

    private boolean active = false;
    Random rand = new Random();
    private World world;
    private BufferedImage Level1_Image;

    public Level1State(Handler handler) {

        super(handler);
        active = true;
        Level1_Image = ImageLoader.loadImage("/textures/HartaLevel_1.png");
        world = new World(handler,"resources/Worlds/world1.txt");
        handler.setWorld(world);

        world.getEntityManager().addEntity(new Enemy(handler, 900 + rand.nextInt(500), rand.nextInt(500), 64, 40, 0));
        world.getEntityManager().addEntity(new Enemy(handler, -100 - rand.nextInt(500), rand.nextInt(500), 64, 40, 1));
        world.getEntityManager().addEntity(new Enemy(handler, 900 + rand.nextInt(500), rand.nextInt(500), 64, 40, 2));
        world.getEntityManager().addEntity(new Enemy(handler, -100 - rand.nextInt(500), rand.nextInt(500), 64, 40, 3));

        world.getEntityManager().addEntity(new FishEnemy(handler, 1000 + rand.nextInt(500), rand.nextInt(530), 80, 64, 0));
        world.getEntityManager().addEntity(new FishEnemy(handler, -500 - rand.nextInt(500), rand.nextInt(530), 80, 64, 1));

    }

    public void tick() {
        world.tick();
    }

    public void render(Graphics g) {
        g.drawImage(Level1_Image, 0, 0, null);
        world.render(g);
        handler.getWorld().getEntityManager().getPlayer().drawScore(g);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
