import java.util.Scanner;

class rechnungbetragA2{
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Anzahl der bestellten M�use: ");
    int maeuseAnzahl = scanner.nextInt();
    System.out.println("Geben Sie bitte den Einzelpreis: ");
    double einzelpreis = scanner.nextDouble();
    double gesamtesPreis = 0;
    if (maeuseAnzahl < 10) {
      gesamtesPreis += 10;
    }
    gesamtesPreis += einzelpreis * maeuseAnzahl;
    System.out.println("Gesamtespreis: " + gesamtesPreis);
  }
  }
