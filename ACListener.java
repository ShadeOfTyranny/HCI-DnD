package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class ACListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField ac;
	
	public ACListener(Character character,TextField ac) {
		this.character = character;
		this.ac = ac;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setCustomArmorClass(Integer.parseInt(ac.getText()));
		}
	}

}
