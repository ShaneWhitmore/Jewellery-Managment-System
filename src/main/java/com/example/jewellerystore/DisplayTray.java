package com.example.jewellerystore;

public class DisplayTray {

    public DisplayCase displayCase;
    private int trayID;
    private String inlay;
    private double width;
    private double depth;

    public Item firstItem;
    public DisplayTray nextTray;

    private int totalTrayValue;


    public DisplayTray()
    {

    }

    public DisplayTray(DisplayCase displayCase,int trayID, String inlay, double width, double depth)
    {
        this.displayCase = displayCase;
        this.trayID = trayID;
        this.inlay = inlay;
        this.width = width;
        this.depth = depth;
    }

    public int getTotalTrayValue()
    {
        //DisplayCase d = MainPageApplication.firstCase; //local variable 'd' of type DisplayCase
        int totalTrayValue = 0;
        DisplayTray t = this; //build this variable 't' which is linked to the firstTray of that case and ...

            Item I = t.firstItem; //build this variable 'I' which is linked to the first item of that tray and...
            while (I != null) //while I is not equal to null...
            {
                totalTrayValue += I.getPrice();
                I = I.nextItem; //move over to the next item and go again
            }
        return totalTrayValue;
    }

    public void setTotalTrayValue(int totalTrayValue)
    {
        this.totalTrayValue = totalTrayValue;
    }

    public int getTrayID()
    {
        return trayID; //return the TrayID to the constrcutor
    }

    public void setTrayID(int trayID)
    {
        this.trayID = trayID; //set the trayID
    }

    public String getInlay()
    {
        return inlay; //return the inlay to the constrcutor
    }

    public void setInlay(String inlay)
    {
        this.inlay = inlay; //set the inlay
    }

    public double getWidth()
    {
        return width; //return the width to the constrcutor
    }

    public void setWidth(double width)
    {
        this.width = width; //set the width
    }

    public double getDepth()
    {
        return depth; //return the depth to the constrcutor
    }

    public void setDepth(double depth)
    {
        this.depth = depth; //set the depth
    }

    public void setNextTray(DisplayTray firstTay)
    {
        nextTray= firstTay; //setting nextTray as firstTray
    }

    public void delete(int index)
    {
        Item temp = firstItem;

        if(index == 0)
        {
            firstItem = temp.nextItem;
        }
        else
        {
            int counter = 1;

            while(counter < index)
            {
                temp = temp.nextItem;
            }

            if(temp.nextItem != null)
            {
                temp.nextItem = temp.nextItem.nextItem;
            }

        }
    }

    @Override
    public String toString() //toString used for displaying info on displayTrays in viewOfTray() method
    {
        return
                "ID: " + trayID
                ;
    }

    public String toFullString() //toString used for displaying info on displayTrays in viewOfTray() method
    {
        return
                "displayCase=" + displayCase +
                        ", trayID=" + trayID +
                        ", inlay='" + inlay + '\'' +
                        ", width=" + width +
                        ", depth=" + depth +
                        ", total Tray Value : € " + getTotalTrayValue();

    }
}
