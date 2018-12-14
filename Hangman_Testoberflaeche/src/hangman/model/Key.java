package hangman.model;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import hangman.MainApp;
import hangman.util.Alphabet;
import hangman.view.WordspaceController;

public class Key extends Button {

	char identity;
	
	public Key() {

		super();

	}

	public Key(char letter) {

		super();
		this.identity = letter;
		String s = Character.toString(letter);
			
		this.setText(s);
		this.setPrefWidth(35);
		this.setId(s);

		
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				setKeyDisable(identity);
			};
		});
		
	}

public void setKeyDisable(char letter) {
		
		setDisable(true);
		MainApp.controller1.testNewLetter(letter);
		
	}

	public char getIdentity() {
		return identity;
	}

	public void setIdentity(char identity) {
		this.identity = identity;
	}
	
}