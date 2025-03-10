/*
 *  Dieses Programm wurd entwicklelt, um Strings zu bearbeiten
 *
 *  @Rafael Xavier
 **/

import java.lang.String;

class A5 
{
    /*
   * Diese Methode übersetzt eine gegebene Zeichenkette in Morsecode.
   * Buchstaben (A-Z) und Ziffern (0-9) werden in die entsprechenden Morsezeichen umgewandelt.
   * Andere Zeichen werden als Leerzeichen dargestellt.
   * @parameter s ist die Eingabezeichenkette, die in Morsecode umgewandelt wird.
   * @return die übersetzte Zeichenkette in Morsecode.
   */
  public static String morseUebersetzen(String s){
        int i = 0;
        String upperString = s.toUpperCase();
        String newString = "";
        String[]morseArray = new String[36];
        morseArray[0] = ".-";           //A
        morseArray[1] = "-...";         //B
        morseArray[2] = "-.-.";           //C
        morseArray[3] = "-..";            //D
        morseArray[4] = ".";              //E
        morseArray[5] = "..-.";           //F
        morseArray[6] = "--.";            //G
        morseArray[7] = "....";           //H
        morseArray[8] = "..";           //I
        morseArray[9] = ".---";         //J
        morseArray[10] = "-.-";         //K
        morseArray[11] = ".-..";        //L
        morseArray[12] = "-.";          //M
        morseArray[13] = "---";         //N
        morseArray[14] = ".--.";        //O
        morseArray[15] = "--.-";        //P
        morseArray[16] = ".-.";         //Q
        morseArray[17] = "...";         //R
        morseArray[18] = "-";           //S
        morseArray[19] = "..-";         //T
        morseArray[20] = "...-";        //U
        morseArray[21] = ".--";         //V
        morseArray[22] = "-..-";        //W
        morseArray[23] = "-.--";        //X
        morseArray[24] = "--..";        //Y
        morseArray[25] = "-----";       //Z
        morseArray[26] = ".----";       //0
        morseArray[27] = "..---";       //1
        morseArray[28] = "...--";       //2
        morseArray[29] = "....-";       //3
        morseArray[30] = "......";      //4
        morseArray[31] = "-....";       //5
        morseArray[32] = "--...";       //6
        morseArray[33] = "---..";       //7
        morseArray[34] = "----.";       //8
        morseArray[35] = "----.";       //9
        while (i < s.length()) { 
          if (upperString.charAt(i) >= 65 && upperString.charAt(i) <= 90)
          {
            int index = upperString.charAt(i) - 65;
            newString += " " + morseArray[index];
          }
          else if (upperString.charAt(i) >=48 && upperString.charAt(i) <= 57) 
          {
            int index = upperString.charAt(i) - 22;
            newString += " " + morseArray[index];          
          }
          else 
          {
            newString += "   ";
          }
        i++;
        }
        return newString;           
  }
  
  public static void main(String[] args) {
    System.out.println(morseUebersetzen("test 5"));
  }
}
