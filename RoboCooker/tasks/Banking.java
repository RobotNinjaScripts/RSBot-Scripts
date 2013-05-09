package RoboCooker.tasks;

import RoboCooker.util.Paint;
import RoboCooker.util.Antiban;
import RoboCooker.util.Resources;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class Banking extends Node {

    SceneObject bankBooth = SceneEntities.getNearest(Resources.bankID);
    SceneObject catherbyDoor = SceneEntities.getNearest(Resources.catherbyDoorID);
    SceneObject shantayChest = SceneEntities.getNearest(Resources.shantayChest);
    NPC denBanker = NPCs.getNearest(Resources.rogueBankID);

    @Override
	public boolean activate() {
		return Inventory.getItem(Resources.rawFoodID) == null || Bank.isOpen();
    }

	@Override
	public void execute() {
        if (Resources.bonfireMode == true) {
            if (Bank.isOpen()) {
                if (Inventory.getItem(Resources.rawFoodID) == null) {
                    if (Inventory.getCount() >= 1) {
                        Paint.status = "Depositing food...";
                        Bank.depositInventory();
                    } else if (Bank.getItem(Resources.rawFoodID) != null && !Inventory.isFull()) {
                        Paint.status = "Withdrawing food...";
                        Bank.withdraw(Resources.rawFoodID, 0);
                    } else if (Bank.getItem(Resources.rawFoodID) == null) {
                        Paint.status = "Run out of food!";
                        Task.sleep(5000);
                        Bank.close();
                        Game.logout(false);
                    }
                } else if (Inventory.getItem(Resources.rawFoodID) != null) {
                    Paint.status = "Closing bank...";
                    Bank.close();
                }
            } else if (!Bank.isOpen()) {
                Paint.status = "Opening bank...";
                if (Bank.isOpen()) {
                    shantayChest.interact("Open");
                }
            }
        } else if (Resources.bonfireMode == false) {
            if (Bank.isOpen()) {
                if (Inventory.getItem(Resources.rawFoodID) == null) {
                    if (Inventory.getCount() >= 1) {
                        Paint.status = "Depositing food...";
                        Bank.depositInventory();
                    } else if (Bank.getItem(Resources.rawFoodID) != null && !Inventory.isFull()) {
                        Paint.status = "Withdrawing food...";
                        Bank.withdraw(Resources.rawFoodID, 0);
                    } else if (Bank.getItem(Resources.rawFoodID) == null) {
                        Paint.status = "Run out of food to cook!";
                        Task.sleep(5000);
                        Bank.close();
                        Game.logout(false);
                    }
                } else if (Inventory.getItem(Resources.rawFoodID) != null) {
                    Paint.status = "Closing bank...";
                    Bank.close();
                }
            } else if (!Bank.isOpen()) {
                if (bankBooth != null || denBanker != null) {
                    if (Resources.denMode) {
                        if (Calculations.distance(denBanker, Players.getLocal().getLocation()) > 5) {
                            Paint.status = "Walking to bank...";
                            if (Resources.catherbyMode && Calculations.distanceTo(Resources.catherbyDoorTile) <= 5 && Resources.catherbyRangeTile.canReach()) {
                                if (catherbyDoor != null) {
                                    catherbyDoor.interact("Open");
                                }
                            } else {
                                Walking.walk(bankBooth);
                                Antiban.rotateCameraRandom();
                                Task.sleep(500, 1000);
                            }
                        } else if (Calculations.distance(bankBooth, Players.getLocal().getLocation()) < 5) {
                            Paint.status = "Opening bank...";
                            Bank.open();
                        }
                    } else if (Resources.nardahMode || Resources.alKharidMode || Resources.catherbyMode) {
                        if (Calculations.distance(bankBooth, Players.getLocal().getLocation()) > 5) {
                            Paint.status = "Walking to bank...";
                            Walking.walk(bankBooth);
                            Antiban.rotateCameraRandom();
                            Task.sleep(500, 1000);
                        } else if (Calculations.distance(bankBooth, Players.getLocal().getLocation()) < 5) {
                            Paint.status = "Opening bank...";
                            Bank.open();
                        }
                    }
                } else if (bankBooth == null || denBanker == null) {
                    Paint.status = "Can't find bank!";
                    Task.sleep(1000, 1500);
                }
            }
        }
    }
}