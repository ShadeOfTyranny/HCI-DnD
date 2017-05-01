package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import model.Character;

public class SkillListener implements EventHandler<ActionEvent> {

	private Character character;
	private RadioButton skill;
	private int skillType;
	
	public SkillListener(Character character,RadioButton skill, int skillType) {
		this.character = character;
		this.skill = skill;
		this.skillType = skillType;
	}

	@Override
	public void handle(ActionEvent event) {
		character.setSkillProf(skillType,skill.isSelected());
	}



}
