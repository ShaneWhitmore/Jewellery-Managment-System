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

public class RemoveItemController implements Initializable
{
    @FXML
    private ChoiceBox<Item> ItemNameDropDown;

    @FXML
    private ChoiceBox<DisplayTray> TrayIDDropDown;

    @FXML
    private ListView<Item> viewOfItems;




    public void TrayIDDropDown(DisplayCase displayCase)
    {
       DisplayCase dC = displayCase; //local variable representing the first case

        TrayIDDropDown.getItems().clear(); //remove existing trays from the dropdown

        while (dC != null) //while the display case is not equal to null ...
        {
            DisplayTray dT = dC.firstTray;
            while(dT != null)  //while dT is not null ...
            {
                TrayIDDropDown.getItems().add(dT); //add that tray to the dropDown
                dT= dT.nextTray; //move over to the next tray and go again
            }
            dC= dC.nextCase; //move over to the next case and go again
        }
    }

    public void ItemNameDropDown()
    {
        ItemNameDropDown.getItems().clear(); //remove existing items from the dropdown

        if(TrayIDDropDown.getSelectionModel().getSelectedItem() != null)
        {
            DisplayTray selectedTray = TrayIDDropDown.getSelectionModel().getSelectedItem(); //setting local variable representing the selected tray from above
            Item items = selectedTray.firstItem; //local variable 'items' representing the first item of the selected tray above

            while(items != null) //while items is not equal to null ...
            {
                ItemNameDropDown.getItems().add(items); //add that items description to the drop down
                items = items.nextItem; //move over  to the next item and go again
            }
        }
    }

    public void deleteJewelleryItem(ActionEvent actionEvent)
    {
        DisplayTray dT = TrayIDDropDown.getSelectionModel().getSelectedItem();

       int itemToDelete = ItemNameDropDown.getSelectionModel().getSelectedIndex();//local variable representing selected item

       dT.delete(itemToDelete); //go to displayTray and delete this item

        viewOfItems(MainPageApplication.firstCase); //re-run the view to show the item is delete
    }

    public void viewOfItems(DisplayCase displayCase)
    {
        viewOfItems.getItems().clear(); //clear the view ...

        DisplayCase dC = displayCase; //local variable dT referencing the display case
        while(dC != null) //while dT is not equal to null ...
        {
            DisplayTray t = dC.firstTray; //build a new variable t referencing the first tray of that case
            while(t != null) //while t is not equal to null ...
            {
                Item i = t.firstItem; //build a new variable i referencing the first item of that tray
                while (i != null) //while i is not equal to null ...
                {
                    viewOfItems.getItems().add(i); //add that item to the view of items
                    i = i.nextItem; //move over to the next item and go again
                }
                t = t.nextTray; //move over to the next tray and go again
            }
            dC = dC.nextCase; //move over to the next case and go again
        }
    }


    public void returnToHome(ActionEvent actionEvent)
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
        TrayIDDropDown(MainPageApplication.firstCase);
        viewOfItems(MainPageApplication.firstCase);
    }
}
