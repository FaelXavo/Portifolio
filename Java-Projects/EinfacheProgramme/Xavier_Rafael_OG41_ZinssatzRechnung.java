import java.util.Scanner;
class Xavier_Rafael_OG41_ZinssatzRechnung {
      public static void main(String[] args){
             Scanner scann = new Scanner(System.in);
             System.out.println("Was ist der Betrag?");  
             float Betrag = scann.nextFloat();
             System.out.println("Was ist der Zinssatz?");
             float Zinssatz = scann.nextFloat();
             float Zinsen = (Betrag / 100) * Zinssatz;
             
             System.out.printf("1 Jahr: %.2f %n", Zinsen);
             System.out.printf("2 Jahre: %.2f %n", (Zinsen * 2));
             System.out.printf("5 Jahre: %.2f %n", (Zinsen * 5));
             System.out.printf("10 Jahr: %.2f %n", (Zinsen * 10));
        }
  }
