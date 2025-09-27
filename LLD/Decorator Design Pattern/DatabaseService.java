public class DatabaseService
{
    public String getMailfromUsername(String userName)
    {
        return userName+"@Mail";
    }
    public String getFBNamefromUsername(String userName)
    {
        return userName+"@FB";
    }
    public String getPhoneNofromUsername(String userName)
    {
        return  userName+"@Phone";
    }
}
