package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import model.Character;

public class ExpListener implements ChangeListener<Boolean> {

	private Character character;
	private String exp;
	
	public ExpListener(Character character, String exp) {
		this.character = character;
		this.exp = exp;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setExperience(Integer.parseInt(exp));
		}
	}

}
