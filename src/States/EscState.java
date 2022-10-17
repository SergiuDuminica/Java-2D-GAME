package States;

import Launcher.Handler;
import Graphics.ImageLoader;
import UserInterface.ClickListener;
import UserInterface.UiImageButton;
import UserInterface.UiManager;

import Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EscState extends State {

    private UiManager uiManager;
    private BufferedImage esc_state;
    private static UiManager copy_uiManager;

    public EscState(Handler handler) {
        super(handler);
        esc_state = ImageLoader.loadImage("/textures/Meniu.png");
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UiImageButton(282, 190, 256, 64, Assets.continue_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().level1State);
            }
        }));

        uiManager.addObject(new UiImageButton(282, 300, 256, 64, Assets.return_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().menuState = new MenuState(handler);
                State.setState(handler.getGame().menuState);
            }
        }));
        uiManager.addObject(new UiImageButton(282, 410, 256, 64, Assets.exit_button, new ClickListener() {
            @Override
            public void onClick() {
                System.exit(1);
            }
        }));
    }


    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(esc_state, 0, 0, null);
        uiManager.render(g);
    }

    public static UiManager getCopy_uiManager() {
        return copy_uiManager;
    }

}