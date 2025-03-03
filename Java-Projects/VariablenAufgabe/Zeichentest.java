import java.util.Scanner;
class Zeichentest{
      public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       char userChar = sc.next().charAt(0);
       char newChar = (char) (userChar + 5);
       System.out.println(newChar);
      }
  }