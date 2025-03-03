import java.util.Scanner;
class GeometrischeForm{
      public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
             System.out.println("Bitte geben Sie den Radius an: ");
             final double PI = Math.PI;
             float radius = sc.nextFloat();
             float kreisflaeche = (float) (Math.pow(radius, 2) * PI);
             float oberflaeche = (float) (Math.pow(radius, 2) * PI * 4);
             float volumen = (float) (Math.pow(radius, 3) * PI * (4.0/3.0));
             System.out.println("--Berechnung--");
             System.out.println("Kreisfläche: " + kreisflaeche); 
             System.out.println("Oberfläche.: " + oberflaeche); 
             System.out.println("Volumen....: " + volumen); 
      }
  }