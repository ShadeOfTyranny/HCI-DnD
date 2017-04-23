/**
 * Notes on Project:
 * Multiclassing and spellcasting are not implemented for this iteration.
 * In checkLevel there is the potential for levelGoal to be less than level. In future iterations, something will have to be done about that.
 * In future iterations, levelUP will not simply call levelUp, but will send a notification to the player who can then choose to level up when they desire
 * In future iterations, CharClass's setPath should have a list of options from the book to prevent mistakes
 */


// TODO: update/push button and check updates regularly

package model;

import java.io.File;
import java.util.ArrayList;

public class Character {
	
	// fields
	
	// player input Strings = have no affect on calculations
	private String name, alignment, personality, ideals, bonds, flaws, equipment, otherProfs_languages, eyeColor, skinColor, hairColor, backstory, alliesOrganizations, charBackground, age, height, 
	weight, size, symbolName, spellcastingAbility;
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
	// integer arrays for any custom modifications
	private int[] customStats, customSkills, customSavingThrows;
	// bools
	private boolean inspired, spellCaster, multiclass;
	// bool arrays
	boolean[] statProfs, skillProfs;
	// integers
	private int level, experience, armorClass, speed, profBonus, maxHP, currentHP, tempHP, init, spellSaveDC, spellAttackBonus;
	// integers for any custom modifications
	private int customArmorClass, customSpeed, customProfBonus, customMaxHP, customWisdom;
	// imported files
	private File appearance;
	private File symbol;
	
	// constructor for new character
	public Character() {
		initDefault();
	}
	
	// construct from a save file
	public Character(String s) {
		initDefault();
		// TODO
		
		
		
	}
	
	public String save() {
		String s = "";
		//TODO
		
		return s;
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
		spellcastingAbility = "";
		symbolName = "";
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
		// custom options
		customStats = new int[] {0, 0, 0, 0, 0, 0};
		customSkills = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		customSavingThrows = new int[] {0, 0, 0, 0, 0, 0};
		customArmorClass = 0;
		customSpeed = 0;
		customProfBonus = 0;
		customMaxHP = 0;
		customWisdom = 0;
		init = 0;
		spellSaveDC = 0;
		spellAttackBonus = 0;
	}
	
	// ArrayList add/remove methods
	public void addAttack(Attack a) {
		attacks.add(a);
	}
	public void removeAttack(int index) {
		attacks.remove(index);
	}
	public void addSpell(Spell s) {
		spells.add(s);
	}
	public void removeSpell(int index) {
		spells.remove(index);
	}
	public void addFeature(Feature f) {
		features.add(f);
	}
	public void removeFeature(int index) {
		features.remove(index);
	}
	
