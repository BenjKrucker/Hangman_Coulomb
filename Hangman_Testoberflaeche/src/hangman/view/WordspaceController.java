package hangman.view;



import hangman.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class WordspaceController {
	 
	//char keyChoice;
	
	//Key key = new Key();
 
    @FXML
    private Label guessWord;
    
    @FXML
    private TextField wordInput;
    
	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp; 

	}
    public WordspaceController() {
    }
    
    // initialize
    @FXML
    private void initialize() {
    	setWord();
    }
    
    // set word
    
    public void setWord() {
    	//keyChoice = key.getIdentity();
    	 guessWord.setText(testInput());
    	 
    } 
    
    private String testInput() {
    	
    	// include value from word library here
    	
    	String input = "Beispiel";
    	input = input.toUpperCase();
    	
    	// convert word into char with spaces between letters
    	char letters[] = new char[input.length()];
    	 letters = input.toCharArray();
    	 char lettersWithSpace[] = new char[2*input.length()];
     	for(int i = 0; i<2*input.length() ; i=i+2) {
    		lettersWithSpace[i] = letters[i/2];
    		lettersWithSpace[i+1] = ' ';
    	}
    	 
     	//create empty char which looks like this: _ _ _ _ _ _
    	char guess[] = new char[2*input.length()];
    	for(int i = 0; i<2*input.length() ; i=i+2) {
    		guess[i] = '_';
    		guess[i+1] = ' ';
    	}
    	
    	//include selected letter here from keyboard
    	
    	//-> only upperCase letters
    	//char letterChoice = key; 
    	char letterChoice = 'B'; 
    	
    	
    	
    	//compare letters with selected letter
    	for(int j = 0; j<2*input.length() ; j=j+2) {
    		if (lettersWithSpace[j] == letterChoice) {
    			guess[j] = letterChoice;
    		}
    	}
    	
    	// return adapted char as string value
    	String output =  new String(guess);
    	return output;
    	
    	//return "Gulasch";
    }
	public static void testNewLetter(char letter) {
		
		/*du bekommst hier den Buchstaben und sollst das label aktualisiere
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
	}
    
    
	
} 
