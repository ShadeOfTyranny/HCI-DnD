package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import model.Character;
import model.Spell;

public class SpellListener implements EventHandler<MouseEvent> {

	private Character character;
	private ArrayList<ArrayList<ComboBox<String>>> spells;
	
	public SpellListener(Character character, ArrayList<ArrayList<ComboBox<String>>> spells) {
		this.character = character;
		this.spells = spells;
	}

	@Override
	public void handle(MouseEvent event) {
		character.removeSpells();
		int spellSize = spells.size();
		for(int i=0; i<spellSize; i++) {
			int levelSize = spells.get(i).size();
			for(int j=0; j<levelSize; j++) {
				character.addSpell(new Spell(spells.get(i).get(j).getValue()));
			}
		}
	}

}