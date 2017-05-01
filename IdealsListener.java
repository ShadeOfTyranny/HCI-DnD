package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class IdealsListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea ideals;
	
	public IdealsListener(Character character,TextArea ideals) {
		this.character = character;
		this.ideals = ideals;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setIdeals(ideals.getText());
		}
	}

}
