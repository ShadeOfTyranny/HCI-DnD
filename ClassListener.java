package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import model.CharClass;
import model.Character;

public class ClassListener implements ChangeListener<Boolean> {

	private Character character;
	private ComboBox<String> charClass;
	
	public ClassListener(Character character, ComboBox<String> charClass) {
		this.character = character;
		this.charClass = charClass;
	}
	
	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setCharClass(new CharClass(charClass.getSelectionModel().getSelectedIndex()));
		}
	}
	
	
	
}
