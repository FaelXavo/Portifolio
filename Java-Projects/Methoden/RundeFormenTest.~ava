/*
 *  Dieses Datei hat die main-Methode, wo man die Funktionen von RundeFormen testen kann.
 *
 *  @Rafael Xavier
 **/

import java.util.Scanner;

class RundeFormenTest{
     public static void main(String[]args) {
       Scanner scann = new Scanner(System.in);
       boolean restart = true;
       while (restart) {
         System.out.println("Geben Sie den Radius ein: ");
         double radius =  scann.nextDouble();
      
         System.out.println("Kreisfläche...........: " + RundeFormen.kreisFlaeche(radius));
         System.out.println("Oberfläche einer Kugel: " + RundeFormen.kugelOberflaesche(radius));
         System.out.println("Volumen einer Kugel...: " + RundeFormen.kugelVolumen(radius));
         
         System.out.println("\nWollen Sie eine andere Zahl waehlen? (j/n): " );
         char repeat = scann.next().charAt(0);
         if(repeat != 'j')
           restart = false;
       }
     }
  }
