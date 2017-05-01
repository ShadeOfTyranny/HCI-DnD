package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class HairListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField hair;
	
	public HairListener(Character character,TextField hair) {
		this.character = character;
		this.hair = hair;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setHair(hair.getText());
		}
	}
}
