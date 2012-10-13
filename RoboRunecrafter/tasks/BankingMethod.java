package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import RoboRunecrafter.util.Paint;
import RoboRunecrafter.util.Resources;

public class BankingMethod extends Node{

    @Override
    public boolean activate()
    {
            //Condition:
            return Resources.banking == true
            		&& Resources.BANK_AREA.contains(Players.getLocal().getLocation())
            		&& !Players.getLocal().isMoving();
    }

    @Override
    public void execute(){
	
    //Code to execute:
	SceneObject BOOTH = SceneEntities.getNearest(Resources.BANK_BOOTH_ID);
	if (Resources.banking == true) {
		Paint.status = "Banking...";
	    Camera.turnTo(BOOTH);
		BOOTH.interact("Bank");
		Task.sleep(1500, 2000);
		if (Bank.isOpen()){
		    Bank.depositInventory();
		}
		    if (Bank.getItem(Resources.ESSENCE_ID) != null){
		        Bank.withdraw(Resources.ESSENCE_ID, 0);
		        Bank.close();
		        Task.sleep(1000, 1500);
		        if (Inventory.getItem(Resources.ESSENCE_ID) != null && Inventory.getItem(Resources.RUNE_ID) == null) {
				    Resources.banking = false;
				    Resources.goToAltar = true;
			    }
		    }
	        if (Bank.getItem(Resources.ESSENCE_ID) == null && Bank.isOpen()){
	        	Bank.close();
	    	    Task.sleep(500, 1000);
	            Paint.status = "Logging out...";
	            Bank.close();
	            Game.logout(false);
	            Task.sleep(1000, 1500);
	            Paint.status = "Run out of essence.";
	        }
	    } else {
		    if (Resources.banking == true && Inventory.getItem(Resources.ESSENCE_ID) != null && Inventory.getItem(Resources.RUNE_ID) == null){
			    Resources.banking = false;
			    Resources.goToAltar = true;
		    }
	    }
    }
}