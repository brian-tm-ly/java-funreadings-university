/**
 * Journal class is a subclass of LibraryItem. 
 * It has a unique journalID, a volume number, and a static variable numJournals to keep track of the number of journals created.
 * @author Brian
 * @version 1.0
 * @see LibraryItem
 * @see Media
 * @see Book
 */

package Library;

public class Journal extends LibraryItem {
    private static int numJournals = 0;
    private String journalID;
    private int volumeNum;

    /**
     * Creates a new instance of Journal with default values.
     * Takes no arguments.
     */
    public Journal() 
    {
        numJournals ++;
        volumeNum = 0;
        journalID = "J" + numJournals;
    }

    /**
     * Creates a new instance of Journal with the specified name, year of publication, and volume number.
     * @param name The name of the journal as a string.
     * @param yearOfPublication The year the journal was published as an integer.
     * @param volumeNum The volume number of the journal as an integer.
     */
    public Journal(String name, int yearOfPublication, int volumeNum)
    {
        super(name, yearOfPublication);
        numJournals++;
        this.volumeNum = volumeNum;
        journalID = "J" + numJournals;
    }

    /**
     * Creates a new instance of Journal that is a copy of another Journal.
     * @param otherJournal The Journal object to be copied.
     */
    public Journal(Journal otherJournal)
    {
        super(otherJournal.name, otherJournal.yearOfPublication);
        numJournals++;
        volumeNum = otherJournal.volumeNum;
        journalID = "J" + numJournals;
    }

    /**
     * Returns the number of journals created.
     * @return The number of journals created as an integer.
     */
    public static int getNumJournals()
    {
        return numJournals;
    }

    /**
     * Returns the unique ID of the journal.
     * @return A string representing the unique ID of the journal.
     */
    @Override
    public String getID()
    {
        return journalID;
    }

    /**
     * Returns the volume number of the journal.
     * @return The volume number of the journal as an integer.
     */
    public int getVolumeNum() 
    {
        return volumeNum;
    }

    /**
     * Sets the volume number of the journal.
     * @param volumeNum The volume number of the journal as an integer.
     */
    public void setVolumeNum(int volumeNum) 
    {
        this.volumeNum = volumeNum;
    }

    /**
     * Compares this Journal to another object for equality.
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
            Journal otherJournal = (Journal) otherObject;
            return (name.equals(otherJournal.name) && yearOfPublication == otherJournal.yearOfPublication 
                && volumeNum == otherJournal.volumeNum);
        }
    }

    /**
     * Returns a string representation of the journal.
     */
    @Override
    public String toString()
    {
        return journalID + ": " + name + ". Published in " + yearOfPublication + ". Its volume number is " + volumeNum + ".";
    }

    
}
