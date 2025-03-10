/*
 *  Dieses Programm wurd entwicklelt, um Strings zu bearbeiten
 *
 *  @Rafael Xavier
 **/

import java.lang.String;

class A7
{
    /*
   * Diese Methode verschlüsselt eine gegebene Zeichenkette mit der Caesar-Chiffre,
   * indem jeder Buchstabe um 3 Stellen im Alphabet verschoben wird.
   * @parameter s ist die Eingabezeichenkette, die verschlüsselt wird.
   * @return die verschlüsselte Zeichenkette.
   */
  public static String caesar(String s){
    String lowerString = s.toLowerCase();
    String endString = "";
    int i = 0;
    while (i < lowerString.length()) { 
      if (lowerString.charAt(i) >= 97 && lowerString.charAt(i) <= 119) 
      {
        endString += (char)(lowerString.charAt(i) + 3);
      }
      else if (lowerString.charAt(i) >= 120 && lowerString.charAt(i) <= 122) 
      {
        endString += (char)(lowerString.charAt(i) - 23); 
      }
      else 
      {
        endString += lowerString.charAt(i);
      }
      i++; 
    }
    return endString;
  }
    /*
   * Diese Methode entschlüsselt eine Zeichenkette, die mit der Caesar-Chiffre verschlüsselt wurde,
   * indem jeder Buchstabe um 3 Stellen im Alphabet zurückverschoben wird.
   * @parameter s ist die verschlüsselte Zeichenkette.
   * @return die entschlüsselte Zeichenkette.
   */
  public static String decaesar(String s){
    String lowerString = s.toLowerCase();
    String endString = "";
    int i = 0;
    while (i < lowerString.length()) { 
      if (lowerString.charAt(i) >= 100 && lowerString.charAt(i) <= 122) 
      {
        endString += (char)(lowerString.charAt(i) - 3);
      }
      else if (lowerString.charAt(i) >= 97 && lowerString.charAt(i) <= 99) 
      {
        endString += (char)(lowerString.charAt(i) + 23); 
      }
      else 
      {
        endString += lowerString.charAt(i);
      }
      i++; 
    }
    return endString;  
    }    
    /*
   * Diese Methode verschlüsselt eine Zeichenkette mit einer variablen Verschiebung,
   * basierend auf einem angegebenen Schlüsselzeichen.
   * @parameter s ist die Eingabezeichenkette, die verschlüsselt wird.
   * @parameter key ist das Zeichen, das die Verschiebung im Alphabet bestimmt.
   * @return die verschlüsselte Zeichenkette.
   */
  public static String encode(String s, char key){
    String lowerString = s.toLowerCase();
    int encodingIndex = key - 97;
    System.out.println(encodingIndex);
    String endString = "";
    int i = 0;
    while (i < lowerString.length()) { 
      if (lowerString.charAt(i) >= 97 && lowerString.charAt(i) <= 122) 
      {
        if (lowerString.charAt(i) + encodingIndex > 122) {
          endString += (char)(97 + 122 - lowerString.charAt(i) + encodingIndex );
        }
        else {
          endString += (char)(lowerString.charAt(i) + encodingIndex);
        }
      }
      else 
      {
        endString += lowerString.charAt(i);
      }
      i++; 
    }
    return endString;     
    }
    /*
   * Diese Methode entschlüsselt eine Zeichenkette, die mit der Methode "encode" verschlüsselt wurde,
   * indem die Verschiebung rückgängig gemacht wird.
   * @parameter s ist die verschlüsselte Zeichenkette.
   * @parameter key ist das Zeichen, das die ursprüngliche Verschiebung bestimmt hat.
   * @return die entschlüsselte Zeichenkette.
   */
  public static String decode(String s, char key){
    String lowerString = s.toLowerCase();
    int encodingIndex = key - 97;
    String endString = "";
    int i = 0;
    while (i < lowerString.length()) {
       
      if (lowerString.charAt(i) >= 97 && lowerString.charAt(i) <= 122) 
      {
        if (lowerString.charAt(i) - encodingIndex < 97) {
           endString += (char) ((lowerString.charAt(i) - 97 - encodingIndex + 26) % 26 + 97);
        }
        else {
          endString += (char)(lowerString.charAt(i) - encodingIndex);
        }
      }
      else 
      {
        endString += lowerString.charAt(i);
      }
      i++; 
    }
    return endString;    
    }    
  
  public static void main(String[] args) {
    System.out.println(caesar("abc xyz"));
    System.out.println(decaesar("def abc"));
    System.out.println(encode("abc", 'b'));
    System.out.println(decode("cde abc", 'b'));
  }
}
