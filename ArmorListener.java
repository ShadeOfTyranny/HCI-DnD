package controller;

import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Armor;
import model.Character;

public class ArmorListener implements EventHandler<MouseEvent> {

	private Character character;
	private ComboBox<String> armorName;
	private TextField armorAc;
	private TextField armorSr;
	private TextField armorType;
	private TextField armorProp;
	
	
	public ArmorListener(Character character, ComboBox<String> name, TextField ac, TextField sr, TextField type, TextField prop) {
		this.character = character;
		this.armorName = name;
		this.armorAc = ac;
		this.armorSr = sr;
		this.armorType = type;
		this.armorProp = prop;
	}


	@Override
	public void handle(MouseEvent event) {
		boolean valid = true;
		String name = armorName.getValue();
		String ac = armorAc.getText();
		String sr = armorSr.getText();
		String type = armorType.getText();
		String prop = armorProp.getText();
		if(name==null || name.trim()=="") { valid=false; }
		if(ac.trim()=="" || sr.trim()=="" || type.trim()=="") { valid=false; }
		if(valid) {
			character.setArmor(new Armor(Integer.parseInt(ac),Integer.parseInt(sr),type,prop,name));
		}
		
	}

	
	
}
