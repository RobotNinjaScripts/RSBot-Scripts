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

public class ExitAltar extends Node{

    @Override
    public boolean activate(){

            //Condition:
            return Resources.exitAltar == true
            		&& (Inventory.getItem(Resources.RUNE_ID) != null
            		&& Inventory.getItem(Resources.ESSENCE_ID) == null
            		&& !Players.getLocal().isMoving()
            		&& Players.getLocal().getAnimation() != Resources.CRAFT_ANIMATION);
    }

    @Override
    public void execute(){
	
    //Code to execute:
		SceneObject PORTAL = SceneEntities.getNearest(Resources.PORTAL_ID);
		
		if (Resources.exitAltar == true) {
		    Paint.status = "Exiting altar...";
			Camera.turnTo(PORTAL);
			Task.sleep(300, 500);
			Walking.walk(PORTAL);
			Task.sleep(1000, 1500);
			PORTAL.interact("Enter");
			Task.sleep(3000, 4000);
			Resources.exitedAltar = true;
	
		if (Resources.exitAltar == true && Resources.exitedAltar == true) {
			Resources.exitAltar = false;
			Resources.exitedAltar = false;
			Resources.goToBank = true;
			}
		}
	}
}