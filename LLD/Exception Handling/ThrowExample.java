import javax.naming.InvalidNameException;

public class ThrowExample
{
    public static void main(String ...s) throws Exception
    {
        try
        {
            validateAge(15);
        }
        catch (Exception e)
        {
            throw new InvalidAgeException("The error message is: "+e.getMessage());
        }
    }
    static void validateAge(int age) throws InvalidAgeException
    {
        if(age<18)
        {
            throw new InvalidAgeException("Invalid Age");
        }
    }
}
class InvalidAgeException extends Exception
{
    public InvalidAgeException(String error)
    {
        super(error);
    }
}
