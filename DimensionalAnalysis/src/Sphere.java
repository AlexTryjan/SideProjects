public class Sphere implements DimAnal
{
    public double radius = 1;
    public Sphere(){}
    public Sphere(double radius)
    {
        this.radius = radius;
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
        double v = (4.0/3.0)*(Math.PI*Math.pow(radius,3));
        return v;
    }
    public double surfarea()
    {
        double s = (4*(Math.PI)*(Math.pow(radius,2)));
        return s;
    }
}
