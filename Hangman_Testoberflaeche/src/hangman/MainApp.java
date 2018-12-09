package hangman;

import java.io.IOException;

import java.util.ArrayList;
import hangman.model.Key;
import hangman.util.Alphabet;
import hangman.view.KeyboardController;
import hangman.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class MainApp extends Application {

	

	public static ArrayList<Key> button  = new ArrayList<Key>();

	private Stage primaryStage;

	private BorderPane rootLayout;

	private GridPane keyboard;



	@Override

	public void start(Stage primaryStage) throws Exception {



		this.primaryStage = primaryStage;

		this.primaryStage.setTitle("Hangman");

		

		//this.primaryStage.getIcons().add(new Image("file:resources/images/hangman.png"));

		

		initRootLayout();

		

		//Set the Hangman, Keybard and Wordspace.

		showKeyboard();

		showButton();

		//ShowHangman();

		//ShowWordspace();

	}

	

    /**

     * Initializes the root layout.

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

	

	public void showButton(){

		

		int z = 0;

		

		 for(int j = 0; j < 4; j++){

			 for(int i = 0; i < 7; i++){
		
			z = i+j*7;

			button.add(z,new Key());			
			
			System.out.println(button.size());
			// Set Keyboard view into the bottom of root layout.

           if(z>0 && z<27) {

        	   button.set(z,new Key(Alphabet.getLetter(z-1)));

			keyboard.add(button.get(z),i, j);

           }

            // Give the controller access to the main app.

			}



			}

		

		}

	



	/**

     * Returns the main stage.

     * @return

     */

    public Stage getPrimaryStage() {

        return primaryStage;

    }



    public static void main(String[] args) {

        launch(args);

    }







}