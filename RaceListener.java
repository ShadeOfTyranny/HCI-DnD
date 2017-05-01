package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import model.Character;
import model.Race;
import model.SubRace;

public class RaceListener implements ChangeListener<Boolean> {

	private Character character;
	private ComboBox<String> race;
	private ComboBox<String> subrace;
	
	public RaceListener(Character character, ComboBox<String> race, ComboBox<String> subrace) {
		this.character = character;
		this.race = race;
		this.subrace = subrace;
	}
	
	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			
			character.setRace(new Race(race.getSelectionModel().getSelectedIndex()));
			if(subrace.getSelectionModel().getSelectedIndex()>0){
				character.getRace().setSubRace(new SubRace(subrace.getSelectionModel().getSelectedIndex()-1));
			}
		}
	}
	
	
	
}