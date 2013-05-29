package RoboCooker;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;

import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;

import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.Manifest;

import RoboCooker.util.GUI;
import RoboCooker.util.Paint;
import RoboCooker.strategies.Banking;
import RoboCooker.strategies.Cooking;

import javax.swing.*;

/**
 * RoboCooker
 * Developed by RobotNinja
 */

@Manifest(authors = { "RobotNinja" }, name = "RoboCooker", description = "Cooks any raw food at Al Kharid.",
        hidden = false, version = 0.1, website = "N/A")

public class RoboCooker extends ActiveScript implements PaintListener, MouseListener, MessageListener {

    public static int FOOD_ID = -1;

    private final java.util.List<Node> nodes = Collections.synchronizedList(new ArrayList<Node>());

	@Override
	public void onStart() {
        nodes.add(new Banking());
        nodes.add(new Cooking());
        Paint.startXP = Skills.getExperience(Skills.COOKING);
        log.info("Welcome to RoboCooker.");
        log.info("Loading GUI...");
        Paint.Status = "Waiting...";

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });

	}

    @Override
    public int loop() {

        if(nodes == null || nodes.size() <= 0)
            return 100;

        final Node[] jobs = nodes.toArray(new Node[nodes.size()]);

        for(final Node job : jobs) {

            if(job.activate())
            {
                getContainer().submit(job);
                job.join();
            }
        }

        return Random.nextInt(100, 200);
    }

    @Override
    public void onStop() {
        System.out.println("Thank you for using RoboCooker!");
        System.out.println("Please leave feedback on the forum thread.");
    }

	@Override
	public void onRepaint(Graphics render) {
		Paint.drawPaintAndCursor(render);
	}

    @Override
    public void messageReceived(MessageEvent messageEvent) {
        if (messageEvent.getMessage().contains("You successfully cook") || messageEvent.getMessage().contains("You manage to") || messageEvent.getMessage().contains("You roast")) {
            Paint.foodCooked++;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(Paint.bounds.contains(e.getPoint())) {
            Paint.showPaint = !Paint.showPaint;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}