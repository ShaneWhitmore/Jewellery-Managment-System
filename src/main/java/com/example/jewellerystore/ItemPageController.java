package com.example.jewellerystore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ItemPageController implements Initializable
{

    @FXML
    private Button AddItemButton;

    @FXML
    private Button BackToHomeButton;

    @FXML
    private ChoiceBox<DisplayCase> CaseIDDropDown;

    @FXML
    private TextField DescriptionTextBar;

    @FXML
    private ListView<Item> DisplayItemView;

    @FXML
    private ChoiceBox<String> GenderDropDown;

    @FXML
    private TextField PriceTextBar;

    @FXML
    private ChoiceBox<DisplayTray> TrayIDDropDown;

    @FXML
    private ChoiceBox<String> TypeDropDown;



    public void AddJewelleryItem(ActionEvent actionEvent) //button to add
    {
        DisplayCase cID = CaseIDDropDown.getSelectionModel().getSelectedItem(); //create variable 'cID' of type DisplayCase using input from dropDown
        DisplayTray tId = TrayIDDropDown.getSelectionModel().getSelectedItem(); //creating local variable 'tId' which uses the TrayIDInput input
        double price = Integer.parseInt(PriceTextBar.getText()); //set variable 'price' based off of the intput info
        boolean gender = GenderDropDown.isShowing(); //set variable 'gender' based off of the dropDown
        String descrip = DescriptionTextBar.getText(); //set variable 'description' based off of the intput info
        String type = TypeDropDown.getSelectionModel().getSelectedItem(); //set variable 'type' based off of the dropDown

        addJewelleryItem(cID ,tId, descrip ,type , gender , price); //take all that info and pass it to the method below
    }

    public void addJewelleryItem(DisplayCase displayCase , DisplayTray displayTray , String description , String type , boolean gender , double price)
    {
        DisplayTray chosenTray = TrayIDDropDown.getSelectionModel().getSelectedItem(); //create variable 'chosenTray' which represents the selected item in the TrayIDDropDown
        DisplayCase chosenCase = CaseIDDropDown.getSelectionModel().getSelectedItem(); //create variable 'chosenCase' which represents the selected item in the CaseIDDropDown
        Item I = new Item(chosenCase , chosenTray ,description ,type ,gender ,price); //build a new item 'I'
        I.setDescription(description); //set the description of 'I' using the variable 'description'
        I.setType(type); //set the type of 'I' using the variable 'type'
        I.setGender(gender); //set the gender of 'I' using the variable 'gender'
        I.setPrice(price); //set the price of 'I' using the variable 'price'
        I.setNextItem(chosenTray.firstItem); //set 'I' as chosenTrays firstItem
        chosenTray.firstItem = I; //set this new item as the 'firstItem' of the chosen tray

        displayItemView(chosenCase.firstTray); //display the new tray in the view
    }

    public void genderDropDown()
    {
        ObservableList<String> gender = FXCollections.observableArrayList("Male" , "Female");
        GenderDropDown.setItems(gender);

        //setting information for GenderDropDown to display
    }

    public void caseIDDropDown(DisplayCase displayCase)
    {
        CaseIDDropDown.getItems().clear(); //clear the drop down (used when starting the page (this acts as a refresh in the event more cases where added))

        while(displayCase != null) //while displayCase is equal to null ...
        {
            CaseIDDropDown.getItems().add(displayCase); //add that case to the dropDown menu

            displayCase = displayCase.nextCase; //move over to the next case and go again
        }
    }

    public void trayIDDropDown() //method for display Tray id's
    {
        TrayIDDropDown.getItems().clear(); //clear all existing trays from the dropdown (acts as refresh on start up in the event more trays have been created

        if(CaseIDDropDown.getSelectionModel().getSelectedItem()!=null) //if something has been selected from the CaseIDDropDown ...
        {
            DisplayCase dcTemp = CaseIDDropDown.getSelectionModel().getSelectedItem(); //create variable 'dcTemp' which represents the selected Item from the caseIDDropDown
            DisplayTray temp = dcTemp.firstTray; //create variable 'temp' which represents the firstTray of dcTemp

            while(temp != null) //while temp is not null ...
            {
                TrayIDDropDown.getItems().add(temp); //add the tray to the dropdown

                temp = temp.nextTray; //move over to the next tray and go again
            }
        }
}

    public void typeDropDown()
    {
        ObservableList<String> type = FXCollections.observableArrayList("Watch" , "Ring" , "Necklace" , "Ear Ring" , "Chain" , "Bracelet");
        TypeDropDown.setItems(type);

        //setting information for the TypeDropDown
    }

    public void displayItemView(DisplayTray chosenTray)
    {
        DisplayItemView.getItems().clear(); //clear all existing trays

        DisplayTray dtTemp = TrayIDDropDown.getSelectionModel().getSelectedItem(); //local variable 'temp' using displayCase.firstTray
        Item temp = dtTemp.firstItem;
        while(temp!= null) //while the linked list of displaycases is not equal to null ...
        {
            //cases += DisplayCase.getDisplayCase(i); //add the current display case to the local variable ...
            DisplayItemView.getItems().add(temp); //"Display Case Id: "+displayCase.getID());

            temp = temp.nextItem;// the move over to the next displaycase and go again
        }
    }

    public void ReturnToHome(ActionEvent actionEvent)
    {
        //bring the user back to the home page
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
        genderDropDown(); //run the genderDropDown() method when the user opens the scene
        caseIDDropDown(MainPageApplication.firstCase); //run the caseIDDropDown() method when the user opens the scene
        typeDropDown(); //run the typeDropDown() method when the user opens the scene
    }
}