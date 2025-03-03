import java.util.Scanner;
import java.text.DecimalFormat;

class ZINSZINS{
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      String form = "###,###.##";
      DecimalFormat decimalFormat = new DecimalFormat(form);
    
      System.out.println("Laufzeit (in Jahren): ");
      int jahren = scanner.nextInt();
    
      System.out.println("Kapital (in Euro): ");
      double kapital = scanner.nextDouble();
    
      System.out.println("Zinssatz(in Prozent): ");
      double zinssatz = scanner.nextDouble();
    
      double ausgezahltesKapital = kapital;
    
      for (int i = 1; i <= jahren; i++) {
        ausgezahltesKapital += ausgezahltesKapital * (zinssatz/100);
      }
      System.out.println("Laufzeit (in Jahren) des Sparvertrags.........: " + jahren);
      System.out.println("Wie viel Kapital (in Euro) möchten Sie anlegen: " + decimalFormat.format(kapital));
      System.out.println("Zinssatz (in Prozent).........................: " + zinssatz);
      System.out.println("\nEingezahltes Kapital: " + decimalFormat.format(kapital) + " Euro");
      System.out.println("Ausgezahltes Kapital: " + decimalFormat.format(ausgezahltesKapital) + " Euro");
    }
  }
