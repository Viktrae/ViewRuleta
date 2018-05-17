/**
 * @author Victor Aznar Echevarria - victor.aznar.2017
 * @project ViewRuleta
 */

package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Config {

    //Path to information
    public static final String RESOURCES_PATH = "resources\\";
    //background image name
    public static final String RULETA_TABLE_IMAGE = RESOURCES_PATH + "RULETA_TABLE.PNG";
    //betButton image
    public static final String BET_BUTTON_IMAGE = RESOURCES_PATH + "BET_BUTTON2.PNG";
    //Bet button pressed image
    public static final String BLACK_JACK_BET_BUTTON_PRESSED_IMAGE = RESOURCES_PATH + "BET_BUTTON_PRESSED.png";
    //bet button on top
    public static final String BLACK_JACK_BET_BUTTON_ON_TOP = RESOURCES_PATH + "BET_BUTTON_ON_TOP.png";
    //back button pressed
    public static final String BLACK_JACK_BACK_BUTTON_PRESSED = RESOURCES_PATH + "BACK_ARROW_PRESSED.png";
    //back button on top
    public static final String BLACK_JACK_BACK_BUTTON_ON_TOP = RESOURCES_PATH + "BACK_ARROW_ON_TOP.png";
    //avatar image
    public static final String USER_AVATAR_IMAGE = RESOURCES_PATH + "AVATAR_MAN.png";
    //dialog box
    //public static final String DIALOG_BOX_IMAGE = RESOURCES_PATH + "DIALOG_BOX.png";
    //window icon
    public static final String WINDOW_GENERAL_ICON = RESOURCES_PATH + "RULETA_PROGRAM_ICON.png";
    //coin frame number
    public static final int STACK_ANIMATION_FRAME_NUMBER = 2;
    //mountain coins frame number
    public static final int MONEY_ANIMATION_FRAME_NUMBER = 2;
    //mountain coins frame number
    public static final int COIN_ANIMATION_FRAME_NUMBER = 8;
    //mountain coins frame number
    public static final int CARTEL_ANIMATION_FRAME_NUMBER = 2;
    //coin base image extension
    public static final String PNG_EXTENSION = ".png";
    //money name
    public static final String CARTEL_ANIMATION_IMAGE = RESOURCES_PATH + "CARTEL_";
    //money name
    public static final String COIN_ANIMATION_IMAGE = RESOURCES_PATH + "coin_0";
    //money name
    public static final String MONEY_ANIMATION_IMAGE = RESOURCES_PATH + "MONEY_";
    //coin base name
    public static final String STACK_ANIMATION_IMAGE = RESOURCES_PATH + "STACK_";
    //ball
    public static final String BALL_ANIMATION_IMAGE = RESOURCES_PATH + "PIXEL_BALL1.PNG";
    //back button
    public static final String BACK_BUTTON_IMAGE = RESOURCES_PATH + "BACK_ARROW.png";
    //font name
    private static final String FONT_NAME = "ARCADECLASSIC.TTF";
    public static Font font;


    //loads font
    public static void loadFont(){
        File font_file = new File(RESOURCES_PATH + FONT_NAME);

        try{
            font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        }catch(IOException | FontFormatException e) {
            System.out.println("Error loading fonts");
        }
    }

    //Action commands

    //BACK button
    public static final String BACK_ACTIONCOMMAND = "BACK";

    //BET button
    public static final String BET_ACTIONCOMMAND = "BET";


}
