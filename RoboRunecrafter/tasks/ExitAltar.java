package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class ExitAltar extends Node{

    @Override
    public boolean activate(){

            //Condition:
            return RoboRunecrafter.util.Resources.exitAltar == true
            		&& (Inventory.getItem(RoboRunecrafter.util.Resources.RUNE_ID) != null
            		&& Inventory.getItem(RoboRunecrafter.util.Resources.ESSENCE_ID) == null
            		&& !Players.getLocal().isMoving()
            		&& Players.getLocal().getAnimation() != RoboRunecrafter.util.Resources.CRAFT_ANIMATION);
    }

    @Override
    public void execute(){
	
    //Code to execute:
		SceneObject PORTAL = SceneEntities.getNearest(RoboRunecrafter.util.Resources.PORTAL_ID);
		SceneObject INSIDE_ALTAR = SceneEntities.getNearest(RoboRunecrafter.util.Resources.INSIDE_AIR_ALTAR_ID);
		
		if (RoboRunecrafter.util.Resources.exitAltar == true && INSIDE_ALTAR.isOnScreen()) {
			Task.sleep(1000, 1500);
			Camera.turnTo(PORTAL);
			PORTAL.interact("Enter");
			Task.sleep(3000, 5000);
			RoboRunecrafter.util.Resources.exitedAltar = true;
	
		if (RoboRunecrafter.util.Resources.exitAltar == true && RoboRunecrafter.util.Resources.exitedAltar == true) {
			Task.sleep(1000, 1500);
			RoboRunecrafter.util.Resources.exitAltar = false;
			RoboRunecrafter.util.Resources.exitedAltar = false;
			RoboRunecrafter.util.Resources.goToBank = true;
			}
		}
	}
}