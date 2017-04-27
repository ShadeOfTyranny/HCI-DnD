package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Character;
import model.Feature;

public class FeatureListener implements EventHandler<MouseEvent> {

	private Character character;
	private String name;
	private String descr;
	private String oldValue;
	
	public FeatureListener(Character character, String name, String descr, String oldValue) {
		this.character = character;
		this.name = name;
		this.descr = descr;
		this.oldValue = oldValue;
	}

	@Override
	public void handle(MouseEvent event) {
		//FUTURE: Check race/class/background, give user a warning dialog to confirm deleting from race/class/background
		character.removeFeature(oldValue);
		character.addFeature(new Feature(name,descr));
	}
	
	
}
