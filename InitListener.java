package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class InitListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField init;
	
	public InitListener(Character character,TextField init) {
		this.character = character;
		this.init = init;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setInit(Integer.parseInt(init.getText()));
		}
	}

}
