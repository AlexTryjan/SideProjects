public class UprightCylinder implements DimAnal
{
    public double radius = 1;
    public double height = 1;
    public UprightCylinder(){}
    public UprightCylinder(double radius, double height)
    {
        this.radius = radius;
        this.height = height;
    }
    public void output()
    {
        double v = volume();
        double s = surfarea();
        System.out.println("Volume: " + v);
        System.out.println("SurfArea: " + s);
    }
    public double volume()
    {
        double v = Math.PI*radius*radius*height;
        return v;
    }
    public double surfarea()
    {
        double s = (2*Math.PI*radius*height) + (2*Math.PI*radius*radius);
        return s;
    }
    public static void main(String []args)
    {
        AssigningValues A = new AssigningValues();
        Sphere sphere1 = new Sphere();
        A.Object("Sphere");
        double r = A.radius();
        Sphere sphere2 = new Sphere(r);
        Box box1 = new Box();
        A.Object("Box");
        double l = A.length();
        double w = A.width();
        double h = A.height();
        Box box2 = new Box(l,w,h);
        Pyramid pyramid1 = new Pyramid();
        A.Object("Pyramid");
        double b = A.base();
        h = A.height();
        Pyramid pyramid2 = new Pyramid(b,h);
        UprightCylinder cyl1 = new UprightCylinder();
        A.Object("UprightCylinder");
        r = A.radius();
        h = A.height();
        UprightCylinder cyl2 = new UprightCylinder(r,h);
        sphere1.output();
        sphere2.output();
        box1.output();
        box2.output();
        pyramid1.output();
        pyramid2.output();
        cyl1.output();
        cyl2.output();
    }
}
