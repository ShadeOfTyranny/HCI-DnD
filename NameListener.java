package controller;

import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import model.Character;

public class NameListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField name;
	
	public NameListener(Character character, TextField name) {
		this.character = character;
		this.name = name;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setName(name.getText());
		}
	}

}