package model;

import java.io.File;
import java.util.ArrayList;

public class Character {
	
	// fields
	
	// player input Strings = have no affect on calculations
	private String name, alignment, personality, ideals, bonds, flaws, equipment, moreEquipment, otherProfs_languages, eyeColor, skinColor, hairColor, backstory, alliesOrganizations, charBackground, age, height, weight, size;
	// special classes
	private CharClass charClass;
	private Race race;
	private Background background;
	private ArrayList<Attack> attacks;
	private ArrayList<Spell> spells;
	private ArrayList<Feature> features; // includes traits
	private Armor armor;
	// integer arrays
	// stats = 6 main stats, skills = 18 stat-based skills, savingThrows = 6 main stats, monies = copper thru platinum
	private int[] stats, skills, savingThrows, monies;
	// bools
	private boolean inspired, spellCaster, multiclass;
	// bool arrays
	boolean[] statProfs, skillProfs;
	// integers
	private int level, experience, armorClass, speed, profBonus, maxHP, currentHP, tempHP;
	// imported files
	private File appearance;
	
	// constructor for new character
	public Character() {
		initDefault();
	}
	
	// construct from a save file
	public Character(String s) {
		
	}
	
	// initializes all values to default
	private void initDefault() {
		// Strings
		name = "";
		alignment = "";
		personality = "";
		ideals = "";
		bonds = "";
		flaws = "";
		equipment = "";
		moreEquipment = "";
		otherProfs_languages = "";
		eyeColor = "";
		hairColor = "";
		skinColor = "";
		backstory = "";
		alliesOrganizations = "";
		charBackground = "";
		age = "";
		height = "";
		weight = "";
		size = "";
		// special classes
		charClass = new CharClass();
		race = new Race();
		background = new Background();
		attacks = new ArrayList<Attack>();
		spells = new ArrayList<Spell>();
		features = new ArrayList<Feature>();
		armor = new Armor();
		// integer arrays
		stats = new int[]{ 0, 0, 0, 0, 0, 0 }; // 6
		skills = new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // 18
		savingThrows = new int[]{ 0, 0, 0, 0, 0, 0 }; // 6
		monies = new int[]{ 0, 0, 0, 0, 0}; // 5
		// booleans
		inspired = false;
		spellCaster = false;
		multiclass = false;
		// boolean arrays
		statProfs = new boolean[]{ false, false, false, false, false, false }; // 6
		skillProfs = new boolean[]{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }; // 18
		// integers
		level = 1;
		experience = 0;
		armorClass = 10;
		speed = 0;
		profBonus = 2;
		maxHP = 0;
		currentHP = 0;
		tempHP = 0;
	}
	
	// ArrayList add/remove methods
	public void addAttack(Attack a) {
		
	}
	public void removeAttack(int index) {
		
	}
	public void addSpell(Spell s) {
		
	}
	public void removeSpell(int x) {
		
	}
	public void addFeature(Feature f) {
		
	}
	public void removeFeature(int x) {
		
	}
	
