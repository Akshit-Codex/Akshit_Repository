package Simple_Generic_Example;
public class Box<T>
{
    private T content;
    public void addContent(T content)
    {
        this.content=content;
    }
    public T getContent()
    {
        return content;
    }
}
