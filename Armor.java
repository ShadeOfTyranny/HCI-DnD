package model;

import java.io.Serializable;

public class Armor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// fields
	private int baseAC, strReq;
	private String armorType; // light, medium, heavy
	private boolean shield;
	private String properties, name;
	
	// default constructor
	public Armor() {
		name = "";
		baseAC = 0;
		strReq = 0;
		armorType = "";
		properties = "";
		shield = false;
	}
	
	// padded, leather, studded leather, hide, chain shirt, scale mail, breastplate, half plate, ring mail, chain mail, splint, plate (0-11)
	public Armor(int x) {
		switch (x) {
		case 0:
			name = "Padded";
			baseAC = 11;
			strReq = 0;
			armorType = "light";
			properties = "Disadvantage on stealth";
			break;
		case 1:
			name = "Leather";
			baseAC = 11;
			strReq = 0;
			armorType = "light";
			properties = "";
			break;
		case 2:
			name = "Studded Leather";
			baseAC = 12;
			strReq = 0;
			armorType = "light";
			properties = "";
			break;
		case 3:
			name = "Hide";
			baseAC = 12;
			strReq = 0;
			armorType = "medium";
			properties = "";
			break;
		case 4:
			name = "Chain Shirt";
			baseAC = 13;
			strReq = 0;
			armorType = "medium";
			properties = "";
			break;
		case 5:
			name = "Scale Mail";
			baseAC = 14;
			strReq = 0;
			armorType = "medium";
			properties = "Disadvantage on stealth";
			break;
		case 6:
			name = "Breastplate";
			baseAC = 14;
			strReq = 0;
			armorType = "medium";
			properties = "";
			break;
		case 7:
			name = "Half Plate";
			baseAC = 15;
			strReq = 0;
			armorType = "medium";
			properties = "Disadvantage on stealth";
			break;
		case 8:
			name = "Ring Mail";
			baseAC = 14;
			strReq = 0;
			armorType = "heavy";
			properties = "Disadvantage on stealth";
			break;
		case 9:
			name = "Chain mail";
			baseAC = 16;
			strReq = 13;
			armorType = "heavy";
			properties = "Disadvantage on stealth";
			break;
		case 10:
			name = "Splint";
			baseAC = 17;
			strReq = 15;
			armorType = "heavy";
			properties = "Disadvantage on stealth";
			break;
		case 11:
			name = "Plate";
			baseAC = 18;
			strReq = 15;
			properties = "Disadvantage on stealth";
			break;
		}
	}
	
	// custom constructor
	public Armor(int baseAC, int strReq, String armorType, String properties, String name) {
		this.baseAC = baseAC;
		this.strReq = strReq;
		this.armorType = armorType;
		this.properties = properties;
		this.name = name;
	}
	
	// setters
	public void setShield(boolean val) {
		shield = val;
	}
	public void setProperties(String s) {
		properties = s;
	}
	
	// getters
	public int getBaseAC() {
		return baseAC;
	}
	public int getStrReq() {
		return strReq;
	}
	public String getArmorType() {
		return armorType;
	}
	public String getProperties() {
		return properties;
	}
	public String getName() {
		return name;
	}
	public boolean hasShield() {
		return shield;
	}

}
