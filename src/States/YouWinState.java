package States;

import Launcher.Handler;
import Graphics.ImageLoader;
import Graphics.Assets;
import UserInterface.ClickListener;
import UserInterface.UiImageButton;
import UserInterface.UiManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class YouWinState extends State {

    private UiManager uiManager;
    private BufferedImage youwin_state;
    private static UiManager copy_uiManager;

    public YouWinState(Handler handler) {
        super(handler);
        youwin_state = ImageLoader.loadImage("/textures/YouWin.png");
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        copy_uiManager = uiManager;
        uiManager.addObject(new UiImageButton(282, 140, 256, 64, Assets.return_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().menuState = new MenuState (handler);
                State.setState(handler.getGame().menuState);
            }
        }));
        uiManager.addObject(new UiImageButton(282, 440, 256, 64, Assets.exit_button, new ClickListener() {
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
        g.drawImage(youwin_state, 0, 0, null);
        uiManager.render(g);
    }

    public static UiManager getCopy_uiManager() {
        return copy_uiManager;
    }

}
