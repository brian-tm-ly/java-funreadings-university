package Driver;
import Library.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        
        Scanner keyIn = new Scanner(System.in);
        int maxItems = 0;
        String junkString;

        System.out.println("Do you want to see the menu or run a demo of the program? (y/n)");

        if( keyIn.next().contains("y") || keyIn.next().contains("Y") )
        {
            System.out.println("Welcome to the FunReadings Library! " +
            "\nWhat is the maximum number of items for your inventory?");   
            maxItems = keyIn.nextInt();
            LibraryItem[] library = new LibraryItem[maxItems]; 
            displayMainMenu();
            int menuChoice = keyIn.nextInt();

            switch(menuChoice)
            {
                case 1:
                   
                    System.out.println("Which item would you like to add? (book, journal, or media)");
                    String itemToAdd = keyIn.next();

                    while(!(itemToAdd.equalsIgnoreCase("book") || 
                        itemToAdd.equalsIgnoreCase("journal") || 
                        itemToAdd.equalsIgnoreCase("media")))
                    {
                        System.out.println("Invalid input. Please try again.");
                        itemToAdd = keyIn.next();
                    }
                    System.out.println("Please enter the name or title.");
                    junkString = keyIn.nextLine();
                    String itemName = keyIn.nextLine();
                    System.out.println("Please enter the year of publication?");
                    int itemYear = keyIn.nextInt();
                    if(itemToAdd.equalsIgnoreCase("book"))
                    {
                        System.out.println("How many pages does the book have?");
                        int bookPages = keyIn.nextInt();
                        for(int i = 0; i < library.length; i++)
                        {
                            library[i] = new Book(itemName, itemYear, bookPages);
                        }
                    }
                    else if(itemToAdd.equalsIgnoreCase("journal"))
                    {
                        System.out.println("What is the volume of the journal?");
                        int journalVolume = keyIn.nextInt();
                        for(int i = 0; i < library.length; i++)
                        {
                            library[i] = new Journal(itemName, itemYear, journalVolume);
                        }
                    }
                    else if(itemToAdd.equalsIgnoreCase("media"))
                    {
                        System.out.println("What is the type of media?");
                        String typeOfMedia = keyIn.next();
                        for(int i = 0; i < library.length; i++)
                        {
                            library[i] = new Media(itemName, itemYear, typeOfMedia);
                        }
                    }
                    break;
                
                case 2:
                    System.out.println("Which item would you like to delete? Please enter its ID.");
                    String itemToDelete = keyIn.next();
                    while(!(itemToDelete.contains("B") || itemToDelete.contains("J") || itemToDelete.contains("M")))
                    {
                        System.out.println("Invalid input. Please try again.");
                        itemToDelete = keyIn.next();
                    }
                    for(int i = 0; i < library.length; i++)
                    {
                        deleteItem(library, itemToDelete);
                    }
                    break;




            }

        }

        else if( keyIn.next().contains("n") || keyIn.next().contains("N") )
        {

        }
            
        else
        {
                System.out.println("Invalid input. Please try again.");
                System.exit(0);
        }

    }

    private static LibraryItem[] deleteItem(LibraryItem[] library, String itemToDelete) {
        LibraryItem[] newLibrary = new LibraryItem[library.length - 1];
        
       
        if(itemToDelete.contains("B"))
        {
            for(int i = 0; i < library.length; i++)
            {
                if(itemToDelete.equals( ((Book)library[i]).getBookID()))
                {
                    library[i] = null;
                }
            }
        }
        else if(itemToDelete.contains("J"))
        {
            for(int i = 0; i < library.length; i++)
            {
                if(itemToDelete.equals( ((Journal)library[i]).getJournalID()))
                {
                    library[i] = null;
                }
            }
        }
        else if(itemToDelete.contains("M"))
        {
            for(int i = 0; i < library.length; i++)
            {
                if(itemToDelete.equals( ((Media)library[i]).getMediaID()))
                {
                    library[i] = null;
                }
            }
        }
        
        for(int i = 0; i < library.length; i++)
        {
            if(library[i] != null)
            {
                newLibrary[i] = library[i];
            }
        }
        return newLibrary;
    }

    private static void displayMainMenu() {
        System.out.println("What would you like to do?\n1) Add an item\n2) Delete an item\n"
        + "3) Update the information of an item\n4) List all items in a specific category(book, journal, or media)"
        + "\n5) View all items\n6) Add a client\n7) Update a client's information\n8) Delete a client"
        + "\n9) Lease an item to a client\n10) Return an item from a client\n11) Show all items leased by a client"
        + "\n12) Show all leased items(by all clients)\n13) Display the biggest book\n14) Copy list of books");
    }
    
}
