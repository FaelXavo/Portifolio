/**
 *
 * Main Methode für MyMath
 * hier kann man die Funktionen der Methode MyMath testen.
 * @Rafael Xavier de Queiroga 
 */

import java.util.Scanner;

class MyMathTest{
  public static void main(String[]args) {
    Scanner scann = new Scanner(System.in);
    boolean looping = true;
    while (looping) { 
      System.out.println("\nWelche funktion wollen Sie testen?\n.pow\n.fak\n.wurzel\n.pytha\n.sin");
      String funktion = scann.next();
      switch (funktion) {
        case  "pow": 
          System.out.println("Geben Sie die Basis ein...: ");
          int basis = scann.nextInt();
          System.out.println("Geben Sie den Exponent ein: ");
          int exponent = scann.nextInt();
          System.out.println(basis+"^"+exponent+" = "+ MyMath.pow(basis, exponent));
          
          break;
        case  "fak":{
           
          System.out.println("Geben Sie die Zahl ein....:");
          int zahl = scann.nextInt();
          System.out.println(zahl+"! = " + MyMath.fak(zahl));
          break;
            }
        case  "wurzel":{
          
          System.out.println("Geben Sie die Zahl ein....:");
          int zahl = scann.nextInt();
          System.out.println(""+zahl + " = " + MyMath.root(zahl));
              
          break;
            }
        case "pytha":
          System.out.println("Geben Sie die Zahl A ein..:");
          double a = scann.nextDouble();
          System.out.println("Geben Sie die Zahl B ein..:");
          double b = scann.nextDouble();
          System.out.println("c = " + MyMath.pythagoras(a,b));
          break;
          
        case "sin":
          System.out.println("Geben Sie die Zahl X ein..:");
          double x = scann.nextDouble();
          System.out.println("sin("+ x +") = " + MyMath.sin(x));
          break;
        default: 
          looping = false;
      }
      
    }
  }
}
