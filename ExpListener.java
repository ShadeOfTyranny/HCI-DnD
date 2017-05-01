package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class ExpListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField exp;
	
	public ExpListener(Character character, TextField exp) {
		this.character = character;
		this.exp = exp;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setExperience(Integer.parseInt(exp.getText()));
		}
	}

}