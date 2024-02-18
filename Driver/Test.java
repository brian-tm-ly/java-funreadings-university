package Driver;
import Library.*;
import Client.*;

public class Test {
    public static void main(String[] args) {
        LibraryItem book1 = new Library.Book("The Hobbit", 1937, 310);
        LibraryItem book2 = new Library.Book("The Hobbit", 1937, 310);
        LibraryItem journal1 = new Library.Journal("Nature", 1869, 1);
        LibraryItem journal2 = new Library.Journal("Nature", 1869, 1);
        Client client1 = new Client("John", 12345678,"email");
        LibraryItem[] library = {book1, book2, journal1, journal2};

        System.out.println(book1.getID());
        System.out.println(journal1.getID());
    }
}
