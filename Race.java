package model;

import java.util.ArrayList;

// default options: dwarf, elf, halfling, human, dragonborn, gnome, half-elf, half-orc, tiefling
public class Race {
	
	// fields
	private String name, size;
	private int speed; // base walking speed in feet
	private int[] statMods; // value added to each stat
	ArrayList<Feature> features;
	private boolean hasSubRace;
	SubRace subRace;
	
	
	// default constructor
	public Race() {
		name = "";
		size = "";
		speed = 0;
		statMods = new int[]{ 0, 0, 0, 0, 0, 0 };
		features = new ArrayList<Feature>();
		hasSubRace = false;
		subRace = new SubRace();
	}
	
	// constructor, takes an int 0-8 to determine which race
	public Race(int x) {
		// a few initializers in common
		statMods = new int[]{ 0, 0, 0, 0, 0, 0 };
		features = new ArrayList<Feature>();
		hasSubRace = false;
		subRace = new SubRace();
		
		// race-specific initializers
		switch (x) {
		case 0:
			initDwarf();
			break;
		case 1:
			initElf();
			break;
		case 2:
			initHalfling();
			break;
		case 3:
			initHuman();
			break;
		case 4:
			initDragonborn();
			break;
		case 5:
			initGnome();
			break;
		case 6:
			initHalfElf();
			break;
		case 7:
			initHalfOrc();
			break;
		case 8:
			initTiefling();
			break;
		default:
			name = "";
			size = "";
			speed = 0;
		}
	}
	
	// constructor for a custom race
	public Race(String name, String size, int speed, int[] statMods, boolean hasSubRace, SubRace subRace) {
		this.name = name;
		this.size = size;
		this.speed = speed;
		this.statMods = statMods;
		ArrayList<Feature> features; // will never contain anything, but still needs to exist
		this.hasSubRace = hasSubRace;
		this.subRace = subRace;
	}

	
	
	// initializes different races
	// contains all the info about each race
	private void initDwarf() {
		name = "Dwarf";
		size = "Medium";
		speed = 25;
		statMods[2] = 2;
		features.add(new Feature("Darkvision"));
		features.add(new Feature("Dwarven Resilience"));
		features.add(new Feature("Stonecunning"));
	}
	private void initElf() {
		name = "Elf";
		size = "Medium";
		speed = 30;
		statMods[1] = 2;
		features.add(new Feature("Darkvision"));
		features.add(new Feature("Fey Ancestry"));
		features.add(new Feature("Trance"));
	}
	private void initHalfling() {
		name = "Halfling";
		size = "Small";
		speed = 25;
		statMods[1] = 2;
		features.add(new Feature("Lucky"));
		features.add(new Feature("Brave"));
		features.add(new Feature("Halfling Nimbleness"));
	}
	private void initHuman() {
		name = "Human";
		size = "Medium";
		speed = 30;
		statMods = new int[]{ 1, 1, 1, 1, 1, 1 };
	}
	private void initDragonborn() {
		name = "Dragonborn";
		size = "Medium";
		speed = 30;
		statMods[0] = 2;
		statMods[5] = 1;
		features.add(new Feature("Draconic Ancestry"));
		features.add(new Feature("Breath Weapon"));
		features.add(new Feature("Damage Resistance"));
	}
	private void initGnome() {
		name = "Gnome";
		size = "Small";
		speed = 25;
		statMods[3] = 2;
		features.add(new Feature("Darkvision"));
		features.add(new Feature("Gnome Cunning"));
	}
	private void initHalfElf() {
		name = "Half-Elf";
		size = "Medium";
		speed = 30;
		statMods[5] = 2;
		// two other stats go up by 1, but will have to be changed manually by the player
		features.add(new Feature("Darkvision"));
		features.add(new Feature("Fey Ancestry"));
	}
	private void initHalfOrc() {
		name = "Half-Orc";
		size = "Medium";
		speed = 30;
		statMods[0] = 2;
		statMods[2] = 1;
		features.add(new Feature("Darkvision"));
		features.add(new Feature("Relentless Endurance"));
		features.add(new Feature("Savage Attacks"));
	}
	private void initTiefling() {
		name = "Tiefling";
		size = "Medium";
		speed = 30;
		statMods[3] = 1;
		statMods[5] = 2;
		features.add(new Feature("Darkvision"));
		features.add(new Feature("Hellish Resistance"));
	}
	
	public void setSubRace(boolean value) { hasSubRace = value; }
	public void setSubRace(SubRace subRace) {
		hasSubRace = true;
		this.subRace = subRace;
		// add stat mods
		for (int i = 0; i < 6; i++) {
			statMods[i] += subRace.getStatMod(i);
		}
		// add features
		if (subRace.getName().equals("Dark Elf (Drow)")) {
			if (features.get(0).getName().equals("Darkvision")) features.remove(0);
		}
		for (int i = 0; i < subRace.getFeatures().size(); i++) {
			features.add(subRace.getFeatures().get(i));
		}
		// speed change?
		if (subRace.getName().equals("Wood Elf")) {
			speed = 35;
		}
	}
	

	// getters
	public String getName() { return name; }
	public String getSize() { return size; }
	public int getSpeed() { return speed; }
	public int[] getStatMods() { return statMods; }
	public ArrayList<Feature> getFeatures() { return features; }
	public boolean hasSubRace() { return hasSubRace; }
	public SubRace getSubRace() { return subRace; }
	
}
