package Library;

public class LibraryItem {

    protected static int ID = 0;
    protected String name;
    protected int yearOfPublication;

    public LibraryItem() 
    {
        ID++;
        name = "";
        yearOfPublication = 0;
    }

    public LibraryItem(String name, int yearOfPublication) 
    {
        ID++;
        this.name = name;
        this.yearOfPublication = yearOfPublication;
    }

    public LibraryItem(LibraryItem otherLibraryItem) 
    {
        ID++;
        name = otherLibraryItem.name;
        yearOfPublication = otherLibraryItem.yearOfPublication;
    }

    public int getID() 
    {
        return ID;
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

    public String toString() {
        return "This library item's ID# is " + ID + ".\nIts name is " + name + 
        ".\n Its year of publication is " +  yearOfPublication;
    }
    
}
