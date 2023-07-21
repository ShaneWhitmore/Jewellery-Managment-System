package com.example.jewellerystore;


import com.example.jewellerystore.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TrayPageController implements Initializable
{
    @FXML
    private Button AddTrayButton;

    @FXML
    private Button BackButton;

    @FXML
    private ChoiceBox<DisplayCase> CaseIDDropDown;

    @FXML
    private TextField DepthInput;

    @FXML
    private ListView<String> DisplayTrayView;

    @FXML
    private ChoiceBox<String> InlayDropDown;

    @FXML
    private TextField TrayIDInput;

    @FXML
    private TextField WidthInput;

    public static DisplayTray firstItem;


    public void showCaseID(DisplayCase displayCase) //getting linked list of cases for dropdown
    {
        CaseIDDropDown.getItems().clear(); //this clears the lists already displayed

        while(displayCase != null) //while the linked list of displaycases is not equal to null ...
        {
            //cases += DisplayCase.getDisplayCase(i); //add the current display case to the local variable ...
            CaseIDDropDown.getItems().add(displayCase); //add a display case to the dropdown ..

            displayCase = displayCase.nextCase; // then move over to the next displaycase and go again
        }
    }

    public void addDisplayTray(int trayID, String inlay , double width, double depth)
    {
        DisplayCase chosenDisplay = CaseIDDropDown.getSelectionModel().getSelectedItem(); //local variable of chosen displayCase from dropdown

        DisplayTray dt = new DisplayTray(chosenDisplay,trayID,inlay,width,depth); //creating new DisplayTray
        dt.setTrayID(trayID); //setting an ID for the new display tray
        dt.setInlay(inlay); //setting the tray inlay
        dt.setWidth(width);//setting tray width dimensions
        dt.setDepth(depth); //setting tray depth dimensions
        dt.setNextTray(chosenDisplay.firstTray); //set this new tray as the 'firsttray' in the chain
        chosenDisplay.firstTray = dt; //make this new tray the first tray in this case (creates first in last out situation)
        DisplayTrayView(chosenDisplay); //update the display tray view with respect to the selected DisplayCase ID from the dropdown
    }

    public void setTrayDepth(ActionEvent actionEvent) //not required as we can use the fx:id in the 'addTrayButton' method
    {
    }

    public void setTrayID(ActionEvent actionEvent) //input for tray id
    {
        // can leave empty, just call the input into the add button, leave these for validations rules eg(int only etc)
    }

    public void setTrayWidth(ActionEvent actionEvent)
    {
        // can leave empty, just call the input into the add button, leave these for validations rules eg(int only etc)
    }

    public void InlayDropDown()
    {
        ObservableList<String> colours = FXCollections.observableArrayList("Ultra Green", "Royal Blue" , "Graphite Black", "Midnight Purple", "Sunlight Red");
        InlayDropDown.setItems(colours);

        //setting information for the 'InlayDropDown' method
    }

    public void addDisplayTray()
    {
        int tId = Integer.parseInt(TrayIDInput.getText()); //creating local variable 'tId' which uses the TrayIDInput input
        String inlay = InlayDropDown.getSelectionModel().getSelectedItem(); //creating local variable 'inlay' which uses the 'InlayDropDown' input
        double width = Integer.parseInt(WidthInput.getText()); //creating local variable 'width' which uses the 'WidthInput'
        double depth = Integer.parseInt(DepthInput.getText()); //creating local variable 'width' which uses the 'DepthInput'
       // String CaseID = CaseIDDropDown.getSelectionModel().getSelectedItem(); //creating local variable 'CaseID' for CaseIDDropDown

        addDisplayTray(tId,inlay, width,depth); //drop all the variables into the linked list method
    }

    public void addDisplayTray(ActionEvent actionEvent) //Button to adding tray to linked list
    {
        addDisplayTray(Integer.parseInt(TrayIDInput.getText()), InlayDropDown.getValue(),Integer.parseInt(WidthInput.getText()),Integer.parseInt(DepthInput.getText()));
        //take all the local variables and put them into the 'addDisplayTray' method (seen above)
    }

    public void DisplayTrayView(DisplayCase displayCase)
    {
        DisplayTrayView.getItems().clear(); //clear any existing displayTrays from the view

        DisplayTray temp = displayCase.firstTray; //creating local variable 'temp' which runs off of displayCase.firstTray
        while( temp!= null) //while the linked list of displayTray is not equal to null ...
        {
            DisplayTrayView.getItems().add(temp.toFullString()); //add that item to the DisplayTrayView and ...

            temp = temp.nextTray;// move over to the next displayTray in that same displayCase and go again until it equals null
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        InlayDropDown(); //run the InlayDropDown() method when the user opens the scene to get all the inlays options to display
        showCaseID(MainPageApplication.firstCase); //run the showCaseID() method to get all of the display case id to display
    }

    public void ReturnToStart(ActionEvent actionEvent) //return to the starting page from the addDisplayTray page
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("jewelleryStoreManagmentSystemMainPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // stage.getIcons().add(new Image("Image/Diamond.png"));   ##SETTING AN ICON FOR THE STAGE
        Stage stage = new Stage();
        stage.setTitle("Whitmore Jewellers");
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }



    public void listViewClicked() //useless method (was intended for something else but was scrapped)
    {

    }

}