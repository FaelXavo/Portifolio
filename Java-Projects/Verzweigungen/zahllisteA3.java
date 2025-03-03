import java.util.Scanner;

class zahllisteA3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Geben Sie die erste Zahl ein: ");
    double zahl1 = scanner.nextDouble();
    System.out.println("Geben Sie die zweite Zahl ein: ");
    double zahl2 = scanner.nextDouble();
    System.out.println("Geben Sie die dritte Zahl ein: ");
    double zahl3 = scanner.nextDouble();
    if (zahl1 < zahl2 && zahl1 < zahl3) {
      System.out.println("" + zahl1 + " ist die kleinste");
    } else if (zahl2 < zahl3 && zahl2 < zahl1){
        System.out.println("" + zahl2 + " ist die kleinste");
    } else if (zahl1 == zahl2 && zahl2 == zahl3) {
        System.out.println("Alle sind gleich");  

    } else if (zahl1 == zahl2 && zahl3 > zahl1) {
        System.out.println("" + zahl1 + " ist die kleinste");
    }
    else {
        System.out.println("" + zahl3 + " ist die kleinste"); 
    }
        
    if (zahl1 > zahl2 && zahl1 > zahl3) {
      System.out.println("" + zahl1 + " ist die grosste");
    } 
    else if (zahl2 > zahl3 && zahl2 > zahl1){
        System.out.println("" + zahl2 + " ist die grosste");
    } 
    else if (zahl1 == zahl2 && zahl2 == zahl3) {
    }   
    else {
        System.out.println("" + zahl3 + " ist die grosste"); 
    } 
  }
}
