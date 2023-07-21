package com.example.jewellerystore;

public class DisplayCase {

    //creating global variables
    public int ID;
    public String type;
    public boolean isLit;
    public DisplayCase nextCase;
    public DisplayTray firstTray;
    private int totalCaseValue;


    public DisplayCase() //default constructor
    {

    }

    public DisplayCase(int ID, String type, boolean isLit) //constructor for DisplayCase
    {
        this.ID = ID;
        this.type = type;
        this.isLit = isLit;
    }

    public int getTotalCaseValue()
    {
        //DisplayCase d = MainPageApplication.firstCase; //local variable 'd' of type DisplayCase
        int totalCaseValue = 0;
        DisplayTray t = firstTray; //build this variable 't' which is linked to the firstTray of that case and ...
            while (t != null) //while t is not equal to null ...
            {
                Item I = t.firstItem; //build this variable 'I' which is linked to the first item of that tray and...
                while (I != null) //while I is not equal to null...
                {
                    totalCaseValue += I.getPrice();
                    I = I.nextItem; //move over to the next item and go again
                }
                t = t.nextTray; //move over to the next tray and go again
            }
        return totalCaseValue;
    }



    public void setTotalCaseValue(int totalCaseValue)
    {
        this.totalCaseValue = totalCaseValue;
    }

    public int getID()
    {
        return ID; //get the ID and return it to the constuctor
    }

    public void setID(int ID)
    {
        this.ID = ID; //set the ID and pass it to the getter
    }

    public String getType()
    {
        return type; //get the type and return it to the constuctor
    }

    public void setType(String type)
    {
        this.type = type; //set the type and pass it to the getter
    }

    public String isLit()
    {
        if(isLit == true) //if 'isLit' is equal to true ...
        {
            return "There is lighting in the case"; //return that "There is lighting in the case"
        }
        else //else ...
        {
            return "there is no lighting in the case"; //return that "There is no lighting in the case"

        }
    }

    public String setLit(boolean isLit)
    {
        if(isLit == true) //if 'isLit' is equal to true ...
        {
            return "There is lighting in the case"; //return that "There is lighting in the case"
        }
        else //else ...
        {
            return "there is no lighting in the case"; //return that "There is no lighting in the case"

        }
    }

    public void setNextCase(DisplayCase firstCase)
    {
        nextCase=firstCase; //setting next case to first case (this creates that first in chain for the linked list)
    }
    @Override
    public String toString() // using this toString for the id dropdown in Display tray page and item page
    {
        return "ID: " + getID();

    }

    public String toLongString() //using this for the view of cases method
    {
        return "Display Case Id: "+getID() +
                ", "+ isLit() +
                " and the Display Case is: " + getType() +
                "Total Case Value: € " + getTotalCaseValue();
    }


    /* why to different toStrings ??? = this means I can get information on the id for drop downs on different
       pages and then I can use the 'toLongString() for the view of cases
    */
}
