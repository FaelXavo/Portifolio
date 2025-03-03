import java.util.Scanner;

class Start_End_Wert{
  public static void main(String[] args) {
    Scanner scann = new Scanner(System.in);
    System.out.println("Startswert: ");
    int Startswert = scann.nextInt();
    System.out.println("Endwert: ");
    int Endwert = scann.nextInt();
    System.out.println("");
    while (Startswert <= Endwert){
      System.out.println(Startswert);
      Startswert++;
      }
  }
}
