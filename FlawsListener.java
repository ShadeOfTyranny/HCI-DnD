package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class FlawsListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea flaws;
	
	public FlawsListener(Character character,TextArea flaws) {
		this.character = character;
		this.flaws = flaws;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setFlaws(flaws.getText());
		}
	}

}
