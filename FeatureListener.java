package controller;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Character;
import model.Feature;

public class FeatureListener implements EventHandler<MouseEvent> {

	private Character character;
	private String name;
	private String descr;
	private String oldValue;
	
	public FeatureListener(Character character, ComboBox<String> name, TextField descr, ArrayList<String> oldValues, int index) {
		this.character = character;
		this.name = name.getValue();
		this.descr = descr.getText();
		this.oldValue = oldValues.get(index);
	}

	@Override
	public void handle(MouseEvent event) {
		//FUTURE: Check race/class/background, give user a warning dialog to confirm deleting from race/class/background
		character.removeFeature(oldValue);
		character.addFeature(new Feature(name,descr));
	}
	
	
}
