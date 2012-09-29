package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class GetEssence extends Node{

    @Override
    public boolean activate()
    {
            //Condition:
            return RoboRunecrafter.util.Resources.getEssence == true
            		&& (Inventory.getItem(RoboRunecrafter.util.Resources.ESSENCE_ID) == null
            		&& RoboRunecrafter.util.Resources.BANK_AREA.contains(Players.getLocal().getLocation())
            		&& !Players.getLocal().isMoving());
    }

    @Override
    public void execute(){
	
    //Code to execute:
	SceneObject BOOTH = SceneEntities.getNearest(RoboRunecrafter.util.Resources.BANK_BOOTH_ID);
	if (RoboRunecrafter.util.Resources.getEssence == true) {
			Camera.turnTo(BOOTH);
			BOOTH.interact("Bank");
			Task.sleep(1000, 1500);
			Bank.depositInventory();
			Bank.withdraw(RoboRunecrafter.util.Resources.ESSENCE_ID, 0);
			Bank.close();
			if (Inventory.contains(RoboRunecrafter.util.Resources.ESSENCE_ID) && !Inventory.contains(RoboRunecrafter.util.Resources.RUNE_ID)) {
				RoboRunecrafter.util.Resources.getEssence = false;
				RoboRunecrafter.util.Resources.goToAltar = true;
			}
	}
}
}