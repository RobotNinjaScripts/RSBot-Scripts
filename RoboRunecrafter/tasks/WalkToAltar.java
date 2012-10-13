package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import RoboRunecrafter.util.Paint;
import RoboRunecrafter.util.Resources;

public class WalkToAltar extends Node{

    @Override
    public boolean activate()
    {
            //Condition:
            return Resources.goToAltar == true
            		&& (Inventory.getItem(Resources.ESSENCE_ID) != null);
    }

    @Override
    public void execute(){
	
    //Code to execute:
		SceneObject OUTSIDE_ALTAR = SceneEntities.getNearest(Resources.OUTSIDE_ALTAR_ID);
		if (Resources.goToAltar == true && (OUTSIDE_ALTAR == null || !OUTSIDE_ALTAR.isOnScreen())) {
		    Paint.status = "Walking to altar...";
			Task.sleep(1000, 1500);
			if (Resources.ALTAR_PATH != null) {
			    Walking.newTilePath(Resources.ALTAR_PATH).traverse();
			    if (Resources.ALTAR_AREA != null && OUTSIDE_ALTAR != null){
			        if (Resources.ALTAR_AREA.contains(Players.getLocal().getLocation()) && Resources.ALTAR_AREA != null || OUTSIDE_ALTAR.isOnScreen() && OUTSIDE_ALTAR != null) {
				        Resources.goToAltar = false;
				        Resources.enterAltar = true;
			        }
			    }
			}
			//PLAYER IS IN BANK WITH ESSENCE, WALK TO ALTAR
		} else {
			if (Resources.ALTAR_AREA.contains(Players.getLocal().getLocation()) && Resources.ALTAR_AREA != null || OUTSIDE_ALTAR.isOnScreen() && OUTSIDE_ALTAR != null) {
				Resources.goToAltar = false;
				Resources.enterAltar = true;
			}	
		}
	}
}