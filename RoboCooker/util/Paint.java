package RoboCooker.util;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;

import javax.imageio.ImageIO;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Timer;

public class Paint {
	
	public  static Image getImage(String url) {
        try { return ImageIO.read(new URL(url)); } 
        catch(IOException e) { return null; }
	}
	
	//HIDE BUTTON
    public static Rectangle bounds = new Rectangle(484, 404, 16, 16);
    public static boolean showPaint = true;

	// IMAGES
	public static Image paintBackground = getImage("http://i.imgur.com/4nQd3.png");
    public static Image devBackground = getImage("http://i.imgur.com/VoWRp.png");
	public static Image circleCursor = getImage("http://i.imgur.com/SOzAtcp.png");
    public static Image cursor = getImage("http://images.wikia.com/runescape/images/9/9a/New_cursor.png");
    public static Image buttonGlow = getImage("http://i1127.photobucket.com/albums/l636/Leyton1512/buttonGlow.png");
	
	//VARIABLES
    public static Timer timeRunning = new Timer(0);
	public static Font verdana15 = new Font("Verdana", 0, 15);
	public static Font verdana10 = new Font("Verdana", 0, 10);
	public static int foodCooked = 0;
	public static int foodHour = 0;
	public static int expGained = 0;
	public static int expHour = 0;
    public static int startExp;
	public static String version = "0.1";
	public static String status = "Nothing.";
    public static String devConsole = "null";

	public static void drawPaintAndCursor(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
		
		// CALCULATIONS
		foodHour = (int) ((foodCooked) * 3600000D / timeRunning.getElapsed());
		expHour = (int) ((expGained) * 3600000D / timeRunning.getElapsed());
		expGained = Skills.getExperience(Skills.COOKING) - startExp;
		
		// DRAW
        if (Resources.developerMode){
            g.drawImage(devBackground, 7, 332, null);
            g.setColor(Color.WHITE);
            g.setFont(verdana15);
            g.drawString(devConsole, 105, 365);
        }
        if (showPaint){
            g.drawImage(paintBackground, -10, 377, null);
		    g.drawImage(circleCursor, Mouse.getX() - 15, Mouse.getY() - 17, null);
		    g.setColor(Color.WHITE);
		    g.setFont(verdana15);
		    g.drawString(timeRunning.toElapsedString(), 128, 503);
		    g.drawString(NumberFormat.getInstance().format(foodHour), 128, 475);
		    g.drawString(NumberFormat.getInstance().format(foodCooked), 128, 447);
		    g.drawString(NumberFormat.getInstance().format(expGained), 365, 447);
		    g.drawString(NumberFormat.getInstance().format(expHour), 365, 475);
		    g.setColor(Color.WHITE);
		    g.setFont(verdana10);
		    g.drawString(status, 327, 501);
        } else {
            g.drawImage(buttonGlow, 482, 402, null);
            g.drawImage(circleCursor, Mouse.getX() - 15, Mouse.getY() - 17, null);
        }
	}
}