package RoboRunecrafter.tasks;

import org.powerbot.core.script.job.state.Node;

import RoboRunecrafter.util.*;

public class CheckRune extends Node {

	@Override
	public boolean activate() {
		return RoboRunecrafter.util.Resources.SCRIPT_START == true;
	}

	@Override
	public void execute() {
		if (Resources.AIR) {
			Paint.selectedRune = "Air";
			Resources.RUNE_ID = Resources.AIR_RUNE_ID;
			Resources.PORTAL_ID = Resources.AIR_PORTAL_ID;
			Resources.BANK_BOOTH_ID = Resources.AIR_BOOTH_ID;
			Resources.INSIDE_ALTAR_ID = Resources.INSIDE_AIR_ALTAR_ID;
			Resources.OUTSIDE_ALTAR_ID = Resources.OUTSIDE_AIR_ALTAR_ID;
			Resources.BANK_AREA = Resources.airBankArea;
			Resources.ALTAR_AREA = Resources.airAltarArea;
			Resources.ALTAR_PATH = Resources.airPath;
			Resources.ESSENCE_ID = Resources.PURE_ESSENCE_ID;
			Resources.SCRIPT_START = false;
			Resources.banking = true;
		} else if (RoboRunecrafter.util.Resources.MIND) {
			Paint.selectedRune = "Mind";
			Resources.RUNE_ID = Resources.MIND_RUNE_ID;
			Resources.PORTAL_ID = Resources.MIND_PORTAL_ID;
			Resources.BANK_BOOTH_ID = Resources.MIND_BOOTH_ID;
			Resources.INSIDE_ALTAR_ID = Resources.INSIDE_MIND_ALTAR_ID;
			Resources.OUTSIDE_ALTAR_ID = Resources.OUTSIDE_MIND_ALTAR_ID;
			Resources.BANK_AREA = Resources.mindBankArea;
			Resources.ALTAR_AREA = Resources.mindAltarArea;
			Resources.ALTAR_PATH = Resources.mindPath;
			Resources.ESSENCE_ID = Resources.PURE_ESSENCE_ID;
			Resources.SCRIPT_START = false;
			Resources.banking = true;
		} else if (RoboRunecrafter.util.Resources.WATER) {
			Paint.selectedRune = "Water";
			Resources.RUNE_ID = Resources.WATER_RUNE_ID;
			Resources.PORTAL_ID = Resources.WATER_PORTAL_ID;
			Resources.BANK_BOOTH_ID = Resources.WATER_BOOTH_ID;
			Resources.INSIDE_ALTAR_ID = Resources.INSIDE_WATER_ALTAR_ID;
			Resources.OUTSIDE_ALTAR_ID = Resources.OUTSIDE_WATER_ALTAR_ID;
			Resources.BANK_AREA = Resources.waterBankArea;
			Resources.ALTAR_AREA = Resources.waterAltarArea;
			Resources.ALTAR_PATH = Resources.waterPath;
			Resources.ESSENCE_ID = Resources.PURE_ESSENCE_ID;
			Resources.SCRIPT_START = false;
			Resources.banking = true;
		} else if (RoboRunecrafter.util.Resources.EARTH) {
			Paint.selectedRune = "Earth";
			Resources.RUNE_ID = Resources.EARTH_RUNE_ID;
			Resources.PORTAL_ID = Resources.EARTH_PORTAL_ID;
			Resources.BANK_BOOTH_ID = Resources.EARTH_BOOTH_ID;
			Resources.INSIDE_ALTAR_ID = Resources.INSIDE_EARTH_ALTAR_ID;
			Resources.OUTSIDE_ALTAR_ID = Resources.OUTSIDE_EARTH_ALTAR_ID;
			Resources.BANK_AREA = Resources.earthBankArea;
			Resources.ALTAR_AREA = Resources.earthAltarArea;
			Resources.ALTAR_PATH = Resources.earthPath;
			Resources.ESSENCE_ID = Resources.PURE_ESSENCE_ID;
			Resources.SCRIPT_START = false;
			Resources.banking = true;
		} else if (RoboRunecrafter.util.Resources.FIRE) {
			Paint.selectedRune = "Fire";
			Resources.RUNE_ID = Resources.FIRE_RUNE_ID;
			Resources.PORTAL_ID = Resources.FIRE_PORTAL_ID;
			Resources.BANK_BOOTH_ID = Resources.FIRE_BOOTH_ID;
			Resources.INSIDE_ALTAR_ID = Resources.INSIDE_FIRE_ALTAR_ID;
			Resources.OUTSIDE_ALTAR_ID = Resources.OUTSIDE_FIRE_ALTAR_ID;
			Resources.BANK_AREA = Resources.fireBankArea;
			Resources.ALTAR_AREA = Resources.fireAltarArea;
			Resources.ALTAR_PATH = Resources.firePath;
			Resources.ESSENCE_ID = Resources.PURE_ESSENCE_ID;
			Resources.SCRIPT_START = false;
			Resources.banking = true;
		} else if (RoboRunecrafter.util.Resources.BODY) {
			Paint.selectedRune = "Body";
			Resources.RUNE_ID = Resources.BODY_RUNE_ID;
			Resources.PORTAL_ID = Resources.BODY_PORTAL_ID;
			Resources.BANK_BOOTH_ID = Resources.BODY_BOOTH_ID;
			Resources.INSIDE_ALTAR_ID = Resources.INSIDE_BODY_ALTAR_ID;
			Resources.OUTSIDE_ALTAR_ID = Resources.OUTSIDE_BODY_ALTAR_ID;
			Resources.BANK_AREA = Resources.bodyBankArea;
			Resources.ALTAR_AREA = Resources.bodyAltarArea;
			Resources.ALTAR_PATH = Resources.bodyPath;
			Resources.ESSENCE_ID = Resources.PURE_ESSENCE_ID;
			Resources.SCRIPT_START = false;
			Resources.banking = true;
		} else if (RoboRunecrafter.util.Resources.COSMIC) {
			Paint.selectedRune = "Cosmic";
			Resources.RUNE_ID = Resources.COSMIC_RUNE_ID;
			Resources.PORTAL_ID = Resources.COSMIC_PORTAL_ID;
			Resources.BANK_BOOTH_ID = Resources.COSMIC_BOOTH_ID;
			Resources.INSIDE_ALTAR_ID = Resources.INSIDE_COSMIC_ALTAR_ID;
			Resources.OUTSIDE_ALTAR_ID = Resources.OUTSIDE_COSMIC_ALTAR_ID;
			Resources.BANK_AREA = Resources.cosmicBankArea;
			Resources.ALTAR_AREA = Resources.cosmicAltarArea;
			Resources.ALTAR_PATH = Resources.cosmicPath;
			Resources.ESSENCE_ID = Resources.PURE_ESSENCE_ID;
			Resources.SCRIPT_START = false;
			Resources.banking = true;
		} else if (RoboRunecrafter.util.Resources.ASTRAL) {
			Paint.selectedRune = "Astral";
			Resources.ASTRAL_RUNE_VALIDATE = true;
			Resources.RUNE_ID = Resources.ASTRAL_RUNE_ID;
			Resources.PORTAL_ID = Resources.ASTRAL_PORTAL_ID;
			Resources.BANK_BOOTH_ID = Resources.ASTRAL_BOOTH_ID;
			Resources.INSIDE_ALTAR_ID = Resources.INSIDE_ASTRAL_ALTAR_ID;
			Resources.OUTSIDE_ALTAR_ID = Resources.OUTSIDE_ASTRAL_ALTAR_ID;
			Resources.BANK_AREA = Resources.astralBankArea;
			Resources.ALTAR_AREA = Resources.astralAltarArea;
			Resources.ALTAR_PATH = Resources.astralPath;
			Resources.ESSENCE_ID = Resources.PURE_ESSENCE_ID;
			Resources.SCRIPT_START = false;
			Resources.banking = true;
		} else
			Paint.selectedRune = "N/A";
		    Paint.status = "Rune is not supported.";
			Resources.STOP_SCRIPT = true;
	}
}