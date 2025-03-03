import java.util.Scanner;
class DivisionTest {
      public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
             System.out.println("Dividend: ");
             int ersteZahl = sc.nextInt();
             System.out.println("Divisor: ");
             int zweiteZahl = sc.nextInt();
             float ergebniss = (float) (ersteZahl /  zweiteZahl); 
             //Wenn (float)() nicht verwendet wird, wartet die Variable auf ein int, die Division gibt jedoch ein float oder double zurück. Verursacht den Fehler
             System.out.println(ergebniss);
      }
  }