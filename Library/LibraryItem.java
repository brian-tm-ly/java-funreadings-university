package Library;

public class LibraryItem {

    private static int numLibraryItems = 0;
    protected String name;
    protected String ID;
    protected int yearOfPublication;

    public LibraryItem() 
    {
        name = "";
        yearOfPublication = 0;
        numLibraryItems++;
        ID = "L" + numLibraryItems;
    }

    public LibraryItem(String name, int yearOfPublication) 
    {
        this.name = name;
        this.yearOfPublication = yearOfPublication;
        numLibraryItems++;
        ID = "L" + numLibraryItems;
    }

    public LibraryItem(LibraryItem otherLibraryItem) 
    {
        name = otherLibraryItem.name;
        yearOfPublication = otherLibraryItem.yearOfPublication;
        numLibraryItems++;
        ID = "L" + numLibraryItems;
    }

    public String getID()
    {
        return ID;
    }
    

    public static int getNumLibraryItems() 
    {
        return numLibraryItems;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getYearOfPublication() 
    {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) 
    {
        this.yearOfPublication = yearOfPublication;
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
            LibraryItem otherLibraryItem = (LibraryItem) otherObject;
            return (name.equals(otherLibraryItem.name) && yearOfPublication == otherLibraryItem.yearOfPublication);
        }

    }

    @Override
    public String toString() {
        return "This library item's name is " + name + ". It was published in " +  yearOfPublication + ".";
    }
    
}
