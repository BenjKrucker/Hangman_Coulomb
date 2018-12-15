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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WordspaceController {

	static String word = "Beispiel";
	static ArrayList<String> input = new ArrayList<String>();
	static ArrayList<String> guess = new ArrayList<String>();

	@FXML
	public Label guessWord;
	
	@FXML
	public TextField wordToGuess;
	
	@FXML
	public void onEnter() {
		word = wordToGuess.getText();
		convertInput();
		guessWord.setText(createEmptyWord());
		wordToGuess.clear();
		wordToGuess.setText("Gesuchtes Wort");
		wordToGuess.setDisable(true);
		
	}

	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp;

	}

	public WordspaceController() {
	}

	// initialize
	@FXML
	private void initialize() {
		wordToGuess.setPromptText("Optionale Worteingabe");
		guessWord.setText("Give a word to guess!");
		MainApp.maennli.updateMaennli(0);
	}

	// set word

	
	/*public void setWordUpdate(String wordUpdate){
		guessWord.setText(wordUpdate);
	}*/

	private void convertInput() {

		// convert word into char with spaces between letters
		for (int n = 0; n < 2 * word.length(); n = n + 2) {
			input.add(n, word.substring(n / 2, (n / 2) + 1));
			input.add(n + 1, " ");
		}
		input.replaceAll(String::toUpperCase);

	}

	public  String createEmptyWord() {
		
		// create empty char which looks like this: _ _ _ _ _ _
		for (int i = 0; i < 2 * word.length(); i = i + 2) {
			guess.add(i, "_");
			guess.add(i + 1, " ");
		}
		// String output = new String(guess);

		String output = String.join("", guess);
		return output;
	}
	int counter=0;

	public void testNewLetter(char letter) {
		
		int countTest=0;
		

		String letterChoice = Character.toString(letter);


		// compare letters with selected letter
		for (int j = 0; j < 2 * word.length(); j = j + 2) {
			if (input.get(j).equals(letterChoice)) {
				guess.set(j, letterChoice);
				countTest=1;
			}
		}
		if(countTest==0){
			counter++;
			}
		
		
		//bring counter to picture

		// return adapted char as string value
		String outcome = String.join("", guess);
		guessWord.setText(outcome);
		
		MainApp.maennli.updateMaennli(counter); //counter einfügen
	}

	public static void resetArraylists() {
		input.clear();
		guess.clear();
	}
	
	
	

}

