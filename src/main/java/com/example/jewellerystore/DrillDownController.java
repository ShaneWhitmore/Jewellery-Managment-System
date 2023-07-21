package com.example.jewellerystore;

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

public class DrillDownController implements Initializable
{
    @FXML
    private ChoiceBox<DisplayCase> caseIDDropDown;

    @FXML
    private ListView<Item> viewOfDrillDown;

    public void caseIDDropDown(DisplayCase displayCase)
    {
        caseIDDropDown.getItems().clear(); //this clears the lists already displayed

        while(displayCase != null) //while 'displayCase' is not equal to null ...
        {
            caseIDDropDown.getItems().add(displayCase); //add the displayCase to the dropdown ...

            displayCase = displayCase.nextCase; // then move over to the next displayCase and go again
        }
    }

    public void startDrillDown(ActionEvent actionEvent)
    {
        caseIDDropDown(MainPageApplication.firstCase); //calls method above

        DisplayCase d = MainPageApplication.firstCase; //make local variable 'd' of type DisplayCase which represents the firstCase


        while(d != null) //while 'd' is not equal to null ...
        {
            DisplayTray t = d.firstTray; //build the variable 't' of type displayCase which represents the firstTray of 'd' ...
            while(t != null) //while t is not equal to null ...
            {
                Item I = t.firstItem; //build the variable 't' of type Item which represents the firstItem of 't' ...
                while(I != null) //while I is not equal to null ...
                {
                    viewOfDrillDown.getItems().add(I); //add that item to the DisplayTrayView and ...
                    I = I.nextItem; //move over to the next item and go again
                }
                t = t.nextTray; //move over to the next tray and go again
            }
            d = d.nextCase; //move over to the next case and go again
        }
    }

    public void returnHome(ActionEvent actionEvent)
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        caseIDDropDown(MainPageApplication.firstCase); //run this method as soon as the page is opened
    }
}