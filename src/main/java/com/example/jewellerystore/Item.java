package com.example.jewellerystore;

public class Item
{

    private String description;
    private String type;
    private boolean gender;
    private double price;

    public Item nextItem;

    public DisplayTray displayTray;
    public DisplayCase displayCase;


    public Item()
    {

    }

    public Item(DisplayCase displayCase , DisplayTray displayTray, String description, String type, boolean gender, double price)
    {
        this.displayCase = displayCase;
        this.displayTray = displayTray;
        this.description = description;
        this.type = type;
        this.gender = gender;
        this.price = price;
    }

    public String getDescription()
    {
        return description; //get the description and put it in the constructor
    }

    public void setDescription(String description)
    {
        this.description = description; //set the description and pass it to the getter
    }

    public String getType()
    {
        return type; //get the item type and put it in the constructor
    }

    public void setType(String type)
    {
        this.type = type; //set the item type and pass it to the getter
    }

    public boolean isGender()
    {
        return gender; //get the gender and put it in the constructor
    }

    public String setGender(boolean gender)
    {
        if(gender == true) //if 'gender' is true ...
        {
            return "male"; //retrun "male"
        }
        else //else ...
        {
            return "female"; //return "female"
        }
    }

    public double getPrice()
    {
        return price; //get the price and put it in the constructor
    }

    public void setPrice(double price)
    {
        this.price = price; //set the price and pass it to the getter
    }

    public void setNextItem(Item firstItem)
    {
        nextItem = firstItem;
    }

    @Override
    public String toString()
    {
        return "displayCase=" + displayCase + '\n' +
                "   displayTray= " +  displayTray + '\n' +
                "       description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", gender=" + gender +
                ", price= €" + price;
    }
}
