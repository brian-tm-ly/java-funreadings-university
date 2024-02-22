package Driver;
import Library.*;
import Client.Client;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        
        Scanner keyIn = new Scanner(System.in);
        String input;
        int maxItems = 0;
        String itemID;
        int clientIndex;
        String itemChoice;
        String junkString;
        int menuChoice=0;
        int remainingItems = 0;
        int maxClients = 0;

        System.out.println("Would you like to run the program or see a demo?" +
            " (Please enter y to run the program or n to see a demo.)");
        input = keyIn.next();
        
        if(input.equalsIgnoreCase("y"))
        {
            System.out.println("Welcome to the FunReadings Library! To get started, the inventory space"
            + "and limit of clients will need to be entered." +
            "\nWhat is the maximum number of items for your inventory?");   
            maxItems = keyIn.nextInt();
            LibraryItem[] library = new LibraryItem[maxItems]; 
            System.out.println("What is the maximum number of clients for your library?");
            maxClients = keyIn.nextInt();
            Client[] clients = new Client[maxClients];
            
            do {
                displayMainMenu();
                menuChoice = getValidMenuChoice();

            
                switch(menuChoice)
                {
                    case 1:
                    
                        System.out.println("Which item would you like to add? (book, journal, or media)");
                        itemChoice = getValidItemChoice();
                       
                        addItem(library, itemChoice);
                        break;
                    
                    case 2:
                        System.out.println("Which item would you like to delete? Please enter its ID.");
                        itemID = getValidItemID();
                    
                        deleteItem(library, itemID);
                        
                        break;
                    
                    case 3:
                        System.out.println("Which item would you like to update? Please enter its ID.");
                        itemID = getValidItemID();
                        
                        updateItem(library, itemID);
                        break;

                    case 4:
                        System.out.println("Which category would you like to list? (book, journal, or media)");
                        itemChoice = getValidItemChoice();
                        displayItemInfo(library, itemChoice);
                        break;

                    case 5:
                        displayLibraryInfo(library);
                        break;

                    case 6:
                        addClient(clients);
                        for(int i = 0; i < clients.length; i++)
                        {
                            if(clients[i] != null)
                            { 
                                System.out.println(clients[i]);
                            }
                        }
                        break;
                    
                    case 7:
                        editClient(clients);
                        for(int i = 0; i < clients.length; i++)
                        {
                            if(clients[i] != null)
                            { 
                                System.out.println(clients[i]);
                            }
                        }
                        break;
                    
                    case 8:
                        deleteClient(clients);
                        for(int i = 0; i < clients.length; i++)
                        {
                            if(clients[i] != null)
                            { 
                                System.out.println(clients[i]);
                            }
                        }
                        break;
                    
                    case 9:
                        System.out.println("Which client would you like to lease to? Please enter their ID.");
                        if(Client.getNumClients() == 0)
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
                        clients[clientIndex].leaseItem(library, itemID);
                        break;
                    
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
                        clients[clientIndex].returnItem(library, itemID);
                        break;
                    
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
                        clients[clientIndex].displayLeasedItems();
                        break;
                    
                    case 12:
                        if(Client.getNumClients() == 0)
                        {
                            System.out.println("There are no clients in this library.");
                            break;
                        }
                        else
                        {
                            for(int i = 0; i < clients.length; i++)
                            {
                                if(clients[i] != null)
                                {
                                    clients[i].displayLeasedItems();
                                }
                            }
                        }
                        break;
                    
                    case 13:
                        System.out.println(getBiggestBook(library));
                        break;
                    
                    case 14:
                        Book[] books = copyBooks(library);
                        for(int i = 0; i < books.length; i++)
                        {
                            if(books[i] != null)
                            {
                                System.out.println(books[i].toString());
                            }
                        }
                        break;

                    case 15:
                        System.out.println("Thank you for using FunReadings Library! Goodbye!");
                        System.exit(0);   
                }
            } while (menuChoice != 15);

        }
  
        else if(input.equalsIgnoreCase("n"))
        {
            System.out.println("Welcome to the FunReadings Library Demo! The inventory space "
            + "and limit of clients have been automatically set to 100, respectively.");
            maxItems = 100;
            LibraryItem[] library = new LibraryItem[maxItems];
            maxClients = 100;
            Client[] clients = new Client[maxClients];
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

            System.out.println("\n"+getBiggestBook(libraryDemo));

            System.out.println("\nHere is a copy of the books in the library.");
            //Call copyBooks on Media or on Books??
            
        }
            
        else
        {
                System.out.println("Invalid input. Please try again.");
                System.exit(0);
        }

    }

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


    private static String getBiggestBook(LibraryItem[] library) {
        
        Book[] books = new Book[library.length];
        for (int i = 0; i < library.length; i++) {
            if (library[i] != null && library[i].getClass() == Book.class) 
            {
                books[i] = (Book) library[i];
            }
        }

        Book biggestBook = books[0];
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getNumberOfPages() > biggestBook.getNumberOfPages())
            {
                
                biggestBook = books[i];
            }
        }

        return "The biggest book in the library is " + biggestBook.getName() + ".";
    }


    private static Book[] copyBooks(LibraryItem[] books) {
        
        Book[] copyOfBooks = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getClass() == Book.class) 
            {
                copyOfBooks[i] = (Book) books[i];
            }
        }
        return copyOfBooks;
    }


    private static String getValidClientID()
    {
        Scanner keyIn = new Scanner(System.in);
        String clientID = keyIn.next();
        while(!(clientID.contains("C")))
        {
            System.out.println("Invalid input. Please try again.");
            clientID = keyIn.next();
        }
        return clientID;
    }


    private static int getValidClientIndex() 
    {
        String clientID = getValidClientID();
        int clientIndex = Integer.parseInt(clientID.substring(1))-1;
        return clientIndex;
    }

    private static void deleteClient(Client[] clients) {
        System.out.println("Which client would you like to delete? Please enter their ID.");
        Scanner keyIn = new Scanner(System.in);
        String clientID = getValidClientID();

        if(Client.getNumClients() == 0)
        {
            System.out.println("There are no clients in this library.");
        }
        else
        {
            for(int i = 0; i < clients.length; i++)
            {
                if(clients[i] != null)
                {
                    if(clientID.equals(clients[i].getClientID()))
                    {
                        clients[i] = null;
                    }
                }
            }
        }

        for(int i = 0; i < clients.length; i++)
        {
            if(clients[i] != null)
            {
                if(clientID.equals(clients[i].getClientID()))
                {
                    clients[i] = null;
                }
            }
        }
    }

    private static void editClient(Client[] clients) {
        System.out.println("Which client would you like to update? Please enter their ID.");
        Scanner keyIn = new Scanner(System.in);
        String clientID = getValidClientID();
        int updateChoice = 0;

        if(Client.getNumClients() ==0)
        {
            System.out.println("There are no clients in this library.");
        }
        else
        {
            for(int i = 0; i < clients.length; i++)
            {
                if(clients[i] != null)
                {
                    if(clientID.equals(clients[i].getClientID()))
                    {
                        do {
                            updateClientMenu();
                            updateChoice = keyIn.nextInt();
                            switch(updateChoice)
                            {
                                case 1:
                                    System.out.println("What is the new name of the client?");
                                    String junkString = keyIn.nextLine();
                                    String newName = keyIn.nextLine();
                                    clients[i].setName(newName);
                                    break;
                                case 2:
                                    System.out.println("What is the new phone number of the client?");
                                    int newPhone = keyIn.nextInt();
                                    clients[i].setPhoneNum(newPhone);
                                    break;
                                case 3:
                                    System.out.println("What is the new email of the client?");
                                    String newEmail = keyIn.next();
                                    clients[i].setEmail(newEmail);
                                    break;
                                case 4:
                                    break;
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

    private static void updateClientMenu() {
        System.out.print("\nWhat information would you like to change?" +
        "\n\t1. Name\n\t2. Phone number\n\t3. Email\n\t4. Quit\nEnter your choice > ");
    }

    private static void addClient(Client[] clients) {
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Please enter the name of the client."); 
        String clientName = keyIn.nextLine();
        System.out.println("Please enter the phone number of the client.");
        while(!keyIn.hasNextLong())
        {
            System.out.println("Invalid input. Please try again.");
            keyIn.nextLong();
        }
        long clientPhone = keyIn.nextLong();
        System.out.println("Please enter the email of the client.");
        String clientEmail = keyIn.next();
        int indexOfNextClient = Client.getNumClients();

        if(clients[clients.length-1] == null)
        {
            clients[indexOfNextClient] = new Client(clientName, clientPhone, clientEmail);
        }
        else
        {
            System.out.println("The client list is full. You cannot add any more clients.");
        }
    }

    private static void displayItemInfo(LibraryItem[] library, String itemChoice) {
        char itemType = itemChoice.charAt(0);
        boolean itemFound = true;
        switch(itemType) 
        {
            case 'b':
                System.out.println("Books in the library:");
                for(int i = 0; i < library.length; i++) 
                {
                    if(library[i] != null && library[i].getClass() == Book.class) {
                        System.out.println(library[i].toString());
                    }
                    else if (library[i] != null && !(library[i].getClass() == Book.class))
                    {
                        itemFound = false;
                    }
                }
                break;

            case 'j':
                System.out.println("Journals in the library:");
                for(int i = 0; i < library.length; i++) 
                {
                    if(library[i] != null && library[i].getClass() == Journal.class) {
                        System.out.println(library[i].toString());
                    }
                    else if (library[i] != null && !(library[i].getClass()== Journal.class))
                    {
                        itemFound = false;
                    }
                }
              
                break;

            case 'm':
                System.out.println("Media in the library:");
                for(int i = 0; i < library.length; i++) 
                {
                    if(library[i] != null && library[i].getClass()== Media.class) {
                        System.out.println(library[i].toString());
                    }
                    else if (library[i] != null && !(library[i].getClass() == Media.class))
                    {
                        itemFound = false;
                    }
                }
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
                
        }
    }

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

    private static void displayLibraryInfo(LibraryItem[] library) {
       
        for(int i = 0; i < library.length; i++)
        {
            if(library[i] != null)
            {
                System.out.println(library[i].toString());
            }
           
        }
        if (findRemainingSpaces(library) == library.length)
        {
            System.out.println("There are no items in the library.");
        }
    }

    private static void updateItem(LibraryItem[] library, String itemID) {
        Scanner keyIn = new Scanner(System.in);
        int updateChoice = 0;
        
        if(itemID.contains("B"))
        {
           do {
            updateBookMenu(library, itemID);
            updateChoice = keyIn.nextInt();
            switch(updateChoice)
            {
                case 1:
                    System.out.println("What is the new name of the book?");
                    String newName = keyIn.next();
                    String junkString = keyIn.nextLine();
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

                case 2:
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

                case 3:
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

                case 4:
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
           } while(updateChoice!=4);
           
        }
        else if(itemID.contains("J"))
        {
            do {
                updateJournalMenu(library, itemID);
                updateChoice = keyIn.nextInt();
                switch(updateChoice)
                {
                    case 1:
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
    
                    case 2:
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
    
                    case 3:
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
    
                    case 4:
                        break;
    
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            } while(updateChoice!=4);

            
        }
        else if(itemID.contains("M"))
        {
            do {
                updateMediaMenu(library, itemID);
                updateChoice = keyIn.nextInt();
                switch(updateChoice)
                {
                    case 1:
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
                    case 2:
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
                    case 3:
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
                }
            } while(updateChoice!=4);
        }
    }

    private static void updateMediaMenu(LibraryItem[] library, String itemID) {
        System.out.print("\nWhat information would you like to change?" +
        "\n\t1. Name\n\t2. Year of Publication\n\t3. Type of media (audio/video/interactive)"+
        "\n\t4. Quit\nEnter your choice > ");
    }

    private static void updateJournalMenu(LibraryItem[] library, String itemID) {
        System.out.print("\nWhat information would you like to change?" +
        "\n\t1. Name\n\t2. Year of Publication\n\t3. Volume number\n\t4. Quit\nEnter your choice > ");
    }

    private static void updateBookMenu(LibraryItem[] library, String itemID) {
        System.out.print("\nWhat information would you like to change?" +
        "\n\t1. Name\n\t2. Year of Publication\n\t3. Number of pages\n\t4. Quit\nEnter your choice > ");
    }

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

    private static void deleteItem(LibraryItem[] library, String itemToDelete) {

        LibraryItem[] newLibrary;
        int j =0;

        if (findRemainingSpaces(library) == library.length)
        {
            System.out.println("There are no items in the library.");
        }
        else
        {
            newLibrary = new LibraryItem[library.length];
            if(itemToDelete.contains("B"))
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
            else if(itemToDelete.contains("J"))
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
            else if(itemToDelete.contains("M"))
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
        
            for(int i = 0; i < library.length; i++)
            {
                if(library[i] != null)
                {
                    newLibrary[j] = library[i];
                    j++;
                }
            }
            library = newLibrary;
        
        }

    }
    
    private static void addItem(LibraryItem[] library, String itemToAdd){
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Please enter the name or title.");
        String itemName = keyIn.nextLine();
        System.out.println("Please enter the year of publication?");
        int itemYear = keyIn.nextInt();
        
        int indexOfNextItem = library.length - findRemainingSpaces(library);

        if(library[library.length-1] == null)
        {
            if(itemToAdd.equalsIgnoreCase("book"))
            {
                System.out.println("How many pages does the book have?");
                int bookPages = keyIn.nextInt();
                library[indexOfNextItem] = new Book(itemName, itemYear, bookPages);
            }
            else if(itemToAdd.equalsIgnoreCase("journal"))
            {
                System.out.println("What is the volume of the journal?");
                int journalVolume = keyIn.nextInt();
                library[indexOfNextItem] = new Journal(itemName, itemYear, journalVolume);
                
            }
            else if(itemToAdd.equalsIgnoreCase("media"))
            {
                System.out.println("What is the type of media?");
                String typeOfMedia = keyIn.next();
                while(typeOfMedia.equalsIgnoreCase("audio") || typeOfMedia.equalsIgnoreCase("video") 
                || typeOfMedia.equalsIgnoreCase("interactive"))
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





    private static void displayMainMenu() {
        System.out.println("What would you like to do?\n1) Add an item\n2) Delete an item\n"
        + "3) Update the information of an item\n4) List all items in a specific category (book, journal, or media)"
        + "\n5) View all items\n6) Add a client\n7) Update a client's information\n8) Delete a client"
        + "\n9) Lease an item to a client\n10) Return an item from a client\n11) Show all items leased by a client"
        + "\n12) Show all leased items(by all clients)\n13) Display the biggest book\n14) Copy list of books\n15) Quit");
    }
    
}
