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
		if (name == "Barbarian" || name == "Bard" || name == "Cleric" || name == "Druid" || name == "Fighter" || name == "Monk" || name == "Paladin" || name == "Ranger" || name == "Rogue" ||
				name == "Sorcerer" || name == "Warlock" || name == "Wizard") {
			this.name = name + " ";
		}
		else this.name = name;
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
		// divine domain immediately adds features, but since the variable path won't have been set yet, there's no point
		// perhaps assign features as soon as the path is set?
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
		features.add(new Feature("Favored Enemy"));
		features.add(new Feature("Natural Explorer"));
	}
	private void initRogue() {
		name = "Rogue";
		hitDie = 8;
		profs[1] = true; // dex
		profs[3] = true; // int
		features.add(new Feature("Expertise (rogue)"));
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
	
	public void levelUp() {
		// If custom class is named the same, there will be problems
		switch (name) {
		case "Barbarian":
			levelBarbarian();
			break;
		case "Bard":
			levelBard();
			break;
		case "Cleric":
			levelCleric();
			break;
		case "Druid":
			levelDruid();
			break;
		case "Fighter":
			levelFighter();
			break;
		case "Monk":
			levelMonk();
			break;
		case "Paladin":
			levelPaladin();
			break;
		case "Ranger":
			levelRanger();
			break;
		case "Rogue":
			levelRogue();
			break;
		case "Sorcerer":
			levelSorcerer();
			break;
		case "Warlock":
			levelWarlock();
			break;
		case "Wizard":
			levelWizard();
			break;
		default:
			level++;
			break;
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
				features.add(new Feature("Totem Spirit"));
			}
			//int x = features.indexOf("Rage");
			//features.set(x, new Feature("Rage"));
			break;
		case 4:
			break;
		case 5:
			features.add(new Feature("Extra Attack"));
			features.add(new Feature("Fast Movement"));
			break;
		case 6:
			if (path.equals("Path of the Beserker")) {
				features.add(new Feature("Mindless Rage"));
			}
			else if (path.equals("Path of the Totem Warrior")) {
				features.add(new Feature("Aspect of the Beast"));
			}
			break;
		case 7:
			features.add(new Feature("Feral Instinct"));
			break;
		case 8:
			break;
		case 9:
			features.add(new Feature("Brutal Critical"));
			break;
		case 10:
			if (path.equals("Path of the Beserker")) {
				features.add(new Feature("Intimidating Presence"));
			}
			else if (path.equals("Path of the Totem Warrior")) {
				features.add(new Feature("Spirit Walker"));
			}
			break;
		case 11:
			features.add(new Feature("Relentless Rage"));
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			if (path.equals("Path of the Beserker")) {
				features.add(new Feature("Retaliation"));
			}
			else if (path.equals("Path of the Totem Warrior")) {
				features.add(new Feature("Totemic Attunement"));
			}
			break;
		case 15:
			features.add(new Feature("Persistent Rage"));
			break;
		case 16:
			break;
		case 17:
			break;
		case 18:
			features.add(new Feature("Indomitable Might"));
			break;
		case 19:
			break;
		case 20:
			features.add(new Feature("Primal Champion"));
			break;
		default:
			break;
		}
	}
	
	private void levelBard() {
		level++;
		switch (level) {
		case 2:
			features.add(new Feature("Jack of All Trades"));
			features.add(new Feature("Song of Rest"));
			break;
		case 3:
			features.add(new Feature("Expertise"));
			if (path.equals("College of Lore")) {
				features.add(new Feature("Cutting Words"));
			}
			else if (path.equals("College of Valor")) {
				features.add(new Feature("Combat Inspiration"));
			}
			break;
		case 4:
			break;
		case 5:
			features.add(new Feature("Font of Inspiration"));
			break;
		case 6:
			features.add(new Feature("Countercharm"));
			if (path.equals("College of Lore")) {
				features.add(new Feature("Additional Magical Secrets"));
			}
			else if (path.equals("College of Valor")) {
				features.add(new Feature("Extra Attack"));
			}
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			features.add(new Feature("Magical Secrets"));
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			if (path.equals("College of Lore")) {
				features.add(new Feature("Peerless Skill"));
			}
			else if (path.equals("College of Valor")) {
				features.add(new Feature("Battle Magic"));
			}
			break;
		case 15:
			break;
		case 16:
			break;
		case 17:
			break;
		case 18:
			break;
		case 19:
			break;
		case 20:
			features.add(new Feature("Superior Inspiration"));
			break;
		default:
			break;
		}
	}
	
	private void levelCleric() {
				level++;
				switch (level) {
				case 2:
					features.add(new Feature("Channel Divinity"));
					features.add(new Feature("Channel Divinity: Turn Undead"));
					if (path.equals("Knowledge Domain")) {
						features.add(new Feature("Channel Divinity: Knowledge of the Ages"));
					}
					else if (path.equals("Life Domain")) {
						features.add(new Feature("Channel Divinity: Preserve Life"));
					}
					else if (path.equals("Light Domain")) {
						features.add(new Feature("Channel Divinity: Radiance of the Dawn"));
					}
					else if (path.equals("Nature Domain")) {
						features.add(new Feature("Channel Divinity: Charm Animals and Plants"));
					}
					else if (path.equals("Tempest Domain")) {
						features.add(new Feature("Channel Divinity: Destructive Wrath"));
					}
					else if (path.equals("Trickery Domain")) {
						features.add(new Feature("Channel Divinity: Invoke Duplicity"));
					}
					else if (path.equals("War Domain")) {
						features.add(new Feature("Channel Divinity: Guided Strike"));
					}
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					features.add(new Feature("Destroy Undead"));
					break;
				case 6:
					if (path.equals("Knowledge Domain")) {
						features.add(new Feature("Channel Divinity: Read Thoughts"));
					}
					else if (path.equals("Life Domain")) {
						features.add(new Feature("Blessed Healer"));
					}
					else if (path.equals("Light Domain")) {
						features.add(new Feature("Improved Flare"));
					}
					else if (path.equals("Nature Domain")) {
						features.add(new Feature("Dampen Elements"));
					}
					else if (path.equals("Tempest Domain")) {
						features.add(new Feature("Thunderbolt Strike"));
					}
					else if (path.equals("Trickery Domain")) {
						features.add(new Feature("Channel Divinity: Cloak of Shadows"));
					}
					else if (path.equals("War Domain")) {
						features.add(new Feature("Channel Divinity: War God's Blessing"));
					}
					break;
				case 7:
					break;
				case 8:
					if (path.equals("Knowledge Domain")) {
						features.add(new Feature("Potent Spellcasting"));
					}
					else if (path.equals("Life Domain")) {
						features.add(new Feature("Divine Strike"));
					}
					else if (path.equals("Light Domain")) {
						features.add(new Feature("Potent Spellcasting"));
					}
					else if (path.equals("Nature Domain")) {
						features.add(new Feature("Divine Strike"));
					}
					else if (path.equals("Tempest Domain")) {
						features.add(new Feature("Divine Strike"));
					}
					else if (path.equals("Trickery Domain")) {
						features.add(new Feature("Divine Strike"));
					}
					else if (path.equals("War Domain")) {
						features.add(new Feature("Divine Strike"));
					}
					break;
				case 9:
					break;
				case 10:
					features.add(new Feature("Divine Intervention"));
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					break;
				case 15:
					break;
				case 16:
					break;
				case 17:
					if (path.equals("Knowledge Domain")) {
						features.add(new Feature("Visions of the Past"));
					}
					else if (path.equals("Life Domain")) {
						features.add(new Feature("Supreme Healing"));
					}
					else if (path.equals("Light Domain")) {
						features.add(new Feature("Corona of Light"));
					}
					else if (path.equals("Nature Domain")) {
						features.add(new Feature("Master of Nature"));
					}
					else if (path.equals("Tempest Domain")) {
						features.add(new Feature("Stormborn"));
					}
					else if (path.equals("Trickery Domain")) {
						features.add(new Feature("Improved Duplicity"));
					}
					else if (path.equals("War Domain")) {
						features.add(new Feature("Avatar of Battle"));
					}
					break;
				case 18:
					break;
				case 19:
					break;
				case 20:
					break;
				default:
					break;
				}
	}
	
	private void levelDruid() {
				level++;
				switch (level) {
				case 2:
					features.add(new Feature("Wild Shape"));
					if (path.equals("Circle of the Land")) {
						features.add(new Feature("Natural Recovery"));
					}
					else if (path.equals("Circle of the Moon")) {
						features.add(new Feature("Combat Wild Shape"));
						features.add(new Feature("Circle Forms"));
					}
					break;
				case 3:
					if (path.equals("Circle of the Land")) {
						features.add(new Feature("Circle Spells"));
					}
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					if (path.equals("Circle of the Land")) {
						features.add(new Feature("Land's Stride"));
					}
					else if (path.equals("Circle of the Moon")) {
						features.add(new Feature("Primal Strike"));
					}
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					if (path.equals("Circle of the Land")) {
						features.add(new Feature("Nature's Ward"));
					}
					else if (path.equals("Circle of the Moon")) {
						features.add(new Feature("Elemental Wild Shape"));
					}
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					if (path.equals("Circle of the Land")) {
						features.add(new Feature("Nature's Sanctuary"));
					}
					else if (path.equals("Circle of the Moon")) {
						features.add(new Feature("Thousand Forms"));
					}
					break;
				case 15:
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					features.add(new Feature("Timeless Body"));
					features.add(new Feature("Beast Spells"));
					break;
				case 19:
					break;
				case 20:
					features.add(new Feature("Archdruid"));
					break;
				default:
					break;
				}
	}
	
	private void levelFighter() {
				level++;
				switch (level) {
				case 2:
					break;
				case 3:
					if (path.equals("Champion")) {
						features.add(new Feature("Improved Critical"));
					}
					else if (path.equals("Battle Master")) {
						features.add(new Feature("Combat Superiority"));
					}
					else if (path.equals("Eldritch Knight")) {
						features.add(new Feature("Weapon Bond"));
					}
					break;
				case 4:
					break;
				case 5:
					features.add(new Feature("Extra Attack"));
					break;
				case 6:
					break;
				case 7:
					if (path.equals("Champion")) {
						features.add(new Feature("Remarkable Athlete"));
					}
					else if (path.equals("Battle Master")) {
						features.add(new Feature("Know Your Enemy"));
					}
					else if (path.equals("Eldritch Knight")) {
						features.add(new Feature("War Magic"));
					}
					break;
				case 8:
					break;
				case 9:
					features.add(new Feature("Indomitable"));
					break;
				case 10:
					if (path.equals("Champion")) {
						// additional fighting style
					}
					else if (path.equals("Battle Master")) {
						features.add(new Feature("Improved Combat Superiority"));
					}
					else if (path.equals("Eldritch Knight")) {
						features.add(new Feature("Eldritch Strike"));
					}
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					break;
				case 15:
					if (path.equals("Champion")) {
						features.add(new Feature("Superior Critical"));
					}
					else if (path.equals("Battle Master")) {
						features.add(new Feature("Relentless"));
					}
					else if (path.equals("Eldritch Knight")) {
						features.add(new Feature("Arcane Charge"));
					}
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					if (path.equals("Champion")) {
						features.add(new Feature("Survivor"));
					}
					else if (path.equals("Battle Master")) {
					}
					else if (path.equals("Eldritch Knight")) {
						features.add(new Feature("Improved War Magic"));
					}
					break;
				case 19:
					break;
				case 20:
					break;
				default:
					break;
				}
	}

	private void levelMonk() {
				level++;
				switch (level) {
				case 2:
					features.add(new Feature("Ki"));
					features.add(new Feature("Unarmored Movement"));
					break;
				case 3:
					features.add(new Feature("Deflect Missiles"));
					if (path.equals("Way of the Open Hand")) {
						features.add(new Feature("Open Hand Technique"));
					}
					else if (path.equals("Way of Shadow")) {
						features.add(new Feature("Shadow Arts"));
					}
					else if (path.equals("Way of the Four Elements")) {
						features.add(new Feature("Disciple of the Elements"));
					}
					break;
				case 4:
					features.add(new Feature("Slow Fall"));
					break;
				case 5:
					features.add(new Feature("Extra Attack"));
					features.add(new Feature("Stunning Strike"));
					break;
				case 6:
					features.add(new Feature("Ki-Empowered Strikes"));
					if (path.equals("Way of the Open Hand")) {
						features.add(new Feature("Wholeness of Body"));
					}
					else if (path.equals("Way of Shadow")) {
						features.add(new Feature("Shadow Step"));
					}
					break;
				case 7:
					features.add(new Feature("Evasion"));
					features.add(new Feature("Stillness of Mind"));
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					features.add(new Feature("Purity of Body"));
					break;
				case 11:
					if (path.equals("Way of the Open Hand")) {
						features.add(new Feature("Tranquility"));
					}
					else if (path.equals("Way of Shadow")) {
						features.add(new Feature("Cloak of Shadows"));
					}
					break;
				case 12:
					break;
				case 13:
					features.add(new Feature("Tongue of the Sun and Moon"));
					break;
				case 14:
					features.add(new Feature("Diamond Soul"));
					break;
				case 15:
					features.add(new Feature("Timeless Body (monk)"));
					break;
				case 16:
					break;
				case 17:
					if (path.equals("Way of the Open Hand")) {
						features.add(new Feature("Quivering Palm"));
					}
					else if (path.equals("Way of Shadow")) {
						features.add(new Feature("Opportunist"));
					}
					break;
				case 18:
					features.add(new Feature("Empty Body"));
					break;
				case 19:
					break;
				case 20:
					features.add(new Feature("Perfect Self"));
					break;
				default:
					break;
				}
	}
	
	private void levelPaladin() {
				level++;
				switch (level) {
				case 2:
					features.add(new Feature("Fighting Style (paladin)"));
					features.add(new Feature("Divine Smite"));
					break;
				case 3:
					features.add(new Feature("Divine Health"));
					if (path.equals("Oath of Devotion")) {
						features.add(new Feature("Tenets of Devotion"));
						features.add(new Feature("Channel Divinity (devotion)"));
					}
					else if (path.equals("Oath of the Ancients")) {
						features.add(new Feature("Tenets of the Ancients"));
						features.add(new Feature("Channel Divinity (ancients)"));
					}
					else if (path.equals("Oath of Vengeance")) {
						features.add(new Feature("Tenets of Vengeance"));
						features.add(new Feature("Channel Divinity (vengeance)"));
					}
					break;
				case 4:
					break;
				case 5:
					features.add(new Feature("Extra Attack"));
					break;
				case 6:
					features.add(new Feature("Aura of Protection"));
					break;
				case 7:
					if (path.equals("Oath of Devotion")) {
						features.add(new Feature("Aura of Devotion"));
					}
					else if (path.equals("Oath of the Ancients")) {
						features.add(new Feature("Aura of Warding"));
					}
					else if (path.equals("Oath of Vengeance")) {
						features.add(new Feature("Relentless Avenger"));
					}
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					features.add(new Feature("Aura of Courage"));
					break;
				case 11:
					features.add(new Feature("Improved Divine Smite"));
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					features.add(new Feature("Cleansing Touch"));
					break;
				case 15:
					if (path.equals("Oath of Devotion")) {
						features.add(new Feature("Purity of Spirit"));
					}
					else if (path.equals("Oath of the Ancients")) {
						features.add(new Feature("Undying Sentinel"));
					}
					else if (path.equals("Oath of Vengeance")) {
						features.add(new Feature("Soul of Vengeance"));
					}
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					break;
				case 19:
					break;
				case 20:
					if (path.equals("Oath of Devotion")) {
						features.add(new Feature("Holy Nimbus"));
					}
					else if (path.equals("Oath of the Ancients")) {
						features.add(new Feature("Elder Champion"));
					}
					else if (path.equals("Oath of Vengeance")) {
						features.add(new Feature("Avenging Angel"));
					}
					break;
				default:
					break;
				}
	}
	
	private void levelRanger() {
				level++;
				switch (level) {
				case 2:
					features.add(new Feature("Fighting Style (ranger)"));
					break;
				case 3:
					features.add(new Feature("Primeval Awareness"));
					if (path.equals("Hunter")) {
						features.add(new Feature("Hunter's Prey"));
					}
					else if (path.equals("Beast Master")) {
						features.add(new Feature("Ranger's Companion"));
					}
					break;
				case 4:
					break;
				case 5:
					features.add(new Feature("Extra Attack"));
					break;
				case 6:
					break;
				case 7:
					if (path.equals("Hunter")) {
						features.add(new Feature("Defensive Tactics"));
					}
					else if (path.equals("Beast Master")) {
						features.add(new Feature("Exceptional Training"));
					}
					break;
				case 8:
					features.add(new Feature("Land's Stride"));
					break;
				case 9:
					break;
				case 10:
					features.add(new Feature("Hide in Plain Sight"));
					break;
				case 11:
					if (path.equals("Hunter")) {
						features.add(new Feature("Multiattack"));
					}
					else if (path.equals("Beast Master")) {
						features.add(new Feature("Bestial Fury"));
					}
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					features.add(new Feature("Vanish"));
					break;
				case 15:
					if (path.equals("Hunter")) {
						features.add(new Feature("Superior Hunter's Defense"));
					}
					else if (path.equals("Beast Master")) {
						features.add(new Feature("Share Spells"));
					}
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					features.add(new Feature("Feral Senses"));
					break;
				case 19:
					break;
				case 20:
					features.add(new Feature("Foe Slayer"));
					break;
				default:
					break;
				}
	}
	
	private void levelRogue() {
				level++;
				switch (level) {
				case 2:
					features.add(new Feature("Cunning Action"));
					break;
				case 3:
					if (path.equals("Thief")) {
						features.add(new Feature("Fast Hands"));
						features.add(new Feature("Second-Story Work"));
					}
					else if (path.equals("Assassin")) {
						features.add(new Feature("Assassinate"));
					}
					else if (path.equals("Arcane Trickster")) {
						features.add(new Feature("Mage Hand Legerdemain"));
					}
					break;
				case 4:
					break;
				case 5:
					features.add(new Feature("Uncanny Dodge"));
					break;
				case 6:
					break;
				case 7:
					features.add(new Feature("Evasion"));
					break;
				case 8:
					break;
				case 9:
					if (path.equals("Thief")) {
						features.add(new Feature("Supreme Sneak"));
					}
					else if (path.equals("Assassin")) {
						features.add(new Feature("Infiltration Expertise"));
					}
					else if (path.equals("Arcane Trickster")) {
						features.add(new Feature("Magical Ambush"));
					}
					break;
				case 10:
					break;
				case 11:
					features.add(new Feature("Reliable Talent"));
					break;
				case 12:
					break;
				case 13:
					if (path.equals("Thief")) {
						features.add(new Feature("Use Magic Device"));
					}
					else if (path.equals("Assassin")) {
						features.add(new Feature("Imposter"));
					}
					else if (path.equals("Arcane Trickster")) {
						features.add(new Feature("Versatile Trickster"));
					}
					break;
				case 14:
					features.add(new Feature("Blindsense"));
					break;
				case 15:
					features.add(new Feature("Slippery Mind"));
					break;
				case 16:
					break;
				case 17:
					if (path.equals("Thief")) {
						features.add(new Feature("Thief's Reflexes"));
					}
					else if (path.equals("Assassin")) {
						features.add(new Feature("Death Strike"));
					}
					else if (path.equals("Arcane Trickster")) {
						features.add(new Feature("Spell Thief"));
					}
					break;
				case 18:
					features.add(new Feature("Elusive"));
					break;
				case 19:
					break;
				case 20:
					features.add(new Feature("Stroke of Luck"));
					break;
				default:
					break;
				}
	}
	
	private void levelSorcerer() {
				level++;
				switch (level) {
				case 2:
					features.add(new Feature("Font of Magic"));
					break;
				case 3:
					features.add(new Feature("Metamagic"));
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					if (path.equals("Draconic Bloodline")) {
						features.add(new Feature("Elemental Affinity"));
					}
					else if (path.equals("Wild Magic")) {
						features.add(new Feature("Bend Luck"));
					}
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					if (path.equals("Draconic Bloodline")) {
						features.add(new Feature("Dragon Wings"));
					}
					else if (path.equals("Wild Magic")) {
						features.add(new Feature("Controlled Chaos"));
					}
					break;
				case 15:
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					if (path.equals("Draconic Bloodline")) {
						features.add(new Feature("Draconic Presence"));
					}
					else if (path.equals("Wild Magic")) {
						features.add(new Feature("Spell Bombardment"));
					}
					break;
				case 19:
					break;
				case 20:
					features.add(new Feature("Sorcerous Restoration"));
					break;
				default:
					break;
				}
	}
	
	private void levelWarlock() {
				level++;
				switch (level) {
				case 2:
					features.add(new Feature("Eldritch Invocations"));
					break;
				case 3:
					features.add(new Feature("Pact Boon"));
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					if (path.equals("Archfey")) {
						features.add(new Feature("Misty Escape"));
					}
					else if (path.equals("Fiend")) {
						features.add(new Feature("Dark One's Own Luck"));
					}
					else if (path.equals("Great Old One")) {
						features.add(new Feature("Entropic Ward"));
					}
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					if (path.equals("Archfey")) {
						features.add(new Feature("Beguiling Defenses"));
					}
					else if (path.equals("Fiend")) {
						features.add(new Feature("Fiendish Resilience"));
					}
					else if (path.equals("Great Old One")) {
						features.add(new Feature("Thought Shield"));
					}
					break;
				case 11:
					features.add(new Feature("Mystic Arcanum"));
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					if (path.equals("Archfey")) {
						features.add(new Feature("Dark Delirium"));
					}
					else if (path.equals("Fiend")) {
						features.add(new Feature("Hurl Through Hell"));
					}
					else if (path.equals("Great Old One")) {
						features.add(new Feature("Create Thrall"));
					}
					break;
				case 15:
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					break;
				case 19:
					break;
				case 20:
					features.add(new Feature("Eldritch Master"));
					break;
				default:
					break;
				}
	}
	
	private void levelWizard() {
				level++;
				switch (level) {
				case 2:
					if (path.equals("School of Abjuration")) {
						features.add(new Feature("Abjuration Savant"));
						features.add(new Feature("Arcane Ward"));
					}
					else if (path.equals("School of Conjuration")) {
						features.add(new Feature("Conjuration Savant"));
						features.add(new Feature("Minor Conjuration"));
					}
					else if (path.equals("School of Divination")) {
						features.add(new Feature("Divination Savant"));
						features.add(new Feature("Portent"));
					}
					else if (path.equals("School of Enchantment")) {
						features.add(new Feature("Enchantment Savant"));
						features.add(new Feature("Hypnotic Gaze"));
					}
					else if (path.equals("School of Evocation")) {
						features.add(new Feature("Evocation Savant"));
						features.add(new Feature("Sculpt Spells"));
					}
					else if (path.equals("School of Illusion")) {
						features.add(new Feature("Illusion Savant"));
						features.add(new Feature("Improved Minor Illusion"));
					}
					else if (path.equals("School of Necromancy")) {
						features.add(new Feature("Necromancy Savant"));
						features.add(new Feature("Grim Harvest"));
					}
					else if (path.equals("School of Transmutation")) {
						features.add(new Feature("Transmutation Savant"));
						features.add(new Feature("Minor Alchemy"));
					}
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					if (path.equals("School of Abjuration")) {
						features.add(new Feature("Projected Ward"));
					}
					else if (path.equals("School of Conjuration")) {
						features.add(new Feature("Benign Transposition"));
					}
					else if (path.equals("School of Divination")) {
						features.add(new Feature("Expert Divination"));
					}
					else if (path.equals("School of Enchantment")) {
						features.add(new Feature("Instinctive Charm"));
					}
					else if (path.equals("School of Evocation")) {
						features.add(new Feature("Potent Cantrip"));
					}
					else if (path.equals("School of Illusion")) {
						features.add(new Feature("Malleable Illusions"));
					}
					else if (path.equals("School of Necromancy")) {
						features.add(new Feature("Undead Thralls"));
					}
					else if (path.equals("School of Transmutation")) {
						features.add(new Feature("Transmuter's Stone"));
					}
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					if (path.equals("School of Abjuration")) {
						features.add(new Feature("Improved Abjuration"));
					}
					else if (path.equals("School of Conjuration")) {
						features.add(new Feature("Focused Conjuration"));
					}
					else if (path.equals("School of Divination")) {
						features.add(new Feature("The Third Eye"));
					}
					else if (path.equals("School of Enchantment")) {
						features.add(new Feature("Split Enchantment"));
					}
					else if (path.equals("School of Evocation")) {
						features.add(new Feature("Empowered Evocation"));
					}
					else if (path.equals("School of Illusion")) {
						features.add(new Feature("Illusory Self"));
					}
					else if (path.equals("School of Necromancy")) {
						features.add(new Feature("Inured to Undeath"));
					}
					else if (path.equals("School of Transmutation")) {
						features.add(new Feature("Shapechanger"));
					}
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
					if (path.equals("School of Abjuration")) {
						features.add(new Feature("Spell Resistance"));
					}
					else if (path.equals("School of Conjuration")) {
						features.add(new Feature("Durable Summons"));
					}
					else if (path.equals("School of Divination")) {
						features.add(new Feature("Greater Portent"));
					}
					else if (path.equals("School of Enchantment")) {
						features.add(new Feature("Alter Memories"));
					}
					else if (path.equals("School of Evocation")) {
						features.add(new Feature("Overchannel"));
					}
					else if (path.equals("School of Illusion")) {
						features.add(new Feature("Illusory Reality"));
					}
					else if (path.equals("School of Necromancy")) {
						features.add(new Feature("Command Undead"));
					}
					else if (path.equals("School of Transmutation")) {
						features.add(new Feature("Master Transmuter"));
					}
					break;
				case 15:
					break;
				case 16:
					break;
				case 17:
					break;
				case 18:
					features.add(new Feature("Spell Mastery"));
					break;
				case 19:
					break;
				case 20:
					break;
				default:
					break;
				}
	}
	
	
	// setters
	public void setName(String s) { name = s; } // only call this from save
	public void setPath(String s) { 
		path = s; 
		// since clerics immediately receive features
		if (name == "Cleric") {
			if (path.equals("Knowledge Domain")) {
				features.add(new Feature("Blessings of Knowledge"));
			}
			else if (path.equals("Life Domain")) {
				features.add(new Feature("Disciple of Life"));
			}
			else if (path.equals("Light Domain")) {
				features.add(new Feature("Warding Flare"));
			}
			else if (path.equals("Nature Domain")) {
				features.add(new Feature("Acolyte of Nature"));
			}
			else if (path.equals("Tempest Domain")) {
				features.add(new Feature("Wrath of the Storm"));
			}
			else if (path.equals("Trickery Domain")) {
				features.add(new Feature("Blessing of the Trickster"));
			}
			else if (path.equals("War Domain")) {
				features.add(new Feature("War Priest"));
			}
		}
		// since sorcerers immediately receive features
		if (name == "Sorcerer") {
			if (path.equals("Draconic Bloodline")) {
				features.add(new Feature("Draconic Ancestor"));
				features.add(new Feature("Draconic Resilience"));
			}
			else if (path.equals("Wild Magic")) {
				features.add(new Feature("Wild Magic Surge"));
				features.add(new Feature("Tides of Chaos"));
			}
		}
		// also warlocks
		if (name == "Warlock") {
			if (path.equals("Archfey")) {
				features.add(new Feature("Fey Presence"));
			}
			else if (path.equals("Fiend")) {
				features.add(new Feature("Dark One's Blessing"));
			}
			else if (path.equals("Great Old One")) {
				features.add(new Feature("Awakened Mind"));
			}
		}
		}
	public void setHitDie(int i) { hitDie = i; }
	public void setLevel(int i) { level = i; }
	public void setProfs(boolean[] b) { profs = b; }
	public void setFeatures(ArrayList<Feature> feats) { features = feats; }
	public void setSpellCaster(boolean b) { spellCaster = b; }
	
	// getters
	public String getName() { return name; }
	public String getPath() { return path; }
	public int getHitDie() { return hitDie; }
	public int getLevel() {return level; }
	public boolean[] getProfs() { return profs; }
	public ArrayList<Feature> getFeatures() { return features; }
	public boolean isSpellCaster() { return spellCaster; }

}
