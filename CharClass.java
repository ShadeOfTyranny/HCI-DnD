package model;

import java.util.ArrayList;

// default options: Barbarian, Bard, Cleric, Druid, Fighter, Monk, Paladin, Ranger, Rogue, Sorcerer, Warlock, Wizard
public class CharClass {
	
	// fields
	private String name; // name of class
	private String path;
	private int hitDie; // number of sides
	private int level;
	private boolean[] profs; // saving throw proficiencies
	private ArrayList<Feature> features;
	boolean spellCaster;

	
	
	// default constructor
	public CharClass() {
		name = "";
		hitDie = 0;
		level = 1;
		profs = new boolean[] { false, false, false, false, false, false };
		features = new ArrayList<Feature>();
		spellCaster = false;
		path = "";
	}
	
	// constructor, takes int 0-11 to determine class
	public CharClass(int x) {
		this();
		switch (x) {
		case 0:
			initBarbarian();
			break;
		case 1:
			initBard();
			break;
		case 2:
			initCleric();
			break;
		case 3:
			initDruid();
			break;
		case 4:
			initFighter();
			break;
		case 5:
			initMonk();
			break;
		case 6:
			initPaladin();
			break;
		case 7:
			initRanger();
			break;
		case 8:
			initRogue();
			break;
		case 9:
			initSorcerer();
			break;
		case 10:
			initWarlock();
			break;
		case 11:
			initWizard();
			break;
		default:
			// do nothing
			}
	}

	// constructor for custom class
	public CharClass(String name, int hitDie, int level) {
		this();
		this.name = name;
		this.hitDie = hitDie;
		this.level = level;
	}
	
	// initializes different classes
	private void initBarbarian() {
		name = "Barbarian";
		hitDie = 12;
		profs[0] = true; // str
		profs[2] = true; // con
		features.add(new Feature("Rage"));
		features.add(new Feature("Unarmored Defense"));
	}
	private void initBard() {
		name = "Bard";
		hitDie = 8;
		profs[1] = true; // dex
		profs[5] = true; // cha
		spellCaster = true;
		features.add(new Feature("Bardic Inspiration(d6)"));
	}
	private void initCleric() {
		name = "Cleric";
		hitDie = 8;
		profs[4] = true; // wis
		profs[5] = true; // cha
		spellCaster = true;
		features.add(new Feature("Divine Domain"));
	}
	private void initDruid() {
		name = "Druid";
		hitDie = 8;
		profs[3] = true; // int
		profs[4] = true; // wis
		spellCaster = true;
		features.add(new Feature("Druidic"));
	}
	private void initFighter() {
		name = "Fighter";
		hitDie = 10;
		profs[0] = true; // str
		profs[2] = true; // con
		// TODO: should there be a popup here?
		features.add(new Feature("Fighting Style"));
		features.add(new Feature("Second Wind"));
	}
	private void initMonk() {
		name = "Monk";
		hitDie = 8;
		profs[0] = true; // str
		profs[1] = true; // dex
		features.add(new Feature("Unarmored Defense"));
		features.add(new Feature("Martial Arts"));
	}
	private void initPaladin() {
		name = "Paladin";
		hitDie = 10;
		profs[4] = true; // wis
		profs[5] = true; // cha
		features.add(new Feature("Divine Sense"));
		features.add(new Feature("Lay on Hands"));
	}
	private void initRanger() {
		name = "Ranger";
		hitDie = 10;
		profs[0] = true; // str
		profs[1] = true; // dex
		// TODO: another popup? Or should these be in the features?
		features.add(new Feature("Favored Enemy"));
		features.add(new Feature("Natural Explorer"));
	}
	private void initRogue() {
		name = "Rogue";
		hitDie = 8;
		profs[1] = true; // dex
		profs[3] = true; // int
		features.add(new Feature("Expertise"));
		features.add(new Feature("Sneak Attack"));
		features.add(new Feature("Thieves' Cant"));
	}
	private void initSorcerer() {
		name = "Sorcerer";
		hitDie = 6;
		profs[2] = true; // con
		profs[5] = true; // cha
		spellCaster = true;
		features.add(new Feature("Sorcerous Origin"));
	}
	private void initWarlock() {
		name = "Warlock";
		hitDie = 8;
		profs[4] = true; // wis
		profs[5] = true; // cha
		spellCaster = true;
		features.add(new Feature("Otherworldly Patron"));
	}
	private void initWizard() {
		name = "Wizard";
		hitDie = 6;
		profs[3] = true; // int
		profs[4] = true; // wis
		spellCaster = true;
		features.add(new Feature("Arcane Recovery"));
	}
	
	private void levelUp() {
		switch (name) {
		case "Barbarian":
			
		}
	}
	
	private void levelBarbarian() {
		level++;
		switch (level) {
		case 2:
			features.add(new Feature("Reckless Attack"));
			features.add(new Feature("Danger Sense"));
			break;
		case 3:
			// must have a path
			if (path.equals("Path of the Beserker")) {
				features.add(new Feature("Frenzy"));
			}
			else if (path.equals("Path of the Totem Warrior")) {
				features.add(new Feature("Spirit Seeker"));
			}
			int x = features.indexOf("Rage");
			features.set(x, new Feature("Rage", 3));
			break;
		case 4:
			
		}
	}
	
	private void levelBard() {
		
	}
	
	private void levelCleric() {
		
	}
	
	private void levelDruid() {
		
	}
	
	private void levelFighter() {
		
	}

	private void levelMonk() {
		
	}
	
	private void levelPaladin() {
		
	}
	
	private void levelRanger() {
		
	}
	
	private void levelRogue() {
		
	}
	
	private void levelSorcerer() {
		
	}
	
	private void levelWarlock() {
		
	}
	
	private void levelWizard() {
		
	}
	// setters
	public void setPath(String s) { path = s; }
	
	// getters
	public String getName() { return name; }
	public String getPath() { return path; }
	public int getHitDie() { return hitDie; }
	public int getLevel() {return level; }
	public boolean[] getProfs() { return profs; }
	public ArrayList<Feature> getFeatures() { return features; }
	public boolean isSpellCaster() { return spellCaster; }

}
