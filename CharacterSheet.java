package view;

import model.Armor;
import model.Character;
import model.Spell;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import controller.NameListener;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CharacterSheet extends TabPane {

	private Stage stage;
	
	private Character character;
	
	//all areas that need to send or receive
	TextField name, name2, name3, exp, bg, prof, hpCurrent, tempHp, hpMax,
	armorAC, armorStrReq, armorType, armorProp, init, acMod, spdMod,
	age, height, weight, eyes, skin, hair, symbol;
	ArrayList<TextField> stats, money, featureDescrs, skillValList, spellSlotsLeft;
	ArrayList<ArrayList<ComboBox<String>>> spells;
	ArrayList<Spell> currentSpells;
	ArrayList<ArrayList<RadioButton>> spellsChosen;
	UnfillableTextField level, ac, spd, hitDice, perc, spellClass, spellAbility, spellSav, spellBonus;
	ArrayList<UnfillableTextField> statMods, statSav, spellSlots;
	RadioButton insp;
	ArrayList<RadioButton> skillButtList, statProfList;
	ComboBox<String> alignment, charClass, race, subrace, armorName;
	TextArea lang, equip, pers, ideals, bonds, flaws, allies, otherFeatures, treasure, backstory;
	ArrayList<ComboBox<String>> atkNames, features;
	ArrayList<ArrayList<TextField>> atkValues;
	ImageView appearance, symbolView;
	File charImage, symbolImage;
	FileChooser fileChooser = new FileChooser();
	
	public CharacterSheet(Stage stage, Character character) {
		this.character = character;
		this.stage = stage;
		init();
	}
	
	private void init() {
		
		//Tab that holds the first page of the character sheet, mainly stats, attacks and inventory
		Tab tabOne = new Tab();
		tabOne.setClosable(false);
		tabOne.setText("Stats and Combat");
		ScrollPane scrollOne = new ScrollPane(); //allows for page to scroll if necessary
		
		VBox pageOne = new VBox(); //base layout for tabOne
		pageOne.setPadding(new Insets(10));
		
		VBox basicCharInfo = new VBox(); //top pane of character sheet
		
		//Sets up character name, class, level, exp, race, and alignment
		
		Label nameLabel = new Label("Character Name"); 
		name = new TextField(); 
		name.setText(character.getName());
		name.focusedProperty().addListener(new NameListener(character,name.getText()));
		
		Label classLabel = new Label("Class");
		charClass = new ComboBox<String>();
		ObservableList<String> classList = //lists all classes available
			    FXCollections.observableArrayList(
			        "Barbarian",
			        "Bard",
			        "Cleric",
			        "Druid",
			        "Fighter",
			        "Monk",
			        "Paladin",
			        "Ranger",
			        "Rogue",
			        "Sorcerer",
			        "Warlock",
			        "Wizard"
			    );
		charClass.setItems(classList);
		charClass.setValue(character.getCharClass().getName());
		//FUTURE: add dialog box for custom classes
		//TODO: add listener
		
		Label levelLabel = new Label("Level");
		level = new UnfillableTextField();
		level.setUnfillable();
		level.setText(Integer.toString(character.getLevel()));
		level.setMaxWidth(40);
		//FUTURE: leveling up, activate when you want?
		
		Label expLabel = new Label("Experience");
		exp = new NumericTextField();
		exp.setText(Integer.toString(character.getExperience()));
		exp.setMaxWidth(60);
		//TODO: add listener
		
		Label bgLabel = new Label("Background");
		bg = new TextField();
		bg.setText(character.getBackground().getName());
		//TODO: non-editable combobox
		//FUTURE: Add dialog box for custom backgrounds
		//TODO: add listener
		
		Label raceLabel = new Label("Race");
		race = new ComboBox<String>();
		ObservableList<String> raceList = //lists all classes available
			    FXCollections.observableArrayList(
			        "Dwarf","Elf","Halfling","Human","Dragonborn",
			        "Gnome","Half-Elf","Half-Orc","Tiefling"
			    );
		race.setItems(raceList);
		race.setValue(character.getRace().getName());
		//FUTURE: add dialog box for custom races
		//TODO: add listener
		
		Label subraceLabel = new Label("Subrace");
		subrace = new ComboBox<String>();
		ObservableList<String> subraceList = //lists all classes available
			    FXCollections.observableArrayList(
			        "Hill Dwarf","Mountain Dwarf","High Elf","Wood Elf",
			        "Dark Elf(Drow)","Lightfoot","Stout","Forest Gnome",
			        "Rock Gnome"
			    );
		subrace.setItems(subraceList);
		subrace.setValue(character.getRace().getSubRace().getName());
		//FUTURE: add dialog box for custom subraces
		//TODO: add listener
		
		Label alignmentLabel = new Label("Alignment");
		alignment = new ComboBox<String>();
		ObservableList<String> alignmentList = //lists all classes available
			    FXCollections.observableArrayList(
			        "Lawful Good","Lawful Neutral","Lawful Evil",
			        "Neutral Good","True Neutral","Neutral Evil",
			        "Chaotic Good","Chaotic Neutral","Chaotic Evil"
			    );
		alignment.setItems(alignmentList);
		alignment.setValue(character.getAlignment());
		//FUTURE: maybe custom alignments????
		//TODO: add listener
		
		//Add top section components to layout
		
		HBox rowOne = new HBox();
		rowOne.getChildren().addAll(nameLabel,name);
		rowOne.setSpacing(10);
		HBox rowTwo = new HBox();
		rowTwo.getChildren().addAll(classLabel,charClass,
				levelLabel,level,expLabel,exp,bgLabel,bg);
		rowTwo.setSpacing(10);
		HBox rowThree = new HBox();
		rowThree.getChildren().addAll(raceLabel,race,
				subraceLabel,subrace,alignmentLabel,alignment);
		rowThree.setSpacing(10);
		
		basicCharInfo.getChildren().addAll(rowOne,rowTwo,rowThree);
		basicCharInfo.setSpacing(5);
		
		//Set up layout for rest of stat sheet
		
		HBox partTwo = new HBox();
		
		//add stats
		
		GridPane stats = new GridPane();
		stats.setHgap(5);
		
		ArrayList<String> statNames = new ArrayList<String>(Arrays.asList(
				"Strength","Dexterity","Constitution","Intelligence","Wisdom","Charisma"
			));
		this.stats = new ArrayList<TextField>();
		this.statMods = new ArrayList<UnfillableTextField>();
		for(int i=0; i<6; i++) {
			Label statLabel = new Label(statNames.get(i));
			TextField stat = new NumericTextField();
			this.stats.add(stat);
			stat.setText(Integer.toString(character.getStat(i)));
			stat.setMaxWidth(40);
			//TODO: add listener (based on i for stat)
			//FUTURE: something about three fields instead of two...?
			Label statModLabel = new Label("Mod");
			UnfillableTextField statMod = new UnfillableTextField();
			this.statMods.add(statMod);
			statMod.setText(Integer.toString(character.getStatMod(i)));
			statMod.setUnfillable();
			statMod.setMaxWidth(40);
			stats.addColumn(0,statLabel,stat);
			stats.addColumn(1,statModLabel,statMod); 
		}
		
		//add inspiration, proficiency bonus, saving throws, and skills
		
		VBox nextToStats = new VBox();
		nextToStats.setSpacing(5);
		
		HBox inspLayout = new HBox();
		Label inspLabel = new Label("Inspiration");
		insp = new RadioButton();
		insp.setSelected(character.isInspired());
		//TODO: add listener
		inspLayout.getChildren().addAll(insp,inspLabel);
		
		HBox profLayout = new HBox();
		Label profLabel = new Label("Proficiency Bonus");
		prof = new NumericTextField();
		prof.setMaxWidth(40);
		prof.setText(Integer.toString(character.getProfBonus()));
		//TODO: add listener
		profLayout.getChildren().addAll(prof,profLabel);
		
		GridPane savThrows = new GridPane();
		savThrows.setVgap(2);
		savThrows.setHgap(5);
		Label savLabel = new Label("Saving Throws");
		GridPane.setColumnSpan(savLabel, 3);
		savThrows.addRow(0, savLabel);
		
		//radio buttons for stat proficiencies
		statProfList = new ArrayList<RadioButton>();
		for(int i = 0; i<6; i++) {
			RadioButton statProf = new RadioButton();
			statProf.setSelected(character.getStatProf(i));
			statProfList.add(statProf);
			//TODO: add listener
			savThrows.add(statProf,0,i+1);
		}
		//values for saving throws
		statSav = new ArrayList<UnfillableTextField>();
		for(int i=0; i<6; i++) {
			UnfillableTextField statSav = new UnfillableTextField();
			statSav.setText(Integer.toString(character.getStatSave(0)));
			statSav.setMaxWidth(40);
			statSav.setUnfillable();
			savThrows.add(statSav,1,i+1);
		}
		
		//labels
		Label strSavLab = new Label("Strength");
		Label dexSavLab = new Label("Dexterity");
		Label conSavLab = new Label("Constitution");
		Label intelSavLab = new Label("Intelligence");
		Label wisSavLab = new Label("Wisdom");
		Label chaSavLab = new Label("Charisma");
		savThrows.addColumn(2,strSavLab,dexSavLab,conSavLab,intelSavLab,wisSavLab,chaSavLab);
		
		//add inspiration, proficiency bonus, saving throws
		
		nextToStats.getChildren().addAll(inspLayout,profLayout,savThrows);
		
		//Skills
		
		GridPane skills = new GridPane();
		skills.setVgap(2);
		skills.setHgap(2);
		//six columns
		//2 'columns' of skills, each get 3 columns: button,value,label
		//18 skills total
		ArrayList<String> skillList = new ArrayList<String>();
		skillList.addAll(Arrays.asList(
				"Acrobatics (Dex)","Animal Handling (Wis)","Arcana (Int)",
				"Athletics (Str)","Deception (Cha)","History (Int)",
				"Insight (Wis)","Intimidation (Cha)","Investigation (Int)",
				"Medicine (Wis)","Nature (Int)","Perception (Wis)",
				"Performance (Cha)","Persuasion (Cha)","Religion (Int)",
				"Sleight of Hand (Dex)","Stealth (Dex)","Survival (Wis)"
		));
		skillButtList = new ArrayList<RadioButton>(18);
		skillValList = new ArrayList<TextField>(18);
		for(int i=0; i<18; i++) {
			RadioButton butt = new RadioButton();
			butt.setSelected(character.getSkillProf(i));
			skillButtList.add(butt);
			//TODO: add listener
			UnfillableTextField val = new UnfillableTextField();
			val.setText(Integer.toString(character.getSkill(i)));
			val.setUnfillable();
			val.setMaxWidth(40);
			skillValList.add(val);
			skills.addRow(Integer.remainderUnsigned(i, 9),butt,val,new Label(skillList.get(i)));
		}
		
		//Passive wisdom (perception)
		
		HBox perception = new HBox();
		perc = new UnfillableTextField();
		perc.setText(Integer.toString(character.getPassiveWisdom()));
		perc.setUnfillable();
		perc.setMaxWidth(40);
		Label percLabel = new Label("Passive Wisdom (Perception)");
		perception.getChildren().addAll(perc,percLabel);
		perception.setAlignment(Pos.CENTER);
		perception.setSpacing(10);
		
		//Other proficiencies and languages
		
		VBox profLang = new VBox();
		Label langLabel = new Label("Other Proficiencies and Languages");
		lang = new TextArea();
		lang.setText(character.getOtherProfs());
		lang.setPrefHeight(100);
		lang.setPrefWidth(150);
		//TODO: add listener
		profLang.getChildren().addAll(langLabel,lang);
		profLang.setAlignment(Pos.CENTER);
		
		
		//Add all first column layouts
		
		VBox colOne = new VBox();
		colOne.setSpacing(15);
		HBox top = new HBox();
		top.setSpacing(15);
		top.getChildren().addAll(stats,nextToStats);
		top.setAlignment(Pos.CENTER);
		colOne.getChildren().addAll(top,skills,perception,profLang);
		colOne.setAlignment(Pos.CENTER);
		
		//second column: battle info
		//AC, Initiative, Speed, HP, Hit Dice(?), Attacks, Equipment
		
		GridPane combatPane = new GridPane();
		combatPane.setAlignment(Pos.CENTER);
		combatPane.setVgap(2);
		combatPane.setHgap(4);
		
		Label acLabel = new Label("Armor Class");
		acLabel.setWrapText(true);
		acLabel.setMaxWidth(40);
		ac = new UnfillableTextField();
		ac.setText(Integer.toString(character.getArmorClass())); //mod?
		ac.setUnfillable();
		ac.setMaxWidth(40);
		Label acModLabel = new Label("Buff/Debuff");
		TextField acMod = new NumericTextField();
		acMod.setText(Integer.toString(character.getCustomArmorClass()));
		acMod.setMaxWidth(40);
		//TODO: add listener
		
		Label initLabel = new Label("Initiative");
		init = new NumericTextField();
		init.setText(Integer.toString(character.getInit()));
		init.setMaxWidth(40);
		//TODO: add listener
		
		Label spdLabel = new Label("Speed");
		spd = new UnfillableTextField();
		spd.setText(Integer.toString(character.getSpeed())); //mod?
		spd.setUnfillable();
		spd.setMaxWidth(40);
		Label spdModLabel = new Label("Buff/Debuff");
		spdMod = new NumericTextField();
		spdMod.setText(Integer.toString(character.getCustomSpeed()));
		spdMod.setMaxWidth(40);
		//TODO: add listener
		
		combatPane.addRow(0,acLabel,acModLabel,initLabel,spdLabel,spdModLabel);
		combatPane.addRow(1,ac,acMod,init,spd,spdMod);
		
		HBox hp = new HBox();
		hp.setSpacing(2);
		
		Label hpLabel = new Label("Current Hit Points");
		GridPane.setColumnSpan(hpLabel, 2);
		hpCurrent = new NumericTextField();
		hpCurrent.setText(Integer.toString(character.getCurrentHP()));
		hpCurrent.setMaxWidth(40);
		//TODO: add listener
		Label hpSlash = new Label("/");
		hpMax = new NumericTextField();
		hpMax.setText(Integer.toString(character.getMaxHP()));
		hpMax.setMaxWidth(40);
		//TODO: add listener
		//FUTURE: make Max HP calculated by model...?
		hp.getChildren().addAll(hpCurrent,hpSlash,hpMax);
		GridPane.setColumnSpan(hp,2);
		
		Label tempHpLabel = new Label("Temp Hit Points");
		GridPane.setColumnSpan(tempHpLabel, 2);
		tempHp = new NumericTextField();
		tempHp.setText(Integer.toString(character.getTempHP()));
		GridPane.setColumnSpan(tempHp,2);
		tempHp.setMaxWidth(84);
		//TODO: add listener
		
		Label hitDiceLabel = new Label("Hit Dice");
		hitDice = new UnfillableTextField();
		hitDice.setText(Integer.toString(character.getCharClass().getHitDie()));
		hitDice.setMaxWidth(40);
		hitDice.setUnfillable();
		
		combatPane.addRow(2, hpLabel);
		combatPane.addRow(3, hp);
		combatPane.add(tempHpLabel,0,4);
		combatPane.add(tempHp,0,5);
		combatPane.add(hitDiceLabel,2,4);
		combatPane.add(hitDice,2,5);
		
		
		GridPane attacks = new GridPane();
		attacks.setAlignment(Pos.CENTER);
		attacks.setVgap(2);
		attacks.setHgap(2);
		
		Label atkName = new Label("Name");
		Label atkDmg = new Label("Atk Dmg");
		Label atkType = new Label("Atk Type");
		Label atkProp = new Label("Properties");
		attacks.addRow(0,atkName,atkDmg,atkType,atkProp);
		
		ObservableList<String> atks = FXCollections.observableArrayList(
				"","Club","Dagger","Greatclub","Handaxe","Javelin","Light Hammer","Mace",
				"Quarterstaff","Sickle","Spear","Light Crossbow","Dart","Shortbow","Sling",
				"Battleaxe","Flail","Glaive","Greataxe","Greatsword","Halberd","Lance",
				"Longsword","Maul","Morningstar","Pike","Rapier","Scimitar","Shortsword",
				"Trident","War Pick","Warhammer","Whip","Blowgun","Hand Crossbow",
				"Heavy Crossbow","Longbow","Net"
				);
		
		atkNames = new ArrayList<ComboBox<String>>();
		atkValues = new ArrayList<ArrayList<TextField>>();
		for(int i=0; i<5; i++) {
			ComboBox<String> atkBox = new ComboBox<String>(atks);
			atkBox.setMaxWidth(200);
			ArrayList<TextField> rowFields = new ArrayList<TextField>();
			rowFields.addAll(Arrays.asList(
					new UnfillableTextField(),
					new UnfillableTextField(),
					new UnfillableTextField()
					));
			rowFields.get(0).setMaxWidth(40);
			atkValues.add(rowFields);
			atkNames.add(new ComboBox<String>(atks));
			
			attacks.addRow(i+2,atkBox,rowFields.get(0),
					rowFields.get(1),rowFields.get(2));
			

			//TODO: add button for attacks - removes all attacks, replaces all attacks
			//TODO: make atkValues update with atkNames - same as Armor, essentially
		}
		
		
		HBox monAndEqp = new HBox();
		monAndEqp.setSpacing(5);
		monAndEqp.setAlignment(Pos.CENTER);
		VBox money = new VBox();
		VBox armor = new VBox();
		
		ArrayList<String> moneyLabels = new ArrayList<String>(Arrays.asList(
				"Copper","Silver","Electrum","Gold","Platinum"
				));
		
		this.money = new ArrayList<TextField>();
		for(int i=0; i<5; i++) {
			Label moneyLabel = new Label(moneyLabels.get(i));
			TextField moneyField = new NumericTextField();
			moneyField.setText(Integer.toString(character.getMoney(0)));
			moneyField.setMaxWidth(40);
			this.money.add(moneyField);
			//TODO: add listener (use i to figure out which value to update)
			money.getChildren().addAll(moneyLabel,moneyField);
		}
		
		Label armNameLabel = new Label("Armor");
		ObservableList<String> armorList = FXCollections.observableArrayList(
				"Padded","Leather","Studded Leather","Hide","Chain Shirt","Scale Mail",
				"Breastplate","Half Plate","Ring Mail","Chain mail","Splint","Plate"
			);
		armorName = new ComboBox<String>(armorList);
		armorName.setEditable(true);
		armorName.setValue(character.getArmor().getName());
		armorName.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int index = armorName.getSelectionModel().getSelectedIndex();
				Armor nArmor = new Armor(index);
				armorAC.setText(Integer.toString(nArmor.getBaseAC()));
				armorStrReq.setText(Integer.toString(nArmor.getStrReq()));
				armorType.setText(nArmor.getArmorType());
				armorProp.setText(nArmor.getProperties());
			}
		});
		
		
		Label armACLabel = new Label("AC");
		armorAC = new TextField();
		armorAC.setText(Integer.toString(character.getArmor().getBaseAC()));
		armorAC.setMaxWidth(40);
		Label armSRLabel = new Label("Str Req");
		armorStrReq = new TextField();
		armorStrReq.setText(Integer.toString(character.getArmor().getStrReq()));
		armorStrReq.setMaxWidth(40);
		Label armTypeLabel = new Label("Type");
		armorType = new TextField();
		armorType.setText(character.getArmor().getArmorType());
		Label armPropLabel = new Label("Properties");
		armorProp = new TextField();
		armorProp.setText(character.getArmor().getProperties());
		Button armorButton = new Button("Update Armor");
		//TODO: add Listener
		
		
		armor.getChildren().addAll(armNameLabel,armorName,armACLabel,armorAC,armSRLabel,
				armorStrReq,armTypeLabel,armorType,armPropLabel,armorProp,new Label(),armorButton);
		armor.setAlignment(Pos.CENTER);
		
		VBox equipBox = new VBox();
		Label equipLabel = new Label("Equipment");
		equip = new TextArea();
		equip.setMinHeight(100);
		//TODO: add listener
		equipBox.getChildren().addAll(equipLabel,equip);
			
		monAndEqp.getChildren().addAll(money,armor,equipBox);
		
		
		//Add components to column two
		
		VBox colTwo = new VBox();
		colTwo.setSpacing(5);
		colTwo.getChildren().addAll(combatPane,attacks,monAndEqp);
		
		
		//third column: features (add to next page?)
		//personality traits, ideals, bonds, flaws, features & traits
		
		Label persLabel = new Label("Personality Traits");
		pers = new TextArea();
		pers.setText(character.getPersonality());
		pers.setPrefHeight(70);
		//TODO: add listener
		Label idealsLabel = new Label("Ideals");
		ideals = new TextArea();
		ideals.setText(character.getIdeals());
		ideals.setPrefHeight(70);
		//TODO: add listener
		Label bondsLabel = new Label("Bonds");
		bonds = new TextArea();
		bonds.setText(character.getBonds());
		bonds.setPrefHeight(70);
		//TODO: add listener
		Label flawsLabel = new Label("Flaws");
		flaws = new TextArea();
		flaws.setText(character.getFlaws());
		flaws.setPrefHeight(70);
		//TODO: add listener
		
		Label featuresLabel = new Label("Features");
		
		GridPane featuresPane = new GridPane();
		featuresPane.setVgap(2);
		featuresPane.setHgap(4);
		Label featureNameLabel = new Label("Name");
		Label featureDescrLabel =  new Label("Description");
		featuresPane.addRow(0,featureNameLabel,featureDescrLabel);
		ObservableList<String> featureList = FXCollections.observableArrayList(
				"Shelter of the Faithful","False Identity","Criminal Contact",
				"By Populuar Demand","Rustic Hospitality","Guild Membership","Discovery",
				"Position by Privilege","Wanderer","Researcher","Ship's Passage","Bad Reputation",
				"Military Rank","City Secrets"
			);
		features = new ArrayList<ComboBox<String>>();
		featureDescrs = new ArrayList<TextField>();
		for(int i=0; i<5; i++) {
			features.add(new ComboBox<String>(featureList));
			//TODO: add listeners to update fields
			TextField tempField = new UnfillableTextField();
			tempField.setMinWidth(325);
			GridPane.setColumnSpan(tempField, 2);
			featureDescrs.add(tempField);
			featuresPane.addRow(i+1,features.get(i),tempField);
		}
		//TODO: add button to replace all features in character class
		
		//Add components to column three
		
		VBox colThree = new VBox();
		colThree.setSpacing(5);
		colThree.getChildren().addAll(persLabel,pers,idealsLabel,ideals,
				bondsLabel,bonds,flawsLabel,flaws,featuresLabel,featuresPane);
		
		
		//Add components to part two
		
		partTwo.setSpacing(10);
		partTwo.getChildren().addAll(colOne,colTwo,colThree);
		
		//Add all components to page and tab
		
		pageOne.getChildren().addAll(basicCharInfo,partTwo);
		pageOne.setSpacing(15);
		
		scrollOne.setContent(pageOne);
		tabOne.setContent(scrollOne);
		
		
		//Tab that holds the second page of the character sheet, mainly bio and other non-gameplay info
		Tab tabTwo = new Tab();
		tabTwo.setClosable(false);		
		tabTwo.setText("Appearance, Backstory, and Other");
		ScrollPane scrollTwo = new ScrollPane(); //allows for page to scroll if necessary
		
		Label name2Label = new Label("Character Name");
		name2 = new TextField();
		name2.setText(character.getName());
		//TODO: add listener - same as listener above
		
		Label ageLabel = new Label("Age");
		age = new TextField();
		age.setText(character.getAge());
		age.setMaxWidth(80);
		//TODO: add listener
		
		Label eyesLabel = new Label("Eyes");
		eyes = new TextField();
		eyes.setText(character.getEyes());
		eyes.setMaxWidth(80);
		//TODO: add listener
		
		Label heightLabel = new Label("Height");
		height = new TextField();
		height.setText(character.getHeight());
		height.setMaxWidth(80);
		//TODO: add listener
		
		Label skinLabel = new Label("Skin");
		skin = new TextField();
		skin.setText(character.getSkin());
		skin.setMaxWidth(80);
		//TODO: add listener

		Label weightLabel = new Label("Weight");
		weight = new TextField();
		weight.setText(character.getWeight());
		weight.setMaxWidth(80);
		//TODO: add listener
		
		Label hairLabel = new Label("Hair");
		hair = new TextField();
		hair.setText(character.getHair());
		hair.setMaxWidth(80);
		//TODO: add listener
		
		HBox topRow = new HBox();
		topRow.getChildren().addAll(name2Label,name2);
		topRow.setSpacing(10);
		HBox midRow = new HBox();
		midRow.getChildren().addAll(ageLabel,age,heightLabel,height,weightLabel,weight);
		midRow.setSpacing(10);
		HBox bottomRow = new HBox();
		bottomRow.getChildren().addAll(eyesLabel,eyes,skinLabel,skin,hairLabel,hair);
		bottomRow.setSpacing(10);
		
		VBox basicCharFeatures = new VBox();
		basicCharFeatures.getChildren().addAll(topRow,midRow,bottomRow);
		basicCharFeatures.setSpacing(5);
		
		VBox firstColumn = new VBox();
		firstColumn.setSpacing(10);
		
		Label appLabel = new Label("Character Appearance");
		appearance = new ImageView();
		if(character.getAppearance()!=null) { appearance.setImage(new Image(character.getAppearance().toURI().toString())); }
		Button appButton = new Button("Choose Image");
		appButton.setOnAction(
	            new EventHandler<ActionEvent>() {
	                @Override
	                public void handle(final ActionEvent e) {
	                    charImage = fileChooser.showOpenDialog(stage);
	                    if(charImage!=null) {
	                    	appearance.setImage(new Image(charImage.toURI().toString()));
	                    	//update model
	                    }
	                }
	            });

		//TODO: make above EventHandler a controller object
		
		Label backstoryLabel = new Label("Character Backstory");
		backstory = new TextArea();
		backstory.setText(character.getBackstory());
		
		firstColumn.getChildren().addAll(appLabel,appearance,appButton,backstoryLabel,backstory);
		
		
		VBox secondColumn = new VBox();
		secondColumn.setSpacing(5);
		
		HBox alliesAndOrgs = new HBox();
		alliesAndOrgs.setSpacing(10);
		Label alliesAndOrgsLabel = new Label("Allies & Organizations");
				
		allies = new TextArea();
		allies.setText(character.getAlliesOrganizations());
		//TODO: add listener
		
		VBox symbolInfo = new VBox();
		symbolInfo.setSpacing(5);
		Label symbolName = new Label("Symbol Name");
		symbol = new TextField();
		symbol.setText(character.getSymbolName());
		//TODO: add listener
		symbolView = new ImageView();
		if(character.getSymbol()!=null) { symbolView.setImage(new Image(character.getSymbol().toURI().toString())); }
		Button symbolButton = new Button("Choose Image");
		appButton.setOnAction(
	            new EventHandler<ActionEvent>() {
	                @Override
	                public void handle(final ActionEvent e) {
	                    symbolImage = fileChooser.showOpenDialog(stage);
	                    if(charImage!=null) {
	                    	symbolView.setImage(new Image(symbolImage.toURI().toString()));
	                    }
	                }
	            });
		//TODO: make above EventHandler in controller?
		
		symbolInfo.getChildren().addAll(symbolName,symbol,symbolView,symbolButton);
		alliesAndOrgs.getChildren().addAll(allies,symbolInfo);
		
		Label treasureLabel = new Label("Other Equipment");
		treasure = new TextArea();
		treasure.setText(""/*character.getMoreEquipment()*/); //TODO: uncomment out method; commented out currently b/c Character isn't most recent version
		//TODO: add listener
		secondColumn.getChildren().addAll(alliesAndOrgsLabel,alliesAndOrgs,treasureLabel,treasure);
		
		//Add all components to page and tab
		
		HBox restOfTwo = new HBox();
		restOfTwo.setSpacing(5);
		restOfTwo.getChildren().addAll(firstColumn,secondColumn);
		
		VBox pageTwo = new VBox();
		pageTwo.setPadding(new Insets(10));
		pageTwo.getChildren().addAll(basicCharFeatures,restOfTwo);
		
		scrollTwo.setContent(pageTwo);
		
		tabTwo.setContent(scrollTwo);
		
		//Tab that hold the third page of the character sheet, all spell related
		Tab tabThree = new Tab();
		tabThree.setClosable(false);
		tabThree.setText("Spells");
		ScrollPane scrollThree = new ScrollPane(); //allows for page to scroll if necessary
		
		VBox pageThree = new VBox();
		
		GridPane topOfPage = new GridPane();
		topOfPage.setVgap(2);
		topOfPage.setHgap(5);
		
		Label spellClassLabel = new Label("Spellcasting Class");
		spellClass = new UnfillableTextField();
		spellClass.setUnfillable();
		//TODO: add listener
		Label spellAbilityLabel = new Label("Spellcasting Ability");
		GridPane.setHalignment(spellAbilityLabel, HPos.CENTER);
		spellAbility = new UnfillableTextField();
		GridPane.setHalignment(spellAbility, HPos.CENTER);
		spellAbility.setUnfillable();
		spellAbility.setMaxWidth(80);
		//TODO: add listener
		Label spellSavLabel = new Label("Spell Save DC");
		GridPane.setHalignment(spellSavLabel, HPos.CENTER);
		spellSav = new UnfillableTextField();
		GridPane.setHalignment(spellSav, HPos.CENTER);
		spellSav.setUnfillable();
		spellSav.setMaxWidth(80);
		//TODO: add listener
		Label spellBonusLabel = new Label("Spell Attack Bonus");
		GridPane.setHalignment(spellBonusLabel, HPos.CENTER);
		spellBonus = new UnfillableTextField();
		GridPane.setHalignment(spellBonus, HPos.CENTER);
		spellBonus.setUnfillable();
		spellBonus.setMaxWidth(80);
		//TODO: add listener

		topOfPage.addRow(0,spellClassLabel,spellAbilityLabel,spellSavLabel,spellBonusLabel);
		topOfPage.addRow(1,spellClass,spellAbility,spellSav,spellBonus);
		
		//Only get values if character is a spellcaster
		if(character.getCharClass().isSpellCaster()) {
			spellClass.setText(character.getCharClass().getName());
			spellAbility.setText(character.getSpellcastingAbility());
			spellSav.setText(Integer.toString(character.getSpellSaveDC()));
			spellBonus.setText(Integer.toString(character.getSpellAttackBonus()));
		}
		
		HBox restOfPage = new HBox();
		restOfPage.setSpacing(15);
		
		ArrayList<Label> spellLevLabel = new ArrayList<Label>();
		spellLevLabel.add(new Label("Cantrips"));
		spellLevLabel.add(new Label("Level 1"));
		spellLevLabel.add(new Label("Level 2"));
		spellLevLabel.add(new Label("Level 3"));
		spellLevLabel.add(new Label("Level 4"));
		spellLevLabel.add(new Label("Level 5"));
		spellLevLabel.add(new Label("Level 6"));
		spellLevLabel.add(new Label("Level 7"));
		spellLevLabel.add(new Label("Level 8"));
		spellLevLabel.add(new Label("Level 9"));
		
		ObservableList<String> spellList = FXCollections.observableArrayList(
				"Acid Splash"," Aid"," Alarm"," Alter Self"," Animal Friendship"," Animal Messenger","Animal Shapes"," Animate Dead"," Animate Objects"," Antilife Shell"," lAntimagic Field"," Antipathy/Sympathy"," Arcane Eye"," Arcane Gate"," Arcane Lock"," Armor of Agathys"," Arms of Hadar"," Astral Projection"," Augury"," Aura of Life"," Aura of Purity"," Aura of Vitality"," Awaken"," Bane"," Banishing Smite"," Banishment"," Barkskin"," Beacon of Hope"," Beast Sense"," Bestow Curse"," Bigby's Hand"," Blade Barrier"," Blade Ward"," Bless"," Blight"," Blinding Smite"," Blindness/Deafness"," Blink"," Blur"," Branding Smite"," Burning Hands"," Call Lightning"," Calm Emotions"," Chain Lightning"," Charm Person"," Chill Touch"," Chromatic Orb"," Circle of Death"," Circle of Power"," Clairvoyance"," Clone"," Cloud of Daggers"," Cloudkill"," Color Spray"," Command"," Commune"," Commune with Nature"," Compelled Duel"," Comprehend Languages"," Compulsion"," Cone of Cold"," Confusion"," Conjure Animals"," Conjure Barrage"," Conjure Celestial"," Conjure Elemental"," Conjure Fey"," Conjure Minor Elementals"," Conjure Volley"," Conjure Woodland Beings"," Contact Other Plane"," Contagion"," Contingency"," Continual Flame"," Control Water"," Control Weather"," Cordon of Arrows"," Counterspell"," Create Food and Water"," Create or Destroy Water"," Create Undead"," Creation"," Crown of Madness"," Crusader's Mantle"," Cure Wounds"," Dancing Lights"," Darkness"," Darkvision"," Daylight"," Death Ward"," Delayed Blast Fireball"," Demiplane"," Destructive Smite"," Destructive Wave"," Detect Evil and Good"," Detect Magic"," Detect Poison and Disease"," Detect Thoughts"," Dimension Door"," Disguise Self"," Disintegrate"," Dispel Evil and Good"," Dispel Magic"," Dissonant Whispers"," Divination"," Divine Favor"," Divine Word"," Dominate Beast"," Dominate Monster"," Dominate Person"," Drawmij's Instant Summons"," Dream"," Druidcraft"," Earthquake"," Eldritch Blast"," Elemental Weapon"," Enhance Ability"," Enlarge/Reduce"," Ensnaring Strike"," Entangle"," Enthrall"," Etherealness"," Evard's Black Tentacles"," Expeditious Retreat"," Eyebite"," Fabricate"," Faerie Fire"," False Life"," Fear"," Feather Fall"," Feeblemind"," Feign Death"," Find Familiar"," Find Steed"," Find the Path"," Find Traps"," Finger of Death"," Fire Bolt"," Fire Shield"," Fire Storm"," Fireball"," Flame Blade"," Flame Strike"," Flaming Sphere"," Flesh to Stone"," Fly"," Fog Cloud"," Forbiddance"," Forcecage"," Foresight"," Freedom of Movement"," Friends"," Gaseous Form"," Gate"," Geas"," Gentle Repose"," Giant Insect"," Glibness"," Globe of Invulnerability"," Glyph of Warding"," Goodberry"," Grasping Vine"," Grease"," Greater Invisibility"," Greater Restoration"," Guardian of Faith"," Guards and Wards"," Guidance"," Guiding Bolt"," Gust of Wind"," Hail of Thorns"," Hallow"," Hallucinatory Terrain"," Harm"," Haste"," Heal"," Healing Word"," Heat Metal"," Hellish Rebuke"," Heroes' Feast"," Heroism"," Hex"," Hold Monster"," Hold Person"," Holy Aura"," Hunger of Hadar"," Hunter's Mark"," Hypnotic Pattern"," Ice Storm"," Identify"," Illusory Script"," Imprisonment"," Incendiary Cloud"," Inflict Wounds"," Insect Plague"," Invisibility"," Jump"," Knock"," Legend Lore"," Leomund's Secret Chest"," Leomund's Tiny Hut"," Lesser Restoration"," Levitate"," Light"," Lightning Arrow"," Lightning Bolt"," Locate Animals or Plants"," Locate Creature"," Locate Object"," Longstrider"," Mage Armor"," Mage Hand"," Magic Circle"," Magic Jar"," Magic Missile"," Magic Mouth"," Magic Weapon"," Major Image"," Mass Cure Wounds"," Mass Heal"," Mass Healing Word"," Mass Suggestion"," Maze"," Meld into Stone"," Melf's Acid Arrow"," Mending"," Message"," Meteor Swarm"," Mind Blank"," Minor Illusion"," Mirage Arcane"," Mirror Image"," Mislead"," Misty Step"," Modify Memory"," Moonbeam"," Mordenkainen's Faithful Hound"," Mordenkainen's Magnificent Mansion"," Mordenkainen's Private Sanctum"," Mordenkainen's Sword"," Move Earth"," Nondetection"," Nystul's Magic Aura"," Otiluke's Freezing Sphere"," Otiluke's Resilient Sphere"," Otto's Irresistible Dance"," Pass without Trace"," Passwall"," Phantasmal Force"," Phantasmal Killer"," Phantom Steed"," Planar Ally"," Planar Binding"," Plane Shift"," Plant Growth"," Poison Spray"," Polymorph"," Power Word Heal"," Power Word Kill"," Power Word Stun"," Prayer of Healing"," Prestidigitation"," Prismatic Spray"," Prismatic Wall"," Produce Flame"," Programmed Illusion"," Project Image"," Protection from Energy"," Protection from Evil and Good"," Protection from Poison"," Purify Food and Drink"," Raise Dead"," Rary's Telepathic Bond"," Ray of Enfeeblement"," Ray of Frost"," Ray of Sickness"," Regenerate"," Reincarnate"," Remove Curse"," Resistance"," Resurrection"," Reverse Gravity"," Revivify"," Rope Trick"," Sacred Flame"," Sanctuary"," Scorching Ray"," Scrying"," Searing Smite"," See Invisibility"," Seeming"," Sending"," Sequester"," Shapechange"," Shatter"," Shield"," Shield of Faith"," Shillelagh"," Shocking Grasp"," Silence"," Silent Image"," Simulacrum"," Sleep"," Sleet Storm"," Slow"," Spare the Dying"," Speak with Animals"," Speak with Dead"," Speak with Plants"," Spider Climb"," Spike Growth"," Spirit Guardians"," Spiritual Weapon"," Staggering Smite"," Stinking Cloud"," Stone Shape"," Stoneskin"," Storm of Vengeance"," Suggestion"," Sunbeam"," Sunburst"," Swift Quiver"," Symbol"," Tasha's Hideous Laughter"," Telekinesis"," Telepathy"," Teleport"," Teleportation Circle"," Tenser's Floating Disk"," Thaumaturgy"," Thorn Whip"," Thunderous Smite"," Thunderwave"," Time Stop"," Tongues"," Transport via Plants"," Trap the Soul"," Tree Stride"," True Polymorph"," True Resurrection"," True Seeing"," True Strike"," Tsunami"," Unseen Servant"," Vampiric Touch"," Vicious Mockery"," Wall of Fire"," Wall of Force"," Wall of Ice"," Wall of Stone"," Wall of Thorns"," Warding Bond"," Water Breathing"," Water Walk"," Web"," Weird"," Wind Walk"," Wind Wall"," Wish"," Witch Bolt"," Word of Recall"," Wrathful Smite","Zone of Truth"
		);
		
		spells = new ArrayList<ArrayList<ComboBox<String>>>();
