/**
 * Book class is a subclass of LibraryItem. 
 * It contains a unique bookID, and a number of pages.
 * @author Brian
 * @version 1.0
 * @see LibraryItem
 * @see Media
 * @see Journal
 */

package Library;

public class Book extends LibraryItem {
    private static int numBooks = 0;
    private String bookID;
    private int numberOfPages;

    public Book()
    {
        numBooks++;
        numberOfPages = 0;
        bookID = "B" + numBooks;
    }

    public Book(String name, int yearOfPublication, int numberOfPages)
    {
        super(name, yearOfPublication);
        numBooks ++;
        this.numberOfPages = numberOfPages;
        bookID = "B" + numBooks;
            
    }

    public Book(Book otherBook)
    {
        super(otherBook.name, otherBook.yearOfPublication);
        numBooks++;
        numberOfPages = otherBook.numberOfPages;
        bookID = "B" + numBooks;

    }
    
    public static int getNumBooks()
    {
        return numBooks;
    }

    @Override
    public String getID()
    {
        return bookID;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else
        {
            Book otherBook = (Book) otherObject;
            return (name.equals(otherBook.name) && yearOfPublication == otherBook.yearOfPublication 
                && numberOfPages == otherBook.numberOfPages);
        }
    }

    @Override
    public String toString()
    {
        return bookID+ ": " + name + ". Published in " + yearOfPublication + ". It has " + numberOfPages + " pages.";
    }

    
    
}
