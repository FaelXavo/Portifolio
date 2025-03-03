import java.util.Scanner;

public class Schaltjahr {
  public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  System.out.println("Geben sie das Jahr ein");
  int jahr = s.nextInt();
  if (jahr > 1582) {
    if((jahr % 4 == 0 && jahr%100 != 100) || jahr % 400 == 0 ) {
     System.out.println("Ist Schaltjahr");
    } else {
      System.out.println("Ist kein Schaltjahr");
    } // end of if-else
  } else {
      System.out.println("Ist kein Schaltjahr");
  } // end of if-else  
  }
  }
