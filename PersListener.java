package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class PersListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea pers;
	
	public PersListener(Character character,TextArea pers) {
		this.character = character;
		this.pers = pers;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setPersonality(pers.getText());
		}
	}

}
