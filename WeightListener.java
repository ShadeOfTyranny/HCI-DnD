package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class WeightListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField weight;
	
	public WeightListener(Character character,TextField weight) {
		this.character = character;
		this.weight = weight;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setWeight(weight.getText());
		}
	}

}
