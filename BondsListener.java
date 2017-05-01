package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class BondsListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea bonds;
	
	public BondsListener(Character character,TextArea bonds) {
		this.character = character;
		this.bonds = bonds;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setBonds(bonds.getText());
		}
	}

}
