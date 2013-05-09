package RoboCooker.util;

import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class Resources {

    //GUI BOOLEANS
    public static boolean developerMode = false;
    public static boolean bonfireMode = false;
    public static boolean denMode = false;
    public static boolean nardahMode = false;
    public static boolean catherbyMode = false;
    public static boolean alKharidMode = false;
    public static boolean useFoodMode = false;

    //MAIN STRINGS
    public static String cookOption;
    public static String cookingObjectType;

    //MAIN INTEGERS
    public static int rawFoodID;
    public static int[] rangeID;
    public static int bankID;

    //RAW FOOD IDS
    public static int rawShrimpID = 317;
    public static int rawAnchoviesID = 321;
    public static int rawTroutID = 335;
    public static int rawSalmonID = 331;
    public static int rawTunaID = 359;
    public static int rawLobsterID = 377;
    public static int rawSwordfishID = 371;
    public static int rawMonkfishID = 7944;
    public static int rawSharkID = 383;
    public static int rawCavefishID = 15264;
    public static int rawRocktailID = 15270;

    //RANGE AND BANK IDS
    public static int[] rogueFireID = { 2732 };
    public static int rogueBankID = 14707;
    public static int[] nardahRangeID = { 10377 };
    public static int nardahBankID = 10517;
    public static int[] alKharidRangeID = { 76295 };
    public static int alKharidBankID = 76274;
    public static int[] catherbyRangeID = { 2728 };
    public static int catherbyBankID = 2213;
    public static int catherbyDoorID = 1530;
    public static int[] bonfireIDs = { 70755, 70757, 70758, 70761, 70764, 70765 };
    public static int shantayChest = 2693;

    //PATHS AND TILES
    public static Tile[] alKharidPath = new Tile[] { new Tile(3269, 3167, 0), new Tile(3274, 3167, 0), new Tile(3274, 3172, 0),
            new Tile(3274, 3177, 0), new Tile(3274, 3182, 0), new Tile(3269, 3183, 0) };

    public static Tile[] catherbyPath = new Tile[] { new Tile(2808, 3441, 0), new Tile(2808, 3436, 0), new Tile(2813, 3436, 0),
            new Tile(2815, 3437, 0), new Tile(2815, 3440, 0), new Tile(2816, 3442, 0) };

    public static Tile catherbyRangeTile = new Tile(2817, 3444, 0);

    public static Tile catherbyDoorTile = new Tile(2816, 3438, 0);

}