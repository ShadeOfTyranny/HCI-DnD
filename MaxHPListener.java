package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class MaxHPListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField maxHP;
	
	public MaxHPListener(Character character,TextField maxHP) {
		this.character = character;
		this.maxHP = maxHP;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setMaxHP(Integer.parseInt(maxHP.getText()));
		}
	}


}
