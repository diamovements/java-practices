package Pr6;

abstract class Shape implements Cloneable {
    protected String type;
    abstract void draw();
    public String getType() {
        return type;
    }
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Circle created");
    }
}

class Triangle extends Shape {

    @Override
    void draw() {
        System.out.println("Triangle created");
    }
}

class Test4 {
    public static void main(String[] args) {
        Shape circle1 = new Circle();
        Shape triangle1 = new Triangle();
        circle1.draw();
        triangle1.draw();
        Circle circle2 = (Circle) circle1.clone();
        Triangle triangle2 = (Triangle) triangle1.clone();
        circle2.draw();
        triangle2.draw();
    }
}
