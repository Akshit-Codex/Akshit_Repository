public class ShapeFactory
{
    public Shape getShapeFactory(String shapeType)
    {
        return switch (shapeType)
        {
            case "Rectangle"->new Rectangle();
            case "Triangle"->new Triangle();
            case "Circle" -> new Circle();
            default -> throw new IllegalArgumentException("Invalid shape is selected: "+shapeType);
        };
    }
}
