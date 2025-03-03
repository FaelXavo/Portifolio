import java.util.Scanner;

class zahlvergleichA1{
  public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  System.out.println("Erste Zahl: ");
  double zahl1 = scanner.nextDouble();
  System.out.println("Zweite Zahl: ");
  double zahl2 = scanner.nextDouble();
  if (zahl1 > zahl2) {
    System.out.println("Erste Zahl ist grosser");
  } else if (zahl1 < zahl2) {
    System.out.println("Zweite Zahl ist grosser");
  } else {
    System.out.println("Beiden Zahlen sind gleich");  
    }
  }
  }
