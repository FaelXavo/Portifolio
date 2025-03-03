import java.util.Scanner;

public class A9Bezugspreis {
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    System.out.println("Listeneinkaufspreis (Euro): ");
    double listeneinkaufpreisfest = s.nextDouble();
    System.out.println("Lieferantenrabatt (%): ");
    double lieferantenrabattfest = s.nextDouble();
    System.out.println("Lieferantenskonto (%): ");
    double lieferantenskontofest = s.nextDouble();
    System.out.println("Bezugskosten (Euro): ");
    double bezugskosten = s.nextDouble();
    double preis = listeneinkaufpreisfest;
    double finalRabat = preis/100 * lieferantenrabattfest;
    System.out.println("");
    System.out.println("Listeneinkaufspreis (Euro): "+ listeneinkaufpreisfest);
    System.out.println("Lieferantenrabatt......(%): "+ lieferantenrabattfest);
    System.out.println("Lieferantenskonto......(%): "+ lieferantenskontofest);
    System.out.println("Bezugskosten........(Euro): "+ bezugskosten);
    
    System.out.println("");
    System.out.println("Listeneinkaufspreis " + preis +" Euro");
    System.out.println("- Lieferantenrabatt " + finalRabat + " Euro");
    preis -= finalRabat;
    
    System.out.println("");
    double finalSkonto = preis /100 * lieferantenskontofest;
    System.out.println("Zieleinkaufspreis   "+ preis + " Euro");
    System.out.println("- Lieferantenskonto "+ finalSkonto +" Euro");
    preis -= finalSkonto;
    
    System.out.println("");
    System.out.println("Bareinkaufspreis    " + preis +" Euro");
    System.out.println("+ Bezugskosten      " + bezugskosten +" Euro");
    preis -= bezugskosten;
    
    System.out.println("");
    System.out.println("Bezugspreis "+ preis +" Euro");
    }
  }
