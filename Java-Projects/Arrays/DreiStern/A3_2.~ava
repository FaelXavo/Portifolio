import java.util.Scanner;

class A3_2{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Bitte die Anzahl der Felder eingeben: ");
    int x = s.nextInt();

    int[][] matrix = new int[x + 1][x + 1];
    for (int i = 0;  i < x ; i++) {
      for (int j = 0; j < x; j++) {
        matrix[i][j] = j * i;
        System.out.print(matrix[i][j]);
        if (j < x - 1) {
        System.out.print(",\t");
      }
     }
        System.out.print("\n");
    }
    
  }
}