	// setters
	// setters for strings
	public void setName(String s) { name = s; }
	public void setAlignment(String s) { alignment = s; }
	public void setPersonality(String s) { personality = s; }
	public void setIdeals(String s) { ideals = s; }
	public void setBonds(String s) { bonds = s; }
	public void setFlaws(String s) { flaws = s; }
	public void setEquipment(String s) { equipment = s; }
	public void setOtherProfs(String s) { otherProfs_languages = s; }
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
		this.charClass = c;
		// TODO: implement
	}
	public void removeCharClass() {
		//TODO
	}
	public void changeCharClass(CharClass c) {
		removeCharClass();
		setCharClass(c);
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
	public void removeRace() {
		//Race r = race;
		race = new Race();
		size = "";
		speed = 0;
		// stat mods
		for (int i = 0; i < 6; i++) {
			stats[i] -= race.getStatMods()[i];
		}
		// features
		for (int i = 0; i < race.getFeatures().size(); i++) {
			for (int j = 0; j < features.size(); j++) {
				if (features.get(j).equals(race.getFeatures().get(i).getName())) {
					features.remove(j);
					j--;
				}
			}
		}
	}
	public void changeRace(Race r) {
		removeRace();
		setRace(r);
	}
	public void setBackground(Background b) {
		background = b;
		skillProfs[b.getSkill1()] = true;
		skillProfs[b.getSkill2()] = true;
		features.add(b.getFeature());
	}
	
	// boolean allows user to decide if they want the proficiencies replaced
	public void removeBackground(boolean removeProfs) {
		background = new Background();
		if (removeProfs) {
			skillProfs[background.getSkill1()] = false;
			skillProfs[background.getSkill2()] = false;
		}
		
		for (int i = 0; i < features.size(); i++) {
			if (features.get(i).equals(background.getFeature().getName())) {
				features.remove(i);
				break; // since there should only be one instance of said feature
			}
		}
	}
	public void setArmor(Armor a) {
		armor = a;
		calculateAC();
	}
	// if no armor: AC = 10 + dex mod
	// if shield: AC += 2
	public void calculateAC() {
		if (armor.getArmorType().equals("")) {
			armorClass = 10 + getStatMod(1);
		}
		else if (armor.getArmorType().equals("light")) {
			armorClass = armor.getBaseAC() + getStatMod(1);
		}
		else if (armor.getArmorType().equals("medium")) {
			int add = getStatMod(1);
			if (add > 2) add = 2;
			armorClass = armor.getBaseAC() + add;
		}
		else if (armor.getArmorType().equals("heavy")) {
			armorClass = armor.getBaseAC();
		}
	}
	// setters for int and boolean arrays
	public void setStat(int stat, int value) { stats[stat] = value; }
	public void setStatSave(int stat, int value) { savingThrows[stat] = value; }
	public void setSkill(int skill, int value) { skills[skill] = value; }
	public void setMoney(int money, int value) { monies[money] = value; }
	public void setStatProf(int stat, boolean value) { statProfs[stat] = value; }
	public void setSkillProf(int skill, boolean value) { skillProfs[skill] = value; }
	public void setCustomStat(int stat, int value) { customStats[stat] = value; }
	public void setCustomSkill(int skill, int value) { customSkills[skill] = value; }
	public void setCustomSavingThrows(int stat, int value) { customSavingThrows[stat] = value; }
	// setters for booleans
	public void setInspired(boolean value) { inspired = value; }
	public void setSpellCaster(boolean value) { spellCaster = value; }
	public void setMulticlass(boolean value) { multiclass = value; }
	// setters for ints
	public void setExperience(int x) { 
		experience = x;
		checkLevel();
		}
	// to see if a level up is necessary
	private void checkLevel() {
		int levelGoal; // what the level should be based on experience
		if (experience >= 355000) {
			levelGoal = 20;
		}
		else if (experience >= 305000) {
			levelGoal = 19;
		}
		else if (experience >= 265000) {
			levelGoal = 18;
		}
		else if (experience >= 225000) {
			levelGoal = 17;
		}
		else if (experience >= 195000) {
			levelGoal = 16;
		}
		else if (experience >= 165000) {
			levelGoal = 15;
		}
		else if (experience >= 140000) {
			levelGoal = 14;
		}
		else if (experience >= 120000) {
			levelGoal = 13;
		}
		else if (experience >= 100000) {
			levelGoal = 12;
		}
		else if (experience >= 85000) {
			levelGoal = 11;
		}
		else if (experience >= 64000) {
			levelGoal = 10;
		}
		else if (experience >= 48000) {
			levelGoal = 9;
		}
		else if (experience >= 34000) {
			levelGoal = 8;
		}
		else if (experience >= 23000) {
			levelGoal = 7;
		}
		else if (experience >= 14000) {
			levelGoal = 6;
		}
		else if (experience >= 6500) {
			levelGoal = 5;
		}
		else if (experience >= 2700) {
			levelGoal = 4;
		}
		else if (experience >= 900) {
			levelGoal = 3;
		}
		else if (experience >= 300) {
			levelGoal = 2;
		}
		else {
			levelGoal = 1;
		}
		if (levelGoal > level) {
			levelUP();
		}
		else if (levelGoal < level) {
		}
	}
	private void levelUP() {
		// for this iteration, simply call levelUp
		levelUp();
		checkLevel(); // in case more levels are necessary
	}
	public void levelUp() {
		level++;
		charClass.levelUp();
		//TODO change variables that are affected by the previous statement
	}
	public void setArmorClass(int x) { armorClass = x; }
	public void setSpeed(int x) { speed = x; }
	public void setProfBonus(int x) { profBonus = x; }
	public void setMaxHP(int x) { maxHP = x; }
	public void setTempHP(int x) { tempHP = x; }
	public void setCurrentHP(int x) { currentHP = x; }
	public void setCustomArmorClass(int x) { customArmorClass = x; }
	public void setCustomSpeed(int x) { customSpeed = x; }
	public void setCustomProfBonus(int x) {customProfBonus = x; }
	public void setCustomMaxHP(int x) { customMaxHP = x; }
	public void setCustomWisdom(int x) { customWisdom = x; }
	
	
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
	public int getStat(int x) { return stats[x] + customStats[x]; }
	public int getStatSave(int x) { return savingThrows[x] + customSavingThrows[x]; }
	public int getCustomStat(int x) { return customStats[x]; }
	public int getCustomStatSave(int x) {return customSavingThrows[x]; }
	public boolean getStatProf(int x) { return statProfs[x]; }
	// stat modifiers - not actually stored as an array, but easily calculated
	// ability score modifiers = (score - 10) / 2 rounded down (Java automatically rounds down when calculating division)
	public int getStatMod(int x) { return ((stats[x] + customStats[x]) - 10) / 2; }
	// skills, x must be between 0 and 17
	public int getSkill(int x) { return skills[x] + customSkills[x]; }
	public int getCustomSkill(int x) { return customSkills[x]; }
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
	public int getArmorClass() { 
		calculateAC(); // just in case something changed
		return armorClass + customArmorClass; }
	public int getCustomArmorClass() {
		return customArmorClass;
	}
	public int getSpeed() { return speed + customSpeed; }
	public int getCustomSpeed() {
		return customSpeed;
	}
	public int getProfBonus() { return profBonus + customProfBonus; }
	public int getCustomProfBonus() { return customProfBonus; }
	public int getMaxHP() { return maxHP + customMaxHP; }
	public int getCustomMaxHP() { return customMaxHP; }
	public int getCurrentHP() { return currentHP; }
	public int getTempHP() { return tempHP; }
	// not stored
	public int getPassiveWisdom() { 
		int x = 10 + skills[11];
		if (skillProfs[11]) {
			x = x + profBonus;
		}
		return x + customWisdom;
	}
	public int getCustomWisdom() {
		return customWisdom;
	}
	// getter for double goldTotal - not stored
	public double getGoldTotal() { return (.01 * monies[0]) + (.1 * monies[1]) + (.5 * monies[2]) + monies[3] + (10 * monies[4]); }
	
	public int getInit() { return init; }
	public void setInit(int i) { init = i; }
	
	public File getAppearance() { return appearance; }
	public void setAppearance(File f) { appearance = f; }
	
	public File getSymbol() { return symbol; }
	public void setSymbol(File f) { symbol = f; }
	
	public String getSpellcastingAbility() { return spellcastingAbility; }
	public void setSpellcastingAbility(String s) { spellcastingAbility = s; }
	
	public int getSpellSaveDC() { return spellSaveDC; }
	public void setSpellSaveDC(int i) { spellSaveDC = i; }
	
	public int getSpellAttackBonus() { return spellAttackBonus; }
	public void setSpellAttackBonus(int i) { spellAttackBonus = i; }
	
	public String getSymbolName() { return symbolName; }
	public void setSymbolName(String s) { symbolName = s; }
}
