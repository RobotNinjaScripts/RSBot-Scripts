package RoboRunecrafter.util;

import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class Resources {

	// MOUSE
	public static int x;
	public static int y;

	// VALIDATE BOOLEANS
	public static boolean SCRIPT_START = true;
	public static boolean ASTRAL_RUNE_VALIDATE = false;
	public static boolean STOP_SCRIPT = false;

	public static boolean playerMoving = false;
	public static boolean playerCrafting = false;
	public static boolean playerOutsideAltar = false;
	public static boolean playerInsideAltar = false;
	public static boolean playerInsideBank = false;
	public static boolean inventoryEmpty = false;
	public static boolean inventoryContainsRunes = false;
	public static boolean inventoryContainsEssence = false;

	public static boolean getEssence = false;
	public static boolean banking = false;
	public static boolean depositRunesGetEssence = false;
	public static boolean goToAltar = false;
	public static boolean enterAltar = false;
	public static boolean craftRunes = false;
	public static boolean exitAltar = false;
	public static boolean goToBank = false;

	public static boolean exitedAltar = false;

	// ==== IDS =====//
	public static int RUNE_ESSENCE_ID = 1436;
	public static int PURE_ESSENCE_ID = 7936;
	public static int CRAFT_ANIMATION = 791;
	// AIR
	public static int AIR_PORTAL_ID = 2465;
	public static int[] AIR_BOOTH_ID = { 782 };
	public static int INSIDE_AIR_ALTAR_ID = 2478;
	public static int OUTSIDE_AIR_ALTAR_ID = 2452;
	public static int AIR_RUNE_ID = 556;
	// MIND
	public static int MIND_PORTAL_ID = 2466;
	public static int[] MIND_BOOTH_ID = { 11758 };
	public static int INSIDE_MIND_ALTAR_ID = 2479;
	public static int OUTSIDE_MIND_ALTAR_ID = 2453;
	public static int MIND_RUNE_ID = 558;
	// WATER
	public static int WATER_PORTAL_ID = 2467;
	public static int[] WATER_BOOTH_ID = { 2012, 2015, 2019 };
	public static int INSIDE_WATER_ALTAR_ID = 2480;
	public static int OUTSIDE_WATER_ALTAR_ID = 2454;
	public static int WATER_RUNE_ID = 555;
	// EARTH
	public static int EARTH_PORTAL_ID = 2468;
	public static int[] EARTH_BOOTH_ID = { 782 };
	public static int INSIDE_EARTH_ALTAR_ID = 2481;
	public static int OUTSIDE_EARTH_ALTAR_ID = 2455;
	public static int EARTH_RUNE_ID = 557;
	// FIRE
	public static int FIRE_PORTAL_ID = 2469;
	public static int[] FIRE_BOOTH_ID = { 3564 };
	public static int INSIDE_FIRE_ALTAR_ID = 2482;
	public static int OUTSIDE_FIRE_ALTAR_ID = 2456;
	public static int FIRE_RUNE_ID = 554;
	// BODY
	public static int BODY_PORTAL_ID = 2470;
	public static int[] BODY_BOOTH_ID = { 42377, 42378, 42217 };
	public static int INSIDE_BODY_ALTAR_ID = 2483;
	public static int OUTSIDE_BODY_ALTAR_ID = 2457;
	public static int BODY_RUNE_ID = 559;
	// COSMIC
	public static int COSMIC_PORTAL_ID = 2471;
	public static int[] COSMIC_BOOTH_ID = { 52589 };
	public static int INSIDE_COSMIC_ALTAR_ID = 2484;
	public static int OUTSIDE_COSMIC_ALTAR_ID = 2458;
	public static int COSMIC_RUNE_ID = 564;
	// ASTRAL
	public static int ASTRAL_PORTAL_ID = 0;
	public static int[] ASTRAL_BOOTH_ID = { 16700 };
	public static int INSIDE_ASTRAL_ALTAR_ID = 17010;
	public static int OUTSIDE_ASTRAL_ALTAR_ID = 0;
	public static int ASTRAL_RUNE_ID = 9075;

	// AREAS
	public static Area airBankArea = new Area(new Tile[] {
			new Tile(3180, 3447, 0), new Tile(3190, 3447, 0),
			new Tile(3190, 3431, 0), new Tile(3180, 3431, 0) });
	public static Area airAltarArea = new Area(new Tile[] {
			new Tile(3124, 3406, 0), new Tile(3132, 3406, 0),
			new Tile(3132, 3398, 0), new Tile(3124, 3398, 0) });
	public static Area mindBankArea = new Area(new Tile[] {
			new Tile(2941, 3373, 0), new Tile(2947, 3373, 0),
			new Tile(2947, 3367, 0), new Tile(2941, 3367, 0) });
	public static Area mindAltarArea = new Area(new Tile[] {
			new Tile(2977, 3517, 0), new Tile(2985, 3517, 0),
			new Tile(2985, 3509, 0), new Tile(2977, 3509, 0) });
	public static Area waterBankArea = new Area(new Tile[] {
			new Tile(3086, 3246, 0), new Tile(3097, 3246, 0),
			new Tile(3097, 3239, 0), new Tile(3086, 3239, 0) });
	public static Area waterAltarArea = new Area(new Tile[] {
			new Tile(3189, 3158, 0), new Tile(3179, 3158, 0),
			new Tile(3179, 3166, 0), new Tile(3189, 3166, 0) });
	public static Area earthBankArea = new Area(new Tile[] {
			new Tile(3248, 3425, 0), new Tile(3257, 3425, 0),
			new Tile(3257, 3415, 0), new Tile(3248, 3415, 0) });
	public static Area earthAltarArea = new Area(new Tile[] {
			new Tile(3303, 3477, 0), new Tile(3311, 3477, 0),
			new Tile(3311, 3469, 0), new Tile(3303, 3469, 0) });
	public static Area fireBankArea = new Area(new Tile[] {
			new Tile(3267, 3174, 0), new Tile(3272, 3174, 0),
			new Tile(3272, 3160, 0), new Tile(3267, 3160, 0) });
	public static Area fireAltarArea = new Area(new Tile[] {
			new Tile(3308, 3256, 0), new Tile(3316, 3256, 0),
			new Tile(3316, 3248, 0), new Tile(3308, 3248, 0) });
	public static Area bodyBankArea = new Area(new Tile[] {
			new Tile(3098, 3487, 0), new Tile(3090, 3487, 0),
			new Tile(3090, 3499, 0), new Tile(3098, 3499, 0) });
	public static Area bodyAltarArea = new Area(new Tile[] {
			new Tile(3048, 3448, 0), new Tile(3056, 3448, 0),
			new Tile(3056, 3440, 0), new Tile(3048, 3440, 0) });
	public static Area cosmicBankArea = new Area(new Tile[] {
			new Tile(2380, 4460, 0), new Tile(2385, 4460, 0),
			new Tile(2385, 4455, 0), new Tile(2380, 4455, 0) });
	public static Area cosmicAltarArea = new Area(new Tile[] {
			new Tile(2403, 4381, 0), new Tile(2412, 4380, 0),
			new Tile(2412, 4373, 0), new Tile(2405, 4373, 0) });
	public static Area astralBankArea = new Area(new Tile[] {
			new Tile(2095, 3921, 0), new Tile(2104, 3921, 0),
			new Tile(2104, 3916, 0), new Tile(2095, 3916, 0) });
	public static Area astralAltarArea = new Area(new Tile[] {
			new Tile(2154, 3868, 0), new Tile(2164, 3868, 0),
			new Tile(2164, 3858, 0), new Tile(2154, 3858, 0) });

	public static Area nullArea = new Area(
			new Tile[] { new Tile(3308, 3256, 0) });

	// PATHS
	public static Tile[] airPath = new Tile[] { new Tile(3186, 3430, 0),
			new Tile(3181, 3430, 0), new Tile(3176, 3430, 0),
			new Tile(3171, 3429, 0), new Tile(3167, 3426, 0),
			new Tile(3163, 3423, 0), new Tile(3158, 3422, 0),
			new Tile(3153, 3421, 0), new Tile(3149, 3418, 0),
			new Tile(3146, 3414, 0), new Tile(3141, 3412, 0),
			new Tile(3137, 3409, 0), new Tile(3132, 3406, 0),
			new Tile(3128, 3400, 0) };
	public static Tile[] mindPath = new Tile[] { new Tile(2944, 3370, 0),
			new Tile(2945, 3375, 0), new Tile(2950, 3376, 0),
			new Tile(2953, 3380, 0), new Tile(2958, 3382, 0),
			new Tile(2960, 3383, 0), new Tile(2965, 3384, 0),
			new Tile(2967, 3389, 0), new Tile(2966, 3394, 0),
			new Tile(2965, 3399, 0), new Tile(2965, 3404, 0),
			new Tile(2967, 3409, 0), new Tile(2970, 3413, 0),
			new Tile(2975, 3415, 0), new Tile(2980, 3416, 0),
			new Tile(2984, 3419, 0), new Tile(2987, 3423, 0),
			new Tile(2988, 3428, 0), new Tile(2985, 3432, 0),
			new Tile(2983, 3437, 0), new Tile(2981, 3442, 0),
			new Tile(2980, 3447, 0), new Tile(2977, 3451, 0),
			new Tile(2976, 3456, 0), new Tile(2976, 3461, 0),
			new Tile(2974, 3466, 0), new Tile(2974, 3471, 0),
			new Tile(2975, 3476, 0), new Tile(2978, 3480, 0),
			new Tile(2979, 3485, 0), new Tile(2980, 3490, 0),
			new Tile(2981, 3495, 0), new Tile(2980, 3500, 0),
			new Tile(2981, 3505, 0), new Tile(2981, 3510, 0),
			new Tile(2981, 3511, 0) };
	public static Tile[] waterPath = new Tile[] { new Tile(3093, 3243, 0),
			new Tile(3092, 3248, 0), new Tile(3097, 3248, 0),
			new Tile(3101, 3245, 0), new Tile(3103, 3240, 0),
			new Tile(3105, 3235, 0), new Tile(3108, 3231, 0),
			new Tile(3109, 3226, 0), new Tile(3112, 3222, 0),
			new Tile(3117, 3219, 0), new Tile(3121, 3216, 0),
			new Tile(3125, 3212, 0), new Tile(3128, 3208, 0),
			new Tile(3133, 3206, 0), new Tile(3138, 3204, 0),
			new Tile(3142, 3201, 0), new Tile(3146, 3198, 0),
			new Tile(3150, 3195, 0), new Tile(3153, 3191, 0),
			new Tile(3156, 3187, 0), new Tile(3159, 3183, 0),
			new Tile(3163, 3180, 0), new Tile(3168, 3178, 0),
			new Tile(3173, 3177, 0), new Tile(3176, 3173, 0),
			new Tile(3177, 3168, 0), new Tile(3181, 3165, 0),
			new Tile(3184, 3162, 0) };
	public static Tile[] earthPath = new Tile[] { new Tile(3252, 3420, 0),
			new Tile(3253, 3425, 0), new Tile(3253, 3428, 0),
			new Tile(3257, 3428, 0), new Tile(3262, 3428, 0),
			new Tile(3267, 3428, 0), new Tile(3272, 3428, 0),
			new Tile(3277, 3428, 0), new Tile(3281, 3431, 0),
			new Tile(3284, 3435, 0), new Tile(3285, 3440, 0),
			new Tile(3284, 3445, 0), new Tile(3284, 3450, 0),
			new Tile(3285, 3455, 0), new Tile(3289, 3458, 0),
			new Tile(3292, 3462, 0), new Tile(3295, 3466, 0),
			new Tile(3299, 3469, 0), new Tile(3303, 3472, 0),
			new Tile(3305, 3473, 0) };
	public static Tile[] firePath = new Tile[] { new Tile(3270, 3166, 0),
			new Tile(3275, 3167, 0), new Tile(3277, 3172, 0),
			new Tile(3277, 3177, 0), new Tile(3280, 3181, 0),
			new Tile(3280, 3186, 0), new Tile(3282, 3191, 0),
			new Tile(3283, 3196, 0), new Tile(3284, 3201, 0),
			new Tile(3286, 3206, 0), new Tile(3288, 3211, 0),
			new Tile(3290, 3216, 0), new Tile(3293, 3220, 0),
			new Tile(3296, 3224, 0), new Tile(3298, 3229, 0),
			new Tile(3301, 3233, 0), new Tile(3304, 3237, 0),
			new Tile(3307, 3241, 0), new Tile(3308, 3246, 0),
			new Tile(3310, 3251, 0) };
	public static Tile[] bodyPath = new Tile[] { new Tile(3092, 3495, 0),
			new Tile(3091, 3500, 0), new Tile(3086, 3502, 0),
			new Tile(3081, 3503, 0), new Tile(3076, 3502, 0),
			new Tile(3072, 3499, 0), new Tile(3069, 3494, 0),
			new Tile(3068, 3489, 0), new Tile(3068, 3484, 0),
			new Tile(3068, 3479, 0), new Tile(3068, 3474, 0),
			new Tile(3068, 3469, 0), new Tile(3067, 3464, 0),
			new Tile(3065, 3459, 0), new Tile(3062, 3455, 0),
			new Tile(3060, 3450, 0), new Tile(3056, 3447, 0),
			new Tile(3054, 3445, 0) };
	public static Tile[] cosmicPath = new Tile[] { new Tile(2388, 4453, 0),
			new Tile(2395, 4451, 0), new Tile(2402, 4450, 0),
			new Tile(2407, 4445, 0), new Tile(2412, 4440, 0),
			new Tile(2418, 4431, 0), new Tile(2420, 4424, 0),
			new Tile(2420, 4416, 0), new Tile(2415, 4411, 0),
			new Tile(2409, 4407, 0), new Tile(2401, 4407, 0),
			new Tile(2393, 4407, 0), new Tile(2386, 4409, 0),
			new Tile(2378, 4410, 0), new Tile(2379, 4403, 0),
			new Tile(2385, 4398, 0), new Tile(2392, 4396, 0),
			new Tile(2399, 4393, 0), new Tile(2404, 4388, 0),
			new Tile(2408, 4382, 0) };
	public static Tile[] astralPath = new Tile[] { new Tile(2099, 3918, 0),
			new Tile(2102, 3914, 0), new Tile(2107, 3913, 0),
			new Tile(2112, 3912, 0), new Tile(2112, 3907, 0),
			new Tile(2111, 3902, 0), new Tile(2111, 3897, 0),
			new Tile(2112, 3892, 0), new Tile(2114, 3887, 0),
			new Tile(2118, 3884, 0), new Tile(2122, 3881, 0),
			new Tile(2126, 3878, 0), new Tile(2130, 3875, 0),
			new Tile(2133, 3871, 0), new Tile(2134, 3866, 0),
			new Tile(2134, 3861, 0), new Tile(2137, 3857, 0),
			new Tile(2142, 3857, 0), new Tile(2147, 3859, 0),
			new Tile(2151, 3862, 0), new Tile(2156, 3863, 0) };

	public static Tile[] nullPath = new Tile[] { new Tile(3186, 3438, 0) };

	// UNIVERSAL IDs
	public static int ESSENCE_ID = 0;
	public static int RUNE_ID = 0;
	public static int PORTAL_ID = 0;
	public static int[] BANK_BOOTH_ID = { 0 };
	public static int INSIDE_ALTAR_ID = 0;
	public static int OUTSIDE_ALTAR_ID = 0;
	public static Area BANK_AREA = nullArea;
	public static Area ALTAR_AREA = nullArea;
	public static Tile[] ALTAR_PATH = nullPath;

	// CHECK_RUNE VALIDATES
	public static boolean AIR = airBankArea.contains(Players.getLocal());
	public static boolean MIND = mindBankArea.contains(Players.getLocal());
	public static boolean WATER = waterBankArea.contains(Players.getLocal());
	public static boolean EARTH = earthBankArea.contains(Players.getLocal());
	public static boolean FIRE = fireBankArea.contains(Players.getLocal());
	public static boolean BODY = bodyBankArea.contains(Players.getLocal());
	public static boolean COSMIC = cosmicBankArea.contains(Players.getLocal());
	public static boolean ASTRAL = astralBankArea.contains(Players.getLocal());
	// public static boolean NATURE =
	// natureBankArea.contains(Players.getLocal());
	// public static boolean LAW = lawBankArea.contains(Players.getLocal());
	// public static boolean DEATH = deathBankArea.contains(Players.getLocal());
	// public static boolean BLOOD = bloodBankArea.contains(Players.getLocal());

}
