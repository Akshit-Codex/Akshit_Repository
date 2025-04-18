public class Custom_Exception
{
    public static void main(String ...s) throws CustomException,ArithmeticException
    {
        try
        {
            int age=35;
            if(age<18)
            {
                validate(age);
            }
            else
            {
                throw new CustomException("AGE IS ABOVE 18");
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
    static void validate(int age)
    {
        throw new ArithmeticException("Age is invalid");
    }
}

class CustomException extends Exception
{
    public CustomException(String message)
    {
        super(message);
    }
}
