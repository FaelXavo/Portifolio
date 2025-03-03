import java.util.Scanner;  //Scanner klasse importieren

public class rabattA7 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // erstellt ein neues Objekt mit der Scanner-Klasse
    System.out.println("Geben Sie bitte den Preis ein: "); //An einen Wert zum Preis fragen
    double gegebenenPreis = scanner.nextDouble(); //Gegebenen Wert in einer Variablen speichern 
    
    if (gegebenenPreis >= 0 && gegebenenPreis <= 100) { // berechnet den Rabatt, wenn der Preis zwischen 0€ und 100€ ist
      double berechneterRabatt = gegebenenPreis - (gegebenenPreis / 100 * 10); //berechnet den Rabatt, wendet ihn an und speichert den Wert in der Variablen 
      System.out.println("Preis mit rabbat: " + berechneterRabatt); //zeigt das Ergebnis
    } 
    else if (gegebenenPreis > 100 && gegebenenPreis <= 500){ // berechnet den Rabatt, wenn der Preis großer als 100€ und 500€ ist
      double berechneterRabatt = gegebenenPreis - (gegebenenPreis / 100 * 15); //berechnet den Rabatt, wendet ihn an und speichert den Wert in der Variablen
      System.out.println("Preis mit rabbat: " + berechneterRabatt); //zeigt das Ergebnis
    } 
    else if (gegebenenPreis > 500){// berechnet den Rabatt, wenn der Preis großer als 500€ ist
      double berechneterRabatt = gegebenenPreis - (gegebenenPreis / 100 * 20); //berechnet den Rabatt, wendet ihn an und speichert den Wert in der Variablen
      System.out.println("Preis mit rabbat: " + berechneterRabatt); // zeigt das Ergebnis
    }
    else {
      System.out.println("Ungültige Preis"); // wenn der Wert negative ist, macht das Programm einfach nichts and drückt, dass der Wert ungulti ist
    }   
  }
}
