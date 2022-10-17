package Graphics;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 64, height = 32;

    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage[] octopus;
    public static BufferedImage Level1_Anchor, Level2_Anchor;
    public static BufferedImage blanktile;
    public static BufferedImage[] bots = new BufferedImage[17];
    public static BufferedImage[] start_button = new BufferedImage[2];
    public static BufferedImage[] load_button = new BufferedImage[2];
    public static BufferedImage[] settings_button = new BufferedImage[2];
    public static BufferedImage[] help_button = new BufferedImage[2];
    public static BufferedImage[] continue_button = new BufferedImage[2];
    public static BufferedImage[] save_button = new BufferedImage[2];
    public static BufferedImage[] return_button = new BufferedImage[2];
    public static BufferedImage[] exit_button = new BufferedImage[2];
    public static BufferedImage[] bad_enemy = new BufferedImage[2];

    public static void init() {
        SpriteSheet sheet_player = new SpriteSheet(ImageLoader.loadImage("/textures/PersonajulPrincipal_Billy.png"));
        SpriteSheet sheet_anchor_level1 = new SpriteSheet(ImageLoader.loadImage("/textures/Anchor_Level1.png"));
        SpriteSheet sheet_anchor_level2 = new SpriteSheet(ImageLoader.loadImage("/textures/Anchor_Level2.png"));
        SpriteSheet sheet_bots = new SpriteSheet(ImageLoader.loadImage("/textures/Mancare.png"));
        SpriteSheet sheet_butoane = new SpriteSheet(ImageLoader.loadImage("/textures/Butoane.png"));
        SpriteSheet sheet_badenemy = new SpriteSheet(ImageLoader.loadImage("/textures/BadEnemy.png"));
        SpriteSheet sheet_badenemyleft = new SpriteSheet(ImageLoader.loadImage("/textures/BadEnemy_left.png"));
        SpriteSheet sheet_octopus = new SpriteSheet(ImageLoader.loadImage("/textures/Octopus.png"));

        octopus = new BufferedImage[6];
        octopus[5] = sheet_octopus.crop(64, 206, 63, 84);
        octopus[4] = sheet_octopus.crop(0, 206, 64, 86);
        octopus[3] = sheet_octopus.crop(62, 106, 65, 94);
        octopus[2] = sheet_octopus.crop(0, 106, 62, 100);
        octopus[1] = sheet_octopus.crop(62, 0, 62, 104);
        octopus[0] = sheet_octopus.crop(0,0, 62, 106);

        player_left = new BufferedImage[2];
        player_left[0] = sheet_player.crop(64, 32, width, height);
        player_left[1] = sheet_player.crop(64,0, width, height);

        player_right = new BufferedImage[2];
        player_right[0] = sheet_player.crop(0, 32, width, height);
        player_right[1] = sheet_player.crop(0,0, width, height);

        bots[0] = sheet_bots.crop(0,0, width, height);
        bots[1] = sheet_bots.crop(64, 0, width, height);
        bots[2] = sheet_bots.crop(0, height, width, height);
        bots[3] = sheet_bots.crop(64, height, width, height);
        bots[4] = sheet_bots.crop(0, height * 2, width, height);
        bots[5] = sheet_bots.crop(64, height * 2, width, height);
        bots[6] = sheet_bots.crop(0, height * 3, width, height);
        bots[7] = sheet_bots.crop(64, height * 3, width, height);
        bots[8] = sheet_bots.crop(0, height * 4, width, height);
        bots[9] = sheet_bots.crop(64, height * 4, width, height);
        bots[10] = sheet_bots.crop(0, height * 5, width, height);
        bots[11] = sheet_bots.crop(64, height * 5, width, height);
        bots[12] = sheet_bots.crop(0, height * 6, width, height);
        bots[13] = sheet_bots.crop(64, height * 6, width, height);
        bots[14] = sheet_bots.crop(0, height * 7, width, height);
        bots[15] = sheet_bots.crop(64, height * 7, width, height);

        bad_enemy[0] = sheet_badenemy.crop(0,0,width*2, height * 2);
        bad_enemy[1] = sheet_badenemyleft.crop(0,0,width*2, height * 2);

        start_button[1] = sheet_butoane.crop(0,0, width * 4, 74);
        start_button[0] = sheet_butoane.crop(0, 296, width * 4, 74);

        load_button[1] = sheet_butoane.crop(0, 76, width * 4, 74);
        load_button[0] = sheet_butoane.crop(0, 372, width * 4, 74);

        settings_button[1] = sheet_butoane.crop(0, 148, width * 4, 74);
        settings_button[0] = sheet_butoane.crop(0, 444, width * 4, 74);

        help_button[1] = sheet_butoane.crop(0, 222, width * 4, 74);
        help_button[0] = sheet_butoane.crop(0, 518, width * 4, 74);

        continue_button[1] = sheet_butoane.crop(0, 592, width * 4, 74);
        continue_button[0] = sheet_butoane.crop(0, 888, width * 4, 74);

        save_button[1] = sheet_butoane.crop(0, 666, width * 4, 74);
        save_button[0] = sheet_butoane.crop(0, 962, width * 4, 74);

        return_button[1] = sheet_butoane.crop(0, 740, width * 4, 74);
        return_button[0] = sheet_butoane.crop(0, 1036, width * 4, 74);

        exit_button[1] = sheet_butoane.crop(0, 814, width * 4, 74);
        exit_button[0] = sheet_butoane.crop(0, 1110, width * 4, 74);

        Level1_Anchor = sheet_anchor_level1.crop(0,0, width + 36, height * 4);
        Level2_Anchor = sheet_anchor_level2.crop(0, 0 ,width * 2, height * 8);

        blanktile = null;
    }

}
