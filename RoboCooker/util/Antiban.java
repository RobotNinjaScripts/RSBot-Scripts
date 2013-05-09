package RoboCooker.util;

import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.interactive.Player;

public class Antiban {

    public static void rotateScreen() {

        if(Players.getLocal().getInteracting() != null) {

            Camera.turnTo(Players.getLocal().getInteracting()); // Turns camera to the object you're interacting with
            Camera.setPitch(Camera.getPitch() + Random.nextInt(-10, 10)); // Rotate up or down a random amount.
            Camera.setAngle(Camera.getYaw() + Random.nextInt(-22, 22)); // Rotate left or right a random amount.

        } else {

            // Since you're not interacting with anything, allow a larger rotation.
            Camera.setPitch(Camera.getPitch() + Random.nextInt(-40, 40)); // Rotate up or down a random amount.
            Camera.setAngle(Camera.getYaw() + Random.nextInt(-83, 83)); // Rotate left or right a random amount.

        }

    }

    public static void checkSkill(int index) {

        Tabs currentTab = Tabs.getCurrent();

        // This could be used as Antiban.checkSkill(Random.nextInt(0, 24))
        Tabs.STATS.open(); // Self explanatory - opens STATS tab.
        Skills.getWidgetChild(index).hover(); // Hovers the specified stat

        Task.sleep(500);

        currentTab.open(); // Go back to previous tab

    }

    public static void checkPlayer() {

        Player[] players = Players.getLoaded(); // Gets all players around
        int whatPlayer = Random.nextInt(0, players.length); // Which player to hover

        if(Players.getLocal().getInteracting() == null) {
            Camera.turnTo(players[whatPlayer]); //If you're not doing anything, turn to the player
        }

        players[whatPlayer].hover(); // Hovers the aforementioned random player

    }

    public void checkTab(Tabs tab) {

        Tabs currentTab = Tabs.getCurrent();

        tab.open(); // Open specified tab

        Task.sleep(500);

        currentTab.open(); // Go back to previous tab

    }

    public static void randomDefault() {

        int randomAnti = Random.nextInt(1, 5);

        switch(randomAnti) {

            case 1:
                rotateScreen();
                break;

            case 2:
                checkPlayer();
                break;

            case 3:
                Task.sleep(600,800);
                break;

            case 4:
                Task.sleep(600,800);
                break;

            case 5:
                Tabs[] possibleTabs = { Tabs.CLAN_CHAT, Tabs.FRIENDS, Tabs.FRIENDS_CHAT }; // Tabs a human might check
                Tabs currentTab = Tabs.getCurrent();
                possibleTabs[Random.nextInt(0, 2)].open(); // Check random tab
                Task.sleep(500);
                currentTab.open(); // Return to previous tab
                break;

        }

    }
    public static void checkSkillRandom() {

        int randomAnti = Random.nextInt(1, 2);

        switch(randomAnti) {

            case 1:
                checkSkill(20);
                break;

            case 2:
                Task.sleep(200,400);
                break;

        }

    }
    public static void rotateCameraRandom() {

        int randomAnti = Random.nextInt(1, 7);

        switch(randomAnti) {

            case 1:
                Task.sleep(1000,2000);
                break;

            case 2:
                Task.sleep(1000,2000);
                break;

            case 3:
                rotateScreen();
                break;

            case 4:
                Task.sleep(1000,2000);
                break;

            case 5:
                Task.sleep(1000,2000);
                break;

            case 6:
                Task.sleep(1000,2000);
                break;

            case 7:
                Task.sleep(1000,2000);
                break;

        }

    }

}