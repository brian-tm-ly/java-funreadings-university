/**
 * The Client class represents a client of the library. 
 * It contains information about the client such as their name, phone number, email, and leased items.
 * @author Brian
 * @version 1.0
 * @see LibraryItem
 */

package Client;

import Library.*;

public class Client {
    private static int numClients = 0;
    private String clientID;
    private String name;
    private long phoneNum;
    private String email;
    private LibraryItem[] leasedItems;

    /**
     * Creates a new instance of Client with default values. 
     * Takes no arguments.
     */
    public Client() 
    {
        numClients++;
        name = "";
        phoneNum = 11111111;
        email = "";
        clientID = "C" + numClients;
        leasedItems = new LibraryItem[0];
    }

    /**
     * Creates a new instance of Client with the specified name, phone number, and email.
     * @param name The name of the client as a string.
     * @param phoneNum The phone number of the client as a long.
     * @param email The email of the client as a string.
     */
    public Client(String name, long phoneNum, String email)
    {
        numClients++;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        clientID = "C" + numClients;
        leasedItems = new LibraryItem[0];
    }

    /**
     * Creates a new instance of Client that is a copy of another Client.
     * @param otherClient The Client object to be copied.
     */
    public Client(Client otherClient)
    {
        numClients++;
        name = otherClient.name;
        phoneNum = otherClient.phoneNum;
        email = otherClient.email;
        clientID = "C" + numClients;
        
        for(int i = 0; i < otherClient.leasedItems.length; i++)
        {
            leasedItems[i] = otherClient.leasedItems[i];
        }
    }

    /**
     * Returns the number of Clients that have been created.
     * @return An integer representing the number of Clients that have been created.
     */
    public static int getNumClients()
    {
        return numClients;
    }

    /**
     * Returns the unique ID of the client.
     * @return A string representing the unique ID of the client.
     */
    public String getClientID()
    {
        return clientID;
    }

    /**
     * Returns the name of the client.
     * @return A string representing the name of the client.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Sets the name of the client.
     * @param name The name of the client as a string.
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Returns the phone number of the client.
     * @return A long representing the phone number of the client.
     */
    public long getPhoneNum() 
    {
        return phoneNum;
    }

    /**
     * Sets the phone number of the client.
     * @param phoneNum The phone number of the client as a long.
     */
    public void setPhoneNum(int phoneNum) 
    {
        this.phoneNum = phoneNum;
    }

    /**
     * Returns the email of the client.
     * @return A string representing the email of the client.
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     * Sets the email of the client.
     * @param email The email of the client as a string.
     */
    public void setEmail(String email) 
    {
        this.email = email;
    }

    /**
     * Returns the leased items of the client.
     * @return A string representing the leased items of the client.
     */
    public String getLeasedItems() 
    {
        String leasedItemsString = "";
        if(leasedItems.length == 0)
        {
            return "This client has no leased items.";
        }
        else
        {
            for(int i = 0; i < leasedItems.length; i++)
            {
                if (i == leasedItems.length - 1) 
                {
                    leasedItemsString += leasedItems[i].getName();
                } else {
                    leasedItemsString += leasedItems[i].getName() + ", ";
                }
            }
        }
        return leasedItemsString;
    }

    public void leaseItem(LibraryItem[] library, String itemID)
    {   
        LibraryItem[] newLeasedItems = new LibraryItem[leasedItems.length + 1];
        LibraryItem[] availableLibrary = new LibraryItem[library.length];
        LibraryItem leasedItem = null;
       
        if (leasedItems.length != 0)
        {
            for(int i = 0; i < leasedItems.length; i++)
            {
                newLeasedItems[i] = leasedItems[i];
            }
        }
       
        if (itemID.charAt(0) == 'B')
        {
            for(int i = 0; i < library.length; i++)
            {
                if(library[i] != null && library[i].getID().equals(itemID))
                {
                    leasedItem = library[i];
                    library[i] = null;
                }
            }
        } 
        else if (itemID.charAt(0) == 'J')
        {
            for(int i = 0; i < library.length; i++)
            {
                if(library[i] != null && library[i].getID().equals(itemID))
                {
                    leasedItem = library[i];
                    library[i] = null;
                }
            }
        }
        else if (itemID.charAt(0) == 'M')
        {
            for(int i = 0; i < library.length; i++)
            {
                if(library[i] != null && library[i].getID().equals(itemID))
                {
                    leasedItem = library[i];
                    library[i] = null;
                }
            }
        } 
        
        newLeasedItems[newLeasedItems.length-1] = leasedItem;
        leasedItems = newLeasedItems;

        for(int i = 0; i < library.length; i++)
        {
            if(library[i] != null)
            {
                availableLibrary[i] = library[i];
            }
        }

        library = availableLibrary;

    }

    public void returnItem(LibraryItem[] library, String itemID)
    {
        
        LibraryItem returnedItem = null;
        LibraryItem[] newLeasedItems = new LibraryItem[leasedItems.length - 1];
        

        if(leasedItems.length == 0)
        {
            System.out.println("This client has no leased items.");
        }
        else
        {
           for(int i = 0; i < leasedItems.length; i++)
           {
               if(leasedItems[i].getID().equals(itemID))
               {
                   returnedItem = leasedItems[i];
                   leasedItems[i] = null;
               }
               else
               {
                   newLeasedItems[i] = leasedItems[i];
               }
           }

           if (itemID.charAt(0) == 'B')
            {
                for(int i = 0; i < library.length; i++)
                {
                    if(library[i] == null)
                    {
                        library[i] = returnedItem;
                        break;
                    }
                }
            } 
            else if (itemID.charAt(0) == 'J')
            {
                for(int i = 0; i < library.length; i++)
                {
                    if(leasedItems[i].getID().equals(itemID))
                    {
                        library[i] = returnedItem;
                        break;
                    }
                }
            }
            else if (itemID.charAt(0) == 'M')
            {
                for(int i = 0; i < library.length; i++)
                {
                    if(leasedItems[i].getID().equals(itemID))
                    {
                        library[i] = returnedItem;
                        break;
                    }
                }
            } 
            leasedItems = newLeasedItems;
           
        }
    }

    public void displayLeasedItems() {
        
        if(leasedItems.length == 0)
        {
            System.out.println("This client has no leased items.");
        }
        else
        {
            for(int i = 0; i < leasedItems.length; i++)
            {
                System.out.println("Client " + clientID + " has leased:");
                System.out.println(leasedItems[i].toString());
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
        return "This client's ID is " + clientID + ". Their name is " + name + ". Their phone number is " 
            + phoneNum + ". Their email is " + email;
    }

   

}
