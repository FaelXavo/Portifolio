import java.util.Scanner;

public class Zahlenvergleich{
   public static void main(String[] args){  
     Scanner s = new Scanner(System.in);
     System.out.println("Erste Zahl: ");
     int zahl1 = s.nextInt();
     int zahl2 = s.nextInt();
     if(zahl1 == zahl2){
       System.out.println("Zahlen sind gleich");
       }else {
         if (zahl1 > zahl2) {
           System.out.println("Zahl 1 is größer"); 
        }else {
           System.out.println("Zahl 2 ist größer");
        }
    }
   }   
  }
