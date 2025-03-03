import java.util.Scanner;
class Xavier_Rafael_OG41_PQLosungsformel{
       public static void main(String[] args){
            Scanner scann = new Scanner(System.in);
            System.out.println("Bitte geben Sie p ein");
            float p = scann.nextFloat();
            System.out.println("Bitte geben Sie q ein");
            float q = scann.nextFloat();
            //float ZweiterSchritt = (p*p/4) - q ;
            double Würzel = Math.sqrt((p*p/4) - q );
            double X1 = -p/2 + Würzel;
            double X2 = -p/2 - Würzel;
            System.out.println("Die mögliche Werte fur X sind:\n \nX1: " + X1+ "\nX2: "+ X2);        
        }  
  }