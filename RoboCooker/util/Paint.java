package RoboCooker.util;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;

import javax.imageio.ImageIO;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Timer;

/**
 * RoboCooker
 * Developed by RobotNinja
 */

public class Paint {
	
	public  static Image getImage(String url) {
        try { return ImageIO.read(new URL(url)); } 
        catch(IOException e) { return null; }
	}

    public static Image paintBackground = getImage("http://i.imgur.com/4nQd3.png");

    public static Image circleCursor = getImage("http://i.imgur.com/SOzAtcp.png");

    public static Image buttonGlow = getImage("http://i1127.photobucket.com/albums/l636/Leyton1512/buttonGlow.png");
	
	public static Timer timeRunning = new Timer(0);

	public static Font verdana15 = new Font("Verdana", 0, 15);

    public static Font verdana10 = new Font("Verdana", 0, 10);

    public static String Status = "null";

    public static Rectangle bounds = new Rectangle(484, 404, 16, 16);

    public static boolean showPaint = true;

    public static int foodCooked;

    public static int startXP;

	public static int expPH() {
        return (int) ((xpGained()) * 3600000D / timeRunning.getElapsed());
    }

    public static int foodPH() {
        return (int) ((foodCooked) * 3600000D / timeRunning.getElapsed());
    }

    public static int xpGained() {
        return Skills.getExperience(Skills.COOKING) - startXP;
    }

	public static void drawPaintAndCursor(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
        if (showPaint){
            g.drawImage(paintBackground, -10, 377, null);
            g.drawImage(circleCursor, Mouse.getX() - 15, Mouse.getY() - 17, null);
            g.setColor(Color.WHITE);
            g.setFont(verdana15);
            g.drawString(timeRunning.toElapsedString(), 128, 503);
            g.drawString(NumberFormat.getInstance().format(foodPH()), 128, 475);
            g.drawString(NumberFormat.getInstance().format(foodCooked), 128, 447);
            g.drawString(NumberFormat.getInstance().format(xpGained()), 365, 447);
            g.drawString(NumberFormat.getInstance().format(expPH()), 365, 475);
            g.setColor(Color.WHITE);
            g.setFont(verdana10);
            g.drawString(Status, 327, 501);
        } else {
            g.drawImage(buttonGlow, 482, 402, null);
            g.drawImage(circleCursor, Mouse.getX() - 15, Mouse.getY() - 17, null);
        }
    }
}