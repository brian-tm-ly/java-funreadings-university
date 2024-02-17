package Library;

public class Media extends LibraryItem {
    private static int numMedia = 0;
    private String mediaID;
    private String type;

    public Media()
    {
        numMedia++;
        type = "";
        mediaID = "M" + numMedia;
    }

    public Media(String name, int yearOfPublication, String type)
    {
        super(name, yearOfPublication);
        numMedia++;
        this.type = type;
        mediaID = "M" + numMedia;
    }
    
    public Media(Media otherMedia)
    {
        super(otherMedia.name, otherMedia.yearOfPublication);
        numMedia++;
        type = otherMedia.type;
        mediaID = "M" + numMedia;
    }

    public static int getNumMedia()
    {
        return  numMedia;
    }

    public String getMediaID()
    {
        return mediaID;
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
        return "This media's ID is " + mediaID + ". Its name is " + name + ". It is " + type +  ". It was published in " 
        + yearOfPublication + ".";
    }
    
}
