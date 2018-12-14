package hangman.view;


import hangman.MainApp;
import hangman.util.Alphabet;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;


public class KeyboardController {

	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp; 

	}
	
	static char test;

	@FXML

	public void keyPressed(KeyEvent key){

		if(key.getCode().isLetterKey()) {

			String x = key.getCode().toString();

			char letter = x.charAt(0);

			MainApp.button.get(Alphabet.getNummber(letter)).setKeyDisable(Alphabet.getNummber(letter));
			

		}

	}


}