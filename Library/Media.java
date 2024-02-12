package Library;

public class Media extends LibraryItem {
    private static int mediaID = 0;
    private String type;

    public Media()
    {
        mediaID++;
        type = "";
    }

    public Media(String name, int yearOfPublication, String type)
    {
        super(name, yearOfPublication);
        mediaID++;
        this.type = type;
    }
    
    public Media(Media otherMedia)
    {
        super(otherMedia.name, otherMedia.yearOfPublication);
        mediaID++;
        type = otherMedia.type;
    }

    public String getMediaID()
    {
        return "M" + mediaID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if(otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else
        {
            Media otherMedia = (Media) otherObject;
            return (name.equals(otherMedia.name) && yearOfPublication == otherMedia.yearOfPublication 
            && type.equals(otherMedia.type));
        }
    }

    @Override
    public String toString()
    {
        return "This media's ID is " + mediaID + "\nIt is " + type + ".\nIts name is " + name + ".\nIt was published in " 
        + yearOfPublication + ".";
    }
    
}
