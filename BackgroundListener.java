package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import model.Background;
import model.Character;

public class BackgroundListener implements ChangeListener<Boolean> {

	private Character character;
	private int index;
	
	public BackgroundListener(Character character, ComboBox<String> index) {
		this.character = character;
		this.index = index.getSelectionModel().getSelectedIndex();
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setBackground(new Background(index));
		}
	}

}
