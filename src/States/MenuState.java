package States;

import Graphics.ImageLoader;
import Launcher.Handler;
import UserInterface.ClickListener;
import UserInterface.UiImageButton;
import UserInterface.UiManager;
import Graphics.Assets;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Date;

public class MenuState extends State {

    private UiManager uiManager;
    private BufferedImage meniu;
    private static UiManager copy_uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UiManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        copy_uiManager = uiManager;

        uiManager.addObject(new UiImageButton(282, 190, 256, 64, Assets.start_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().level1State = new Level1State (handler);
                State.setState(handler.getGame().level1State);
            }
        }));
//        uiManager.addObject(new UiImageButton(282, 250, 256, 64, Assets.load_button, new ClickListener() {
//            @Override
//            public void onClick() {
//                handler.getMouseManager().setUiManager(null);
//                handler.getGame().level3State = new Level3State(handler);
//                handler.getGame().getLevel3State().startDate = new Date();
//                State.setState(handler.getGame().level3State);
//            }
//        }));
        uiManager.addObject(new UiImageButton(282, 300, 256, 64, Assets.settings_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().settingsState = new SettingsState (handler);
                State.setState(handler.getGame().settingsState);
            }
        }));
        uiManager.addObject(new UiImageButton(282, 410, 256, 64, Assets.help_button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().helpState = new HelpState(handler);
                State.setState(handler.getGame().helpState);
            }
        }));
        meniu = ImageLoader.loadImage("/textures/Meniu.png");
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(meniu, 0, 0, null);
        uiManager.render(g);
    }

    public static UiManager getCopy_uiManager() {
        return copy_uiManager;
    }
}
