package Driver;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        
        Scanner keyIn = new Scanner(System.in);

        System.out.println("Do you want to see the menu or run a demo of the program?");

        if( keyIn.next().contains("y") || keyIn.next().contains("Y") )
        {
            displayMenu();
        }

        else
        {

        }

    }

    private static void displayMenu() {
        System.out.println("What would you like to do?\n1) Add an item\n2) Delete an item\n"
        + "3) Update the information of an item\n4) List all items in a specific category(book, journal, or media)"
        + "\n5) View all items\n6) Add a client\n7) Update a client's information\n8) Delete a client"
        + "\n9) Lease an item to a client\n10) Return an item from a client\n11) Show all items leased by a client"
        + "\n12) Show all leased items(by all clients)\n13) Display the biggest book\n14) Copy list of books");
    }
    
}
