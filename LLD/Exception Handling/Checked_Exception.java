import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;

public class Checked_Exception
{
    public static void main(String ...s) throws Exception
    {
        try
        {
            readFile("Example.txt");
        }
        catch (Exception e)
        {
            throw new Exception("THERE IS THE MESSAGE: "+e.getMessage());
        }
    }

    static void readFile(String fileName) throws Exception
    {
        FileReader fileHandler=new FileReader(fileName);
    }
}
// This code is an example for checked exception which occurs at compile time.