import java.util.Scanner;
import java.text.DecimalFormat;

class PeterZwegat{
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Geben Sie das Kredit ein: ");
      //double kredit = scanner.nextDouble();
        double kredit = 285;
      System.out.println("Geben Sie das Zinssatz ein: ");
      //double zinssatz = scanner.nextDouble();
         double zinssatz = 7.5;
      System.out.println("Geben Sie die Laufzeit (in Monaten): ");
      //double laufzeit = scanner.nextDouble();
      double laufzeit = 24;
      int monat = 1; //increment für die Schleife
    
      double restBerechnung = kredit;
      double formelTilgung;
    
      double formelJaehrlicheRate = kredit * ( zinssatz / 100 ) / (1 - (Math.pow ( 12 / (12 + (zinssatz / 100) ), laufzeit ) ) );
      double jaehrlicheRate = (int)(formelJaehrlicheRate / 12 * 100);
      jaehrlicheRate /= 100;
    
      while (laufzeit >= 1) {
        double formelZinsen = restBerechnung * (zinssatz / 100) * 12;
        double zinsen = (int)(formelZinsen * 100);
        zinsen /= 100;
        
        
        formelTilgung = jaehrlicheRate - zinsen;
        double tilgung = (int)(formelTilgung * 100);
        tilgung /= 100;
        
        restBerechnung -= jaehrlicheRate;
        double rest = (int)(restBerechnung * 100);
        rest /=100;
        
        System.out.println("Monat\tZinsen\tTilgung\tRate\tRest");
        System.out.println(monat+"\t"+ zinsen +"\t"+ tilgung +"\t"+ jaehrlicheRate + "\t" + rest);
        
        monat++;
        laufzeit-=1;  
      }
    }
  }
