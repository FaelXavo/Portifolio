/*
 *  Dieses Programm wurd entwicklelt, um Strings zu bearbeiten
 *
 *  @Rafael Xavier
 **/

import java.lang.String;

class A1{
   /*
   * Diese Methode ersetzt jedes Vorkommen des Buchstabens 'r' in der Eingabezeichenkette
   * durch 'rrr'.
   * @parameter s ist die Eingabezeichenkette.
   * @return die veränderte Zeichenkette mit 'rrr' anstelle von 'r'.
   */
    public static String grrr(String s){
        int str_length = s.length();
        String ende_string = "";
        for(int i = 0; i < str_length; i++){
          if (s.charAt(i) == 'r') {
            ende_string += "rrr";
          } else {
            ende_string += (s.charAt(i));
          }
        }
        return ende_string;
    }
   /*
   * Diese Methode entfernt alle Vokale aus einer gegebenen Zeichenkette.
   * @parameter s ist die Eingabezeichenkette.
   * @return die Zeichenkette ohne Vokale.
   */
    public static String removeVovel(String s){   
    String ende_string = "";       
    for(int i = 0; i< s.length(); i++){
      if (s.charAt(i) != 'a' || s.charAt(i) != 'e' || s.charAt(i) != 'i' ||
       s.charAt(i) != 'o' || s.charAt(i) != 'u'){
           ende_string += s.charAt(i);
        }
    }
    return ende_string;
    }
   /*
   * Diese Methode gibt eine Zeichenkette aus und markiert eine bestimmte Teilzeichenkette 
   * mit Unterstrichen ('-').
   * @parameter s ist die Eingabezeichenkette.
   * @parameter underline ist die Teilzeichenkette, die unterstrichen werden soll.
   * @return die ursprüngliche Zeichenkette mit einer darunterliegenden Markierung.
   */
    public static String printUnderline(String s, String underline){
      String new_string = "";
      int i = 0;
      while (i < s.length()) { 
          if (i + underline.length() <= s.length() && s.substring(i, i + underline.length()).equals(underline)) {
            new_string += "-".repeat(underline.length());
            i += underline.length();
        } else {
            new_string += ' ';
            i++;
        }
      }
      return (s+"\n"+new_string);
    }
  
    public static void main(String[] args) {
      System.out.println(grrr("arara"));
      System.out.println(removeVovel("arara"));
      System.out.println(printUnderline("maluquice do crl eu posso escrever o que eu quiser nessa merda crl.", "eu"));
    }
  }
