package RoboRunecrafter.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.util.Timer;

public class Paint {
	
	public  static Image getImage(String url) {
        try { return ImageIO.read(new URL(url)); } 
        catch(IOException e) { return null; }
	}
	
	public static Image paintBackground = getImage("http://i1127.photobucket.com/albums/l636/Leyton1512/roborunecrafter_paint_final.png");
	public static Image cursor = getImage("http://i1127.photobucket.com/albums/l636/Leyton1512/New_cursor.png");
	
	public static int x;
	public static int y;
	
	public static Font verdana15 = new Font("Verdana", 0, 15);
	public static String runesCrafted = "test";
	public static String runesHour = "test";
	public static String expGained = "test";
	public static String expHour = "test";
	public static String selectedRune = "test";
	public static String version = "1.0";
	public static String status = "test";	
	public static Timer timeRunning = new Timer(0);

	public static void drawPaintAndCursor(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
		
		x = Mouse.getX();
		y = Mouse.getY();
		
		g.drawImage(paintBackground, 0, 330, null);
		g.drawImage(cursor, x, y, null);
		
		g.setColor(Color.WHITE);
		g.setFont(verdana15);
		g.drawString(timeRunning.toElapsedString(), 156, 416);
		g.drawString(selectedRune, 156, 449);
		g.drawString(runesHour, 156, 500);
		g.drawString(runesCrafted, 156, 472);
		g.drawString(version, 400, 476);
		g.drawString(expGained, 400, 417);
		g.drawString(expHour, 400, 445);
		g.drawString(status, 350, 502);		
	}

}