	// setters
	// setters for strings
	// TODO: Should I also have a method for adding to each string?
	public void setName(String s) { name = s; }
	public void setAlignment(String s) { alignment = s; }
	public void setPersonality(String s) { personality = s; }
	public void setIdeals(String s) { ideals = s; }
	public void setBonds(String s) { bonds = s; }
	public void setFlaws(String s) { flaws = s; }
	public void setEquipment(String s) { equipment = s; }
	public void setOtherProfs(String s) { otherProfs_languages = s; }
	public void setMoreEquipment(String s) { moreEquipment = s; }
	public void setEyes(String s) { eyeColor = s; }
	public void setSkin(String s) { skinColor = s; }
	public void setHair(String s) { hairColor = s; }
	public void setBackstory(String s) { backstory = s; }
	public void setAlliesOrganizations(String s) { alliesOrganizations = s; }
	public void setCharBackground(String s) { charBackground = s; }
	public void setAge(String s) { age = s; }
	public void setHeight(String s) { height = s; }
	public void setWeight(String s) { weight = s; }
	public void setSize(String s) { size = s; }
	// setters for special classes
	public void setCharClass(CharClass c) {
		// TODO: implement
	}
	public void setRace(Race r) {
		race = r;
		size = race.getSize();
		speed = race.getSpeed();
		// stat mods
		for (int i = 0; i < 6; i++) {
			stats[i] += race.getStatMods()[i];
		}
		// features
		for (int i = 0; i < race.getFeatures().size(); i ++) {
			features.add(race.getFeatures().get(i));
		}
	}
	public void setBackground(Background b) {
		
	}
	public void setArmor(Armor a) {
		
	}
	// setters for int and boolean arrays
	public void setStat(int stat, int value) { stats[stat] = value; }
	public void setStatSave(int stat, int value) { savingThrows[stat] = value; }
	public void setSkill(int skill, int value) { skills[skill] = value; }
	public void setMoney(int money, int value) { monies[money] = value; }
	public void setStatProf(int stat, boolean value) { statProfs[stat] = value; }
	public void setSkillProf(int skill, boolean value) { skillProfs[skill] = value; }
	// setters for booleans
	public void setInspired(boolean value) { inspired = value; }
	public void setSpellCaster(boolean value) { spellCaster = value; }
	public void setMulticlass(boolean value) { multiclass = value; }
	// setters for ints
	private void setLevel(int x) { level = x; } // should never be accessed directly
	public void setExperience(int x) { experience = x; }
	public void setArmorClass(int x) { armorClass = x; }
	public void setSpeed(int x) { speed = x; }
	public void setProfBonus(int x) { profBonus = x; }
	public void setMaxHP(int x) { maxHP = x; }
	public void setTempHP(int x) { tempHP = x; }
	public void setCurrentHP(int x) { currentHP = x; }
	
	
	// getters
	// getters for strings
	public String getName() { return name; }
	public String getAlignment() { return alignment; }
	public String getPersonality() { return personality; }
	public String getIdeals() { return ideals; }
	public String getBonds() { return bonds; }
	public String getFlaws() { return flaws; }
	public String getEquipment() { return equipment; }
	public String getOtherProfs() { return otherProfs_languages; }
	public String getMoreEquipment() { return moreEquipment; }
	public String getEyes() { return eyeColor; }
	public String getSkin() { return skinColor; }
	public String getHair() { return hairColor; }
	public String getBackstory() { return backstory; }
	public String getAlliesOrganizations() { return alliesOrganizations; }
	public String getCharBackground() { return charBackground; }
	public String getAge() { return age; }
	public String getHeight() { return height; }
	public String getWeight() { return weight; }
	public String getSize() { return size; }
	// getters for special classes
	public CharClass getCharClass() { return charClass; }
	public Race getRace() { return race; }
	public Background getBackground() { return background; }
	public ArrayList<Attack> getAttacks() { return attacks; }
	public ArrayList<Spell> getSpells() { return spells; }
	public ArrayList<Feature> getFeatures() { return features; }
	public Armor getArmor() { return armor; }
	// getters for int arrays
	// stats, x must be between 0 and 5
	public int getStat(int x) { return stats[x]; }
	public int getStatSave(int x) { return savingThrows[x]; }
	public boolean getStatProf(int x) { return statProfs[x]; }
	// stat modifiers - not actually stored as an array, but easily calculated
	// ability score modifiers = (score - 10) / 2 rounded down (Java automatically rounds down when calculating division)
	public int getStatMod(int x) { return (stats[x] - 10) / 2; }
	// skills, x must be between 0 and 17
	public int getSkill(int x) { return skills[x]; }
	public boolean getSkillProf(int x) { return skillProfs[x]; }
	// monies, x must be between 0 and 4
	public int getMoney(int x) { return monies[x]; }
	// getters for booleans
	public boolean isInspired() { return inspired; }
	public boolean isSpellCaster() { return spellCaster; }
	public boolean isMulticlass() { return multiclass; }
	// getters for ints
	public int getLevel() { return level; }
	public int getExperience() { return experience; }
	public int getArmorClass() { return armorClass; }
	public int getSpeed() { return speed; }
	public int getProfBonus() { return profBonus; }
	public int getMaxHP() { return maxHP; }
	public int getCurrentHP() { return currentHP; }
	public int getTempHP() { return tempHP; }
	// not stored
	public int getPassiveWisdom() { 
		int x = 10 + skills[11];
		if (skillProfs[11]) {
			x = x + profBonus;
		}
		return x;
	}
	// getter for double goldTotal - not stored
	public double getGoldTotal() { return (.01 * monies[0]) + (.1 * monies[1]) + (.5 * monies[2]) + monies[3] + (10 * monies[4]); }
	
	
}
