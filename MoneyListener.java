package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import model.Character;

public class MoneyListener implements ChangeListener<Boolean> {

	private Character character;
	private TextField money;
	private int moneyType;
	
	public MoneyListener(Character character,TextField money,int moneyType) {
		this.character = character;
		this.money = money;
		this.moneyType = moneyType;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if(oldValue) {
			character.setMoney(Integer.parseInt(money.getText()), moneyType);
		}
	}

}
