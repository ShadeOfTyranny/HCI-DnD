package controller;

import java.awt.TextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import model.Character;

public class NameListener implements ChangeListener<Boolean> {

	private Character character;
	private String name;
	
	public NameListener(Character character, TextField name) {
		this.character = character;
		this.name = name.getText();
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setName(name);
		}
	}

}
