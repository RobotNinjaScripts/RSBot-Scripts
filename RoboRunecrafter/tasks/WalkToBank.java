package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;

import RoboRunecrafter.util.Paint;
import RoboRunecrafter.util.Resources;


public class WalkToBank extends Node{

    @Override
    public boolean activate(){

            //Condition:
            return Resources.goToBank == true
            		&& (Inventory.getItem(Resources.RUNE_ID) != null);
    }

    @Override
    public void execute(){
	
    //Code to execute:
		if (Resources.goToBank == true && !Resources.BANK_AREA.contains(Players.getLocal().getLocation()) && Inventory.getItem(Resources.RUNE_ID) != null) {
		    Paint.status = "Walking to bank...";
			Walking.newTilePath(Resources.ALTAR_PATH).reverse().traverse();
				//PLAYER IS OUTSIDE ALTAR WITH RUNES, WALK TO BANK
		} else {
			if (Resources.goToBank == true && Resources.BANK_AREA.contains(Players.getLocal().getLocation()) && Inventory.getItem(Resources.RUNE_ID) != null) {
				Resources.banking = true;
				Resources.goToBank = false;
			}
		}
	}
}