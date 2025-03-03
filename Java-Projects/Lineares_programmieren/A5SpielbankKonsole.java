import java.util.Scanner;

public class A5SpielbankKonsole {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int zweis;
    int fuenfs;
    int zehns;
    int zwanzigs;
    int fuenfzigs;
    int hunderts;
    double value;
    System.out.println("Wie vielen 2 Chips haben Sie?");
    zweis = s.nextInt(); 
    System.out.println("Wie vielen 5 Chips haben Sie?");
    fuenfs = s.nextInt();
    System.out.println("Wie vielen 10 Chips haben Sie?");
    zehns = s.nextInt();
    System.out.println("Wie vielen 20 Chips haben Sie?");
    zwanzigs = s.nextInt();
    System.out.println("Wie vielen 50 Chips haben Sie?");
    fuenfzigs = s.nextInt();
    System.out.println("Wie vielen 100 Chips haben Sie?");
    hunderts = s.nextInt();
    value = (zweis*2)+(fuenfs*5)+(zehns*10)+(zwanzigs*20)+(fuenfzigs*50)+(hunderts*100);
    System.out.println("Sie haben "+value+ " auszuzahlen.");
  }
  }
