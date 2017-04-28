package controller;

import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Armor;
import model.Character;

public class ArmorListener implements EventHandler<MouseEvent> {

	private Character character;
	private String name;
	private String ac;
	private String sr;
	private String type;
	private String prop;
	
	
	public ArmorListener(Character character, ComboBox<String> name, TextField ac, TextField sr, TextField type, TextField prop) {
		this.character = character;
		this.name = name.getValue();
		this.ac = ac.getText();
		this.sr = sr.getText();
		this.type = type.getText();
		this.prop = prop.getText();
	}


	@Override
	public void handle(MouseEvent event) {
		boolean valid = true;
		if(name==null || name.trim()=="") { valid=false; }
		if(ac.trim()=="" || sr.trim()=="" || type.trim()=="") { valid=false; }
		if(valid) {
			System.out.println("Went through");
			character.setArmor(new Armor(Integer.parseInt(ac),Integer.parseInt(sr),type,prop,name));
		}
		
	}

	
	
}
