package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class CurrentHPListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField currentHP;
	
	public CurrentHPListener(Character character,TextField currentHP) {
		this.character = character;
		this.currentHP = currentHP;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setCurrentHP(Integer.parseInt(currentHP.getText()));
		}
	}


}
