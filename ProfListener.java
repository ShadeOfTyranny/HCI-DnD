package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class ProfListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField prof;
	
	public ProfListener(Character character,TextField prof) {
		this.character = character;
		this.prof = prof;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setProfBonus(Integer.parseInt(prof.getText()));
		}
	}

}
