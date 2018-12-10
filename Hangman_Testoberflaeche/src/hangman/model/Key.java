package hangman.model;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import hangman.MainApp;

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
				setDisable(true);
			};
		});
		
	}
	
	public static void setKeyDisable(int i) {
		
		MainApp.button.get(i).setDisable(true);
		
	}
}