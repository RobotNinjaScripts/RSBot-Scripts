package RoboRunecrafter.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	
	// IMAGES
	public static Image paintBackground = getImage("http://i1127.photobucket.com/albums/l636/Leyton1512/roborunecrafter_paint_final.png");
	public static Image cursor = getImage("http://i1127.photobucket.com/albums/l636/Leyton1512/New_cursor.png");
	
	public static int startExp;
	public static int runeCount = 0;
	
	public static Timer timeRunning = new Timer(0);
	public static Font verdana15 = new Font("Verdana", 0, 15);
	public static Font verdana12 = new Font("Verdana", 0, 12);
	public static int runesCrafted = 0;
	public static int runesHour = 0;
	public static int expGained = 0;
	public static int expHour = 0;
	public static String selectedRune = "null";
	public static String version = "0.1";
	public static String status = "Nothing.";
	public static String DEV = "null";

	public static void drawPaintAndCursor(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
		
		// CALCULATIONS
		runesHour = (int) ((runesCrafted) * 3600000D / timeRunning.getElapsed());
		expHour = (int) ((expGained) * 3600000D / timeRunning.getElapsed());
		expGained = Skills.getExperience(Skills.RUNECRAFTING) - startExp;
		
		// DRAW
		g.drawImage(paintBackground, 0, 330, null);
		g.drawImage(cursor, Mouse.getX(), Mouse.getY(), null);		
		g.setColor(Color.WHITE);
		g.setFont(verdana15);
		g.drawString(timeRunning.toElapsedString(), 156, 422);
		g.drawString(selectedRune, 156, 451);
		g.drawString(version, 401, 480);
		g.drawString(NumberFormat.getInstance().format(runesHour), 156, 508);
		g.drawString(NumberFormat.getInstance().format(runesCrafted), 156, 480);
		g.drawString(NumberFormat.getInstance().format(expGained), 401, 422);
		g.drawString(NumberFormat.getInstance().format(expHour), 401, 451);		
		g.setColor(Color.WHITE);
		g.setFont(verdana12);
		g.drawString(status, 348, 508);
		//g.drawString(DEV, 20, 140);
	}
}