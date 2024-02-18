package Library;

public class Journal extends LibraryItem {
    private static int numJournals = 0;
    private String journalID;
    private int volumeNum;

    public Journal() 
    {
        numJournals ++;
        volumeNum = 0;
        journalID = "J" + numJournals;
    }

    public Journal(String name, int yearOfPublication, int volumeNum)
    {
        super(name, yearOfPublication);
        numJournals++;
        this.volumeNum = volumeNum;
        journalID = "J" + numJournals;
    }

    public Journal(Journal otherJournal)
    {
        super(otherJournal.name, otherJournal.yearOfPublication);
        numJournals++;
        volumeNum = otherJournal.volumeNum;
        journalID = "J" + numJournals;
    }

    public static int getNumJournals()
    {
        return numJournals;
    }

    @Override
    public String getID()
    {
        return journalID;
    }

    public int getVolumeNum() 
    {
        return volumeNum;
    }

    public void setVolumeNum(int volumeNum) 
    {
        this.volumeNum = volumeNum;
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
            Journal otherJournal = (Journal) otherObject;
            return (name.equals(otherJournal.name) && yearOfPublication == otherJournal.yearOfPublication 
                && volumeNum == otherJournal.volumeNum);
        }
    }

    @Override
    public String toString()
    {
        return journalID + ": " + name + ". Published in " + yearOfPublication + ". Its volume number is " + volumeNum + ".";
    }
    
}
