package com.example.jewellerystore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SearchItemController implements Initializable
{

    @FXML
    private ListView<Item> displayJewelleryItem;

    @FXML
    private ChoiceBox<String> itemTypeDropDown;


    public void findJewelleryItem(ActionEvent actionEvent)
    {
        DisplayCase d = MainPageApplication.firstCase; //local variable 'd' of type DisplayCase
        displayJewelleryItem.getItems().clear(); //clear of the view as soon as this method is run

        while(d != null) //while the displayCase is not equal to null ...
        {
            DisplayTray t = d.firstTray; //build this variable 't' which is linked to the firstTray of that case and ...
            while(t != null) //while t is not equal to null ...
            {
                Item I = t.firstItem; //build this variable 'I' which is linked to the first item of that tray and...
                while(I != null) //while I is not equal to null...
                {
                    if(itemTypeDropDown.getSelectionModel().getSelectedItem() == I.getType()) //is the selected item is equal to item type that is currently called on ...
                    {
                        displayJewelleryItem.getItems().add(I); //add that item to the list view 'displayJewelleryItem'
                    }
                    I = I.nextItem; //move over to the next item and go again
                }
                t = t.nextTray; //move over to the next tray and go again
            }
            d = d.nextCase; //move to the next case and go again
        }
    }

    public void itemTypeDropDown(DisplayTray displayTray)
    {
        //fill this information into the type dropdown
        ObservableList<String> type = FXCollections.observableArrayList("Watch" , "Ring" , "Necklace" , "Ear Ring" , "Chain" , "Bracelet");
        itemTypeDropDown.setItems(type);
    }
/*
    public void deleteItem(ActionEvent actionEvent) //make this method for deleting an item out of the tray
    {
        int itemToDelete =  displayJewelleryItem.getSelectionModel().getSelectedIndex(); //local variable of type int representing the index of the selected item
        DisplayTray displayTray = thing.getSelectionModel().getSelectedItem(); //local variable of type DisplayTray

        displayTray.firstItem.delete(itemToDelete); //go to that list and delete the selected item from that tray
    }


 */

    public void returnToMainPage(ActionEvent actionEvent)
    {
        //take the user back to the home page
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
        itemTypeDropDown(TrayPageController.firstItem); //start the 'itemTypeDropDown' method as soon as this page is opened
    }

}
