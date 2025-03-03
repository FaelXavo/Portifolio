import java.util.Scanner;

public class A8Benzinverbrauch {
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    System.out.println("Erste Km-Stand: ");
    double kmStandLeztzerTank = s.nextDouble();
    System.out.println("Letzte Km-Stand: ");
    double kmStandActuelerTank = s.nextDouble();
    System.out.println("Getanken Litern: ");
    double getankenLitern = s.nextDouble();
    double kmStandDifferenz = kmStandActuelerTank - kmStandLeztzerTank;
    double benzinVerbrauch = getankenLitern / (kmStandDifferenz / 100); 
    System.out.println("km-Stand bei letzten Tanken: " + kmStandLeztzerTank);
    System.out.println("km-Stand beim Tanken.......: " + kmStandActuelerTank);
    System.out.println("Benzinverbrauch (Liter)....: " + getankenLitern);
    System.out.println("Der LKW hat " + benzinVerbrauch + " Liter auf 100 km verbraucht.");
    }
  }
