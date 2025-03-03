/*
 *  Dieses Programm wurd entwicklelt, um Strings zu bearbeiten
 *
 *  @Rafael Xavier
 **/

import java.lang.String;

class A4{
   /*
   * Diese Methode berechnet die Summe der Ziffern einer gegebenen Zeichenkette.
   * Falls die Zeichenkette nicht ausschlie�lich Ziffern enth�lt, wird 0 zur�ckgegeben.
   * @parameter value ist die Eingabezeichenkette, die nur Ziffern enthalten sollte.
   * @return die Summe der Ziffern oder 0, wenn ung�ltige Zeichen enthalten sind.
   */
    public static int sumOfTheDigits(String value){
      int i = 0;
      int sum = 0;
      while (i < value.length()) { 
        if(value.charAt(i) > 57 || value.charAt(i) < 48){
          return (0);
        }
        else {
          sum += value.charAt(i) - 48;
          i++;
        } 
      }
      return sum;
    }

  public static void main(String[] args){
    System.out.println(sumOfTheDigits("10938"));
    }
  }
