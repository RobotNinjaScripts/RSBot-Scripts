package RoboCooker.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.Menu;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.Entity;
import org.powerbot.game.api.wrappers.node.SceneObject;

import RoboCooker.util.Paint;
import RoboCooker.util.Antiban;
import RoboCooker.util.Resources;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import java.awt.*;

public class Cooking extends Node {

    SceneObject cookingObject = SceneEntities.getNearest(Resources.rangeID);
    SceneObject catherbyDoor = SceneEntities.getNearest(Resources.catherbyDoorID);

    public static WidgetChild cookButton = Widgets.get(1371,5);
    public static WidgetChild cancelButton = Widgets.get(1251,18);
    public static WidgetChild cookBox = Widgets.get(1371,0);
    public static WidgetChild actionBar = Widgets.get(640,4);
    public static WidgetChild actionBarClose = Widgets.get(640,30);
    public static WidgetChild bonfireMenu = Widgets.get(1179,18);
    public static WidgetChild bonfireMenuCook = Widgets.get(1179,16);

    public static boolean actionBarOpen() {
        return actionBar.visible();
    }

    public static boolean bonfireMenuOpen() {
        return bonfireMenu.visible();
    }

    private static boolean interactUsingMenu(final String action,
                                             final Entity entity) {
        return interactUsingMenu(action, null, entity);
    }

    private static boolean interactUsingMenu(final String action,
                                             final String option, final Entity entity) {
        if (entity.click(false)) {
            final Timer t = new Timer(500);
            while (t.isRunning() && !Menu.isOpen()) {
                Task.sleep(50);
            }
            if (Menu.isOpen()) {
                return Menu.select(action, option);
            }
        }
        return false;
    }

@Override
    public boolean activate() {
        return Inventory.getItem(Resources.rawFoodID) != null && !Bank.isOpen();
    }

    @Override
    public void execute() {
        Paint.devConsole = "Cooking is active.";
        if (actionBarOpen()) {
            Paint.status = "Minimising action bar...";
            Paint.devConsole = "Minimising action bar...";
            actionBarClose.interact("Minimise");
            Paint.devConsole = "Action bar minimised.";
        }
        if (bonfireMenuOpen()) {
            Paint.status = "Using interface...";
            Paint.devConsole = "Using the bonfire menu interface.";
            bonfireMenuCook.interact("Select");
            Paint.devConsole = "Bonfire menu done.";
        }
        if (!cookBox.visible() && !cancelButton.visible()) {
            if (cookingObject != null) {
                Paint.devConsole = "cookingObject is not null.";
                if (Calculations.distance(cookingObject, Players.getLocal().getLocation()) > 5) {
                    Paint.status = "Walking to " + Resources.cookingObjectType;
                    if (Resources.alKharidMode) {
                        Walking.newTilePath(Resources.alKharidPath).traverse();
                        Antiban.rotateCameraRandom();
                        Task.sleep(500,1000);
                    } else if (Resources.catherbyMode) {
                        if (Resources.catherbyMode && Calculations.distanceTo(Resources.catherbyDoorTile) <= 5 && Resources.catherbyRangeTile.canReach()) {
                            if (catherbyDoor != null) {
                                catherbyDoor.interact("Open");
                            }
                        }
                        Walking.newTilePath(Resources.catherbyPath).traverse();
                        Antiban.rotateCameraRandom();
                        Task.sleep(500,1000);
                    } else {
                        Walking.walk(cookingObject);
                        Antiban.rotateCameraRandom();
                        Task.sleep(500,1000);
                    }
                } else if (Calculations.distance(cookingObject, Players.getLocal().getLocation()) < 5) {
                    if (cookingObject == null) {
                        Task.sleep(500, 1000);
                    } else if (cookingObject != null) {
                    Paint.status = "Interacting with " + Resources.cookingObjectType;
                        if (Resources.useFoodMode) {
                            Inventory.getItem(Resources.rawFoodID).getWidgetChild().interact("Use");
                            interactUsingMenu("Use", cookingObject);
                            Task.sleep(900, 1500);
                        } else {
                            interactUsingMenu(Resources.cookOption, cookingObject);
                            Paint.devConsole = "Interacted with " + Resources.cookingObjectType;
                            Task.sleep(900, 1500);
                        }
                    }
                }
            } else if (cookingObject == null) {
                Paint.status = "Can't find the " + Resources.cookingObjectType;
            }
        } else if (cookBox.visible()) {
            Paint.status = "Using interface...";
            cookButton.click(true);
            Task.sleep(900,1200);
        } else if (cancelButton.visible()) {
            while(cancelButton.validate()){
                Paint.status = "Cooking food...";
                Antiban.rotateCameraRandom();
                Task.sleep(100);
            }
        } else {
            Paint.devConsole = "Unknown action.";
        }
    }
}