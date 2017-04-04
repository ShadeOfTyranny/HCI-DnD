package model;

public class Attack {
	
	// fields
	int numDice, typeDice; // damage
	String damageType, name, properties;
	
	// default constructor
	public Attack() {
		numDice = 0;
		typeDice = 0;
		damageType = "";
		name = "";
		properties = "";
	}
	
	// x = 0-36
	// club, dagger, greatclub, handaxe, javelin, light hammer, mace, quarterstaff, sickle, spear, light crossbow, dart, shortbow, sling, battleaxe, flail, glaive
	// greataxe, greatsword, halberd, lance, longsword, maul, morningstar, pike, rapier, scimitar, shortsword, trident, war pick, warhammer, whip, blowgun
	// hand crossbow, heavy crossbow, longbow, net
	public Attack(int x) {
		switch (x) {
		case 0:
			name = "Club";
			setAttack(1, 4, "bludgeoning", "light");
			break;
		case 1:
			name = "Dagger";
			setAttack(1, 4, "piercing", "finesse, light, thrown (range 20/60)");
			break;
		case 2:
			name = "Greatclub";
			setAttack(1, 8, "bludgeoning", "two-handed");
			break;
		case 3:
			name = "Handaxe";
			setAttack(1, 6, "slashing", "light, thrown (range 20/60)");
			break;
		case 4:
			name = "Javelin";
			setAttack(1, 6, "piercing", "thrown (range 30/120)");
			break;
		case 5:
			name = "Light Hammer";
			setAttack(1, 4, "bludgeoning", "light, thrown (range 20/60)");
			break;
		case 6:
			name = "Mace";
			setAttack(1, 6, "bludgeoning", "");
			break;
		case 7:
			name = "Quarterstaff";
			setAttack(1, 6, "bludgeoning", "versatile (1d8)");
			break;
		case 8:
			name = "Sickle";
			setAttack(1, 4, "slashing", "light");
			break;
		case 9:
			name = "Spear";
			setAttack(1, 6, "piercing", "thrown (range 20/60), versatile (1d8)");
			break;
		case 10:
			name = "Light Crossbow";
			setAttack(1, 8, "piercing", "ammunition (range 80/320), loading, two-handed");
			break;
		case 11:
			name = "Dart";
			setAttack(1, 4, "piercing", "finesse, thrown (range 20/60)");
			break;
		case 12:
			name = "Shortbow";
			setAttack(1, 6, "piercing", "ammunition (range 80/320), two-handed");
			break;
		case 13:
			name = "Sling";
			setAttack(1, 4, "bludgeoning", "ammunition (range 30/120)");
			break;
		case 14:
			name = "Battleaxe";
			setAttack(1, 8, "slashing", "versatile (1d10)");
			break;
		case 15:
			name = "Flail";
			setAttack(1, 8, "bludgeoning", "");
			break;
		case 16:
			name = "Glaive";
			setAttack(1, 10, "slashing", "heavy, reach, two-handed");
			break;
		case 17:
			name = "Greataxe";
			setAttack(1, 12, "slashing", "heavy, two-handed");
			break;
		case 18:
			name = "Greatsword";
			setAttack(2, 6, "slashing", "heavy, two-handed");
			break;
		case 19:
			name = "Halberd";
			setAttack(1, 10, "slashing", "heavy, reach, two-handed");
			break;
		case 20:
			name = "Lance";
			setAttack(1, 12, "piercing", "reach, disadvantage when you attack a target within 5 feet, requires two hands when you are not mounted");
			break;
		case 21:
			name = "Longsword";
			setAttack(1, 8, "slashing", "versatile (1d10)");
			break;
		case 22:
			name = "Maul";
			setAttack(2, 6, "bludgeoning", "heavy, two-handed");
			break;
		case 23:
			name = "Morningstar";
			setAttack(1, 8, "piercing", "");
			break;
		case 24:
			name = "Pike";
			setAttack(1, 10, "piercing", "heavy, reach, two-handed");
			break;
		case 25:
			name = "Rapier";
			setAttack(1, 8, "piercing", "finesse");
			break;
		case 26:
			name = "Scimitar";
			setAttack(1, 6, "slashing", "finesse, light");
			break;
		case 27:
			name = "Shortsword";
			setAttack(1, 6, "piercing", "finesse, light");
			break;
		case 28:
			name = "Trident";
			setAttack(1, 6, "piercing", "thrown (range 20/60), versatile (1d8)");
			break;
		case 29:
			name = "War Pick";
			setAttack(1, 8, "piercing", "");
			break;
		case 30:
			name = "Warhammer";
			setAttack(1, 8, "bludgeoning", "versatile (1d10)");
			break;
		case 31:
			name = "Whip";
			setAttack(1, 4, "slashing", "finesse, reach");
			break;
		case 32:
			name = "Blowgun";
			setAttack(1, 1, "piercing", "ammunition (range 25/100), loading");
			break;
		case 33:
			name = "Hand Crossbow";
			setAttack(1, 6, "piercing", "ammunition (range 30/120), light, loading");
			break;
		case 34:
			name = "Heavy Crossbow";
			setAttack(1, 10, "piercing", "ammunition (range 100/400), heavy, loading, two-handed");
			break;
		case 35:
			name = "Longbow";
			setAttack(1, 8, "piercing", "ammunition (range 150/600), heavy, two-handed");
			break;
		case 36:
			name = "Net";
			String s = "thrown (range 5/15) \nA Large or smaller creature hit by a net is restrained until it is freed. A net has no effect on creatures that are "
					+ "formless or Huge or larger. A creature can use its action to make a DC 10 Strength check, freeing itself or another creature within its reach "
					+ "on a success. Dealing 5 slashing damage to the net (AC 10) also frees the creature without harming it, ending the effect and destroying the "
					+ "net.\n"
					+ "When you use an action, bonus action, or reaction to attack with a net, you can make only one attack regardless of the number of attacks you "
					+ "can normally make.";
			setAttack(0, 0, "none", s);
			break;
		}
	}
	
	// custom constructor
	public Attack(int numDice, int typeDice, String damageType, String name, String properties) {
		this.name = name;
		setAttack(numDice, typeDice, damageType, properties);
	}
	
	// makes things slightly easier?
	private void setAttack(int numDice, int typeDice, String damageType, String properties) {
		this.numDice = numDice;
		this.typeDice = typeDice;
		this.damageType = damageType;
		this.properties = properties;
	}
	
	//setters
	public void setProperties(String s) {
		properties = s;
	}
	
	// getters
	public int getNumDice() {
		return numDice;
	}
	public int getTypeDice() {
		return typeDice;
	}
	public String getDamageType() {
		return damageType;
	}
	public String getName() {
		return name;
	}
	public String getProperties() {
		return properties;
	}

}
