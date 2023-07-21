package com.example.jewellerystore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ViewStockController implements Initializable
{
    @FXML
    private ListView<Item> viewOfJewellery;


    public void findAllItems(DisplayCase displayCase) //button to find all items
    {
        DisplayCase d = displayCase; //build variable 'd' of type DisplayCase which represent a displayCase
        viewOfJewellery.getItems().clear(); //clear any items out of the view

        while(d != null) //while the displayCase is not equal to null ...
        {
            DisplayTray t = d.firstTray; //build the variable 't' of type DisplayTray which represent the firstTray of d ...
            while(t != null) //while t is not equal to null ...
            {
                Item I = t.firstItem; //build the variable 'I' of type Item which represents the firstItem of t ...
                while(I != null) //while I is not equal to null ...
                {
                    viewOfJewellery.getItems().add(I); //add that item to the viewOfJewellery and ...
                    I = I.nextItem; //move over to the next item and go again
                }
                t = t.nextTray; //move over to the next tray and go again
            }
            d = d.nextCase; //move over to the next case and go again
        }
    }

    public void findAllItems(ActionEvent actionEvent) //required to start (this does nothing , there is just a method in the fxml)
    {
     findAllItems(MainPageApplication.firstCase);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

    public void returnToHomePage(ActionEvent actionEvent)
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
