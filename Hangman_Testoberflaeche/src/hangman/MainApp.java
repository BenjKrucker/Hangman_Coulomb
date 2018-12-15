package hangman;

import java.io.IOException;
import java.util.ArrayList;
import hangman.model.Key;
import hangman.util.Alphabet;
import hangman.view.KeyboardController;
import hangman.view.MaennliController;
import hangman.view.RootLayoutController;
import hangman.view.WordspaceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static ArrayList<Key> button = new ArrayList<Key>();
	private Stage primaryStage;
	private BorderPane rootLayout;

	private GridPane keyboard;	
	private AnchorPane maennliPane;
	private AnchorPane wordSpace;
	public static WordspaceController controller1;
	public static MaennliController maennli;
	
	
	@Override

	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hangman");
		
		// this.primaryStage.getIcons().add(new
		// Image("file:resources/images/hangman.png"));

		initRootLayout();
		
		// Set the Hangman, Keybard and Wordspace.


		showKeyboard();
		showButton();

		
		showMaennli(0);
		
			/*  @Simon - Um Maennli zu malen: 
			 * 
			 * ----------------------------------------------------------------------
			 *
			 *		showMaennli(azahlFähler); 
			 *		
			 *		-> wenn azahlFähler = 0, denn zeigts eifach nüd aa
			 *
			 *		-> im Momänt wird mängiAnFähler im showMaennli() automatisch uf 11 (max)  gsetzt 
			 *			drmit me öbbis gseht...
			 *	----------------------------------------------------------------------
			 *
			 */ 

		 showWordspace();

	}

	/**
	 * 
	 * Initializes the root layout.
	 * 
	 */

	private void initRootLayout() {

		try {

			// Load root layout from fxml file.

			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));

			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.

			Scene scene = new Scene(rootLayout);

			primaryStage.setScene(scene);

			// Give the controller access to the main app.

			RootLayoutController controller = loader.getController();

			controller.setMainApp(this);

			primaryStage.show();
			

		}catch(IOException e) {


			e.printStackTrace();

		}

	}

	public void showKeyboard() {

		try {

			// Load Keyboard view.

			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainApp.class.getResource("view/Keyboard.fxml"));

			keyboard = (GridPane) loader.load();

			// Set Keyboard view into the bottom of root layout.

			rootLayout.setBottom(keyboard);

			KeyboardController controller = loader.getController();

			controller.setMainApp(this);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
		
	public void showMaennli(int stage) {

		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Maennli.fxml"));
			maennliPane = (AnchorPane) loader.load();
			rootLayout.setLeft(maennliPane);

			maennli = loader.getController();
			maennli.setMainApp(this);
			
			//maennliController.updateMaennli(stage);		//Diese Zeile nach Einführung von Zähler löschen!
			

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	public void showWordspace() {
		try {

			// Load Wordspace view.

	
		
			FXMLLoader loader = new FXMLLoader();

			loader.setLocation(MainApp.class.getResource("view/Wordspace.fxml"));

			wordSpace = (AnchorPane) loader.load();
			
			//wordSpace.setPrefSize(50, 50);



			// Set Wordspace view into the bottom of root layout.

			rootLayout.setRight(wordSpace);



			controller1 = loader.getController();
			
		

			controller1.setMainApp(this);



		} catch (IOException e) {

			e.printStackTrace();
			}
		}

	

	public void showButton() {

		// z= gridfield counter
		int z = 0;
		// l=Button Array counter
		int l = 0;
		// Sprungvariable
		int a = 2;

		for (int j = 0; j < 4; j++) {
			if (a == 2) {
				a--;
			} else {
				a++;
			}
			for (int i = 0; i < 7; i++) {

				z = i + j * 7;

				// Create Keys and set it in the keyboard view.

				if (z > 0 && z < 27) {
					button.add(l, new Key(Alphabet.getLetter(l)));
					keyboard.add(button.get(l), 2 * i + a, j);
					l++;
				}

			}

		}

	}

	/**
	 * 
	 * Returns the main stage.
	 * 
	 * @return
	 * 
	 */

	public Stage getPrimaryStage() {

		return primaryStage;

	}
	
	public void resetGame() {
		controller1.resetArraylists();
		showMaennli(0);
		showKeyboard();
		showKeyboard();
		showButton();
		showWordspace();
		
	}

	public static void main(String[] args) {

		launch(args);

	}

}