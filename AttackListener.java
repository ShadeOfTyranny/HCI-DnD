package controller;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Attack;
import model.Character;

public class AttackListener implements EventHandler<MouseEvent> {

	private Character character;
	private ArrayList<ComboBox<String>> atkNames;
	private ArrayList<ArrayList<TextField>> atkValues;
	
	public AttackListener(Character character, ArrayList<ComboBox<String>> atkNames, ArrayList<ArrayList<TextField>> atkValues) {
		this.character = character;
		this.atkNames = atkNames;
		this.atkValues = atkValues;
	}

	@Override
	public void handle(MouseEvent event) {
		character.removeAttacks(); //remove all attacks from Character, then re-add list
		for(int i=0; i<atkNames.size(); i++) {
			ComboBox<String> attack = atkNames.get(i);
			boolean valid = true;
			String atkName = attack.getValue();
			if(atkName == null || atkName.trim()=="") { valid = false; }
			ArrayList<TextField> values = atkValues.get(i);
			for(int j=0; j<3; j++) {
				TextField v = values.get(j);
				if(v.getText().trim()=="" ) {
					valid = false;
					break;
				}
			}
			if(valid) {
				character.addAttack(new Attack(Integer.parseInt(values.get(0).getText()),Integer.parseInt(values.get(1).getText()),
						values.get(2).getText(),atkName,values.get(3).getText()));
			}
		}		
	}

}
