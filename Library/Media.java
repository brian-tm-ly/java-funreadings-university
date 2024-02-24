/**
 * Media class is a subclass of LibraryItem class. It represents a media item in the library.
 * It has a unique mediaID, and a type of media.
 * @author Brian
 * @version 1.0
 * @see LibraryItem
 * @see Book
 * @see Journal
 */

package Library;

public class Media extends LibraryItem {
    private static int numMedia = 0;
    private String mediaID;
    private String type;

    /**
     * Creates a new instance of Media with default values.
     */
    public Media()
    {
        numMedia++;
        type = "";
        mediaID = "M" + numMedia;
    }

    /**
     * Creates a new instance of Media with the specified name, year of publication, and type.
     * @param name The name of the media as a string.
     * @param yearOfPublication The year the media was published as an integer.
     * @param type The type of media as a string.
     */
    public Media(String name, int yearOfPublication, String type)
    {
        super(name, yearOfPublication);
        numMedia++;
        setType(type);
        mediaID = "M" + numMedia;
    }
    
    /**
     * Creates a new instance of Media that is a copy of another Media.
     * @param otherMedia The Media object to be copied.
     */
    public Media(Media otherMedia)
    {
        super(otherMedia.name, otherMedia.yearOfPublication);
        numMedia++;
        type = otherMedia.type;
        mediaID = "M" + numMedia;
    }

    /**
     * Returns the number of media created.
     * @return The number of media created as an integer.
     */
    public static int getNumMedia()
    {
        return  numMedia;
    }

    /**
     * Returns the unique ID of the media.
     * @return A string representing the unique ID of the media.
     */
    @Override
    public String getID()
    {
        return mediaID;
    }

    /**
     * Returns the type of media.
     * @return A string representing the type of media.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of media.
     * @param type The type of media as a string.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Compares this Media to another object for equality.
     * @param otherObject The object to compare to.
     * @return A boolean value of true if the objects are equal, and false if they are not.
     */
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

    /**
     * Returns a string representation of the media.
     * @return A string representing the information of the media.
     */
    @Override
    public String toString()
    {
        return mediaID + ": " + name + ". Published in "  + yearOfPublication + ". It is " + type +  "." ;
    }
    

}
