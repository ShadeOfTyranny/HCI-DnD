package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import controller.ArmorListener;
import controller.AttackListener;
import controller.BackgroundListener;
import controller.ClassListener;
import controller.ExpListener;
import controller.FeatureListener;
import controller.NameListener;
import controller.SpellListener;
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
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Armor;
import model.Attack;
import model.Background;
import model.Character;
import model.Feature;
import model.Listener;
import model.Spell;

public class CharacterSheet extends TabPane implements Listener {

	private Stage stage;
	
	private Character character;
	
	private ArrayList<Feature> autoFeatureList; //number of features from Class/Race/Background
	private ArrayList<String> oldFeatureNames;
	private int[] spellNumbers;
	
	//all areas that need to send or receive
	TextField name, name2, exp, prof, hpCurrent, tempHp, hpMax,
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
	ComboBox<String> bg, alignment, charClass, race, subrace, armorName;
	TextArea lang, equip, pers, ideals, bonds, flaws, allies, otherEquip, backstory;
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
		name.focusedProperty().addListener(new NameListener(character,name));
		
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
		//FUTURE: add dialog box for custom classes
		charClass.focusedProperty().addListener(new ClassListener(character,charClass));
		
		Label levelLabel = new Label("Level");
		level = new UnfillableTextField();
		level.setUnfillable();
		level.setMaxWidth(40);
		//FUTURE: leveling up, activate when you want?
		
		Label expLabel = new Label("Experience");
		exp = new NumericTextField();
		exp.setMaxWidth(60);
		exp.focusedProperty().addListener(new ExpListener(character,exp));
		
		Label bgLabel = new Label("Background");
		bg = new ComboBox<String>(FXCollections.observableArrayList(
				"Acolyte",
				"Charlatan",
				"Criminal",
				"Entertainer",
				"Folk Hero",
				"Guild Artisan",
				"Hermit",
				"Noble",
				"Outlander",
				"Sage",
				"Sailor",
				"Soldier",
				"Urchin"
				));
		//FUTURE: Add dialog box for custom backgrounds
		bg.focusedProperty().addListener(new BackgroundListener(character,bg));
		
		Label raceLabel = new Label("Race");
		race = new ComboBox<String>();
		ObservableList<String> raceList = //lists all classes available
			    FXCollections.observableArrayList(
			        "Dwarf","Elf","Halfling","Human","Dragonborn",
			        "Gnome","Half-Elf","Half-Orc","Tiefling"
			    );
		race.setItems(raceList);
		//FUTURE: add dialog box for custom races
		
		Label subraceLabel = new Label("Subrace");
		subrace = new ComboBox<String>();
		ObservableList<String> subraceList = //lists all classes available
			    FXCollections.observableArrayList(
			        "","Hill Dwarf","Mountain Dwarf","High Elf","Wood Elf",
			        "Dark Elf(Drow)","Lightfoot","Stout","Forest Gnome",
			        "Rock Gnome"
			    );
		subrace.setItems(subraceList);
		//FUTURE: add dialog box for custom subraces
		
		race.focusedProperty().addListener(new RaceListener(character,race,subrace));
		subrace.focusedProperty().addListener(new SubraceListener(character,subrace));
		
		Label alignmentLabel = new Label("Alignment");
		alignment = new ComboBox<String>();
		alignment.setEditable(true);
		ObservableList<String> alignmentList = //lists all classes available
			    FXCollections.observableArrayList(
			        "Lawful Good","Lawful Neutral","Lawful Evil",
			        "Neutral Good","True Neutral","Neutral Evil",
			        "Chaotic Good","Chaotic Neutral","Chaotic Evil"
			    );
		alignment.setItems(alignmentList);
		alignment.focusedProperty().addListener(new AlignmentListener(character,alignment));
		
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
			stat.setMaxWidth(40);
			stat.focusedProperty().addListener(new StatListener(character,stat,i));
			//FUTURE: something about three fields instead of two...?
			Label statModLabel = new Label("Mod");
			UnfillableTextField statMod = new UnfillableTextField();
			this.statMods.add(statMod);
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
		insp.setOnAction(new InspListener(character,insp));
		inspLayout.getChildren().addAll(insp,inspLabel);
		
