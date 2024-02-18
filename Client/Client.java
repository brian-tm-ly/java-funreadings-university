package Client;

import Library.*;

public class Client {
    private static int numClients = 0;
    private String clientID;
    private String name;
    private int phoneNum;
    private String email;
    private LibraryItem[] leasedItems;

    public Client() 
    {
        numClients++;
        name = "";
        phoneNum = 11111111;
        email = "";
        clientID = "C" + numClients;
    }

    public Client(String name, int phoneNum, String email)
    {
        numClients++;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        clientID = "C" + numClients;
    }

    public Client(Client otherClient)
    {
        numClients++;
        name = otherClient.name;
        phoneNum = otherClient.phoneNum;
        email = otherClient.email;
        clientID = "C" + numClients;
    }

    public int getNumClients()
    {
        return numClients;
    }

    public String getClientID()
    {
        return clientID;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getPhoneNum() 
    {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) 
    {
        this.phoneNum = phoneNum;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getLeasedItems() 
    {
        String leasedItemsString = "";
        for(int i = 0; i < leasedItems.length; i++)
        {
            if (i == leasedItems.length - 1) 
            {
                leasedItemsString += leasedItems[i].getName();
            } else {
                leasedItemsString += leasedItems[i].getName() + ", ";
            }
        }
        return leasedItemsString;
    }

    public void leaseItem(LibraryItem[] library, String itemID)
    {   
        LibraryItem[] newLeasedItems = new LibraryItem[leasedItems.length + 1];
        LibraryItem[] availableLibrary = new LibraryItem[library.length];
        int leasedItemIndex;

        for(int i = 0; i < leasedItems.length; i++)
        {
            if(leasedItems[i] == null)
            {
                newLeasedItems[i] = leasedItems[i];
            }
        }
       
        if (itemID.charAt(0) == 'B')
        {
            for(int i = 0; i < library.length; i++)
            {
                if(((Book) library[i]).getID().equals(itemID))
                {
                    newLeasedItems[leasedItems.length] = library[i];
                    leasedItemIndex = i;
                    library[i] = null;
                }
                availableLibrary[library.length] = library[i];
            }
        } 
        else if (itemID.charAt(0) == 'M')
        {
            for(int i = 0; i < library.length; i++)
            {
                if(((Media) library[i]).getID().equals(itemID))
                {
                    newLeasedItems[leasedItems.length] = library[i];
                    leasedItemIndex = i;
                    library[i] = null;
                }
                availableLibrary[library.length] = library[i];
            }
        } 
        else if (itemID.charAt(0) == 'J')
        {
            for(int i = 0; i < library.length; i++)
            {
                if(((Journal) library[i]).getID().equals(itemID))
                {
                    newLeasedItems[leasedItems.length] = library[i];
                    leasedItemIndex = i;
                    library[i] = null;
                }
                availableLibrary[library.length] = library[i];
            }
        }
        

    }

    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else
        {
            Client otherClient = (Client) otherObject;
            return (name.equals(otherClient.name) && phoneNum == otherClient.phoneNum 
                && email.equals(otherClient.email));
        }
    }

    @Override
    public String toString()
    {
        return "This client's ID is " + numClients + ".\nTheir phone number is " 
            + phoneNum + ".\nTheir email is " + email;
    }

}
