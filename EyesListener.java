package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class EyesListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField eyes;
	
	public EyesListener(Character character,TextField eyes) {
		this.character = character;
		this.eyes = eyes;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setEyes(eyes.getText());
		}
	}

}
