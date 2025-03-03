import java.util.Scanner;

class NotenA6 {
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Geben Sie die Note ein: ");
    int note = scanner.nextInt();
    
    switch (note) {
      case 1 : 
        System.out.println("Sehr gut");
        break;
      case 2 : 
        System.out.println("Gut");
        break;
      case 3 :
        System.out.println("Befriedigend");
        break;
      case 4 :
        System.out.println("Ausreichend");
        break;
      case 5 :
        System.out.println("Mangelhaft");
        break;
      case 6 :
        System.out.println("Ungenügend");
        break;
      default: 
        System.out.println("Ungülstige Eingabe");
    } 
  }
}

