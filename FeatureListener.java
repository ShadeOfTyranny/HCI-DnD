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
	private ComboBox<String> name;
	private TextField descr;
	private ArrayList<String> oldValues;
	private int index;
	
	public FeatureListener(Character character, ComboBox<String> name, TextField descr, ArrayList<String> oldValues, int index) {
		this.character = character;
		this.name = name;
		this.descr = descr;
		this.oldValues = oldValues;
		this.index = index;
	}

	@Override
	public void handle(MouseEvent event) {
		//FUTURE: Check race/class/background, give user a warning dialog to confirm deleting from race/class/background
		character.removeFeature(oldValues.get(index));
		character.addFeature(new Feature(name.getValue(),descr.getText()));
	}
	
	
}
