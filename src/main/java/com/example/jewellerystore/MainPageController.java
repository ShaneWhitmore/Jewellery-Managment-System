package com.example.jewellerystore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class MainPageController implements Initializable
{

    @FXML
    private ListView<Integer> viewOfStockValue;

    public void viewOfStockValue()
    {
        viewOfStockValue.getItems().clear();
        DisplayCase d = MainPageApplication.firstCase; //local variable 'd' of type DisplayCase
        float totalValue = 0;

        while(d != null) //while the displayCase is not equal to null ...
        {
            DisplayTray t = d.firstTray; //build this variable 't' which is linked to the firstTray of that case and ...
            while (t != null) //while t is not equal to null ...
            {
                Item I = t.firstItem; //build this variable 'I' which is linked to the first item of that tray and...
                while (I != null) //while I is not equal to null...
                {
                    totalValue += I.getPrice();
                    I = I.nextItem; //move over to the next item and go again
                }
                t = t.nextTray; //move over to the next tray and go again
            }
            d = d.nextCase; //move to the next case and go again
        }
        viewOfStockValue.getItems().add((int) totalValue);
    }

    public void EasterEgg(MouseEvent mouseEvent) //this method loads the easter egg page
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("EasterEggUI.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // stage.getIcons().add(new Image("Image/Diamond.png"));   ##SETTING AN ICON FOR THE STAGE
        Stage stage = new Stage();
        stage.setTitle("Whitmore Jewellers");
        stage = (Stage) ((Text) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void ViewallStock(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("ViewStockPage.fxml"));
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

    public void AddDisplayCase(ActionEvent actionEvent) //OPEN UP THE DISPLAY GUI MENU
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("AddDisplayCaseGUI.fxml"));
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


    public void DrillDown(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("DrillDown Page.fxml"));
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

    public void AddDisplayTray(ActionEvent actionEvent) //this method loads the add display tray page
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("DisplayTrayUI.fxml"));
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

    public void AddJewelleryItem(ActionEvent actionEvent) //this method loads the add Jewellery item page
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("ItemPageUI.fxml"));
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

    public void SearchJewelleryItem(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("SearchItemPage.fxml"));
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

    public void RemoveJewelleryItem(ActionEvent actionEvent)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPageApplication.class.getResource("RemoveItemPage.fxml"));
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

    public void addDisplayCase(ActionEvent actionEvent) //this method is not required as it is input is called in the addCaseButton method
    {
       //addDisplayCase(); //creating new DisplayCase
    }

    public void returnToMainPage(ActionEvent actionEvent) throws IOException
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




    public void LoadLinkedList(ActionEvent actionEvent)  //load the linked list doc
    {
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<DisplayCase>[] classes = new Class[] {DisplayCase.class , DisplayTray.class , Item.class };

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream inMessages = xstream.createObjectInputStream(new FileReader("JewelleryStore.xml"));
        MainPageApplication.firstCase = (DisplayCase) inMessages.readObject();
        inMessages.close();
    }

    public void SaveLinkedList (ActionEvent actionEvent) //save the linked list
    {
        try {
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream outMessages = xstream.createObjectOutputStream(new FileWriter("JewelleryStore.xml"));
        outMessages.writeObject(MainPageApplication.firstCase);
        outMessages.close();
    }



    public void ClearLinkedList(ActionEvent actionEvent) //delete the linked list and make a new one
    {
        MainPageApplication.firstCase = null;

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
        viewOfStockValue();
    }
}
