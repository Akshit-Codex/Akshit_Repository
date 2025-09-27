public class Main
{
    public static void main(String[] args)
    {
        ShapeFactory shapeFactory=new ShapeFactory();
        //Shape shape=shapeFactory.getShapeFactory(ShapeType.SQUARE); THIS IS USED USING ENUM
        Shape shape=shapeFactory.getShapeFactory("Rectangle");// THIS IS DONE USING STRING

        shape.getShape();
    }
}
