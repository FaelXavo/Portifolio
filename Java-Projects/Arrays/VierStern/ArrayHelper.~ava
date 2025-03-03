import java.util.ArrayList;
import java.util.Arrays;

class ArrayHelper{
  public static String convertArrayToString(ArrayList<Integer> zahlen){
    //return Arrays.toString(zahlen);
    String convertedArray = "";
    
    for (int i = 0; i < zahlen.size();i++) {
      int n = zahlen.get(i);
      if (n > 10) {
        for (int digit : digitsTrenner(n)){
            convertedArray += (char)(digit + '0');
        } 
        } 
      else {
           convertedArray += (char)(n + '0');
      }
      if (i < zahlen.size() - 1) {
        convertedArray += ", "; 
      } 
      }
      return convertedArray; 
    }
  
  public static ArrayList<Integer> digitsTrenner(int zahl){        //345
    ArrayList<Integer> ungekerhtenDigits = new ArrayList<>();
    while (zahl > 0)
    {
      //Trennt die Zahlen und fügt sie invertiert in ein Array ein 
      int digit = zahl % 10; 
      ungekerhtenDigits.add(digit);
      zahl /= 10 ;
      }
      //Kehrt die Reihenfolge der Array-Werte um
      ArrayList<Integer> richtigeDigits = new ArrayList<>();
      for (int i = ungekerhtenDigits.size() - 1; i >= 0 ; i--) {
        richtigeDigits.add(ungekerhtenDigits.get(i));
      }  
    return richtigeDigits;   
  }           
}
