package hangman.view;


import hangman.MainApp;
import hangman.model.Key;
import hangman.util.Alphabet;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;


public class KeyboardController {

	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp; 

	}

	@FXML

	public void keyPressed(KeyEvent key){

		if(key.getCode().isLetterKey()) {

			String x = key.getCode().toString();

			char letter = x.charAt(0);

			Key.setKeyDisable(Alphabet.getNummber(letter));
			//Alphabet d = new Alphabet();
			//Key c = new Key();
			//c.setKeyDisable(d.getNummber(letter));
		}

	}



}