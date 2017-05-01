package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class AlliesListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea allies;
	
	public AlliesListener(Character character,TextArea allies) {
		this.character = character;
		this.allies = allies;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setAlliesOrganizations(allies.getText());
		}
	}

}
