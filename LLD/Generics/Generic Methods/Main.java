public class Main
{
    public static void main(String[] args)
    {
        Sample ss=new Sample();
        String[] a1={"Hello","YOLO"};
        Integer[] a2={32,12,15,35,6346};// Generic doesn't allow primitive data types so use
        // Integer not int

        ss.demo(a1);
        ss.demo(a2);
    }
}
