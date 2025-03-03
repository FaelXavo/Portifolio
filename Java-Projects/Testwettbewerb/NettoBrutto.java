import java.util.Scanner;

public class NettoBrutto{
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.println("Betrag: ");
      double betrag = s.nextDouble();
      System.out.println("Reduziert: ");
      char reduziert = s.next().charAt(0);
      if(reduziert == 'j' || reduziert == 'n')
      {
        if (reduziert == 'j') 
        {
         betrag += betrag*7/100;
        } 
        else 
        {
         betrag += betrag*19/100;
        }
        System.out.println("Betrag: " + betrag);
      } 
      else
      {
       System.out.println("Ungültige Eingabe");
      } 
    }
  }
