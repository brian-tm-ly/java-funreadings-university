/**
 * The LibraryItem abstract class is the parent class for the Book, Media, and Journal classes. 
 * It contains the name, ID, and year of publication of a library item.
 * Instances of this class cannot be created.
 * @author Brian
 * @version 1.0
 * @see Book
 * @see Media
 * @see Journal
 */

package Library;
public abstract class LibraryItem {

    private static int numLibraryItems = 0;
    protected String name;
    protected String ID;
    protected int yearOfPublication;

    /** 
     * Creates a new instance of LibraryItem with default values. 
     * Takes no arguments.
     */ 
    public LibraryItem() 
    {
        name = "";
        yearOfPublication = 0;
        numLibraryItems++;
        ID = "L" + numLibraryItems;
    }

    /**
     * Creates a new instance of LibraryItem with the specified name and year of publication.
     * @param name The name of the library item as a string.
     * @param yearOfPublication The year the library item was published as an integer.  
     */ 

    public LibraryItem(String name, int yearOfPublication) 
    {
        this.name = name;
        this.yearOfPublication = yearOfPublication;
        numLibraryItems++;
        ID = "L" + numLibraryItems;
    }

    /**
     * Creates a new instance of LibraryItem that is a copy of another LibraryItem.
     * @param otherLibraryItem The LibraryItem object to be copied.
     */

    public LibraryItem(LibraryItem otherLibraryItem) 
    {
        name = otherLibraryItem.name;
        yearOfPublication = otherLibraryItem.yearOfPublication;
        numLibraryItems++;
        ID = "L" + numLibraryItems;
    }

    /**
     * Returns the unique ID of the library item.
     * @return A string representing the unique ID of the library item.
     */
    public String getID()
    {
        return ID;
    }
    
    /**
     * Returns the number of LibraryItems that have been created.
     * @return An int representing the number of LibraryItems that have been created.
     */
    public static int getNumLibraryItems() 
    {
        return numLibraryItems;
    }

    /**
     * Returns the name of the library item.
     * @return A string representing the name of the library item.
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Sets the name of the library item.
     * @param name The new name of the library item as a string.
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
    /**
     * Returns the year of publication of the library item.
     * @return An int representing the year of publication of the library item.
     */
    public int getYearOfPublication() 
    {
        return yearOfPublication;
    }

    /**
     * Sets the year of publication of the library item.
     * @param yearOfPublication The new year of publication of the library item as an int.
     */
    public void setYearOfPublication(int yearOfPublication) 
    {
        this.yearOfPublication = yearOfPublication;
    }

    /**
     * Compares the library item to another object to see if they are equal.
     * @param otherObject The object to compare to the library item.
     * @return A boolean value of true if the objects are equal and false if they are not.
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
            LibraryItem otherLibraryItem = (LibraryItem) otherObject;
            return (name.equals(otherLibraryItem.name) && yearOfPublication == otherLibraryItem.yearOfPublication);
        }

    }

    /**
     * Returns a string representation of the library item.
     * @return A string representing the information of the library item.
     */
    @Override
    public String toString() {
        return "This library item's name is " + name + ". It was published in " +  yearOfPublication + ".";
    }
    
}
