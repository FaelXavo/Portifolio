import java.util.Scanner;

class Million {
    public static void main(String[] args) {
       Scanner scann = new Scanner(System.in);
       //Einlage
       System.out.println("Geben Sie bitte die Einlage ein: ");
       double einlage = scann.nextDouble();
       //Zinsatz
       System.out.println("Geben Sie bitte den Zinsatz ein: ");
       double zinsatz = scann.nextDouble();
       //Ergebniss
       double result = einlage + einlage /100 * zinsatz;
       int jahren = 1;
       while(result < 1000000)
       {
          result = result  + (result / 100 * zinsatz);
          jahren++;
        }
      System.out.println("Sie werden Millionär in " + jahren + " Jahren");
    }
  }
