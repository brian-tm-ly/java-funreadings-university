/**
 * This class is the driver class for the FunReadings Library program. 
 * It contains the main method which allows the user to interact directly with the library 
 * or see a demo of a pre-defined scenario.
 * @author Brian
 * @version 1.0
 * @see LibraryItem
 * @see Client
 */

package Driver;
import Library.*;
import Client.Client;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        
        //Declaration of variables necessary for the program to run.
        Scanner keyIn = new Scanner(System.in);
        String input;
        int maxItems = 0;
        String itemID;
        int clientIndex;
        String itemChoice;
        int menuChoice=0;
        int maxClients = 0;

        //Prompts the user to run the program or see a demo.
        System.out.println("Would you like to run the program or see a demo?" +
            " (Please enter y to run the program or n to see a demo.)");
        input = keyIn.next();
        
        if(input.equalsIgnoreCase("y"))
        {
            //Prompts the user to enter the maximum number of items and clients for the library.
            System.out.println("Welcome to the FunReadings Library! To get started, the inventory space"
            + "and limit of clients will need to be entered." +
            "\nWhat is the maximum number of items for your inventory?");   
            maxItems = keyIn.nextInt();
            
            //Creates an array of LibraryItem objects with the maximum number of items entered by the user.
            LibraryItem[] library = new LibraryItem[maxItems]; 
            System.out.println("What is the maximum number of clients for your library?");
            maxClients = keyIn.nextInt();

            //Creates an array of Client objects with the maximum number of clients entered by the user.
            Client[] clients = new Client[maxClients];
            
            //A do-while loop that allows the user to interact with the library until they choose to quit.
            do {
                displayMainMenu();
                menuChoice = getValidMenuChoice();

                //A switch statement that allows the user to choose an option from 15 options in the main menu.
                switch(menuChoice)
                {
                    //Adds an item to the library by calling the addItem method.
                    //The user is prompted to enter the type of item to add and the choice is validated by the getValidItemChoice method.
                    case 1:
                    
                        System.out.println("Which item would you like to add? (book, journal, or media)");
                        itemChoice = getValidItemChoice();
                        addItem(library, itemChoice);
                        break;
                    
                    //Deletes an item from the library by calling the deleteItem method.
                    //The user is prompted to enter the ID of the item to delete and the choice is validated by the getValidItemID method.
                    case 2:
                        System.out.println("Which item would you like to delete? Please enter its ID.");
                        itemID = getValidItemID();
                        deleteItem(library, itemID);
                        break;
                    
                    //Updates the information of an item in the library by calling the updateItem method.
                    case 3:
                        System.out.println("Which item would you like to update? Please enter its ID.");
                        itemID = getValidItemID();
                        updateItem(library, itemID);
                        break;

                    //Displays the information of a specific category of items in the library by calling the displayItemInfo method.
                    case 4:
                        System.out.println("Which category would you like to list? (book, journal, or media)");
                        itemChoice = getValidItemChoice();
                        displayItemInfo(library, itemChoice);
                        break;

                    //Displays the information of all items in the library by calling the displayLibraryInfo method.
                    case 5:
                        displayLibraryInfo(library);
                        break;

                    //Adds a client to the library by calling the addClient method.
                    case 6:
                        addClient(clients);
                        System.out.println("Client has been added. Here are the clients in the library.");
                        displayClients(clients);
                        break;

                    //Updates the information of a client in the library by calling the editClient method.
                    case 7:
                        editClient(clients);
                        System.out.println("Client has been updated. Here are the clients in the library.");
                        displayClients(clients);
                        break;

                    //Deletes a client from the library by calling the deleteClient method.
                    case 8:
                        deleteClient(clients);
                        System.out.println("Client has been deleted. Here are the clients in the library.");
                        displayClients(clients);
                        break;
                    
                    //Leases an item to a client by calling the leaseItem method.
                    //The user is prompted to enter the ID of the client and the choice is validated by the getValidClientIndex method.
                    case 9:
                        System.out.println("Which client would you like to lease to? Please enter their ID.");
                        if(Client.getNumClients() == 0) //If there are no clients in the library, the user is informed.
                        {
                            System.out.println("There are no clients in this library.");
                            break;
                        }
                        else
                        {
                            clientIndex = getValidClientIndex();
                        }
                        System.out.println("Which item would you like to lease? Please enter its ID.");
                        itemID = getValidItemID();

                        //The leaseItem method is called with the library and itemID as parameters.
                        clients[clientIndex].leaseItem(library, itemID);
                        break;
                    
                    //Returns an item from a client by calling the returnItem method.
                    //The user is prompted to enter the ID of the client and the choice is validated by the getValidClientIndex method.
                    case 10:
                        System.out.println("Which client would you like to return the item for? Please enter their ID.");
                        if(Client.getNumClients() == 0)
                        {
                            System.out.println("There are no clients in this library.");
                            break;
                        }
                        else
                        {
                            clientIndex = getValidClientIndex();
                        }
                        System.out.println("Which item would you like to return? Please enter its ID.");
                        itemID = getValidItemID();

                        //The returnItem method is called with the library and itemID as parameters.
                        clients[clientIndex].returnItem(library, itemID);
                        break;
                    
                    //Displays the items leased by a specific client by calling the displayLeasedItems method.
                    case 11:
                        System.out.println("Which client would you like to see the leased items for? Please enter their ID.");
                        if(Client.getNumClients() == 0)
                        {
                            System.out.println("There are no clients in this library.");
                            break;
                        }
                        else
                        {
                            clientIndex = getValidClientIndex();
                        }

                        //The displayLeasedItems method is called.
                        clients[clientIndex].displayLeasedItems();
                        break;
                    
                    //Displays all the items leased by all clients by calling the displayLeasedItems method.
                    case 12:
                        if(Client.getNumClients() == 0)
                        {
                            System.out.println("There are no clients in this library.");
                            break;
                        }
                        else
                        {   //The displayLeasedItems method is called for each client in the clients array.
                            for(int i = 0; i < clients.length; i++)
                            {
                                if(clients[i] != null)
                                {
                                    clients[i].displayLeasedItems();
                                }
                            }
                        }
                        break;
                    
                    //Displays the biggest book in the library by calling the getBiggestBook method.
                    case 13:
                        System.out.println(getBiggestBook(library));
                        break;
                    
                    //Displays a copy of the list of books in the library by calling the copyBooks method.
                    case 14:
                        LibraryItem[] books = copyBooks(library);
                        for(int i = 0; i < books.length; i++)
                        {
                            if(books[i] != null)
                            {
                                System.out.println(books[i]);
                            }
                        }
                        break;
                    
                    //Quits the program.
                    case 15:
                        System.out.println("Thank you for using FunReadings Library! Goodbye!");
                        System.exit(0);   
                }
            } while (menuChoice != 15); //The loop continues until the user enters 15 to quit the program.

        }

        //If the user chooses to see a demo, the program runs a pre-defined scenario.
        else if(input.equalsIgnoreCase("n"))
        {
            System.out.println("Welcome to the FunReadings Library Demo! The inventory space "
            + "and limit of clients have been automatically set to 100, respectively.");
            maxItems = 100;
            LibraryItem[] library = new LibraryItem[maxItems]; //Creates an array of LibraryItem objects with 100 spaces.
            maxClients = 100;
            Client[] clients = new Client[maxClients]; //Creates an array of Client objects with 100 spaces.

            //Creates 4 Book objects, 4 Journal objects, and 4 Media objects.
            Book book1 = new Book("The Great Gatsby", 1925, 180);
            Book book2 = new Book("To Kill a Mockingbird", 1960, 281);
            Book book3 = new Book("1984", 1949, 328);
            Book book4 = new Book(book1);
            Journal journal1 = new Journal("Nature", 1869, 1);
            Journal journal2 = new Journal("Science", 1880, 2);
            Journal journal3 = new Journal("The Lancet", 1823, 3);
            Journal journal4 = new Journal(journal1);
            Media media1 = new Media("The Shawshank Redemption", 1994, "video");
            Media media2 = new Media("The Godfather", 1972, "video");
            Media media3 = new Media("The Dark Knight", 2008, "video");
            Media media4 = new Media(media1);

            //Creates an array of Books, an array of Journals, an array of Media, and an array of LibraryItem objects.
            Book[] books = {book1, book2, book3, book4};
            Journal[] journals = {journal1, journal2, journal3, journal4};
            Media[] media = {media1, media2, media3, media4};
            LibraryItem[] libraryDemo = {book1, book2, book3, book4, journal1, journal2, journal3, journal4, media1, media2, media3, media4};

            System.out.println("\nHere are the books in the library.");
            for(int i = 0; i < books.length; i++)
            {
                System.out.println(books[i]);
            }

            System.out.println("\nHere are the journals in the library.");
            for(int i = 0; i < journals.length; i++)
            {
                System.out.println(journals[i]);
            }

            System.out.println("\nHere are the media items in the library.");
            for(int i = 0; i < media.length; i++)
            {
                System.out.println(media[i]);
            }

            //Tests the equals method for each object.
            if(book1.equals(book2))
            {
                System.out.println(book1.getID() + " and " + book2.getID() + "are the same.");
            }
            else
            {
                System.out.println(book1.getID() + " and " + book2.getID() + " are not the same.");
            
            }

            if(book1.equals(book4))
            {
                System.out.println(book1.getID() + " and " + book4.getID() + " are the same.");
            }
            else
            {
                System.out.println(book1.getID() + " and " + book4.getID() + " are not the same.");
            }

            if(book1.equals(journal1))
            {
                System.out.println(book1.getID() + " and " + journal1.getID() + " are the same.");
            }
            else
            {
                System.out.println(book1.getID() + " and " + journal1.getID() + " are not the same.");
            }

            if(journal1.equals(media1))
            {
                System.out.println(journal1.getID() + " and " + media1.getID() + " are the same.");
            }
            else
            {
                System.out.println(journal1.getID() + " and " + media1.getID() + " are not the same.");
            }

            if(journal1.equals(journal4))
            {
                System.out.println(journal1.getID() + " and " + journal4.getID() + " are the same.");
            }
            else
            {
                System.out.println(journal1.getID() + " and " + journal4.getID() + " are not the same.");
            }

            if(media1.equals(media4))
            {
                System.out.println(media1.getID() + " and " + media4.getID() + " are the same.");
            }
            else
            {
                System.out.println(media1.getID() + " and " + media4.getID() + " are not the same.");
            }   

            //Tests the getBiggestBook method on the libraryDemo array.
            System.out.println("\n"+getBiggestBook(libraryDemo));

            //Tests the copyBooks method on the Media array.
            LibraryItem[] booksCopy = copyBooks(media);
            for(int i = 0; i < booksCopy.length; i++)
            {
                if(booksCopy[i] != null)
                    System.out.println(booksCopy[i]);
            }
            
        }
        
        //If the user enters an invalid input, the program will prompt the user to try again.
        else
        {
                System.out.println("Invalid input. Please try again.");
                System.exit(0);
        }

    }


