package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import model.Character;

public class StatListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField stat;
	private int statType;
	
	public StatListener(Character character,TextField stat,int statType) {
		this.character = character;
		this.stat = stat;
		this.statType = statType;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setStat(statType,Integer.parseInt(stat.getText()));
		}
	}

}
