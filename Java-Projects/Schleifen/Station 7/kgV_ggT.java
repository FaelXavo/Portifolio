import java.util.Scanner;

class kgV_ggT {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Geben Sie den ersten Zahl ein: ");
    final int ZAHL1 = scanner.nextInt();
    
    System.out.println("Geben Sie den zweiten Zahl ein: ");
    final int ZAHL2 = scanner.nextInt();
    int kgV = 1;
    int ggT;
    //ggT
    if (ZAHL1 > ZAHL2) {
      int i = ZAHL2;
      do{
        if (ZAHL1 % i == 0 && ZAHL2 % i == 0) {
          ggT = i;
          System.out.println("ggT: "+ ggT);
          
          int produkt = ZAHL1 * ZAHL2;
          if (produkt < 0) {
            produkt *= -1;
          }
          
          kgV = produkt / ggT;
          System.out.println("kgV: " + kgV);
          i = 0;
        } 
        i--;
        } while (i > 0);
      }
      else {
      int i = ZAHL1;
      do {
        if (ZAHL1 % i == 0 && ZAHL2 % i == 0 ) {
          ggT = i;
          System.out.println("ggT: "+ ggT);
          
          int produkt = ZAHL1 * ZAHL2;
          if (produkt < 0) {
            produkt *= -1;
          }
          
          kgV = produkt / ggT;
          System.out.println("kgV: " + kgV);
          i = 0;
          
      }
        i--;
     }  while(i > 0);
    }
    }
  }
