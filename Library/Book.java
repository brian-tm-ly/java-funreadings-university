package Library;

public class Book extends LibraryItem {
    private static int bookID = 0;
    private int numberOfPages;

    public Book()
    {
        bookID++;
        numberOfPages = 0;
    }

    public Book(String name, int yearOfPublication, int numberOfPages)
    {
        super(name, yearOfPublication);
        bookID ++;
        this.numberOfPages = numberOfPages;
    }

    public Book(Book otherBook)
    {
        super(otherBook.name, otherBook.yearOfPublication);
        bookID++;
        numberOfPages = otherBook.numberOfPages;

    }

    public String getBookID()
    {
        return "B" + bookID;
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
        return "This book's ID is " + bookID + ".\nIts name is " + name + ".\n It was published in " 
        + yearOfPublication + ".\nIt has " + numberOfPages + " of pages.";
    }
    
}
