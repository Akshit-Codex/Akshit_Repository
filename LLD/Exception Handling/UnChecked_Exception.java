public class UnChecked_Exception
{
    public static void main(String ...s) throws Exception
    {
        try
        {
            int res=10/0;
        }
        catch (Exception e)
        {
            throw new Exception("The error is: "+e.getMessage());
        }
    }
}
// This code is an example for unchecked exception which occurs at runtime.
