package hangman.view;

import hangman.MainApp;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class MaennliController {

	private MainApp mainApp;

	
	// declares body parts for maennli

	@FXML
	private Arc boden;
	@FXML
	private Line pfoste1;
	@FXML
	private Line pfoste2;
	@FXML
	private Line pfoste3;
	@FXML
	private Line pfoste4;

	@FXML
	private Circle kopf;
	@FXML
	private Line koerper;
	@FXML
	private Line armR;
	@FXML
	private Line armL;
	@FXML
	private Line beiR;
	@FXML
	private Line beiL;

	@FXML
	private Line augL1;
	@FXML
	private Line augL2;
	@FXML
	private Line augR1;
	@FXML
	private Line augR2;
	@FXML
	private Line muul;

	public void setMainApp(MainApp mainApp) {

		this.mainApp = mainApp;
		
	}

	public void updateMaennli(int stage) {

		hideMaennli();					//vrsteckt alles
		
		for(int i=1;i<=stage; i++) { 	//ratteret jedes körperteili duure und machts sichtbar
			activateMaennliPart(i);
		}
		

	}
	
	public void activateMaennliPart(int stage) {
		
		switch (stage) {
		case 1:
			boden.setVisible(true);
			break;

		case 2:
			pfoste1.setVisible(true);
			break;

		case 3:
			pfoste2.setVisible(true);
			break;
		
		case 4:
			pfoste3.setVisible(true);
			break;		
		
		case 5:	
			pfoste4.setVisible(true);
			break;	
		
		case 6:	
			kopf.setVisible(true);
			break;	
		
		case 7:	
			koerper.setVisible(true);
			break;
		
		case 8:	
			armR.setVisible(true);
			break;	
		
		case 9:	
			armL.setVisible(true);
			break;
		
		case 10:	
			beiR.setVisible(true);
			break;
			
		case 11:	
			beiL.setVisible(true);
			muul.setVisible(true);
			augL1.setVisible(true);
			augL2.setVisible(true);
			augR1.setVisible(true);
			augR2.setVisible(true);
			break;
		

			
		default:
			break;
		}

		
	}

	public void hideMaennli() {
		boden.setVisible(false);
		pfoste1.setVisible(false);
		pfoste2.setVisible(false);
		pfoste3.setVisible(false);
		pfoste4.setVisible(false);
		kopf.setVisible(false);
		koerper.setVisible(false);
		armR.setVisible(false);
		armL.setVisible(false);
		beiR.setVisible(false);
		beiL.setVisible(false);
		augL1.setVisible(false);
		augL2.setVisible(false);
		augR1.setVisible(false);
		augR2.setVisible(false);
		muul.setVisible(false);
	}

}