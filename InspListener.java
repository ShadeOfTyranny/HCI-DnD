package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import model.Character;

public class InspListener implements EventHandler<ActionEvent> {

	private Character character;
	private RadioButton insp;
	
	public InspListener(Character character,RadioButton insp) {
		this.character = character;
		this.insp = insp;
	}

	@Override
	public void handle(ActionEvent event) {
		character.setInspired(insp.isSelected());
	}

}
