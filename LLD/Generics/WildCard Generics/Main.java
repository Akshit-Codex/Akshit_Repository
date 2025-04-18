import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> list= Arrays.asList(1,2,3,4);
        Printer.print(list);

        List<String> list1=Arrays.asList("GET ON THE","DANCE FLOOR!!!!!");
        Printer.print(list1);
    }
}
