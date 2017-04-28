package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import model.CharClass;
import model.Character;

public class ClassListener implements ChangeListener<Boolean> {

	private Character character;
	private int index;
	
	public ClassListener(Character character, int index) {
		this.character = character;
		this.index = index;
	}
	
	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setCharClass(new CharClass(index));
		}
	}
	
	
	
}
