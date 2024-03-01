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
     * Returns the number of leased items of the client.
     * @return An integer representing the number of leased items of the client.
     */
    public int getNumLeasedItems()
    {
        return leasedItems.length;
    }

    /**
     * Sets the leased items of the client.
     * @param library The library from which the client is leasing items.
     * @param itemID The ID of the item the client is leasing.
     */
    public void leaseItem(LibraryItem[] library, String itemID)
    {   
        
        LibraryItem[] newLeasedItems = new LibraryItem[leasedItems.length + 1]; // Create a new array to store the leased items
        LibraryItem[] availableLibrary = new LibraryItem[library.length]; // Create a new array to store the available items
        LibraryItem leasedItem = null;
       
        // Copy the leased items into the new array if there are any
        if (leasedItems.length != 0)
        {
            for(int i = 0; i < leasedItems.length; i++)
            {
                newLeasedItems[i] = leasedItems[i];
            }
        }
        // Lease the item depending on the type
        if (itemID.charAt(0) == 'B')
        {
            if(Book.getNumBooks() == 0)
            {
                System.out.println("There are no books to lease.");
            }
            else
            {   // Find the item in the library and lease it
                for(int i = 0; i < library.length; i++)
                {
                    if(library[i] != null && library[i].getID().equals(itemID))
                    {
                        leasedItem = library[i];
                        library[i] = null; // Set the item in the library to null
                        newLeasedItems[newLeasedItems.length-1] = leasedItem; // Add the item to the leased items
                        leasedItems = newLeasedItems; // Set the leased items to the new array
                    }
                }
            }

        } 
        else if (itemID.charAt(0) == 'J')
        {
            if(Journal.getNumJournals() == 0)
            {
                System.out.println("There are no journals to lease.");
            }
            else
            {
                for(int i = 0; i < library.length; i++)
                {
                    if(library[i] != null && library[i].getID().equals(itemID))
                    {
                        leasedItem = library[i];
                        library[i] = null;
                        newLeasedItems[newLeasedItems.length-1] = leasedItem;
                        leasedItems = newLeasedItems;
                    }
                }
            }
        }
        else if (itemID.charAt(0) == 'M')
        {
            if(Media.getNumMedia() == 0)
            {
                System.out.println("There are no media to lease.");
            }
            else
            {
                for(int i = 0; i < library.length; i++)
                {
                    if(library[i] != null && library[i].getID().equals(itemID))
                    {
                        leasedItem = library[i];
                        library[i] = null;
                        newLeasedItems[newLeasedItems.length-1] = leasedItem;
                        leasedItems = newLeasedItems;
                    }
                }
            }
        } 
        
        

        for(int i = 0; i < library.length; i++)
        {
            if(library[i] != null)
            {
                availableLibrary[i] = library[i];
            }
        }

        library = availableLibrary;

    }

    /**
     * Returns the leased items of the client.
     * @param library The library from which the client is returning items.
     * @param itemID The ID of the item the client is returning.
     */
    public void returnItem(LibraryItem[] library, String itemID)
    {
        LibraryItem returnedItem = null;
        LibraryItem[] newLeasedItems = new LibraryItem[leasedItems.length]; // Create a new array to store the leased items
        
        // Check if the client has any leased items
        if(leasedItems.length == 0)
        {
            System.out.println("This client has no leased items.");
        }
        // Find the item in the leased items and return it
        else
        {  
            newLeasedItems = new LibraryItem[leasedItems.length - 1]; // Create a new array to store the leased items
            // Copy the leased items into the new array if there are any
            for(int i = 0; i < leasedItems.length; i++)
            {
                if(leasedItems[i].getID().equals(itemID))
                {
                    returnedItem = leasedItems[i];
                    leasedItems[i] = null;
                }
                else if(leasedItems[i] != null)
                {
                    newLeasedItems[i] = leasedItems[i];
                }
            }
            // Find the first null spot in the library and add the returned item based on item type
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
            leasedItems = newLeasedItems; // Set the leased items to the new array
        }
    }

    /**
     * Displays the leased items of the client.
     */
    public void displayLeasedItems() {
        String leasedItemsString = "";
        if(leasedItems.length == 0)
        {
            System.out.println("Client " + getClientID() +  " has no leased items.");
        }
        else
        {   // Create a string of the leased items
            for(int i = 0; i < leasedItems.length; i++)
            {
                if (i == leasedItems.length - 1) 
                {
                    leasedItemsString += leasedItems[i].getName();// Don't add a comma if it's the last item
                } 
                else 
                {
                    leasedItemsString += leasedItems[i].getName() + ", "; // Add a comma if there are more items
                }
            }
            System.out.println("Client " + getClientID() + " has leased the following items:\n" + leasedItemsString);
        }
        
    }

    /**
     * Compares the client to another object to see if they are equal.
     * @param otherObject The object to compare to the client.
     */
    @Override
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

    /**
     * Returns a string representation of the client.
     * @return A string representing the information of the client.
     */
    @Override
    public String toString()
    {
        return "Client " + clientID + ": Their name is " + name + ". Their phone number is " 
            + phoneNum + ". Their email is " + email + ". They have leased " + leasedItems.length + " items.";
    }

   

}
