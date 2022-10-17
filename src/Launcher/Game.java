package Launcher;

import Entities.Creature.Player;
import Graphics.ImageLoader;
import Display.Display;
import Graphics.Assets;
import Input.KeyManager;
import Input.MouseManager;
import States.*;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public State gameState;
    public State menuState;
    public State youLostState;
    public State level1passedState;
    public State level2passedState;
    public State level1State;
    public State level2State;
    public State level3State;
    public State helpState;
    public State settingsState;
    public State youwinState;
    public State escState;

    private KeyManager keyManager;
    private MouseManager mouseManager;

    private Handler handler;
    private Player player;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    public State getYouwinState() {
        return youwinState;
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();
        handler = new Handler(this);
        gameState = new GameState(handler);
        level1State = new Level1State(handler);
        level2State = new Level2State(handler);
        level3State = new Level3State(handler);
        level1passedState = new Level1PassedState(handler);
        level2passedState = new Level2PassedState(handler);
        youLostState = new YouLostState(handler);
        helpState = new HelpState(handler);
        settingsState = new SettingsState(handler);
        youwinState = new YouWinState(handler);
        escState = new EscState(handler);

        menuState = new MenuState(handler);

        State.setState(menuState);
    }

    private void tick() {
        keyManager.tick();
        if(State.getState() != null)
            State.getState().tick();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0, width, height);

        if(State.getState() != null)
            State.getState().render(g);

        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta = delta + (now - lastTime) / timePerTick;
            timer = timer + now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public synchronized void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public State getLevel3State() {
        return level3State;
    }

    public synchronized void stop() {
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public State getMenuState() {
        return menuState;
    }

    public State getYouLostState() {
        return youLostState;
    }

    public State getLevel1PassedState() {
        return level1passedState;
    }

    public State getLevel2PassedState() {
        return level2passedState;
    }

    public State getLevel1State() {
        return level1State;
    }

    public State getLevel2State() {
        return level2State;
    }

    public State getEscState() {
        return escState;
    }
}
