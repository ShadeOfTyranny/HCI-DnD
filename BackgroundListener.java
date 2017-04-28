package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import model.Background;
import model.Character;

public class BackgroundListener implements ChangeListener<Boolean> {

	private Character character;
	private ComboBox<String> bg;
	
	public BackgroundListener(Character character, ComboBox<String> bg) {
		this.character = character;
		this.bg = bg;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			character.setBackground(new Background(bg.getSelectionModel().getSelectedIndex()));
		}
	}

}
