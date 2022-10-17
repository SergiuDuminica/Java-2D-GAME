package States;

import Launcher.Handler;
import Graphics.ImageLoader;
import UserInterface.ClickListener;
import UserInterface.UiImageButton;
import UserInterface.UiManager;


import Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HelpState extends State {

    private UiManager uiManager;
    private BufferedImage help_state;

    public HelpState(Handler handler) {
        super(handler);
        help_state = ImageLoader.loadImage("/textures/Help.png");
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UiImageButton(282, 470, 256, 64, Assets.return_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().menuState = new MenuState(handler);
                State.setState(handler.getGame().menuState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(help_state, 0, 0, null);
        uiManager.render(g);
    }
}
