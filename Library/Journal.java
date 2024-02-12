package Library;

public class Journal extends LibraryItem {
    private static int journalID = 0;
    private int volumeNum;

    public Journal() 
    {
        journalID ++;
        volumeNum = 0;
    }

    public Journal(String name, int yearOfPublication, int volumeNum)
    {
        super(name, yearOfPublication);
        journalID++;
        this.volumeNum = volumeNum;
    }

    public Journal(Journal otherJournal)
    {
        super(otherJournal.name, otherJournal.yearOfPublication);
        journalID++;
        volumeNum = otherJournal.volumeNum;
    }

    public String getJournalID()
    {
        return "J" + journalID;
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
        return "This journal's ID is " + journalID + ".\nIts name is " + name + ".\nIt was published in " 
        + yearOfPublication + ".\nIts volume number is " + volumeNum + ".";
    }
    
}
