package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class CraftRunes extends Node{

    @Override
    public boolean activate(){
		SceneObject INSIDE_ALTAR = SceneEntities.getNearest(RoboRunecrafter.util.Resources.INSIDE_AIR_ALTAR_ID);
            //Condition:
            return RoboRunecrafter.util.Resources.craftRunes == true
            		&& !Players.getLocal().isMoving()
            		&& (INSIDE_ALTAR.isOnScreen());
    }

    @Override
    public void execute(){
	
    //Code to execute:
		SceneObject INSIDE_ALTAR = SceneEntities.getNearest(RoboRunecrafter.util.Resources.INSIDE_AIR_ALTAR_ID);
		
		if (RoboRunecrafter.util.Resources.craftRunes == true && Players.getLocal().getAnimation() != RoboRunecrafter.util.Resources.CRAFT_ANIMATION && Inventory.contains(RoboRunecrafter.util.Resources.ESSENCE_ID)) {
			Task.sleep(1000, 1500);
			Camera.turnTo(INSIDE_ALTAR);
			INSIDE_ALTAR.interact("Craft-rune");
			Task.sleep(1000, 1500);
		
		if (Inventory.contains(RoboRunecrafter.util.Resources.RUNE_ID) && !Inventory.contains(RoboRunecrafter.util.Resources.ESSENCE_ID) && Players.getLocal().getAnimation() != RoboRunecrafter.util.Resources.CRAFT_ANIMATION) {
			RoboRunecrafter.util.Resources.craftRunes = false;
			RoboRunecrafter.util.Resources.exitAltar = true;
		}
		} else {
			if (RoboRunecrafter.util.Resources.craftRunes == true && Inventory.contains(RoboRunecrafter.util.Resources.RUNE_ID) && !Inventory.contains(RoboRunecrafter.util.Resources.ESSENCE_ID) && Players.getLocal().getAnimation() != RoboRunecrafter.util.Resources.CRAFT_ANIMATION) {
				RoboRunecrafter.util.Resources.craftRunes = false;
				RoboRunecrafter.util.Resources.exitAltar = true;
			}
		}
	}
}