package Entities.Creature;

import java.awt.*;
import java.awt.image.BufferedImage;

import Graphics.Assets;
import Graphics.Animation;
import Launcher.Handler;
import States.*;


public class Player extends Creature {

    private Animation animLeft, animRight;
    public boolean isDead = false;
    public int contor = 0;

    public void setContor(int contor) {
        this.contor = contor;
    }

    public int getContor() {
        return contor;
    }

    public static Player player;

    public static Player getInstance(Handler handler){
        if (player== null){
            player = new Player(handler, 100, 100 );
        }

        return player;
    }

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT / 2);

        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
    }

    @Override
    public void tick() {
        animLeft.tick();
        animRight.tick();
        getInput();
        move();
        if (handler.getGame().getLevel1State().isActive()) {
            player.width = 64;
            player.height = 32;
            if (contor == 5) {
                handler.getMouseManager().setUiManager(Level1PassedState.getCopy_uiManager());
                State.setState(handler.getGame().getLevel1PassedState());
                handler.getGame().getLevel2State().setActive(true);
                handler.getGame().getLevel1State().setActive(false);
            }
        }
        if (handler.getGame().getLevel2State().isActive()) {
            if (contor == 10) {
                handler.getMouseManager().setUiManager(Level2PassedState.getCopy_uiManager());
                State.setState(handler.getGame().getLevel2PassedState());
            }
        }
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up) {
            if(y > 2) yMove = -speed;
        }
        if(handler.getKeyManager().down) {
            if (y < 567) yMove = speed;
        }
        if(handler.getKeyManager().right) {
            if (x < 733)
                xMove = speed;
        }
        if(handler.getKeyManager().left) {
            if (x > 2)
                xMove = -speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0){
            return animRight.getCurrentFrame();
        } else
            return animLeft.getCurrentFrame();
    }

    public void drawScore(Graphics g) {
        Font fnt = new Font("arial", 3, 50);
        String text;
        text = Integer.toString(this.contor);
        g.setColor(Color.black);
        g.setFont(fnt);
        g.drawString("Score: " + text, 300,50);
    }

    public void die() {
        isDead = true;
        handler.getMouseManager().setUiManager(YouLostState.getCopy_uiManager());
        State.setState(handler.getGame().getYouLostState());
    }
}