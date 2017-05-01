package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class OtherEquipListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea otherEquip;
	
	public OtherEquipListener(Character character,TextArea otherEquip) {
		this.character = character;
		this.otherEquip = otherEquip;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setMoreEquipment(otherEquip.getText());
		}
	}
	
	

}
