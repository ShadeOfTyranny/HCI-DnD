package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class SymbolListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField symbol;
	
	public SymbolListener(Character character,TextField symbol) {
		this.character = character;
		this.symbol = symbol;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setSymbolName(symbol.getText());
		}
	}

}
