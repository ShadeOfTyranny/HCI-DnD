package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import model.Character;

public class NameListener implements ChangeListener<Boolean> {

	private Character character;
	private String name;
	
	public NameListener(Character character, String name) {
		this.character = character;
		this.name = name;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		character.setName(name);
	}

}
