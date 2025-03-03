import java.util.Scanner;

class BMIBerechnenA8 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Geben sie das Gewicht in kg ein: ");
    double gewicht = scanner.nextDouble();
    System.out.println("Geben sie die Grösse in cm ein: ");
    double groesse = scanner.nextDouble();
    System.out.println("Geschlecht (m/w): ");
    char geschlecht = scanner.next().charAt(0);
    
    double BMI = gewicht / (groesse * groesse / 100);
    if (gewicht > 0 && groesse > 0) {
      if (geschlecht == 'm' || geschlecht == 'w') {
        if (geschlecht == 'm') {
          if (BMI < 20) {
            System.out.println("Untergewicht");
          } 
          else if (BMI>=20 && BMI <=25) {
            System.out.println("Normalgewicht");
          } 
          else {
            System.out.println("Übergewicht");    
          } 
        } 
        else {
          if (BMI < 19) {
            System.out.println("Untergewicht");
          } 
          else if (BMI>=19 && BMI <=24) {
            System.out.println("Normalgewicht");
          } 
          else {
            System.out.println("Übergewicht");    
          }   
        } 
      }
      else {
        System.out.println("Ungünstiges Geschlecht für die Berechnung");
      }
    } 
    else {
      System.out.println("Geben Sie bitte richtige Gewicht und Grösse");  
    }    
  }
}
