package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class HeightListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField height;
	
	public HeightListener(Character character,TextField height) {
		this.character = character;
		this.height = height;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setHeight(height.getText());
		}
	}

}
