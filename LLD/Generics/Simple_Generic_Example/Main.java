//package Simple_Generic_Example;
import Simple_Generic_Example.Box;
public class Main
{
    public static void main(String[] args)
    {
        Box<Integer> box=new Box<>();
        box.addContent(42);
        System.out.println("The content is: "+box.getContent()+" which is in integer");

        Box<String> box1=new Box<>();
        box1.addContent("THE BEST IN THE WORLD");
        System.out.println("THE CONTENT IS: "+box1.getContent()+" WHICH IS IN STRING");
    }
}


//Refer this link for more info - https://github.com/KingsGambitLab
