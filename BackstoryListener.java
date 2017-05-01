package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class BackstoryListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea backstory;
	
	public BackstoryListener(Character character,TextArea backstory) {
		this.character = character;
		this.backstory = backstory;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setBackstory(backstory.getText());
		}
	}

}
