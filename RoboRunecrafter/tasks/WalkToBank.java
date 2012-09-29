package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;


public class WalkToBank extends Node{

    @Override
    public boolean activate(){

            //Condition:
            return RoboRunecrafter.util.Resources.goToBank == true
            		&& (Inventory.getItem(RoboRunecrafter.util.Resources.RUNE_ID) != null);
    }

    @Override
    public void execute(){
	
    //Code to execute:
		if (RoboRunecrafter.util.Resources.goToBank == true && !RoboRunecrafter.util.Resources.BANK_AREA.contains(Players.getLocal().getLocation()) && Inventory.contains(RoboRunecrafter.util.Resources.RUNE_ID)) {
			Walking.newTilePath(RoboRunecrafter.util.Resources.ALTAR_PATH).reverse().traverse();
				//PLAYER IS OUTSIDE ALTAR WITH RUNES, WALK TO BANK
		} else {
			if (RoboRunecrafter.util.Resources.goToBank == true && RoboRunecrafter.util.Resources.BANK_AREA.contains(Players.getLocal().getLocation()) && Inventory.contains(RoboRunecrafter.util.Resources.RUNE_ID)) {
				RoboRunecrafter.util.Resources.depositRunesGetEssence = true;
				RoboRunecrafter.util.Resources.goToBank = false;
			}
		}
	}
}