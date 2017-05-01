package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import model.Character;

public class AlignmentListener implements ChangeListener<Boolean> {

	private Character character;
	private ComboBox<String> alignment;
	
	public AlignmentListener(Character character, ComboBox<String> alignment) {
		this.character = character;
		this.alignment = alignment;
	}
	
	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setAlignment(alignment.getValue());
		}
	}
	
	
	
}