//----The following methods are static methods that are used in the main method to perform various tasks ----//
    
    //Displays the main menu of the program.
    private static void displayMainMenu() {
        System.out.println("What would you like to do?\n1) Add an item\n2) Delete an item\n"
        + "3) Update the information of an item\n4) List all items in a specific category (book, journal, or media)"
        + "\n5) View all items\n6) Add a client\n7) Update a client's information\n8) Delete a client"
        + "\n9) Lease an item to a client\n10) Return an item from a client\n11) Show all items leased by a client"
        + "\n12) Show all leased items(by all clients)\n13) Display the biggest book\n14) Copy list of books\n15) Quit");
    }

    /*
     * This method gets a valid menu choice from the user.
     * Returns an integer representing the user's choice of menu option.
     */
    private static int getValidMenuChoice() {
        Scanner keyIn = new Scanner(System.in);
        int menuChoice = keyIn.nextInt();
        while(menuChoice < 1 || menuChoice > 15)
        {
            System.out.println("Invalid input. Please try again.");
            menuChoice = keyIn.nextInt();
        }
        return menuChoice;
    }

    /*
     * This method gets a valid item choice from the user.
     * Returns a string representing the user's choice of item.
     */
    private static String getValidItemChoice() {
        Scanner keyIn = new Scanner(System.in);
        String itemChoice = keyIn.next();
        while(!(itemChoice.equalsIgnoreCase("book") || 
        itemChoice.equalsIgnoreCase("journal") || 
        itemChoice.equalsIgnoreCase("media")))
        {
            System.out.println("Invalid input. Please try again.");
            itemChoice = keyIn.next();
        }
        return itemChoice;
    }

    /*
     * This method adds an item to the library.
     * Takes the parameter library: The array of LibraryItem objects
     * and the parameter itemToAdd: The type of item to add.
     */
    private static void addItem(LibraryItem[] library, String itemToAdd){
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Please enter the name or title.");
        String itemName = keyIn.nextLine();
        System.out.println("Please enter the year of publication?");
        int itemYear = keyIn.nextInt();
        
        int indexOfNextItem = library.length - findRemainingSpaces(library); //Finds the index of the next item to add.

        
        if(library[library.length-1] == null) //If there is space in the library, the user is prompted to enter the details of the item.
        {
            //The user is prompted to enter the number of pages if the item is a book.
            if(itemToAdd.equalsIgnoreCase("book")) 
            {
                System.out.println("How many pages does the book have?");
                int bookPages = keyIn.nextInt();
                library[indexOfNextItem] = new Book(itemName, itemYear, bookPages);
            }
            //The user is prompted to enter the volume number if the item is a journal.
            else if(itemToAdd.equalsIgnoreCase("journal"))
            {
                System.out.println("What is the volume of the journal?");
                int journalVolume = keyIn.nextInt();
                library[indexOfNextItem] = new Journal(itemName, itemYear, journalVolume);
                
            }
            //The user is prompted to enter the type of media if the item is a media item.
            else if(itemToAdd.equalsIgnoreCase("media"))
            {
                System.out.println("What is the type of media?");
                String typeOfMedia = keyIn.next();

                //The user is prompted to enter a valid type of media.
                while(!(typeOfMedia.equalsIgnoreCase("audio")) && !(typeOfMedia.equalsIgnoreCase("video")) 
                && !(typeOfMedia.equalsIgnoreCase("interactive")))
                {
                    System.out.println("Invalid input. Please try again.");
                    typeOfMedia = keyIn.next();
                }
                library[indexOfNextItem] = new Media(itemName, itemYear, typeOfMedia);
            }
        }
        else
        {
            System.out.println("The library is full. You cannot add any more items.");
        }

    }

    /*
     * This method returns a valid item ID from the user.
     * Returns a string representing the user's choice of item ID.
     */
    private static String getValidItemID() {
        Scanner keyIn = new Scanner(System.in);
        String itemID = keyIn.next();
        while(!(itemID.contains("B") || itemID.contains("J") || itemID.contains("M")))
        {
            System.out.println("Invalid input. Please try again.");
            itemID = keyIn.next();
        }
        return itemID;
    }

    /*
     * This method returns the number of remaining spaces in the library.
     * Takes the parameter library: The array of LibraryItem objects 
     * and the parameter itemToDelete: The ID of the item to delete.
     */
    private static void deleteItem(LibraryItem[] library, String itemToDelete) {

        LibraryItem[] newLibrary; //A new array of LibraryItem objects.
        int j =0; //A counter variable.

        if (findRemainingSpaces(library) == library.length) //If there are no items in the library, the user is informed.
        {
            System.out.println("There are no items in the library.");
        }
        else
        {
            newLibrary = new LibraryItem[library.length];
            if(itemToDelete.contains("B")) //If the item to delete is a book, the user is prompted to enter the ID of the book.
            {
                if (Book.getNumBooks() == 0)
                {
                    System.out.println("There are no books in this library.");
                }
                for(int i = 0; i < library.length; i++)
                {
                    if(library[i] != null)
                    {     
                        if(itemToDelete.equals( library[i].getID()))
                        {
                            library[i] = null;
                        }
                        
                    }
                }
            }
            else if(itemToDelete.contains("J")) //If the item to delete is a journal, the user is prompted to enter the ID of the journal.
            {
                if(Journal.getNumJournals() == 0)
                {
                    System.out.println("There are no journals in this library.");
                }
                for(int i = 0; i < library.length; i++)
                {
                    if(library[i] != null)
                    {   
                        if(itemToDelete.equals( library[i].getID()))
                        {
                            library[i] = null;
                        }

                    }
                }
            }
            else if(itemToDelete.contains("M")) //If the item to delete is a media item, the user is prompted to enter the ID of the media item.
            {
                if(Media.getNumMedia() == 0)
                {
                    System.out.println("There are no media items in this library.");
                }
                for(int i = 0; i < library.length; i++)
                {
                    if(library[i] != null)
                    {   
                        if(itemToDelete.equals( library[i].getID()))
                        {
                            library[i] = null;
                        }
                    }
                }
            }
        
            //The newLibrary array is created and the items are copied over to it.
            for(int i = 0; i < library.length; i++)
            {
                if(library[i] != null) //If the item is not null, it is copied over to the newLibrary array.
                {
                    newLibrary[j] = library[i]; 
                    j++;
                }
            }
            library = newLibrary; //The library array is updated to the newLibrary array.
        
        }

    }

    /*
     * This method updates the information of an item in the library.
     * Takes the parameter library: The array of LibraryItem objects
     * and itemID: The ID of the item to update.
     */
    private static void updateItem(LibraryItem[] library, String itemID) {
        Scanner keyIn = new Scanner(System.in);
        int updateChoice = 0;
        
        //If the itemID represents a Book, the user is prompted to choose an option from the updateBookMenu.
        if(itemID.contains("B"))
        {
           do {
            updateBookMenu(library, itemID); //The user is prompted to choose an option from the updateBookMenu.
            updateChoice = keyIn.nextInt();

            //A switch statement that allows the user to choose an option from 4 options in the updateBookMenu.
            switch(updateChoice)
            {
                case 1: //The user is prompted to enter the new name of the book.
                    System.out.println("What is the new name of the book?");
                    String newName = keyIn.next();
                    String junkString = keyIn.nextLine(); //A junk string to clear the buffer.
                    for(int i = 0; i < library.length; i++)
                    {
                        if(library[i] != null)
                        {   
                            if(itemID.equals(library[i].getID()))
                            {
                                (library[i]).setName(newName);
                            }
                        }
                    }
                    break;

                case 2: //The user is prompted to enter the new year of publication of the book.
                    System.out.println("What is the new year of publication?");
                    int newYear = keyIn.nextInt();
                    for(int i = 0; i < library.length; i++)
                    {
                        if(library[i] != null)
                        {     
                            if(itemID.equals(library[i].getID()))
                            {
                                (library[i]).setYearOfPublication(newYear);
                            }
                        }
                    }
                    break;

                case 3: //The user is prompted to enter the new number of pages of the book.
                    System.out.println("What is the new number of pages?");
                    int newPages = keyIn.nextInt();
                    for(int i = 0; i < library.length; i++)
                    {
                        if(library[i] != null)
                        {   
                            if(library[i].getClass() == Book.class)
                            {    
                                if(itemID.equals( ((Book)library[i]).getID()))
                                {
                                    ((Book)library[i]).setNumberOfPages(newPages);
                                }
                            }
                        }
                    }
                    break;

                case 4: //The user chooses to quit the updateBookMenu.
                    break;

                default: //If the user enters an invalid input, they are prompted to try again.
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
           } while(updateChoice!=4); //The loop continues until the user enters 4 to quit the updateBookMenu.
           
        }
        //If the itemID represents a Journal, the user is prompted to choose an option from the updateJournalMenu.
        else if(itemID.contains("J"))
        {
            do {
                updateJournalMenu(library, itemID); //The user is prompted to choose an option from the updateJournalMenu.
                updateChoice = keyIn.nextInt();
                //A switch statement that allows the user to choose an option from 4 options in the updateJournalMenu.
                switch(updateChoice)
                {
                    case 1: //The user is prompted to enter the new name of the journal.
                        System.out.println("What is the new name of the journal?");
                        String newName = keyIn.next();
                        String junkString = keyIn.nextLine();
                        for(int i = 0; i < library.length; i++)
                        {
                            if(library[i] != null)
                            {      
                                if (itemID.equals(library[i].getID()))
                                {
                                    (library[i]).setName(newName);
                                }
                            }
                        }
                        break;
    
                    case 2: //The user is prompted to enter the new year of publication of the journal.
                        System.out.println("What is the new year of publication?");
                        int newYear = keyIn.nextInt();
                        for(int i = 0; i < library.length; i++)
                        {
                            if(library[i] != null)
                            {       
                                if(itemID.equals(library[i].getID()))
                                {
                                    (library[i]).setYearOfPublication(newYear);
                                }
                            }
                        }
                        break;
    
                    case 3: //The user is prompted to enter the new volume number of the journal.
                        System.out.println("What is the new volume number?");
                        int newVolume = keyIn.nextInt();
                        for(int i = 0; i < library.length; i++)
                        {
                            if(library[i] != null)
                            {   
                                if(library[i].getClass() == Journal.class)
                                {    
                                    if(itemID.equals( ((Journal)library[i]).getID()))
                                    {
                                        ((Journal)library[i]).setVolumeNum(newVolume);
                                    }
                                }
                            }
                        }
                        break;
    
                    case 4: //The user chooses to quit the updateJournalMenu.
                        break;
    
                    default: //If the user enters an invalid input, they are prompted to try again.
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            } while(updateChoice!=4); //The loop continues until the user enters 4 to quit the updateJournalMenu.

            
        }
        //If the itemID represents a Media item, the user is prompted to choose an option from the updateMediaMenu.
        else if(itemID.contains("M"))
        {
            do {
                updateMediaMenu(library, itemID);
                updateChoice = keyIn.nextInt();
                //A switch statement that allows the user to choose an option from 4 options in the updateMediaMenu.
                switch(updateChoice)
                {
                    case 1: //The user is prompted to enter the new name of the media item.
                        System.out.println("What is the new name of the media?");
                        String newName = keyIn.next();
                        String junkString = keyIn.nextLine();
                        for(int i = 0; i < library.length; i++)
                        {
                            if(library[i] != null)
                            {  
                                if(itemID.equals( library[i].getID()))
                                {
                                    (library[i]).setName(newName);
                                }
                            }
                            
                        }
                        break;
                    case 2: //The user is prompted to enter the new year of publication of the media item.
                        System.out.println("What is the new year of publication?");
                        int newYear = keyIn.nextInt();
                        for(int i = 0; i < library.length; i++)
                        {
                            if(library[i] != null)
                            {   
                                if(itemID.equals( library[i].getID()))
                                {
                                    (library[i]).setYearOfPublication(newYear);
                                }
                            }
                        }
                        break;

                    case 3: //The user is prompted to enter the new type of media.
                        System.out.println("What is the new type of media?");
                        String newType = keyIn.next();
                        for(int i = 0; i < library.length; i++)
                        {
                            if(library[i] != null)
                            {
                                if(library[i].getClass() == Media.class)
                                {    
                                    if(itemID.equals( ((Media)library[i]).getID()))
                                    {
                                        ((Media)library[i]).setType(newType);
                                    }
                                }
                            }
                        }
                        break;

                    case 4: //The user chooses to quit the updateMediaMenu.
                        break;

                    default: //If the user enters an invalid input, they are prompted to try again.
                        System.out.println("Invalid input. Please try again.");
                        break;    

                }
            } while(updateChoice!=4); //The loop continues until the user enters 4 to quit the updateMediaMenu.
        }
    }
    
    /*
     * This method displays the information of a chosen item type in the library.
     * Takes the parameter library: The array of LibraryItem objects 
     * and itemChoice: The type of item to display.
     */
    public static void displayItemInfo(LibraryItem[] library, String itemChoice) {
        char itemType = itemChoice.charAt(0); //The first character of the itemChoice string.
        boolean itemFound = true; //A boolean variable that is true if the item is found in the library.

        //A switch statement that allows the user to choose an option from 3 options in the displayItemInfo method.
        switch(itemType) 
        {
            case 'b': //If the user chooses to display books, the books in the library are displayed.
                System.out.println("Books in the library:");
                for(int i = 0; i < library.length; i++) 
                {
                    //If the item is not null and is a Book object, the item is displayed.
                    if(library[i] != null && library[i].getClass() == Book.class) 
                    {
                        System.out.println(library[i].toString());
                    }
                    //If the item is not null and is not a Book object, the itemFound variable is set to false.
                    else if (library[i] != null && !(library[i].getClass() == Book.class))
                    {
                        itemFound = false;
                    }
                }
                break;

            case 'j': //If the user chooses to display journals, the journals in the library are displayed.
                System.out.println("Journals in the library:");
                for(int i = 0; i < library.length; i++) 
                {
                    //If the item is not null and is a Journal object, the item is displayed.
                    if(library[i] != null && library[i].getClass() == Journal.class) {
                        System.out.println(library[i].toString());
                    }
                    //If the item is not null and is not a Journal object, the itemFound variable is set to false.
                    else if (library[i] != null && !(library[i].getClass()== Journal.class))
                    {
                        itemFound = false;
                    }
                }
              
                break;

            case 'm': //If the user chooses to display media items, the media items in the library are displayed.
                System.out.println("Media in the library:");
                for(int i = 0; i < library.length; i++) 
                {
                    //If the item is not null and is a Media object, the item is displayed.
                    if(library[i] != null && library[i].getClass()== Media.class) {
                        System.out.println(library[i].toString());
                    }
                    //If the item is not null and is not a Media object, the itemFound variable is set to false.
                    else if (library[i] != null && !(library[i].getClass() == Media.class))
                    {
                        itemFound = false;
                    }
                }
                break;

            default: //If the user enters an invalid input, they are prompted to try again.
                System.out.println("Invalid input. Please try again.");
                break;
                
        }
        //If the itemFound variable is false, the user is informed that there are no items of that type in the library.
        if(itemFound == false) 
        {
            System.out.println("There are no items of this type in the library.");
        }
    }

    /*
     * This method displays the information of all items in the library.
     */
    private static void displayLibraryInfo(LibraryItem[] library) {
       
        //A for loop that goes through the library array and displays the information of each item.
        for(int i = 0; i < library.length; i++)
        {
            if(library[i] != null) //If the item is not null, the item is displayed.
            {
                System.out.println(library[i]);
            }
           
        }
        //If there are no items in the library, the user is informed.
        if (findRemainingSpaces(library) == library.length)
        {
            System.out.println("There are no items in the library.");
        }
    }

    /*
     * This method gets a valid client ID from the user.
     * Returns a string representing the user's choice of client ID.
     */
    private static String getValidClientID()
    {
        Scanner keyIn = new Scanner(System.in);
        String clientID = keyIn.next();

        //The user is prompted to enter a valid client ID. All client IDs start with the letter "C".
        while(!(clientID.contains("C")))
        {
            System.out.println("Invalid input. Please try again.");
            clientID = keyIn.next();
        }
        return clientID;
    }

    /*
     * This method returns a valid client index based on the valid client ID from user.
     * The index is used to access the client in the clients array.
     * Returns an integer representing the user's choice of client index.
     */
    private static int getValidClientIndex() 
    {
        //The user is prompted to enter a valid client ID.
        String clientID = getValidClientID();

        //The client index is calculated based on the client ID.
        int clientIndex = Integer.parseInt(clientID.substring(1))-1;
        return clientIndex;
    }

    /*
     * This method adds a client to the library.
     * Takes the parameter clients: The array of Client objects.
     */
    private static void addClient(Client[] clients) {
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Please enter the name of the client."); 
        String clientName = keyIn.nextLine();
        System.out.println("Please enter the phone number of the client.");

        //The user is prompted to enter a valid phone number.
        while(!keyIn.hasNextLong())
        {
            System.out.println("Invalid input. Please try again.");
            keyIn.nextLong();
        }
        long clientPhone = keyIn.nextLong();
        System.out.println("Please enter the email of the client.");
        String clientEmail = keyIn.next();

        //The index of the next client is calculated based on the number of clients in the clients array.
        int indexOfNextClient = Client.getNumClients();

        //If there is space in the clients array, the user is prompted to enter the details of the client.
        if(clients[clients.length-1] == null)
        {
            clients[indexOfNextClient] = new Client(clientName, clientPhone, clientEmail);
        }
        else
        {
            System.out.println("The client list is full. You cannot add any more clients.");
        }
    }

    /*
     * This method edits the information of a client in the library.
     * Takes the parameter clients: The array of Client objects.
     */
    private static void editClient(Client[] clients) {
        System.out.println("Which client would you like to update? Please enter their ID.");
        Scanner keyIn = new Scanner(System.in);
        String clientID = getValidClientID();
        int updateChoice = 0;

        //If there are no clients in the library, the user is informed.
        if(Client.getNumClients() ==0)
        {
            System.out.println("There are no clients in this library.");
        }
        //If there are clients in the library, the user is prompted to enter the ID of the client to update.
        else
        {
            for(int i = 0; i < clients.length; i++)
            {
                //If the clientID is found in the clients array, the user is prompted to choose an option from the updateClientMenu.
                if(clients[i] != null)
                {
                    if(clientID.equals(clients[i].getClientID()))
                    {
                        //A do-while loop that allows the user to choose an option from 4 options in the updateClientMenu.
                        do {
                            updateClientMenu();
                            updateChoice = keyIn.nextInt();

                            //A switch statement that allows the user to choose an option from 4 options in the updateClientMenu.
                            switch(updateChoice)
                            {
                                //The user is prompted to enter the new name of the client.
                                case 1:
                                    System.out.println("What is the new name of the client?");
                                    String junkString = keyIn.nextLine();
                                    String newName = keyIn.nextLine();
                                    clients[i].setName(newName);
                                    break;
                                //The user is prompted to enter the new phone number of the client.
                                case 2:
                                    System.out.println("What is the new phone number of the client?");
                                    int newPhone = keyIn.nextInt();
                                    clients[i].setPhoneNum(newPhone);
                                    break;
                                //The user is prompted to enter the new email of the client.
                                case 3:
                                    System.out.println("What is the new email of the client?");
                                    String newEmail = keyIn.next();
                                    clients[i].setEmail(newEmail);
                                    break;
                                //The user chooses to quit the updateClientMenu.
                                case 4:
                                    break;
                                //If the user enters an invalid input, they are prompted to try again.
                                default:
                                    System.out.println("Invalid input. Please try again.");
                                    break;
                            }
                        } while(updateChoice!=4);
                    }
                }
            }
        }
    }

    /*
     * This method deletes a client from the library.
     * Takes the parameter clients: The array of Client objects.
     */
    private static void deleteClient(Client[] clients) {
        System.out.println("Which client would you like to delete? Please enter their ID.");
        Scanner keyIn = new Scanner(System.in);
        String clientID = getValidClientID();
        Client[] newClients = new Client[clients.length]; //A new array of Client objects.
        int j =0; //A counter variable.

        //If there are no clients in the library, the user is informed.
        if(Client.getNumClients() == 0)
        {
            System.out.println("There are no clients in this library.");
        }
        //If there are clients in the library, the user is prompted to enter the ID of the client to delete.        
        else
        {
            //A for loop that goes through the clients array and deletes the client with the given clientID.
            for(int i = 0; i < clients.length; i++)
            {
                if(clients[i] != null)
                {
                    if(clientID.equals(clients[i].getClientID()))
                    {
                        clients[i] = null; //The client is deleted from the clients array.
                    }
                }
            }
        }

        //The newClients array is created and the clients are copied over to it.
        for(int i = 0; i < clients.length; i++)
        {
            if(clients[i] != null) //If the client is not null, it is copied over to the newClients array.
            {
                newClients[j] = clients[i]; 
                j++;
            }
        }
        clients = newClients; //The clients array is updated to the newClients array.
    }

    /*
     * This method returns the biggest book in the library.
     * Takes the parameter library: The array of LibraryItem objects.
     * Returns a string representing the biggest book in the library.
     */
    private static String getBiggestBook(LibraryItem[] library) {
        Book[] books = new Book[library.length]; //Created an array of Book objects with the same length as the library array.

        //A for loop that goes through the library array and copies the books to the books array.
        for (int i = 0; i < library.length; i++) {
            if (library[i] != null && library[i].getClass() == Book.class) 
            {
                books[i] = (Book) library[i];
            }
        }
        //The biggestBook variable is set to the first book in the books array.
        Book biggestBook = books[0];
        //A for loop that goes through the books array and finds the biggest book.
        for (int i = 0; i < books.length; i++) 
        {
            //If the book is not null and has more pages than the current biggestBook, the biggestBook is set to the book.
            if (books[i] != null && books[i].getNumberOfPages() > biggestBook.getNumberOfPages())
            {
                
                biggestBook = books[i]; //The biggestBook is set to the book found.
            }
        }

        return "The biggest book in the library is " + biggestBook.getName() + ".";
    }

    /*
     * This method returns a copy of the books in the library.
     * Will not work for journals or media.
     * Takes the parameter books: The array of LibraryItem objects.
     * Returns an array of Book objects.
     */
    private static Book[] copyBooks(LibraryItem[] books) {
        Boolean isBook = true; //A boolean variable that is true if the item is a book.
        Book[] booksCopy = new Book[books.length]; //An array of Book objects with the same length as the books array.
        
        //A for loop that goes through the books array and copies the books to the booksCopy array.
        for (int i = 0; i < books.length; i++) 
        {
            //If the book is not null and is a Book object, the book is copied to the booksCopy array.
            if (books[i] != null && books[i].getClass() == Book.class) 
            {
                booksCopy[i] = (Book) books[i]; //The book is copied to the booksCopy array.
            }
            //If the book is not null and is not a Book object, the isBook variable is set to false.
            else if(books[i] != null && books[i].getClass() != Book.class)
            {
                isBook = false;
            }
        }
        //If the item is not a book, the user is informed that they cannot copy journals or media using this method.
        if(isBook == false)
        {
            System.out.println("Cannot copy journals or media using this method.");
        }
        else
        {
            System.out.println("Here is a copy of the books in the library.");
        }
        return booksCopy;
        
    }

    /*
     * This method displays the update client menu.
     */
    private static void updateClientMenu() {
        System.out.print("\nWhat information would you like to change?" +
        "\n\t1. Name\n\t2. Phone number\n\t3. Email\n\t4. Quit\nEnter your choice > ");
    }

    /*
     * This method displays the update media menu.
     * Takes the parameter library: The array of LibraryItem objects and the itemID of the item to update.
     * Takes the parameter itemID: The ID of the item to update.
     */
    private static void updateMediaMenu(LibraryItem[] library, String itemID) {
        System.out.print("\nWhat information would you like to change?" +
        "\n\t1. Name\n\t2. Year of Publication\n\t3. Type of media (audio/video/interactive)"+
        "\n\t4. Quit\nEnter your choice > ");
    }

    /*
     * This method displays the update journal menu.
     * Takes the parameter library: The array of LibraryItem objects and the itemID of the item to update.
     * Takes the parameter itemID: The ID of the item to update.
     */
    private static void updateJournalMenu(LibraryItem[] library, String itemID) {
        System.out.print("\nWhat information would you like to change?" +
        "\n\t1. Name\n\t2. Year of Publication\n\t3. Volume number\n\t4. Quit\nEnter your choice > ");
    }

    /*
     * This method displays the update book menu.
     * Takes the parameter library: The array of LibraryItem objects and the itemID of the item to update.
     * Takes the parameter itemID: The ID of the item to update.
     */
    private static void updateBookMenu(LibraryItem[] library, String itemID) {
        System.out.print("\nWhat information would you like to change?" +
        "\n\t1. Name\n\t2. Year of Publication\n\t3. Number of pages\n\t4. Quit\nEnter your choice > ");
    }

    /*
     * This method returns the number of remaining spaces in the library.
     * Takes the parameter library: The array of LibraryItem objects.
     * Returns an integer representing the number of remaining spaces in the library.
     */
    private static int findRemainingSpaces(LibraryItem[] library) {
        int remainingSpaces = 0;
        for(int i = 0; i < library.length; i++)
        {
            if(library[i] == null)
            {
                remainingSpaces++;
            }
        }
        return remainingSpaces;
    }

     //A method that displays the information of all clients in the library if there are any.
     private static void displayClients(Client[] clients) {
        
        for(int i = 0; i < clients.length; i++)
        {
            if(clients[i] != null)
            { 
                System.out.println(clients[i]);
            }
        }
    }
 
    
}
