package States;

import Entities.Creature.Player;
import Launcher.Handler;
import Worlds.World;

import java.awt.Graphics;


public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Handler handler) {
        super(handler);
        handler.setWorld(world);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
