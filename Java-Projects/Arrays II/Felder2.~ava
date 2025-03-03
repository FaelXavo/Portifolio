import java.util.ArrayList;
import java.util.Arrays;
//ArrayList<Integer> ungekerhtenDigits = new ArrayList<>();

class Felder2{
  public static int minWert(ArrayList<Integer> zahlen){
    int kleinerZahl = zahlen.get(0);
    
    for (int i = 0;i < zahlen.size(); i++) {
      if (kleinerZahl > zahlen.get(i)){  
        kleinerZahl = zahlen.get(i);
      }
    }
    return kleinerZahl;
  }
  
  public static int durschnitt(ArrayList<Integer> zahlen){
    int durschnittWert;
    int summe = 0;
    int anzahl = zahlen.size();
    for (int zahl: zahlen ) {
      summe += zahl;
    }
    durschnittWert = summe/anzahl;
    return durschnittWert;
  }
  
    public static String[][] matrixErstellen(int groesse) {
    int x = groesse; //Größe der Matrix (wenn 4, wird es eine 4x4 Matrix erstellen)
    String[][] matrix = new String[x + 1][x + 1];
    for (int i = 0;  i < x ; i++) {
      for (int j = 0; j < x; j++) {
        matrix[i][j] = i + ", " + j;
      }
     }
    return matrix;    
    }
  public static void matrixAusdruecken(String[][] matrix){
    for (int i = 0;  i < matrix.length -1 ; i++) {
      for (int j = 0; j < matrix[i].length - 1; j++) {
        System.out.print(matrix[i][j]);
        if (j < matrix[i].length - 1) 
          System.out.print(";\t");
     }
      System.out.print("\n");
    }
    return;
    }
  
  public static String[] findByFirstChar(String[] Worte, char zeichen){
    String[] matchingWords = new String[Worte.length];
    for(int i = 0; i < Worte.length; i++){
      String wort = Worte[i];
      if(wort.charAt(0) == zeichen){
         matchingWords[i] = wort;
      } else {
          matchingWords[i] = "0";
        } 
    }
    return matchingWords;
  }
  
  public static int[] zufallsZahlenFeld(int groesse, int minGrenze, int maxGrenze){
    int[] zufallsZahlen = new int[groesse];
    
    
    
    }        
}                  

