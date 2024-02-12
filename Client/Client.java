package Client;

public class Client {
    private static int clientID = 0;
    private String name;
    private int phoneNum;
    private String email;

    public Client() 
    {
        clientID++;
        name = "";
        phoneNum = 11111111;
        email = "";
    }

    public Client(String name, int phoneNum, String email)
    {
        clientID++;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public Client(Client otherClient)
    {
        clientID++;
        name = otherClient.name;
        phoneNum = otherClient.phoneNum;
        email = otherClient.email;
    }

    public String getClientID()
    {
        return "C" + clientID;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getPhoneNum() 
    {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) 
    {
        this.phoneNum = phoneNum;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else
        {
            Client otherClient = (Client) otherObject;
            return (name.equals(otherClient.name) && phoneNum == otherClient.phoneNum 
                && email.equals(otherClient.email));
        }
    }

    @Override
    public String toString()
    {
        return "This client's ID is " + clientID + ".\nTheir phone number is " 
            + phoneNum + ".\nTheir email is " + email;
    }

}
