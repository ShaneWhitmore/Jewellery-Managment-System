package com.example.jewellerystore;

public class Material extends Item
{
    //creating local variable
    private String name;
    private String information;
    private int quantity;
    private double quality;


    public Material(String name, String information, int quantity, double quality) //constructor for Material class
    {
        this.name = name;
        this.information = information;
        this.quantity = quantity;
        this.quality = quality;
    }

    public Material(DisplayCase displayCase, DisplayTray displayTray, String description, String type, boolean gender, double price, String name, String information, int quantity, double quality)
    { //constructor for class Material as subclass of Item
        super(displayCase,displayTray,description, type, gender, price);
        this.name = name;
        this.information = information;
        this.quantity = quantity;
        this.quality = quality;
    }

    public String getName()
    {
        return name; //get the item name and put it into the constructor
    }

    public void setName(String name)
    {
        this.name = name; //set the name of the item and pass it to the getter
    }

    public String getInformation()
    {
        return information; //get the item information and put it into the constructor
    }

    public void setInformation(String information)
    {
        this.information = information; //set the information of the item and pass it to the getter
    }

    public int getQuantity()
    {
        return quantity; //get the quantity and put it into the constructor
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity; //set the quantity of the item and pass it to the getter
    }

    public double getQuality()
    {
        return quality; //get the item quality and put it into the constructor
    }

    public void setQuality(double quality)
    {
        this.quality = quality; //set the quality of the item and pass it to the getter
    }

}