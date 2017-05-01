package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import model.Character;

public class StatProfListener implements EventHandler<ActionEvent> {

	private Character character;
	private RadioButton stat;
	private int statType;
	
	public StatProfListener(Character character,RadioButton stat, int statType) {
		this.character = character;
		this.stat = stat;
		this.statType = statType;
	}

	@Override
	public void handle(ActionEvent event) {
		character.setStatProf(statType,stat.isSelected());
	}

}
