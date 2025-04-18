import java.util.List;
import java.util.Objects;

public class Printer
{
    public static void print(List<?> list)
    {
        for(Object item:list)
        {
            System.out.println(item);
        }
    }
}
