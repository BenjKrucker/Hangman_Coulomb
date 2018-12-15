package hangman.view;

import hangman.MainApp;

public class RootLayoutController {
	
    // Reference to the main application
    private MainApp mainApp;
        /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void handleNewGame() {
    	mainApp.resetGame();
    }

    public void handleClose() {
        System.exit(0);
    }
}
