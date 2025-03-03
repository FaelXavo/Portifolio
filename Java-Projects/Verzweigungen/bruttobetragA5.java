import java.util.Scanner;

class bruttobetragA5 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Geben Sie den Nettowert bitte ein: ");
    double nettoPreis = scanner.nextDouble();
    System.out.println("Wird der angewandte Steuersatz gesenkt?(j/n) ");
    char jaOderNein = scanner.next().charAt(0);
    if(jaOderNein == 'j' || jaOderNein == 'n'){
      if (jaOderNein == 'j') {
      System.out.println("Bruttobetrag: " + (nettoPreis +(nettoPreis /100 * 7)));
    } else {
      System.out.println("Bruttobetrag: " + (nettoPreis +(nettoPreis /100 * 19)));
    } // end of if-else 
    } else {
      System.out.println("Ungünstige Antwort");    
    } // end of if-else

  }
  }
