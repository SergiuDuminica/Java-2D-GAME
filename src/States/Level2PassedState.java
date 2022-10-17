package States;

import Launcher.Handler;
import UserInterface.ClickListener;
import UserInterface.UiImageButton;
import UserInterface.UiManager;
import Graphics.Assets;
import Graphics.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Level2PassedState extends State{

    private UiManager uiManager;
    private BufferedImage level2passed;
    private static UiManager copy_uiManager;

    public Level2PassedState(Handler handler) {
        super(handler);
        level2passed = ImageLoader.loadImage("/textures/Level2Completed.png");
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        copy_uiManager = uiManager;
        uiManager.addObject(new UiImageButton(282, 240, 256, 64, Assets.continue_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().level3State = new Level3State (handler);
                State.setState(handler.getGame().level3State);
            }
        }));

        uiManager.addObject(new UiImageButton(282, 340, 256, 64, Assets.return_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().menuState = new MenuState (handler);
                State.setState(handler.getGame().menuState);
            }
        }));

        uiManager.addObject(new UiImageButton(282, 340, 256, 64, Assets.exit_button, new ClickListener() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));

    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(level2passed, 0, 0, null);
        uiManager.render(g);
    }

    public static UiManager getCopy_uiManager() {
        return copy_uiManager;
    }

}
