package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import model.Character;
import model.Race;
import model.SubRace;

public class AlignmentListener implements ChangeListener<Boolean> {

	private Character character;
	private ComboBox<String> alignment;
	
	public AlignmentListener(Character character, ComboBox<String> race, ComboBox<String> alignment) {
		this.character = character;
		this.alignment = alignment;
	}
	
	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) { //if was focused (oldValue is True)
			if(subrace.getSelectionModel().getSelectedIndex()>0){
				character.getRace().setSubRace(new SubRace(subrace.getSelectionModel().getSelectedIndex()-1));
			}
		}
	}
	
	
	
}