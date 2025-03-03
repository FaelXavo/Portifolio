import java.util.Scanner;

class Primzahl {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Geben Sie eine Zahl ein: ");
    final int ZAHL = scanner.nextInt();
    int ergebniss = 0;
    String zahlen = "";
    int i = ZAHL;
    do{
        if (ZAHL%i == 0 && (i!= ZAHL && i!= 1)){
           System.out.println("Nicht ein Primzahl");
           i = 0;
          }
        if (i==1) {
           System.out.println("Primzahl");
        }
        i--; 
      } while (i > 0);
    }
  }