		HBox profLayout = new HBox();
		Label profLabel = new Label("Proficiency Bonus");
		prof = new NumericTextField();
		prof.setMaxWidth(40);
		prof.focusedProperty().addListener(new ProfListener(character,prof));
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
			statProfList.add(statProf);
			statProf.onActionProperty(new StatProfListener(character,statProf,i));
			savThrows.add(statProf,0,i+1);
		}
		//values for saving throws
		statSav = new ArrayList<UnfillableTextField>();
		for(int i=0; i<6; i++) {
			UnfillableTextField statSav = new UnfillableTextField();
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
			butt.onActionProperty(new SkillListener(character,butt,i));
			skillButtList.add(butt);
			UnfillableTextField val = new UnfillableTextField();
			val.setUnfillable();
			val.setMaxWidth(40);
			skillValList.add(val);
			skills.addRow(Integer.remainderUnsigned(i, 9),butt,val,new Label(skillList.get(i)));
		}
		
		//Passive wisdom (perception)
		
		HBox perception = new HBox();
		perc = new UnfillableTextField();
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
		lang.setPrefHeight(100);
		lang.setPrefWidth(150);
		lang.focusedProperty(new LangListener(character,lang));
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
		ac.setUnfillable();
		ac.setMaxWidth(40);
		Label acModLabel = new Label("Buff/Debuff");
		acMod = new NumericTextField();
		acMod.setMaxWidth(40);
		acMod.focusedProperty().addListener(new ACListener(character,acMod));
		
		Label initLabel = new Label("Initiative");
		init = new NumericTextField();
		init.setMaxWidth(40);
		init.focusedProperty().addListener(new InitListener(character,init));
		
		Label spdLabel = new Label("Speed");
		spd = new UnfillableTextField();
		spd.setUnfillable();
		spd.setMaxWidth(40);
		Label spdModLabel = new Label("Buff/Debuff");
		spdMod = new NumericTextField();
		spdMod.setMaxWidth(40);
		spdMod.focusedProperty().addListener(new SpdListener(character,spdMod));
		
		combatPane.addRow(0,acLabel,acModLabel,initLabel,spdLabel,spdModLabel);
		combatPane.addRow(1,ac,acMod,init,spd,spdMod);
		
		HBox hp = new HBox();
		hp.setSpacing(2);
		
		Label hpLabel = new Label("Current Hit Points");
		GridPane.setColumnSpan(hpLabel, 2);
		hpCurrent = new NumericTextField();
		hpCurrent.setMaxWidth(40);
		hpCurrent.focusedProperty().addListener(new CurrentHPListener(character,hpCurrent));
		Label hpSlash = new Label("/");
		hpMax = new NumericTextField();
		hpMax.setMaxWidth(40);
		hpMax.focusedProperty().addListener(new MaxHPListener(character,hpMax));
		//FUTURE: make Max HP calculated by model?
		hp.getChildren().addAll(hpCurrent,hpSlash,hpMax);
		GridPane.setColumnSpan(hp,2);
		
		Label tempHpLabel = new Label("Temp Hit Points");
		GridPane.setColumnSpan(tempHpLabel, 2);
		tempHp = new NumericTextField();
		GridPane.setColumnSpan(tempHp,2);
		tempHp.setMaxWidth(84);
		tempHp.focusedProperty().addListener(new TempHPListener(character,tempHp));
		
		Label hitDiceLabel = new Label("Hit Dice");
		hitDice = new UnfillableTextField();
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
		Label atkNumDice = new Label("# of Dice");
		Label atkTypeDice = new Label("Dice Sides");
		Label atkType = new Label("Atk Type");
		Label atkProp = new Label("Properties");
		attacks.addRow(0,atkName,atkNumDice,atkTypeDice,atkType,atkProp);
		
		ObservableList<String> atks = FXCollections.observableArrayList(
				"Club","Dagger","Greatclub","Handaxe","Javelin","Light Hammer","Mace",
				"Quarterstaff","Sickle","Spear","Light Crossbow","Dart","Shortbow","Sling",
				"Battleaxe","Flail","Glaive","Greataxe","Greatsword","Halberd","Lance",
				"Longsword","Maul","Morningstar","Pike","Rapier","Scimitar","Shortsword",
				"Trident","War Pick","Warhammer","Whip","Blowgun","Hand Crossbow",
				"Heavy Crossbow","Longbow","Net"
				);
		
		atkNames = new ArrayList<ComboBox<String>>();
		atkValues = new ArrayList<ArrayList<TextField>>();
		for(int i=0; i<5; i++) {
			int boxIndex = i; 
			ComboBox<String> atkBox = new ComboBox<String>(atks);
			atkBox.setEditable(true);
			atkBox.setMaxWidth(200);
			atkBox.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					int index = atkBox.getSelectionModel().getSelectedIndex();
					Attack attack = new Attack(index);
					atkValues.get(boxIndex).get(0).setText(Integer.toString(attack.getNumDice()));
					atkValues.get(boxIndex).get(1).setText(Integer.toString(attack.getTypeDice()));
					atkValues.get(boxIndex).get(2).setText(attack.getDamageType());
					atkValues.get(boxIndex).get(3).setText(attack.getProperties());
				}
				
			});
			ArrayList<TextField> rowFields = new ArrayList<TextField>();
			rowFields.addAll(Arrays.asList(
					new NumericTextField(),
					new NumericTextField(),
					new TextField(),
					new TextField()
					));
			rowFields.get(0).setMaxWidth(40);
			rowFields.get(1).setMaxWidth(40);
			rowFields.get(3).textProperty().addListener((observable, oldValue, newValue) -> {
				Tooltip temp = new Tooltip(rowFields.get(3).getText());
				temp.setMaxWidth(300);
				temp.setWrapText(true);
				rowFields.get(3).setTooltip(temp);
			});			
			atkValues.add(rowFields);
			atkNames.add(atkBox);
			
			attacks.addRow(i+2,atkBox,rowFields.get(0),
					rowFields.get(1),rowFields.get(2),rowFields.get(3));
		}
		Button atkButton = new Button("Update Attacks");
		atkButton.setOnMouseClicked(new AttackListener(character,atkNames,atkValues));
		attacks.addRow(7,atkButton);
		
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
			moneyField.setMaxWidth(40);
			this.money.add(moneyField);
			moneyField.focusedProperty().addListener(new MoneyListener(character,moneyField,i));
			money.getChildren().addAll(moneyLabel,moneyField);
		}
		
		Label armNameLabel = new Label("Armor");
		ObservableList<String> armorList = FXCollections.observableArrayList(
				"Padded","Leather","Studded Leather","Hide","Chain Shirt","Scale Mail",
				"Breastplate","Half Plate","Ring Mail","Chain mail","Splint","Plate"
			);
		armorName = new ComboBox<String>(armorList);
		armorName.setEditable(true);
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
		armorAC.setMaxWidth(40);
		Label armSRLabel = new Label("Str Req");
		armorStrReq = new TextField();
		armorStrReq.setMaxWidth(40);
		Label armTypeLabel = new Label("Type");
		armorType = new TextField();
		Label armPropLabel = new Label("Properties");
		armorProp = new TextField();
		Button armorButton = new Button("Update Armor");
		armorButton.setOnMouseClicked(new ArmorListener(character,armorName,armorAC,armorStrReq,armorType,armorProp));
		
		
		armor.getChildren().addAll(armNameLabel,armorName,armACLabel,armorAC,armSRLabel,
				armorStrReq,armTypeLabel,armorType,armPropLabel,armorProp,new Label(),armorButton);
		armor.setAlignment(Pos.CENTER);
		
		VBox equipBox = new VBox();
		Label equipLabel = new Label("Equipment");
		equip = new TextArea();
		equip.setMinHeight(100);
		equip.focusedProperty().addListener(new EquipListener(character,equip));
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
		pers.setPrefHeight(70);
		pers.focusedProperty().addListener(new PersListener(character,pers));
		Label idealsLabel = new Label("Ideals");
		ideals = new TextArea();
		ideals.setPrefHeight(70);
		ideals.focusedProperty().addListener(new IdealsListener(character,ideals));
		Label bondsLabel = new Label("Bonds");
		bonds = new TextArea();
		bonds.setPrefHeight(70);
		bonds.focusedProperty().addListener(new BondsListener(character,bonds));
		Label flawsLabel = new Label("Flaws");
		flaws = new TextArea();
		flaws.setPrefHeight(70);
		flaws.focusedProperty().addListener(new FlawsListener(character,flaws));
		
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
		
		
		for(int i=0; i<8; i++) {
			int index = i;
			ComboBox<String> tempBox = new ComboBox<String>(featureList);
			tempBox.setEditable(true);
			features.add(tempBox);
			tempBox.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Feature feature = new Feature(tempBox.getValue());
					featureDescrs.get(index).setText(feature.getDescription());
				}
				
			});
			TextField tempField = new TextField();
			tempField.setMinWidth(325);
			GridPane.setColumnSpan(tempField, 2);
			featureDescrs.add(tempField);
			Button featureButton = new Button("Update Features");
			featureButton.setOnMouseClicked(new FeatureListener(character,tempBox,tempField,oldFeatureNames,i));
			featuresPane.addRow(i+1,tempBox,tempField, featureButton);
		}
		
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
		name2.focusedProperty().addListener(new NameListener(character,name2));
		
		Label ageLabel = new Label("Age");
		age = new TextField();
		age.setMaxWidth(80);
		age.focusedProperty().addListener(new AgeListener(character,age));
		
		Label eyesLabel = new Label("Eyes");
		eyes = new TextField();
		eyes.setMaxWidth(80);
		eyes.focusedProperty().addListener(new EyesListener(character,eyes));
		
		Label heightLabel = new Label("Height");
		height = new TextField();
		height.setMaxWidth(80);
		height.focusedProperty().addListener(new HeightListener(character,height));
		
		Label skinLabel = new Label("Skin");
		skin = new TextField();
		skin.setMaxWidth(80);
		skin.focusedProperty().addListener(new SkinListener(character,skin));

		Label weightLabel = new Label("Weight");
		weight = new TextField();
		weight.setText(character.getWeight());
		weight.setMaxWidth(80);
		weight.focusedProperty().addListener(new WeightListener(character,weight));
		
		Label hairLabel = new Label("Hair");
		hair = new TextField();
		hair.setMaxWidth(80);
		hair.focusedProperty().addListener(new HairListener(character,hair));
		
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
		Button appButton = new Button("Choose Image");
		appButton.setOnAction(
	            new EventHandler<ActionEvent>() {
	                @Override
	                public void handle(final ActionEvent e) {
	                    charImage = fileChooser.showOpenDialog(stage);
	                    if(charImage!=null) {
	                    	appearance.setImage(new Image(charImage.toURI().toString()));
	                    	character.setAppearance(charImage); //no controller - easier to handle directly
	                    }
	                }
	            });
		
		Label backstoryLabel = new Label("Character Backstory");
		backstory = new TextArea();
		backstory.focusedProperty().addListener(new BackstoryListener(character,backstory));
		
		firstColumn.getChildren().addAll(appLabel,appearance,appButton,backstoryLabel,backstory);
		
		
		VBox secondColumn = new VBox();
		secondColumn.setSpacing(5);
		
		HBox alliesAndOrgs = new HBox();
		alliesAndOrgs.setSpacing(10);
		Label alliesAndOrgsLabel = new Label("Allies & Organizations");
				
		allies = new TextArea();
		allies.focusedProperty().addListener(new AlliesListener(character,allies));
		
		VBox symbolInfo = new VBox();
		symbolInfo.setSpacing(5);
		Label symbolName = new Label("Symbol Name");
		symbol = new TextField();
		symbol.focusedProperty().addListener(new SymbolListener(character,symbol)); //symbol name
		symbolView = new ImageView();
		if(character.getSymbol()!=null) { symbolView.setImage(new Image(character.getSymbol().toURI().toString())); }
		Button symbolButton = new Button("Choose Image");
		appButton.setOnAction(
	            new EventHandler<ActionEvent>() {
	                @Override
	                public void handle(final ActionEvent e) {
	                    symbolImage = fileChooser.showOpenDialog(stage);
	                    if(symbolImage!=null) {
	                    	symbolView.setImage(new Image(symbolImage.toURI().toString()));
	                    	character.setSymbol(symbolImage);
	                    }
	                }
	            });
		
		symbolInfo.getChildren().addAll(symbolName,symbol,symbolView,symbolButton);
		alliesAndOrgs.getChildren().addAll(allies,symbolInfo);
		
		Label otherEquipLabel = new Label("Other Equipment");
		otherEquip = new TextArea();
		otherEquip.focusedProperty().addListener(new OtherEquipListener(character,otherEquip));
		secondColumn.getChildren().addAll(alliesAndOrgsLabel,alliesAndOrgs,otherEquipLabel,otherEquip);
		
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
		Label spellAbilityLabel = new Label("Spellcasting Ability");
		GridPane.setHalignment(spellAbilityLabel, HPos.CENTER);
		spellAbility = new UnfillableTextField();
		GridPane.setHalignment(spellAbility, HPos.CENTER);
		spellAbility.setUnfillable();
		spellAbility.setMaxWidth(80);
		Label spellSavLabel = new Label("Spell Save DC");
		GridPane.setHalignment(spellSavLabel, HPos.CENTER);
		spellSav = new UnfillableTextField();
		GridPane.setHalignment(spellSav, HPos.CENTER);
		spellSav.setUnfillable();
		spellSav.setMaxWidth(80);
		Label spellBonusLabel = new Label("Spell Attack Bonus");
		GridPane.setHalignment(spellBonusLabel, HPos.CENTER);
		spellBonus = new UnfillableTextField();
		GridPane.setHalignment(spellBonus, HPos.CENTER);
		spellBonus.setUnfillable();
		spellBonus.setMaxWidth(80);
		
		Button spellUpdate = new Button("Update Spells");
		spellUpdate.setMinSize(200, 40);
		GridPane.setColumnSpan(spellUpdate, GridPane.REMAINING);
		GridPane.setRowSpan(spellUpdate, GridPane.REMAINING);
		spellUpdate.setOnMouseClicked(new SpellListener(character, spells));

		topOfPage.addRow(0,spellClassLabel,spellAbilityLabel,spellSavLabel,spellBonusLabel);
		topOfPage.addRow(1,spellClass,spellAbility,spellSav,spellBonus);
		topOfPage.add(spellUpdate, 6, 0);
		
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
				"Acid Splash","Aid","Alarm","Alter Self","Animal Friendship","Animal Messenger","Animal Shapes","Animate Dead","Animate Objects","Antilife Shell","lAntimagic Field","Antipathy/Sympathy","Arcane Eye","Arcane Gate","Arcane Lock","Armor of Agathys","Arms of Hadar","Astral Projection","Augury","Aura of Life","Aura of Purity","Aura of Vitality","Awaken","Bane","Banishing Smite","Banishment","Barkskin","Beacon of Hope","Beast Sense","Bestow Curse","Bigby's Hand","Blade Barrier","Blade Ward","Bless","Blight","Blinding Smite","Blindness/Deafness","Blink","Blur","Branding Smite","Burning Hands","Call Lightning","Calm Emotions","Chain Lightning","Charm Person","Chill Touch","Chromatic Orb","Circle of Death","Circle of Power","Clairvoyance","Clone","Cloud of Daggers","Cloudkill","Color Spray","Command","Commune","Commune with Nature","Compelled Duel","Comprehend Languages","Compulsion","Cone of Cold","Confusion","Conjure Animals","Conjure Barrage","Conjure Celestial","Conjure Elemental","Conjure Fey","Conjure Minor Elementals","Conjure Volley","Conjure Woodland Beings","Contact Other Plane","Contagion","Contingency","Continual Flame","Control Water","Control Weather","Cordon of Arrows","Counterspell","Create Food and Water","Create or Destroy Water","Create Undead","Creation","Crown of Madness","Crusader's Mantle","Cure Wounds","Dancing Lights","Darkness","Darkvision","Daylight","Death Ward","Delayed Blast Fireball","Demiplane","Destructive Smite","Destructive Wave","Detect Evil and Good","Detect Magic","Detect Poison and Disease","Detect Thoughts","Dimension Door","Disguise Self","Disintegrate","Dispel Evil and Good","Dispel Magic","Dissonant Whispers","Divination","Divine Favor","Divine Word","Dominate Beast","Dominate Monster","Dominate Person","Drawmij's Instant Summons","Dream","Druidcraft","Earthquake","Eldritch Blast","Elemental Weapon","Enhance Ability","Enlarge/Reduce","Ensnaring Strike","Entangle","Enthrall","Etherealness","Evard's Black Tentacles","Expeditious Retreat","Eyebite","Fabricate","Faerie Fire","False Life","Fear","Feather Fall","Feeblemind","Feign Death","Find Familiar","Find Steed","Find the Path","Find Traps","Finger of Death","Fire Bolt","Fire Shield","Fire Storm","Fireball","Flame Blade","Flame Strike","Flaming Sphere","Flesh to Stone","Fly","Fog Cloud","Forbiddance","Forcecage","Foresight","Freedom of Movement","Friends","Gaseous Form","Gate","Geas","Gentle Repose","Giant Insect","Glibness","Globe of Invulnerability","Glyph of Warding","Goodberry","Grasping Vine","Grease","Greater Invisibility","Greater Restoration","Guardian of Faith","Guards and Wards","Guidance","Guiding Bolt","Gust of Wind","Hail of Thorns","Hallow","Hallucinatory Terrain","Harm","Haste","Heal","Healing Word","Heat Metal","Hellish Rebuke","Heroes' Feast","Heroism","Hex","Hold Monster","Hold Person","Holy Aura","Hunger of Hadar","Hunter's Mark","Hypnotic Pattern","Ice Storm","Identify","Illusory Script","Imprisonment","Incendiary Cloud","Inflict Wounds","Insect Plague","Invisibility","Jump","Knock","Legend Lore","Leomund's Secret Chest","Leomund's Tiny Hut","Lesser Restoration","Levitate","Light","Lightning Arrow","Lightning Bolt","Locate Animals or Plants","Locate Creature","Locate Object","Longstrider","Mage Armor","Mage Hand","Magic Circle","Magic Jar","Magic Missile","Magic Mouth","Magic Weapon","Major Image","Mass Cure Wounds","Mass Heal","Mass Healing Word","Mass Suggestion","Maze","Meld into Stone","Melf's Acid Arrow","Mending","Message","Meteor Swarm","Mind Blank","Minor Illusion","Mirage Arcane","Mirror Image","Mislead","Misty Step","Modify Memory","Moonbeam","Mordenkainen's Faithful Hound","Mordenkainen's Magnificent Mansion","Mordenkainen's Private Sanctum","Mordenkainen's Sword","Move Earth","Nondetection","Nystul's Magic Aura","Otiluke's Freezing Sphere","Otiluke's Resilient Sphere","Otto's Irresistible Dance","Pass without Trace","Passwall","Phantasmal Force","Phantasmal Killer","Phantom Steed","Planar Ally","Planar Binding","Plane Shift","Plant Growth","Poison Spray","Polymorph","Power Word Heal","Power Word Kill","Power Word Stun","Prayer of Healing","Prestidigitation","Prismatic Spray","Prismatic Wall","Produce Flame","Programmed Illusion","Project Image","Protection from Energy","Protection from Evil and Good","Protection from Poison","Purify Food and Drink","Raise Dead","Rary's Telepathic Bond","Ray of Enfeeblement","Ray of Frost","Ray of Sickness","Regenerate","Reincarnate","Remove Curse","Resistance","Resurrection","Reverse Gravity","Revivify","Rope Trick","Sacred Flame","Sanctuary","Scorching Ray","Scrying","Searing Smite","See Invisibility","Seeming","Sending","Sequester","Shapechange","Shatter","Shield","Shield of Faith","Shillelagh","Shocking Grasp","Silence","Silent Image","Simulacrum","Sleep","Sleet Storm","Slow","Spare the Dying","Speak with Animals","Speak with Dead","Speak with Plants","Spider Climb","Spike Growth","Spirit Guardians","Spiritual Weapon","Staggering Smite","Stinking Cloud","Stone Shape","Stoneskin","Storm of Vengeance","Suggestion","Sunbeam","Sunburst","Swift Quiver","Symbol","Tasha's Hideous Laughter","Telekinesis","Telepathy","Teleport","Teleportation Circle","Tenser's Floating Disk","Thaumaturgy","Thorn Whip","Thunderous Smite","Thunderwave","Time Stop","Tongues","Transport via Plants","Trap the Soul","Tree Stride","True Polymorph","True Resurrection","True Seeing","True Strike","Tsunami","Unseen Servant","Vampiric Touch","Vicious Mockery","Wall of Fire","Wall of Force","Wall of Ice","Wall of Stone","Wall of Thorns","Warding Bond","Water Breathing","Water Walk","Web","Weird","Wind Walk","Wind Wall","Wish","Witch Bolt","Word of Recall","Wrathful Smite","Zone of Truth"
		);
		
		spells = new ArrayList<ArrayList<ComboBox<String>>>();
