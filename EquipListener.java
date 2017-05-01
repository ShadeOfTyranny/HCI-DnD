package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class EquipListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea equip;
	
	public EquipListener(Character character,TextArea equip) {
		this.character = character;
		this.equip = equip;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setEquipment(equip.getText());
		}
	}

}
