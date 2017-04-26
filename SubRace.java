package model;

import java.io.Serializable;
import java.util.ArrayList;

public class SubRace implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// fields
	String name;
	int[] statMods;
	ArrayList<Feature> features;
	
	// default constructor
	public SubRace() {
		name = "";
		statMods = new int[]{ 0, 0, 0, 0, 0, 0 };
		features = new ArrayList<Feature>();
	}
	
	// constructor for a default subRace
	// x: Hill Dwarf, Mountain Dwarf, High Elf, Wood Elf, Dark Elf(Drow), Lightfoot, Stout, Forest Gnome, Rock Gnome
	public SubRace(int x) {
		this();
		switch (x) {
		case 0:
			name = "Hill Dwarf";
			statMods[4] = 1; // wis
			features.add(new Feature("Dwarven Toughness"));
			break;
		case 1:
			name = "Mountain Dwarf";
			statMods[0] = 2; // str
			break;
		case 2:
			name = "High Elf";
			statMods[3] = 1; // int
			break;
		case 3:
			name = "Wood Elf";
			statMods[4] = 1; // wis
			features.add(new Feature("Mask of the Wild"));
			// speed changes from 30 to 35, dealt with in Race class
			break;
		case 4:
			name = "Dark Elf (Drow)";
			statMods[5] = 1; //cha
			features.add(new Feature("Superior Darkvision")); // replaces darkvision, dealt with in Race class
			features.add(new Feature("Sunlight Sensitivity"));
			break;
		case 5:
			name = "Lightfoot";
			statMods[5] = 1; // cha
			features.add(new Feature("Natureally Stealthy"));
			break;
		case 6:
			name = "Stout";
			statMods[2] = 1;
			features.add(new Feature("Stout Resilience"));
			break;
		case 7:
			name = "Forest Gnome";
			statMods[1] = 1; // dex
			features.add(new Feature("Speak with Small Beasts"));
			break;
		case 8:
			name = "Rock Gnome";
			statMods[2] = 1; // con
			features.add(new Feature("Artificer's Lore"));
			features.add(new Feature("Tinker"));
			break;
		default:
			// do nothing
		}
	}
	
	// constructor for a custom subRace
	public SubRace(String name, int[] statMods) {
		this();
		this.name = name;
		this.statMods = statMods;
	}
	
	public void removeFeature(int i) {
		features.remove(i);
	}
	
	// getters
	public String getName() { return name; }
	public int getStatMod(int stat) { return statMods[stat]; }
	public ArrayList<Feature> getFeatures() { return features; }

}
