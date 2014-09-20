package dimAnalysis;


public class MAIN {
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
