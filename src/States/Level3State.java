package States;

import Entities.Creature.OctopusEnemy;
import Launcher.Handler;
import Worlds.World;
import Graphics.ImageLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Level3State extends State {

    Random rand = new Random();
    private int counter = 0;
    Timer timer;
    private boolean active = false;

    private World world;
    private BufferedImage Level3_Image;

    public Level3State(Handler handler) {
        super(handler);

        Level3_Image = ImageLoader.loadImage("/textures/HartaLevel_3.png");
        world = new World(handler,"resources/Worlds/world3.txt");
        world.getEntityManager().addEntity(new OctopusEnemy(handler, rand.nextInt(730), 700 + rand.nextInt(500), 62, 100));
        world.getEntityManager().addEntity(new OctopusEnemy(handler, rand.nextInt(730), 700 + rand.nextInt(500), 62, 100));
        world.getEntityManager().addEntity(new OctopusEnemy(handler, rand.nextInt(730), 700 + rand.nextInt(500), 62, 100));
        world.getEntityManager().addEntity(new OctopusEnemy(handler, rand.nextInt(730), 700 + rand.nextInt(500), 62, 100));
        world.getEntityManager().addEntity(new OctopusEnemy(handler, rand.nextInt(730), 700 + rand.nextInt(300), 62, 100));
        world.getEntityManager().addEntity(new OctopusEnemy(handler, rand.nextInt(730), 700 + rand.nextInt(200), 62, 100));
        world.getEntityManager().addEntity(new OctopusEnemy(handler, rand.nextInt(730), 700 + rand.nextInt(100), 62, 100));
        handler.setWorld(world);
        world.getEntityManager().getPlayer().setWidth(128);
        world.getEntityManager().getPlayer().setHeight(64);
        startTimer(-1);
    }

    public void tick() {
        world.tick();
        active = true;
    }

    public void render(Graphics g) {
        g.drawImage(Level3_Image, 0, 0, null);
        world.render(g);
        drawTimer(g);
    }

    private void startTimer(long seconds) {
        counter = 30;
        final JLabel label = new JLabel("0");
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (active) {
                    counter--;
                }
                if (counter == seconds) {
                    timer.stop();
                    handler.getMouseManager().setUiManager(YouWinState.getCopy_uiManager());
                    States.State.setState(handler.getGame().youwinState);
                }
            }
        });
        timer.start();
    }

    public void drawTimer(Graphics g) {
        Font fnt = new Font("arial", 3, 30);
        String text;
        text = Integer.toString(counter);
        g.setColor(Color.cyan);
        g.setFont(fnt);
        g.drawString("Time's up in: " + text, 275,30);
    }
}