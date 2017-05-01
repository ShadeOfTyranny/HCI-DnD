package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class TempHPListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField tempHP;
	
	public TempHPListener(Character character,TextField tempHP) {
		this.character = character;
		this.tempHP = tempHP;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setTempHP(Integer.parseInt(tempHP.getText()));
		}
	}

}
