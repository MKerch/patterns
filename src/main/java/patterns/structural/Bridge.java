package patterns.structural;

public class Bridge {

    public static void main(String[] args) {
        Shape square = new Square(new Blue());
        String draw = square.draw();
        System.out.println(draw);
    }
}

interface Color {
    String fill();
}

class Blue implements Color {

    public String fill() {
        return "Color is Blue";
    }
}

abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    //standard constructors

    abstract public String draw();
}

class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}