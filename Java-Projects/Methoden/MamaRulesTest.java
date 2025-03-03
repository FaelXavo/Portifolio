/*
 * description : Dieses Programm testet eine  Methode, die MamaRules heißt. Es soll eine String zurückgeben.
 *
 * version 1.0 from 27.01.2025
 * @Rafael Xavier
**/

import java.util.Scanner;

public class MamaRulesTest{
  public static void main(String[]args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Ist der Stecke gezogen?");
    boolean istGezogen = s.nextBoolean();
    String action =  MamaRules.raeumDeinZimmerAuf(istGezogen);
    System.out.println(action);
  }
  }
