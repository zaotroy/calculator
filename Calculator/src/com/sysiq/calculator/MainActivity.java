package com.sysiq.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText edit = null;

	private Double firstArgument = 0.0;

	private Double secondArgument = 0.0;

	private Boolean isEnteredFirstArgument = false;

	private String tempString = "";

	private Operation operation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit = (EditText) findViewById(R.id.edit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onClickButtonOne(View view) {
		processString("1");
	}

	public void onClickButtonTwo(View view) {
		processString("2");
	}

	public void onClickButtonThree(View view) {
		processString("3");
	}

	public void onClickButtonFour(View view) {
		processString("4");
	}

	public void onClickButtonFive(View view) {
		processString("5");
	}

	public void onClickButtonSix(View view) {
		processString("6");
	}

	public void onClickButtonSeven(View view) {
		processString("7");
	}

	public void onClickButtonEight(View view) {
		processString("8");
	}

	public void onClickButtonNine(View view) {
		processString("9");
	}

	public void onClickButtonZero(View view) {
		processString("0");
	}

	public void onClickButtonPoint(View view) {
		if (!"".equals(tempString) && !tempString.contains(".")) {
			tempString = tempString + ".";
			edit.setText(tempString);
		}
	}

	public void onClickButtonPlus(View view) {
		processOperation(Operation.PLUS);
	}

	public void onClickButtonMinus(View view) {
		processOperation(Operation.MINUS);
	}

	public void onClickButtonDevide(View view) {
		processOperation(Operation.DEVIDE);
	}

	public void onClickButtonMultiply(View view) {
		processOperation(Operation.MULTIPLY);
	}

	public void onClickButtonResult(View view) {
		try {
			if (!tempString.equals("") && true == isEnteredFirstArgument) {
				secondArgument = Double.parseDouble(tempString);
				tempString = "";
				switch (operation) {
				case PLUS:
					firstArgument = firstArgument + secondArgument;
					break;
				case MINUS:
					firstArgument = firstArgument - secondArgument;
					break;
				case DEVIDE:
					firstArgument = firstArgument / secondArgument;
					break;
				case MULTIPLY:
					firstArgument = firstArgument * secondArgument;
					break;
				}
				tempString = firstArgument.toString();
				edit.setText(tempString);
			}
		} catch (Exception ex) {
			isEnteredFirstArgument = false;
			tempString = "Error during calculation";
			edit.setText(tempString);
		}
	}

	public void onClickButtonClear(View view) {
		resetCalculator();
	}

	private void processString(String arg) {
		tempString = tempString + arg;
		edit.setText(tempString);
	}

	private void processOperation(Operation operation) {
		if (false == isEnteredFirstArgument) {
			firstArgument = Double.parseDouble(tempString);
			isEnteredFirstArgument = true;
		}
		this.operation = operation;
		tempString = "";
		edit.setText(tempString);
	}

	private void resetCalculator() {
		isEnteredFirstArgument = false;
		tempString = "";
		edit.setText(tempString);
	}

}
