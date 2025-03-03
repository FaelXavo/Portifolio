import java.util.Scanner;
import java.text.DecimalFormat;

class Million_c {
    public static void main(String[] args) {
      char execute = 'j';
    
      while(execute == 'j'){ 
       Scanner scanner = new Scanner(System.in);
      
      DecimalFormat df = new DecimalFormat("###,##0.00");
       //Hier entseht die Einlage
       System.out.println("Geben Sie bitte die Einlage ein: ");
       double einlage = scanner.nextDouble();
      
       //Zinsatz pro-cent (%)
       System.out.println("Geben Sie bitte den Zinsatz ein: ");
       double zinsatz = scanner.nextDouble();
       //Das Ergebniss der Rechnung wird als Kapital gennant
       double kapital = einlage + einlage /100 * zinsatz;
       int jahren = 1;
       //Die Variable f�r 1 Million als eine Konstant
       final double MILLION = 1000000;
       //Das Kapital w�chst jedes Jahr um den Zinssatz. 
       //Vor der Schleife ist das Kapital die Einlage, danach wird es j�hrlich um den Zinssatz erh�rt
       while(kapital < MILLION)
       {
          kapital = kapital  + (kapital / 100 * zinsatz);
          jahren++;
        }
      System.out.println("Sie werden Million�r in " + jahren + " Jahren, mit " + df.format(kapital) + " euro");
      //Eine Leerzeile dr�cken, damit das Ende lesbarer wird
      System.out.println("");
      System.out.println("M�chten Sie ein Weiteren Programmdurchlauf mit anderen werten durchf�hren?('j' wenn ja)");
      execute = scanner.next().charAt(0);
      }      
    }
  }
