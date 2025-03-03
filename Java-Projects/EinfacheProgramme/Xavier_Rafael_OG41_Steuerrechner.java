import java.util.Scanner;
class Xavier_Rafael_OG41_Steuerrechner {
      public static void main(String[] args){
             Scanner scann = new Scanner(System.in);
             System.out.println("Was ist Ihres Lohn?");
             int Lohn = scann.nextInt();
             int Mehrwertsteuer = Lohn / 100 * 19;
             int Mehrwertsteuersatz = Lohn / 100 * 7;
             System.out.println("Mehrwertsteuer (19%): " + 
             Mehrwertsteuer);
             System.out.println("Mehrwertsteuerstatz (7%): " + Mehrwertsteuersatz);
        } 
  }
