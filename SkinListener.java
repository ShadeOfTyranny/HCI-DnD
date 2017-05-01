package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class SkinListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField skin;
	
	public SkinListener(Character character,TextField skin) {
		this.character = character;
		this.skin = skin;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setSkin(skin.getText());
		}
	}

}
