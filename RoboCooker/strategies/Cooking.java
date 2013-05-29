package RoboCooker.strategies;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.Menu;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Entity;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.node.SceneObject;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import RoboCooker.RoboCooker;
import RoboCooker.util.GUI;
import RoboCooker.util.Paint;
import RoboCooker.util.Constants;

/**
 * RoboCooker
 * Developed by RobotNinja
 */

public class Cooking extends Node {

    public static int destroyRock() {
        for (Item i : Inventory.getItems()) {
            if (i.getName().equals("Strange rock")) {
                return i.getId();
            }
            i.getWidgetChild().interact("destroy");
        }
        return -1;
    }

    public static boolean inventoryContains(String s) {
        final Item[] items = Inventory.getItems();
        for (final Item i : items) {
            if (i != null && i.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean interactUsingMenu(final String action, final Entity entity) {
        if (entity.click(false)) {
            final Timer t = new Timer(500);
            while (t.isRunning() && !Menu.isOpen()) {
                Task.sleep(50);
            }
            if (Menu.isOpen()) {
                return Menu.select(action);
            }
        }
        return false;
    }

    public static WidgetChild COOK_BUTTON = Widgets.get(1371, 5);

    public static WidgetChild CANCEL_BUTTON = Widgets.get(1251,18);

    public static WidgetChild COOK_BOX = Widgets.get(1371,0);

    public static WidgetChild ACTION_BAR = Widgets.get(640,4);

    public static WidgetChild MINIMISE_BUTTON = Widgets.get(640,30);


	@Override
	public boolean activate() {
        return Game.isLoggedIn() && !GUI.isRunning && Inventory.getItem(RoboCooker.FOOD_ID) != null;
	}

	@Override
	public void execute() {

        SceneObject range = SceneEntities.getNearest(Constants.IDS_RANGE);

        if (inventoryContains("Strange rock")) {
            destroyRock();
        }
        if (ACTION_BAR.visible()) {
            Paint.Status = "Minimising action bar...";
            MINIMISE_BUTTON.interact("Minimise");
            Timer t = new Timer(1000);
            while (t.isRunning() && MINIMISE_BUTTON.visible()) {
                Task.sleep(20);
            }
        }
        if (COOK_BOX.visible()) {
            Paint.Status = "Using interface...";
            COOK_BUTTON.click(true);
            Timer t = new Timer(1500);
            while (t.isRunning() && COOK_BUTTON.visible()) {
                Task.sleep(20);
            }
        }
        if (CANCEL_BUTTON.visible()) {
            while(CANCEL_BUTTON.validate()){
                Paint.Status = "Cooking food...";
                Task.sleep(100);
            }
        }
        if (!COOK_BOX.visible() && !CANCEL_BUTTON.visible()) {
            if (Bank.isOpen()) {
                Bank.close();
            } else {
                if (range != null) {
                    if (Calculations.distance(range, Players.getLocal().getLocation()) > 5) {
                        Paint.Status = "Walking to range...";
                        Walking.newTilePath(Constants.AL_KHARID_PATH).traverse();
                        Task.sleep(500,1000);
                    } else if (Calculations.distance(range, Players.getLocal().getLocation()) < 5) {
                        Paint.Status = "Interacting with range...";
                        Inventory.getItem(RoboCooker.FOOD_ID).getWidgetChild().interact("Use");
                        interactUsingMenu("Use", range);
                        Timer t = new Timer(1000);
                        while (t.isRunning() && !COOK_BOX.visible()) {
                            Task.sleep(20);
                        }
                    }
                }
            }
        }
    }
}