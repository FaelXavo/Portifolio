import java.util.Scanner;

class ASCIIzeichenA4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Geben Sie die Ganzzahl ein: ");
    int index = scanner.nextInt();
    if (index >=0 && index < 255) {
      char zeichen = 0;
      zeichen += index;
      System.out.println(""+ zeichen);
    } 
    else {
      System.out.println("Ungünstige Zahl");
    } 
  }
  }
