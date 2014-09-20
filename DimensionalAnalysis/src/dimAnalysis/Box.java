package dimAnalysis;

public class Box implements ExtraDimAnal
{
    double length = 1;
    double width = 1;
    double height = 1;
    public Box(){}
    public Box(double length, double width, double height)
    {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public void output()
    {
        double v = volume();
        double s = surfarea();
        double p = baseperimeter();
        System.out.println("Volume: " + v);
        System.out.println("SurfArea: " + s);
        System.out.println("BasePerimeter: " + p);
    }
    public double volume()
    {
        double v = length*width*height;
        return v;
    }
    public double surfarea()
    {
        double s = (2*((length*width)+(width*height)+(height*length)));
        return s;
    }
    public double baseperimeter()
    {
        double p = 2*length*2*width;
        return p;
    }
}
