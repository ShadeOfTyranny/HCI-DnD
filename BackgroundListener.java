package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import model.Background;
import model.Character;

public class BackgroundListener implements ChangeListener<Boolean> {

	private Character character;
	private int index;
	
	public BackgroundListener(Character character, int index) {
		this.character = character;
		this.index = index;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		character.setBackground(new Background(index));
	}

}
