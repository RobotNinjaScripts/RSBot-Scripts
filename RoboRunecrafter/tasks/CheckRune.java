package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.state.Node;

public class CheckRune extends Node{

	@Override
	public boolean activate() {
		return RoboRunecrafter.util.Resources.SCRIPT_START == true;
	}

	@Override
	public void execute() {
		if (RoboRunecrafter.util.Resources.AIR) {
			RoboRunecrafter.util.Paint.selectedRune = "Air";
			RoboRunecrafter.util.Resources.RUNE_ID = RoboRunecrafter.util.Resources.AIR_RUNE_ID;
			RoboRunecrafter.util.Resources.PORTAL_ID = RoboRunecrafter.util.Resources.AIR_PORTAL_ID;
			RoboRunecrafter.util.Resources.BANK_BOOTH_ID = RoboRunecrafter.util.Resources.AIR_BOOTH_ID;
			RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.INSIDE_AIR_ALTAR_ID;
			RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.OUTSIDE_AIR_ALTAR_ID;
			RoboRunecrafter.util.Resources.BANK_AREA = RoboRunecrafter.util.Resources.airBankArea;
			RoboRunecrafter.util.Resources.ALTAR_AREA = RoboRunecrafter.util.Resources.airAltarArea;
			RoboRunecrafter.util.Resources.ALTAR_PATH = RoboRunecrafter.util.Resources.airPath;			
			RoboRunecrafter.util.Resources.SCRIPT_START = false;
			RoboRunecrafter.util.Resources.getEssence = true;
		} else if (RoboRunecrafter.util.Resources.MIND) {
			RoboRunecrafter.util.Paint.selectedRune = "Mind";
			RoboRunecrafter.util.Resources.RUNE_ID = RoboRunecrafter.util.Resources.MIND_RUNE_ID;
			RoboRunecrafter.util.Resources.PORTAL_ID = RoboRunecrafter.util.Resources.MIND_PORTAL_ID;
			RoboRunecrafter.util.Resources.BANK_BOOTH_ID = RoboRunecrafter.util.Resources.MIND_BOOTH_ID;
			RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.INSIDE_MIND_ALTAR_ID;
		    RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.OUTSIDE_MIND_ALTAR_ID;
		    RoboRunecrafter.util.Resources.BANK_AREA = RoboRunecrafter.util.Resources.mindBankArea;
		    RoboRunecrafter.util.Resources.ALTAR_AREA = RoboRunecrafter.util.Resources.mindAltarArea;
		    RoboRunecrafter.util.Resources.ALTAR_PATH = RoboRunecrafter.util.Resources.mindPath;
			RoboRunecrafter.util.Resources.SCRIPT_START = false;
			RoboRunecrafter.util.Resources.getEssence = true;
		} else if (RoboRunecrafter.util.Resources.WATER) {
			RoboRunecrafter.util.Paint.selectedRune = "Water";
			RoboRunecrafter.util.Resources.RUNE_ID = RoboRunecrafter.util.Resources.WATER_RUNE_ID;
		    RoboRunecrafter.util.Resources.PORTAL_ID = RoboRunecrafter.util.Resources.WATER_PORTAL_ID;
		    RoboRunecrafter.util.Resources.BANK_BOOTH_ID = RoboRunecrafter.util.Resources.WATER_BOOTH_ID;
		    RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.INSIDE_WATER_ALTAR_ID;
		    RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.OUTSIDE_WATER_ALTAR_ID;
		    RoboRunecrafter.util.Resources.BANK_AREA = RoboRunecrafter.util.Resources.mindBankArea;
		    RoboRunecrafter.util.Resources.ALTAR_AREA = RoboRunecrafter.util.Resources.mindAltarArea;
		    RoboRunecrafter.util.Resources.ALTAR_PATH = RoboRunecrafter.util.Resources.mindPath;
			RoboRunecrafter.util.Resources.SCRIPT_START = false;
			RoboRunecrafter.util.Resources.getEssence = true;
		} else if (RoboRunecrafter.util.Resources.EARTH) {
			RoboRunecrafter.util.Paint.selectedRune = "Earth";
			RoboRunecrafter.util.Resources.RUNE_ID = RoboRunecrafter.util.Resources.EARTH_RUNE_ID;
			RoboRunecrafter.util.Resources.PORTAL_ID = RoboRunecrafter.util.Resources.EARTH_PORTAL_ID;
			RoboRunecrafter.util.Resources.BANK_BOOTH_ID = RoboRunecrafter.util.Resources.EARTH_BOOTH_ID;
			RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.INSIDE_EARTH_ALTAR_ID;
			RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.OUTSIDE_EARTH_ALTAR_ID;
			RoboRunecrafter.util.Resources.BANK_AREA = RoboRunecrafter.util.Resources.mindBankArea;
			RoboRunecrafter.util.Resources.ALTAR_AREA = RoboRunecrafter.util.Resources.mindAltarArea;
		    RoboRunecrafter.util.Resources.ALTAR_PATH = RoboRunecrafter.util.Resources.mindPath;	
			RoboRunecrafter.util.Resources.SCRIPT_START = false;
			RoboRunecrafter.util.Resources.getEssence = true;
		} else if (RoboRunecrafter.util.Resources.FIRE) {
			RoboRunecrafter.util.Paint.selectedRune = "Fire";
			RoboRunecrafter.util.Resources.RUNE_ID = RoboRunecrafter.util.Resources.FIRE_RUNE_ID;
			RoboRunecrafter.util.Resources.PORTAL_ID = RoboRunecrafter.util.Resources.FIRE_PORTAL_ID;
			RoboRunecrafter.util.Resources.BANK_BOOTH_ID = RoboRunecrafter.util.Resources.FIRE_BOOTH_ID;
			RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.INSIDE_FIRE_ALTAR_ID;
			RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.OUTSIDE_FIRE_ALTAR_ID;
			RoboRunecrafter.util.Resources.BANK_AREA = RoboRunecrafter.util.Resources.fireBankArea;
			RoboRunecrafter.util.Resources.ALTAR_AREA = RoboRunecrafter.util.Resources.fireAltarArea;
			RoboRunecrafter.util.Resources.ALTAR_PATH = RoboRunecrafter.util.Resources.firePath;
			RoboRunecrafter.util.Resources.SCRIPT_START = false;
			RoboRunecrafter.util.Resources.getEssence = true;
		} else if (RoboRunecrafter.util.Resources.BODY) {
			RoboRunecrafter.util.Paint.selectedRune = "Body";
			RoboRunecrafter.util.Resources.RUNE_ID = RoboRunecrafter.util.Resources.BODY_RUNE_ID;
			RoboRunecrafter.util.Resources.PORTAL_ID = RoboRunecrafter.util.Resources.BODY_PORTAL_ID;
			RoboRunecrafter.util.Resources.BANK_BOOTH_ID = RoboRunecrafter.util.Resources.BODY_BOOTH_ID;
			RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.INSIDE_BODY_ALTAR_ID;
			RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.OUTSIDE_BODY_ALTAR_ID;
			RoboRunecrafter.util.Resources.BANK_AREA = RoboRunecrafter.util.Resources.mindBankArea;
			RoboRunecrafter.util.Resources.ALTAR_AREA = RoboRunecrafter.util.Resources.mindAltarArea;
			RoboRunecrafter.util.Resources.ALTAR_PATH = RoboRunecrafter.util.Resources.mindPath;	
			RoboRunecrafter.util.Resources.SCRIPT_START = false;
			RoboRunecrafter.util.Resources.getEssence = true;
		} else if (RoboRunecrafter.util.Resources.COSMIC) {
			RoboRunecrafter.util.Paint.selectedRune = "Cosmic";
			RoboRunecrafter.util.Resources.RUNE_ID = RoboRunecrafter.util.Resources.COSMIC_RUNE_ID;
			RoboRunecrafter.util.Resources.PORTAL_ID = RoboRunecrafter.util.Resources.COSMIC_PORTAL_ID;
			RoboRunecrafter.util.Resources.BANK_BOOTH_ID = RoboRunecrafter.util.Resources.COSMIC_BOOTH_ID;
			RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.INSIDE_COSMIC_ALTAR_ID;
			RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.OUTSIDE_COSMIC_ALTAR_ID;
			RoboRunecrafter.util.Resources.BANK_AREA = RoboRunecrafter.util.Resources.mindBankArea;
			RoboRunecrafter.util.Resources.ALTAR_AREA = RoboRunecrafter.util.Resources.mindAltarArea;
			RoboRunecrafter.util.Resources.ALTAR_PATH = RoboRunecrafter.util.Resources.mindPath;
			RoboRunecrafter.util.Resources.SCRIPT_START = false;
			RoboRunecrafter.util.Resources.getEssence = true;
		} else if (RoboRunecrafter.util.Resources.ASTRAL) {
			RoboRunecrafter.util.Paint.selectedRune = "Astral";
			RoboRunecrafter.util.Resources.ASTRAL_RUNE_VALIDATE = true;
			RoboRunecrafter.util.Resources.RUNE_ID = RoboRunecrafter.util.Resources.ASTRAL_RUNE_ID;
			RoboRunecrafter.util.Resources.PORTAL_ID = RoboRunecrafter.util.Resources.ASTRAL_PORTAL_ID;
			RoboRunecrafter.util.Resources.BANK_BOOTH_ID = RoboRunecrafter.util.Resources.ASTRAL_BOOTH_ID;
			RoboRunecrafter.util.Resources.INSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.INSIDE_ASTRAL_ALTAR_ID;
			RoboRunecrafter.util.Resources.OUTSIDE_ALTAR_ID = RoboRunecrafter.util.Resources.OUTSIDE_ASTRAL_ALTAR_ID;
			RoboRunecrafter.util.Resources.BANK_AREA = RoboRunecrafter.util.Resources.mindBankArea;
			RoboRunecrafter.util.Resources.ALTAR_AREA = RoboRunecrafter.util.Resources.mindAltarArea;
			RoboRunecrafter.util.Resources.ALTAR_PATH = RoboRunecrafter.util.Resources.mindPath;
			RoboRunecrafter.util.Resources.SCRIPT_START = false;
			RoboRunecrafter.util.Resources.getEssence = true;
		} else
			RoboRunecrafter.util.Resources.STOP_SCRIPT = true;
	}
}	