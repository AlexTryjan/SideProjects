package dimAnalysis;

import javax.swing.JOptionPane; 
public class AssigningValues
{
   public double radius()
   {
       String r = JOptionPane.showInputDialog("Input radius:");
       double radius = Double.parseDouble(r);
       return radius;
   }
   public double length()
   {
       String l = JOptionPane.showInputDialog("Input length:");
       double length = Double.parseDouble(l);
       return length;
   }
   public double base()
   {
       String b = JOptionPane.showInputDialog("Input base:");
       double base = Double.parseDouble(b);
       return base;
   }
   public double width()
   {
       String w = JOptionPane.showInputDialog("Input width:");
       double width = Double.parseDouble(w);
       return width;
   }
   public double height()
   {
       String h = JOptionPane.showInputDialog("Input height:");
       double height = Double.parseDouble(h);
       return height;
   }
   public void Object(String type)
   {
       JOptionPane.showMessageDialog(null,"Input values for the second " + type);
   }
}
