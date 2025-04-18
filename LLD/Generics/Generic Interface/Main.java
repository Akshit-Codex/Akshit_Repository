public class Main
{
    public static void main(String[] args)
    {
        Client<Integer,Integer> client=new Client<>(1,2);
        System.out.println("Printing Key: "+client.getKey());
        System.out.println("Printing Value: "+client.getValue());

        System.out.println();

        Client<String,Integer> client1=new Client<>("Apple",25);
        System.out.println("Fruit: "+client1.getKey());
        System.out.println("No. of Apples: "+client1.getValue());
    }
}
