package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import RoboRunecrafter.util.Paint;
import RoboRunecrafter.util.Resources;

public class CraftRunes extends Node{

    @Override
    public boolean activate(){
            //Condition:
            return Resources.craftRunes == true
            		&& !Players.getLocal().isMoving();
    }

    @Override
    public void execute(){
	
    //Code to execute:
		SceneObject INSIDE_ALTAR = SceneEntities.getNearest(Resources.INSIDE_ALTAR_ID);
		
		if (Resources.craftRunes == true && Players.getLocal().getAnimation() != Resources.CRAFT_ANIMATION && Inventory.getItem(Resources.ESSENCE_ID) != null) {
		    Paint.status = "Crafting runes...";
			Task.sleep(1000, 1500);
			if (INSIDE_ALTAR != null){
				Walking.walk(INSIDE_ALTAR);
			    Camera.turnTo(INSIDE_ALTAR);
			    Task.sleep(1000, 1500);
			    if (INSIDE_ALTAR != null){	
			    	Walking.walk(INSIDE_ALTAR);
			        Paint.DEV = "Interacting with altar...";
			        if (INSIDE_ALTAR != null){
			            INSIDE_ALTAR.interact("Craft-rune");
			            Task.sleep(1000, 1500);
			        }
			    }
			}
		}	
		if (Resources.craftRunes == true && Inventory.getItem(Resources.RUNE_ID) != null && Inventory.getItem(Resources.ESSENCE_ID) == null && Players.getLocal().getAnimation() != Resources.CRAFT_ANIMATION) {
			Paint.runeCount = Inventory.getItem(Resources.RUNE_ID).getStackSize();
			Paint.runesCrafted = Paint.runesCrafted + Paint.runeCount;
			Paint.runeCount = 0;
		    Resources.craftRunes = false;
			Resources.exitAltar = true;
		} else {
            Task.sleep(500, 1000);
		}
	}
}