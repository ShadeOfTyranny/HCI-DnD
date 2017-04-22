package model;

// default options: acolyte, charlatan, criminal, entertainer, folk hero, guild artisan, hermit, noble, outlander, sage, sailor, soldier, urchin, custom
public class Background {
	
	// fields
	private String name; // name of background
	private int skillProf_1, skillProf_2; // two skill proficiencies, int 0-17
	private Feature feature;
	
	// default constructor
	public Background() {
		name = "";
		skillProf_1 = -1;
		skillProf_2 = -1;
		feature = new Feature();
	}
	
	// constructor, takes int 0-12 to determine background
	public Background(int x) {
		switch (x) {
		case 0:
			initAcolyte();
			break;
		case 1:
			initCharlatan();
			break;
		case 2:
			initCriminal();
			break;
		case 3:
			initEntertainer();
			break;
		case 4:
			initFolkHero();
			break;
		case 5:
			initGuildArtisan();
			break;
		case 6:
			initHermit();
			break;
		case 7:
			initNoble();
			break;
		case 8:
			initOutlander();
			break;
		case 9:
			initSage();
			break;
		case 10:
			initSailor();
			break;
		case 11:
			initSoldier();
			break;
		case 12:
			initUrchin();
			break;
		}
		// determine feature
		if (x < 13) {
			//feature = new Feature(0, x);
		}
	}
	
	// custom constructor
	public Background(String name, int skill1, int skill2) {
		this.name = name;
		skillProf_1 = skill1;
		skillProf_2 = skill2;
		//feature = new Feature(); 
	}
	
	// initializes various backgrounds
	private void initAcolyte() {
		name = "Acolyte";
		skillProf_1 = 6; // insight
		skillProf_2 = 14; // religion
		feature = new Feature("Shelter of the Faithful");
	}
	private void initCharlatan() {
		name = "Charlatan";
		skillProf_1 = 4; // deception
		skillProf_2 = 0; // sleight of hand
		feature = new Feature("False Identity");
	}
	private void initCriminal() {
		name = "Criminal";
		skillProf_1 = 4; // deception
		skillProf_2 = 16; // stealth
		feature = new Feature("Criminal Contact");
	}
	private void initEntertainer() {
		name = "Entertainer";
		skillProf_1 = 0; // acrobatics
		skillProf_2 = 12; // performance
		feature = new Feature("By Popular Demand");
	}
	private void initFolkHero() {
		name = "Folk Hero";
		skillProf_1 = 1; // animal handling
		skillProf_2 = 17; // survival
		feature = new Feature("Rustic Hospitality");
	}
	private void initGuildArtisan() {
		name = "Guild Artisan";
		skillProf_1 = 6; // insight
		skillProf_2 = 13; // persuasion
		feature = new Feature("Guild Membership");
	}
	private void initHermit() {
		name = "Hermit";
		skillProf_1 = 9; // medicine
		skillProf_2 = 14; // religion
		feature = new Feature("Discovery");
	}
	private void initNoble() {
		name = "Noble";
		skillProf_1 = 5; // history
		skillProf_2 = 13; // persuasion
		feature = new Feature("Position of Privilege");
	}
	private void initOutlander() {
		name = "Outlander";
		skillProf_1 = 3; // athletics
		skillProf_2 = 17; // survival
		feature = new Feature("Wanderer");
	}
	private void initSage() {
		name = "Sage";
		skillProf_1 = 2; // arcana
		skillProf_2 = 5; // history
		feature = new Feature("Researcher");
	}
	private void initSailor() {
		name = "Sailor";
		skillProf_1 = 3; // athletics
		skillProf_2 = 11; // perception
		feature = new Feature("Ship's Passage");
	}
	private void initSoldier() {
		name = "Soldier";
		skillProf_1 = 3; // athletics
		skillProf_2 = 7; // intimidation
		feature = new Feature("Military Rank");
	}
	private void initUrchin() {
		name = "Urchin";
		skillProf_1 = 15; // sleight of hand
		skillProf_2 = 16; // stealth
		feature = new Feature("City Secrets");
	}
	
	// getters
	public String getName() {
		return name;
	}
	public int getSkill1() {
		return skillProf_1;
	}
	public int getSkill2() {
		return skillProf_2;
	}
	public Feature getFeature() {
		return feature;
	}


}
