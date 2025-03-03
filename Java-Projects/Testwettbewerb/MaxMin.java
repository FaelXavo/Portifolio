import java.util.Scanner;

public class MaxMin{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("zahl1: ");
    int zahl1 = s.nextInt();
    System.out.println("zahl2: ");
    int zahl2 = s.nextInt();
    System.out.println("zahl3: ");
    int zahl3 = s.nextInt();
    
    if (zahl1 > zahl2 || zahl1 > zahl3) 
    {
      if (zahl3 > zahl2) 
      {
        System.out.println("Zahl2 am kleinsten");
      } 
      else 
      {
        System.out.println("Zahl3 am kleinsten");  
      } 
    } 
    else 
    {
      System.out.println("zahl1 ist am kleinsten");
    }
    if (zahl1> zahl2 && zahl1 > zahl3) {
      System.out.println("zahl1 am größten");
    } 
    else 
    {
      if (zahl2 > zahl1 && zahl2 > zahl3) {
        System.out.println("zahl2 am größten");
      } else 
      {
        System.out.println("zahl3 am größten");
      } 
    } 
  }
}
