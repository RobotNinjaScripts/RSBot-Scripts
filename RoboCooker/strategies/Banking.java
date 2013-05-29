package RoboCooker.strategies;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.util.Timer;

import RoboCooker.RoboCooker;
import RoboCooker.util.GUI;
import RoboCooker.util.Paint;
import RoboCooker.util.Constants;

/**
 * RoboCooker
 * Developed by RobotNinja
 */

public class Banking extends Node {

	@Override
	public boolean activate() {
        return Game.isLoggedIn() && !GUI.isRunning && Inventory.getItem(RoboCooker.FOOD_ID) == null;
	}

	@Override
	public void execute() {

        SceneObject bank = SceneEntities.getNearest(Constants.IDS_AL_KHARID_BANK);

        if (Bank.isOpen()) {
            if (Inventory.getCount() >= 1) {
                Bank.depositInventory();
            }
            if (Bank.getItem(RoboCooker.FOOD_ID) == null) {
                Paint.Status = "Run out of food!";
                System.out.println("Run out of food to cook.");
                System.out.println("Stopping script...");
                Game.logout(false);
                System.exit(0);
            }
            if (Bank.getItem(RoboCooker.FOOD_ID) != null && !Inventory.isFull()) {
                Bank.withdraw(RoboCooker.FOOD_ID, 0);
            }
        } else {
            if (bank != null) {
                if (Calculations.distance(bank, Players.getLocal().getLocation()) > 5) {
                    Paint.Status = "Walking to bank...";
                    Walking.newTilePath(Constants.AL_KHARID_PATH).reverse().traverse();
                    Task.sleep(500,1000);
                } else if (Calculations.distance(bank, Players.getLocal().getLocation()) < 5) {
                    Paint.Status = "Opening bank...";
                    Bank.open();
                    Timer t = new Timer(2000);
                    while (t.isRunning() && !Bank.isOpen()) {
                        Task.sleep(20);
                    }
                }
            }
        }
    }
}