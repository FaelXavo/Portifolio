import java.util.Scanner;
class Xavier_Rafael_OG41_PolynomRechner{
      public static void main (String[] args)
      {
             Scanner scann = new Scanner(System.in);
             System.out.println("Geben Sie bitte dem X Wert");
             float X = scann.nextFloat();
             float ErsteStelle = 5*(X*X*X);
             float ZweiteStelle = 2*(X*X);
             float Ergebniss = ErsteStelle + ZweiteStelle - 15;
             System.out.println("das Ergebniss für das Polynom 5x³+2x²-15 mit " + X +" als x Wert ist: \n " + Ergebniss);         
      }
  }