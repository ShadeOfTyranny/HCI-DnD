package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class SpdListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField spd;
	
	public SpdListener(Character character,TextField spd) {
		this.character = character;
		this.spd = spd;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setCustomSpeed(Integer.parseInt(spd.getText()));
		}
	}


}
