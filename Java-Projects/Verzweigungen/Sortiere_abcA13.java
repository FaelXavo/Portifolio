import java.util.Scanner;

class Sortiere_abcA13 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Bitte geben Sie die Zeicheneingaben separat an: ");
    //diese Variablen werden für outprint verwendet
    char z1 = scanner.next().charAt(0);
    char z2 = scanner.next().charAt(0);
    char z3 = scanner.next().charAt(0);
    //diese Variablen werden für logische operationen verwendet
    char zeichen1 = z1;
    char zeichen2 = z2;
    char zeichen3 = z3;
    System.out.println("Sortierte Liste -------------------------------------");
    // wenn ein Zeichen ein klein Buchstabb ist, wird die sekundarischenVariable vermindert
    if (z1 >= 97 && z1<= 122) {
      zeichen1 -= 32;
    } 
    if(z2 >= 97 && z2<= 122){
      zeichen2 -= 32;
    } 
    if (z3 >= 97 && z3<= 122) {
      zeichen3 -= 32;  
    }
    
    if (zeichen1 < zeichen2 && zeichen1 < zeichen3){
      System.out.println(z1);
      if (zeichen2 < zeichen3) {
        System.out.println(z2);
        System.out.println(z3);
      }
      else {
        System.out.println(z3);
        System.out.println(z2);
      }
    } 
    else{
      if (zeichen2 < zeichen3) {
        System.out.println(z2);
        if (zeichen1 < zeichen3) {
          System.out.println(z1);
          System.out.println(z3);
        }
        else {
          System.out.println(z3);
          System.out.println(z1);          
        } 
      } else {
        System.out.println(z3);
        if (zeichen1 < zeichen2) {
          System.out.println(z1);
          System.out.println(z2);
        }
        else {
          System.out.println(z2);
          System.out.println(z1);          
        } 
      } 
    } 
  }
}
