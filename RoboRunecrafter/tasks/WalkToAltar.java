package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class WalkToAltar extends Node{

    @Override
    public boolean activate()
    {
            //Condition:
            return RoboRunecrafter.util.Resources.goToAltar == true
            		&& (Inventory.getItem(RoboRunecrafter.util.Resources.ESSENCE_ID) != null);
    }

    @Override
    public void execute(){
	
    //Code to execute:
		SceneObject OUTSIDE_ALTAR = SceneEntities.getNearest(RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID);
		if (RoboRunecrafter.util.Resources.goToAltar == true && (OUTSIDE_ALTAR == null || !OUTSIDE_ALTAR.isOnScreen())) {
			Task.sleep(1000, 1500);
			Walking.newTilePath(RoboRunecrafter.util.Resources.ALTAR_PATH).traverse();
			if (RoboRunecrafter.util.Resources.ALTAR_AREA.contains(Players.getLocal().getLocation()) || OUTSIDE_ALTAR.isOnScreen()) {
				RoboRunecrafter.util.Resources.goToAltar = false;
				RoboRunecrafter.util.Resources.enterAltar = true;
			}
			//PLAYER IS IN BANK WITH ESSENCE, WALK TO ALTAR
		} else {
			if (RoboRunecrafter.util.Resources.ALTAR_AREA.contains(Players.getLocal().getLocation()) || OUTSIDE_ALTAR.isOnScreen()) {
				RoboRunecrafter.util.Resources.goToAltar = false;
				RoboRunecrafter.util.Resources.enterAltar = true;
			}	
		}
	}
}