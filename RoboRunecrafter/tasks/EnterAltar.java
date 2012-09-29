package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class EnterAltar extends Node{

    @Override
    public boolean activate()
    {
            //Condition:
            return RoboRunecrafter.util.Resources.enterAltar == true
            		&& (Inventory.getItem(RoboRunecrafter.util.Resources.ESSENCE_ID) != null
            		&& !Players.getLocal().isMoving());
    }

    @Override
    public void execute(){
	
    //Code to execute:
		SceneObject OUTSIDE_ALTAR = SceneEntities.getNearest(RoboRunecrafter.util.Resources.OUTSIDE_AIR_ALTAR_ID);
		SceneObject INSIDE_ALTAR = SceneEntities.getNearest(RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID);
		
		if (RoboRunecrafter.util.Resources.enterAltar == true) {
			if (!RoboRunecrafter.util.Resources.ALTAR_AREA.contains(Players.getLocal().getLocation())) {
				if (INSIDE_ALTAR.isOnScreen()) {
					if (Players.getLocal().getAnimation() != RoboRunecrafter.util.Resources.CRAFT_ANIMATION) {
						RoboRunecrafter.util.Resources.enterAltar = false;
						RoboRunecrafter.util.Resources.craftRunes = true;
					}
				} else {
					Camera.turnTo(INSIDE_ALTAR);
				}
			}
		}
		
		if (RoboRunecrafter.util.Resources.enterAltar == true && OUTSIDE_ALTAR.isOnScreen() && RoboRunecrafter.util.Resources.ASTRAL_RUNE_VALIDATE == false) {
			Task.sleep(1000, 1500);
			Camera.turnTo(OUTSIDE_ALTAR);
			OUTSIDE_ALTAR.interact("Enter");

		if (RoboRunecrafter.util.Resources.enterAltar == true && INSIDE_ALTAR.isOnScreen() && !OUTSIDE_ALTAR.isOnScreen()) {
			Task.sleep(3000, 5000);
			RoboRunecrafter.util.Resources.enterAltar = false;
			RoboRunecrafter.util.Resources.craftRunes = true;
			
		if (RoboRunecrafter.util.Resources.enterAltar == true && RoboRunecrafter.util.Resources.ASTRAL_RUNE_VALIDATE == true && RoboRunecrafter.util.Resources.ALTAR_AREA.contains(Players.getLocal().getLocation())) {
			RoboRunecrafter.util.Resources.enterAltar = false;
			RoboRunecrafter.util.Resources.craftRunes = true;
		}
		
		} else {
			Camera.turnTo(INSIDE_ALTAR);
			if (RoboRunecrafter.util.Resources.enterAltar == true && !OUTSIDE_ALTAR.isOnScreen() && !RoboRunecrafter.util.Resources.ALTAR_AREA.contains(Players.getLocal().getLocation())) {
				Task.sleep(3000, 5000);
				RoboRunecrafter.util.Resources.enterAltar = false;
				RoboRunecrafter.util.Resources.craftRunes = true;
			}
			}
		}
	}
}