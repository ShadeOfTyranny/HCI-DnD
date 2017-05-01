package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class AgeListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField age;
	
	public AgeListener(Character character,TextField age) {
		this.character = character;
		this.age = age;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setAge(age.getText());
		}
	}

}
