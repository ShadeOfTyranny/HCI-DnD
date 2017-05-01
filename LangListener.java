package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import model.Character;

public class LangListener implements ChangeListener<Boolean> {

	private Character character;
	private TextArea lang;
	
	public LangListener(Character character,TextArea lang) {
		this.character = character;
		this.lang = lang;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setOtherProfs(lang.getText());
		}
	}
}