//		spellSlots = new ArrayList<UnfillableTextField>(); // FUTURE: implement spell slots when implemented in model
//		spellSlotsLeft = new ArrayList<TextField>(); // FUTURE: implement spell slots remaining when implemented in model
		spellNumbers = new int[]{8,12,13,13,13,9,9,9,7,7};
		spellsChosen = new ArrayList<ArrayList<RadioButton>>();
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
			ArrayList<RadioButton> spellLevChose = new ArrayList<RadioButton>();
			spellsChosen.add(spellLevChose);
			for(int j=0; j<numberSpells; j++) {
				ComboBox<String> tempSpellBox = new ComboBox<String>(spellList);
				//FUTURE: make button where user can make custom spells?
				tempSpellBox.setMinWidth(250);
				tempSpellBox.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
					Spell spell = new Spell(tempSpellBox.getValue());
					String spellDetails = "Cast Time: " + spell.getCastTime() + "\nComponents: " + spell.getComponents()
					+ "\nDuration: " + spell.getDuration() + "\nRange: " + spell.getRange()
					+ "\nDescription: " + spell.getDescription();
					Tooltip spellTip = new Tooltip(spellDetails);
					spellTip.setWrapText(true);
					spellTip.setMaxWidth(300);
					spellTip.setWrapText(true);
					tempSpellBox.setTooltip(spellTip);
					}
					
				});
				spellLevel.add(tempSpellBox);
				RadioButton tempSpellChoice = new RadioButton();
				spellLevChose.add(tempSpellChoice);
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
				HBox temp = new HBox();
				temp.getChildren().addAll(spellsChosen.get(i).get(j),spells.get(i).get(j));
				restOne.getChildren().add(temp);
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
				HBox temp = new HBox();
				temp.getChildren().addAll(spellsChosen.get(i).get(j),spells.get(i).get(j));
				restTwo.getChildren().add(temp);
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
				HBox temp = new HBox();
				temp.getChildren().addAll(spellsChosen.get(i).get(j),spells.get(i).get(j));
				restThree.getChildren().add(temp);
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
				HBox temp = new HBox();
				temp.getChildren().addAll(spellsChosen.get(i).get(j),spells.get(i).get(j));
				restFour.getChildren().add(temp);
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
				HBox temp = new HBox();
				temp.getChildren().addAll(spellsChosen.get(i).get(j),spells.get(i).get(j));
				restFive.getChildren().add(temp);
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
		
		updated();
	}
	
	
	//FUTURE: removing background - takes boolean, if true removes proficiencies, if false does not
	
	@Override
	public void updated() {
		//Name
		name.setText(character.getName());
		name2.setText(character.getName());
		//Level
		level.setText(Integer.toString(character.getLevel()));
		//EXP
		exp.setText(Integer.toString(character.getExperience()));
		//Background
		bg.setValue(character.getBackground().getName());
		//Alignment
		alignment.setValue(character.getAlignment());
		//Class
		charClass.setValue(character.getCharClass().getName());
		//Race
		race.setValue(character.getRace().getName());
		//Subrace
		subrace.setValue(character.getRace().getSubRace().getName());
		//Stats, Stat Mods, Stat Save, Stat Proficiencies
		for(int i=0; i<6; i++) {
			stats.get(i).setText(Integer.toString(character.getStat(i)));
			statMods.get(i).setText(Integer.toString(character.getStatMod(i)));
			statSav.get(i).setText(Integer.toString(character.getStatSave(i))); //TODO: custom saving throws in Character not set????
			statProfList.get(i).setSelected(character.getStatProf(i));
		}
		//Skill Proficiencies, Skill Values
		for(int i=0; i<18; i++) {
			skillButtList.get(i).setSelected(character.getSkillProf(i));
			skillValList.get(i).setText(Integer.toString(character.getSkill(i)));
		}
		//Inspiration
		insp.setSelected(character.isInspired());
		//Proficiency Bonus
		prof.setText(Integer.toString(character.getProfBonus()));
		//HP
		hpCurrent.setText(Integer.toString(character.getCurrentHP()));
		tempHp.setText(Integer.toString(character.getTempHP()));
		hpMax.setText(Integer.toString(character.getMaxHP()));
		//Armor
		armorName.setValue(character.getArmor().getName());
		//TODO: test to see if other armor fields get updated
		//Initiative
		init.setText(Integer.toString(character.getInit()));
		//Armor Class
		ac.setText(Integer.toString(character.getArmorClass()));
		acMod.setText(Integer.toString(character.getCustomArmorClass()));
		//Speed
		spd.setText(Integer.toString(character.getSpeed()));
		spdMod.setText(Integer.toString(character.getCustomSpeed()));
		//Hit Dice
		hitDice.setText(Integer.toString(character.getCharClass().getHitDie()));
		//Perception
		perc.setText(Integer.toString(character.getPassiveWisdom()));
		//Money
		for(int i=0; i<5; i++) { money.get(i).setText(Integer.toString(character.getMoney(i)));	}
		//Attacks
		for(int i=0; i<character.getAttacks().size(); i++) {
			atkNames.get(i).setValue(character.getAttacks().get(i).getName());
			//TODO: test to see if other attack fields get updated
		}
		//Features
		ArrayList<Feature> charFeatures = character.getFeatures();
		//Set number of features from class, background and race
		autoFeatureList = character.getCharClass().getFeatures();
		if(character.getBackground().getFeature()!=null) {
			autoFeatureList.add(character.getBackground().getFeature());
		}
		autoFeatureList.addAll(character.getRace().getFeatures());
		//Set names of features and feature list
		oldFeatureNames = new ArrayList<String>();
		for(int i=0; i<autoFeatureList.size(); i++) {
			String name = autoFeatureList.get(i).getName();
			oldFeatureNames.add(name);
			features.get(i).setValue(name);
		}
		for(int i=autoFeatureList.size(); i<charFeatures.size(); i++) {
			String name = charFeatures.get(i).getName();
			oldFeatureNames.add(name);
			features.get(i).setValue(name);
			//featureDescrs.get(i).setText(charFeatures.get(i).getDescription());
			//TODO: test to see if descr gets updated; if not, implement above line
		}
		//Age
		age.setText(character.getAge());
		//Height
		height.setText(character.getHeight());
		//Weight
		weight.setText(character.getWeight());
		//Eyes
		eyes.setText(character.getEyes());
		//Skin
		skin.setText(character.getSkin());
		//Hair
		hair.setText(character.getHair());
		//Symbol
		symbol.setText(character.getSymbolName());
		//Languages and Other Proficiencies
		lang.setText(character.getOtherProfs());
		//Equipment
		equip.setText(character.getEquipment());
		//Personality
		pers.setText(character.getPersonality());
		//Ideals
		ideals.setText(character.getIdeals());
		//Bonds
		bonds.setText(character.getBonds());
		//Flaws
		flaws.setText(character.getFlaws());
		//Allies and Organizations
		allies.setText(character.getAlliesOrganizations());
		//Other Equipment
		otherEquip.setText(character.getMoreEquipment());
		//Backstory
		backstory.setText(character.getBackstory());
		//Appearance
		charImage = character.getAppearance();
		if(charImage!=null) {
			symbolView.setImage(new Image(symbolImage.toURI().toString()));
		}
		//Symbol Image
		symbolImage = character.getSymbol();
		if(symbolImage!=null) {
			symbolView.setImage(new Image(symbolImage.toURI().toString()));
		}
		//Spells
		boolean isSpellcaster = character.getCharClass().isSpellCaster();
		if(isSpellcaster) {
			spellClass.setText(character.getCharClass().getName());
			spellAbility.setText(character.getSpellcastingAbility());
			spellSav.setText(Integer.toString(character.getSpellSaveDC()));
			spellBonus.setText(Integer.toString(character.getSpellAttackBonus()));
		} else {
			spellClass.setText("");
			spellAbility.setText("");
			spellSav.setText("");
			spellBonus.setText("");
		}
		currentSpells = character.getSpells();
		int[] spellCounters = {0,0,0,0,0,0,0,0,0,0};
		for(Spell nextSpell : currentSpells) {
			int spellLevel = nextSpell.getLevel();
			spells.get(spellLevel).get(spellCounters[spellLevel]).setValue(nextSpell.getName());
			spellCounters[spellLevel]++;
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
			this.setBackground(new javafx.scene.layout.Background(new BackgroundFill(Color.LIGHTGREY,null,null)));
		}
	}
	
	
}
