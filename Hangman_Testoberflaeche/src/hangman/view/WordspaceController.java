package hangman.view;

import java.util.ArrayList;
import java.util.Arrays;

import hangman.MainApp;
import hangman.view.KeyboardController;
import hangman.model.Key;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class WordspaceController {

	static String word = "Beispiel";
	static ArrayList<String> input = new ArrayList<String>();
	static ArrayList<String> guess = new ArrayList<String>();

	@FXML
	public Label guessWord;

	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp;

	}

	public WordspaceController() {
	}

	// initialize
	@FXML
	private void initialize() {
		convertInput();
		setWordUpdate(createEmptyWord());
	}

	// set word

	
	public void setWordUpdate(String wordUpdate){
		guessWord.setText(wordUpdate);
	}

	private void convertInput() {

		// include value from word library here
		// word = " --------- "

		// convert word into char with spaces between letters
		for (int n = 0; n < 2 * word.length(); n = n + 2) {
			input.add(n, word.substring(n / 2, (n / 2) + 1));
			input.add(n + 1, " ");
		}
		input.replaceAll(String::toUpperCase);
		//String out = String.join("", input);
		//System.out.println(out);

		// String output = "Gulasch";

		// return output;
	}

	public  String createEmptyWord() {

		// String qiu = "gulasch";
		// create empty char which looks like this: _ _ _ _ _ _
		for (int i = 0; i < 2 * word.length(); i = i + 2) {
			guess.add(i, "_");
			guess.add(i + 1, " ");
		}
		// String output = new String(guess);

		String output = String.join("", guess);
		System.out.println(output);
		return output;
	}

	public static void testNewLetter(char letter) {
		// char letterChoice = key;
		String letterChoice = Character.toString(letter);
		// String letterChoice = String.valueOf(letter);

		// compare letters with selected letter
		for (int j = 0; j < 2 * word.length(); j = j + 2) {
			if (input.get(j).equals(letterChoice)) {
				guess.set(j, letterChoice);
			}
		}

		// return adapted char as string value
		 //String outcome = Arrays.toString(guess.toArray());
		String outcome = String.join("", guess);
		System.out.println(outcome);
		//setWordUpdate(outcome);
		//guessWord.setText(outcome);
		
	}

}
