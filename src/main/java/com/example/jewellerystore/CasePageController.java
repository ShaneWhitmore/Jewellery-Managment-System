package com.example.jewellerystore;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CasePageController implements Initializable {

    public static Object firstTay;


    @FXML
    private Button AddCaseButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextField CaseIDInput;

    @FXML
    private ChoiceBox<String> LitDropDown;

    @FXML
    private ChoiceBox<String> TypeDropDown;

    @FXML
    private ListView<String> ViewOfCases;


    Scene scene = null;
    //public static DisplayCase firstCase;
    public static Stage primaryStage;
    public static DisplayTray firstTray;


    public void addDisplay()
    {
        int cId =  Integer.parseInt(CaseIDInput.getText()); //creating local variable 'cId'
        String lit = LitDropDown.getSelectionModel().getSelectedItem(); //creating local variable lit
        String type = TypeDropDown.getSelectionModel().getSelectedItem(); //creating local variable type

        boolean l = false; //setting is as false "starting with flag down"
        if(lit.equals("Lit")) //if 'lit' says "Lit" ...
        {
            l = true; //then l is equal to true
        }
        boolean t = false; //setting t as false "starting with flag down"
        if(type.equals("Free Standing")) //if 'type' says "Free Standing" ...
        {
            t = true; //then t is equal to true
        }
        addDisplayCase(cId, String.valueOf(t), l); //take all the information and drop it in the addDisplayCase method
    }

    public void addDisplayCase(int ID,String type, boolean lighting)
    {
        DisplayCase dc = new DisplayCase(ID,type,lighting); //creating new DisplayCase
        dc.setID(ID); //setting an ID for the new display case
        dc.setType(type); //setting if case is wall mounted
        dc.setLit(lighting); //setting if case is lighted or not
        dc.setNextCase(MainPageApplication.firstCase); //add this new case to the linked lists with respect to the location of 'firstCase'
        MainPageApplication.firstCase = dc; //set this new case as the 'firstcase' in the chain

        //this linked lists creates a first in last out system :)
    }

    public void AddCaseButton()
    {
        addDisplayCase(Integer.parseInt(CaseIDInput.getText()), TypeDropDown.getValue(), LitDropDown.getValue().equals("Lit") );
        //Take all the information from the dropdowns and inputs and run them through the addDisplayCase method
    }

    public void LitDropDown()
    {
        ObservableList<String> list = FXCollections.observableArrayList("Lit", "Unlit");
        LitDropDown.setItems(list);

        //setting the information to be displayed in the 'litDropDown' dropdown
    }

    public void TypeDropDown()
    {
        ObservableList<String> type = FXCollections.observableArrayList("Free Standing" , "Wall-mounted");
        TypeDropDown.setItems(type);

        //setting the information to be displayed in the 'typeDropDown' dropdown
    }

    public void ViewOfCases(DisplayCase displayCase)
    {
        //DisplayCase dc1=getDisplayCaseByIndex(ViewOfCases.getSelectionModel().getSelectedIndex());
        //DisplayCase dc2=ViewOfCases.getSelectionModel().getSelectedItem();
        //dc2.
        //DisplayCase cases = displayCase; //creating a local variable 'cases'
        ViewOfCases.getItems().clear();

        while(displayCase != null) //while the linked list of displaycases is not equal to null ...
        {
            //cases += DisplayCase.getDisplayCase(i); //add the current display case to the local variable ...
            ViewOfCases.getItems().add(displayCase.toLongString()); //"Display Case Id: "+displayCase.getID());

            displayCase = displayCase.nextCase; // the move over to the next displaycase and go again
        }
        // return cases; //return the local variable
    }
    public void addDisplayCase(ActionEvent actionEvent) //method for button to add the case to the linkedlist

    {
        AddCaseButton(); //run addCaseButton method
        ViewOfCases(MainPageApplication.firstCase); //drop the new case into the viewOfCases method
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        TypeDropDown(); //start the dropdown method as soon as the user opens the 'addCase' scene
        LitDropDown(); //start the dropdown method as soon as the user opens the 'addCase' scene
        ViewOfCases(MainPageApplication.firstCase); //run the viewOfCases method to get all existing cases to display
    }

    public void start(ActionEvent actionEvent) throws IOException  //RETURN TO HOME PAGE FROM DISPLAY CASE
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
}