//		spellSlots = new ArrayList<UnfillableTextField>();
//		spellSlotsLeft = new ArrayList<TextField>();
		int[] spellNumbers = new int[]{8,12,13,13,13,9,9,9,7,7};
		for(int i=0; i<10; i++) {
			spellLevLabel.get(i).setFont(Font.font(spellLevLabel.get(i).getFont().getName(),FontWeight.BOLD,spellLevLabel.get(i).getFont().getSize()));
			ArrayList<ComboBox<String>> spellLevel = new ArrayList<ComboBox<String>>();
			spells.add(spellLevel);
//			UnfillableTextField slot = new UnfillableTextField();
//			slot.setUnfillable();
//			slot.setMaxWidth(40);
//			spellSlots.add(slot);
//			TextField slotsLeft = new NumericTextField();
//			slotsLeft.setMaxWidth(40);
//			spellSlotsLeft.add(slotsLeft);
			int numberSpells = spellNumbers[i];
			for(int j=0; j<numberSpells; j++) {
				ComboBox<String> tempSpellBox = new ComboBox<String>();
				//FUTURE: make button where user can make custom spells?
				tempSpellBox.setMinWidth(250);
				spellLevel.add(tempSpellBox);
			}
		}
		
		VBox restOne = new VBox();
		VBox restTwo = new VBox();
		VBox restThree = new VBox();
		VBox restFour = new VBox();
		VBox restFive = new VBox();
		for(int i=0; i<2; i++) {
			restOne.getChildren().add(spellLevLabel.get(i));
//			HBox tempBox = new HBox();
//			tempBox.setSpacing(4);
//			tempBox.getChildren().addAll(
//					new Label("Total Slots:"),spellSlots.get(i),
//					new Label("Slots Left:"),spellSlotsLeft.get(i)
//				);
//			restOne.getChildren().add(tempBox);
			int numberSpells = spellNumbers[i];
			for(int j=0; j<numberSpells; j++) {
				restOne.getChildren().add(spells.get(i).get(j));
			}
		}
		for(int i=2; i<4; i++) {
			restTwo.getChildren().add(spellLevLabel.get(i));
//			HBox tempBox = new HBox();
//			tempBox.setSpacing(4);
//			tempBox.getChildren().addAll(
//					new Label("Total Slots:"),spellSlots.get(i),
//					new Label("Slots Left:"),spellSlotsLeft.get(i)
//				);
//			restTwo.getChildren().add(tempBox);
			int numberSpells = spellNumbers[i];
			for(int j=0; j<numberSpells; j++) {
				restTwo.getChildren().add(spells.get(i).get(j));
			}
		}
		for(int i=4; i<6; i++) {
			restThree.getChildren().add(spellLevLabel.get(i));
//			HBox tempBox = new HBox();
//			tempBox.setSpacing(4);
//			tempBox.getChildren().addAll(
//					new Label("Total Slots:"),spellSlots.get(i),
//					new Label("Slots Left:"),spellSlotsLeft.get(i)
//				);
//			restThree.getChildren().add(tempBox);
			int numberSpells = spellNumbers[i];
			for(int j=0; j<numberSpells; j++) {
				restThree.getChildren().add(spells.get(i).get(j));
			}
		}
		for(int i=6; i<8; i++) {
			restFour.getChildren().add(spellLevLabel.get(i));
//			HBox tempBox = new HBox();
//			tempBox.setSpacing(4);
//			tempBox.getChildren().addAll(
//					new Label("Total Slots:"),spellSlots.get(i),
//					new Label("Slots Left:"),spellSlotsLeft.get(i)
//				);
//			restFour.getChildren().add(tempBox);
			int numberSpells = spellNumbers[i];
			for(int j=0; j<numberSpells; j++) {
				restFour.getChildren().add(spells.get(i).get(j));
			}
		}
		for(int i=8; i<10; i++) {
			restFive.getChildren().add(spellLevLabel.get(i));
//			HBox tempBox = new HBox();
//			tempBox.setSpacing(4);
//			tempBox.getChildren().addAll(
//					new Label("Total Slots:"),spellSlots.get(i),
//					new Label("Slots Left:"),spellSlotsLeft.get(i)
//				);
//			restFive.getChildren().add(tempBox);
			int numberSpells = spellNumbers[i];
			for(int j=0; j<numberSpells; j++) {
				restFive.getChildren().add(spells.get(i).get(j));
			}
		}
		
		restOfPage.getChildren().addAll(restOne,restTwo,restThree,restFour,restFive);
		
		//Add all components to page and tab
		
		pageThree.setPadding(new Insets(10));
		pageThree.setSpacing(10);
		pageThree.getChildren().addAll(topOfPage,restOfPage);
		
		scrollThree.setContent(pageThree);
		
		tabThree.setContent(scrollThree);
		
		//Add all tabs to CharacterSheet object
		this.getTabs().addAll(tabOne,tabTwo,tabThree);
	}
	
	//TODO: Replace with single update method
	
	public void updateName() { this.name.setText(character.getName()); }
	public void updateClass() { this.charClass.setValue(character.getCharClass().getName()); }
	public void updateLevel() { this.level.setText(Integer.toString(character.getLevel())); }
	public void updateExp() { this.exp.setText(Integer.toString(character.getExperience())); }
	public void updateBackground() { this.bg.setText(character.getBackground().getName()); }
	//FUTURE: removing background - takes boolean, if true removes proficiencies, if false does not
	public void updateRace() { this.race.setValue(character.getRace().getName()); }
	public void updateSubrace() { this.subrace.setValue(character.getRace().getSubRace().getName()); }
	public void updateAlignment() { this.alignment.setValue(character.getAlignment()); }
	public void updateStats() {
		for(int i=0; i<6; i++) {
			this.stats.get(i).setText(Integer.toString(character.getStat(i)));
		}}
	public void updateStatMods() {
		for(int i=0; i<6; i++) {
			this.statMods.get(i).setText(Integer.toString(character.getStatMod(i)));
		}}
	public void updateStatSavs() {
		for(int i=0; i<6; i++) {
			this.statSav.get(i).setText(Integer.toString(character.getStatSave(i)));
		}}
	public void updateStatProf() {
		for(int i=0; i<6; i++) {
			this.statProfList.get(i).setSelected(character.getStatProf(i));
		}}
	public void updateProf() { this.prof.setText(Integer.toString(character.getProfBonus())); }
	public void updateCurrentHP() { this.hpCurrent.setText(Integer.toString(character.getCurrentHP())); }
	public void updateMaxHP() { this.hpMax.setText(Integer.toString(character.getMaxHP())); }
	public void updateTempHP() { this.tempHp.setText(Integer.toString(character.getTempHP())); }
	public void updateSkillProf() {
		for(int i=0; i<18; i++) {
			this.skillButtList.get(i).setSelected(character.getSkillProf(i));
	}}
	public void updateSkillVals() {
		for(int i=0; i<18; i++) {
			this.skillValList.get(i).setText(Integer.toString(character.getSkill(i)));
		}}
	public void updateInsp() { this.insp.setSelected(character.isInspired()); }
	public void updateArmor() {
		Armor armor = character.getArmor();
		this.armorName.setValue(armor.getName());
		this.armorAC.setText(Integer.toString(armor.getBaseAC()));
		this.armorStrReq.setText(Integer.toString(armor.getStrReq()));
		this.armorType.setText(armor.getArmorType());
		this.armorProp.setText(armor.getProperties());
	}
	public void updateAC() { this.ac.setText(Integer.toString(character.getArmorClass())); } 
	//Still not sure; AC mod?
	public void updateSpd() { this.spd.setText(Integer.toString(character.getSpeed())); } 
	//Still not sure; spd mod?
	public void updateHitDice() { this.hitDice.setText(Integer.toString(character.getCharClass().getHitDie())); }
	public void updatePerc() { this.perc.setText(Integer.toString(character.getPassiveWisdom())); }
	// Features!
	// Attacks!
	// Initiative
	public void updateMoney() {
		for(int i=0; i<5; i++) {
			this.money.get(i).setText(Integer.toString(character.getMoney(i)));
		}}
	public void updateOtherProf() { this.lang.setText(character.getOtherProfs()); }
	public void updatePersonality() { this.pers.setText(character.getPersonality()); }
	public void updateIdeals() { this.ideals.setText(character.getIdeals()); }
	public void updateBonds() { this.bonds.setText(character.getBonds()); }
	public void updateFlaws() { this.flaws.setText(character.getFlaws()); }
	public void updateAge() { this.age.setText(character.getAge()); }
	public void updateHeight() { this.height.setText(character.getHeight()); }
	public void updateWeight() { this.weight.setText(character.getWeight()); }
	public void updateEyes() { this.eyes.setText(character.getEyes()); }
	public void updateSkin() { this.skin.setText(character.getSkin()); }
	public void updateHair() { this.hair.setText(character.getHair()); }
	public void updateAppearance() { 
		
	}
	public void updateBackstory() { this.backstory.setText(character.getBackstory()); }
	public void updateAllies() { this.allies.setText(character.getAlliesOrganizations()); }
	public void updateTreasure() { this.allies.setText(""/*character.getMoreEquipment()*/); }
	public void updateSpellcasting() {
		if(character.getCharClass().isSpellCaster()) {
			//TODO: figure out spellcasting stuff and get update method working
		} else {
			//empty all spellcasting stuff
		}
	}
	public void updateSpells() {
		for(Spell tempSpell : character.getSpells()) {
			int spellLevel = tempSpell.getLevel();
			//Get next ComboBox somehow...?
			String ritualText;
			if(tempSpell.isRitual()) { ritualText = "YES"; } else { ritualText = "NO"; }
//			spellField.setTooltip(new Tooltip(
//					"Cast Time: " + tempSpell.getCastTime() + "; " +
//			"Range: " + tempSpell.getRange() + "; " +
//			"Components: " + tempSpell.getComponents() + "; " +
//			"Duration: " + tempSpell.getDuration() + "; " +
//			"Ritual: " + ritualText + "; " +
//			"Description: " + tempSpell.getDescription()
//				));
//			this.spells.get(spellLevel).add(spellField);
		}
	}
	
	//TextField classes for use above
	
	private class NumericTextField extends TextField {
		@Override public void replaceText(int start, int end, String text) {
	        if (text.matches("[0-9]*")) {
	          super.replaceText(start, end, text);
	        }
	      }

	      @Override public void replaceSelection(String text) {
	        if (text.matches("[0-9]*")) {
	          super.replaceSelection(text);
	        }
	      }
	}
	
	private class UnfillableTextField extends TextField {
		public void setUnfillable() {
			this.setEditable(false);
			this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,null,null)));
		}
	}
	
	
}
