package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import RoboRunecrafter.util.Paint;
import RoboRunecrafter.util.Resources;

public class EnterAltar extends Node{

    @Override
    public boolean activate()
    {
            //Condition:
            return Resources.enterAltar == true
            		&& (Inventory.getItem(Resources.ESSENCE_ID) != null
            		&& !Players.getLocal().isMoving());
    }

    @Override
    public void execute(){
	
    //Code to execute:
		SceneObject OUTSIDE_ALTAR = SceneEntities.getNearest(Resources.OUTSIDE_ALTAR_ID);
		SceneObject INSIDE_ALTAR = SceneEntities.getNearest(Resources.INSIDE_ALTAR_ID);
		
		if (Resources.enterAltar == true && Resources.ASTRAL_RUNE_VALIDATE == false) {
			if (!Resources.ALTAR_AREA.contains(Players.getLocal().getLocation())) {
				if (INSIDE_ALTAR.isOnScreen()) {
					if (Players.getLocal().getAnimation() != Resources.CRAFT_ANIMATION) {
						Resources.enterAltar = false;
						Resources.craftRunes = true;
					}
				} else {
					Camera.turnTo(INSIDE_ALTAR);
				}
			}
		}		
		if (Resources.enterAltar == true && OUTSIDE_ALTAR.isOnScreen() && Resources.ASTRAL_RUNE_VALIDATE == false && OUTSIDE_ALTAR != null) {
		    Paint.status = "Entering altar...";
			Camera.turnTo(OUTSIDE_ALTAR);
			OUTSIDE_ALTAR.interact("Enter");
			Task.sleep(1000, 1500);

		if (Resources.enterAltar == true && INSIDE_ALTAR.isOnScreen() && !OUTSIDE_ALTAR.isOnScreen()) {
			Resources.enterAltar = false;
			Resources.craftRunes = true;
			
		if (Resources.enterAltar == true && Resources.ASTRAL_RUNE_VALIDATE == true && Resources.ALTAR_AREA.contains(Players.getLocal().getLocation())) {
			Resources.enterAltar = false;
			Resources.craftRunes = true;
		}
		
		} else {
			Camera.turnTo(INSIDE_ALTAR);
			if (Resources.enterAltar == true && !OUTSIDE_ALTAR.isOnScreen() && !Resources.ALTAR_AREA.contains(Players.getLocal().getLocation())) {
				Resources.enterAltar = false;
				Resources.craftRunes = true;
			}
			}
		}
	}
}