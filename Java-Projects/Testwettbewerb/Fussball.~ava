import java.util.Scanner;

public class  Fussball{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Tordifferenz: ");
    int torDiff = s.nextInt();
    //man muss einfach die "underDogWint" Variable mit einem zufällig Character initializieren, ansonsten wird die Zeile 20 nicht funktionieren wegen ein "variable not initialized" error.
    char underDogWin = 'v';
    if (torDiff == 0) {
      System.out.println("Hat der Underdog gewonnen? (j/n): ");
      underDogWin = s.next().charAt(0);
    }
    if (torDiff >= 6) {
      System.out.println("Platz 1");
    } else {
      if (torDiff >= 5) {
        System.out.println("Platz 2");
      } else {
        if (torDiff == 0 && underDogWin == 'j') {
         System.out.println("Platz 4"); 
        } else {
          if (torDiff == -1 || torDiff == 0) {
          System.out.println("Platz 3");  
          } else {
              if(torDiff <= -2){
              System.out.println("Platz 4");
            }
            } // end of if-else // end of if
        } // end of if-else
      } // end of if-else
    } // end of if-else
  }
}
