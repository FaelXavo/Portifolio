import java.util.*;

public class testinforlilly{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
      
    System.out.println("Regnet es? (j/n)");  //Frage über das Wetter
    char regen = s.next().charAt(0);  //Die Antwort speichern
      
    System.out.println("Ist es Sonnig? (j/n)");
    char sonnig = s.next().charAt(0);
      
    System.out.println("Ist es heiß? (j/n)");
    char heiss = s.next().charAt(0);  
    
    System.out.println("Ist es Stürmisch? (j/n)");
    char stuermisch = s.next().charAt(0);  
    
    System.out.println(""); //Space
      
    switch (regen) {
      case  'j':
        switch (stuermisch) {
          case  'j': 
            System.out.println("Autoschlüssel");
            break;
          case  'n': 
            System.out.println("Regenschirm");
            break;
          default: 
            System.out.println("Antworten Sie bitte nur mir 'j' oder 'n' (beim stuermisch)");
        }
        switch (sonnig) {
          case  'j': 
            System.out.println("Spaten");
            break;
          case  'n': 
            System.out.println("Badesachen");
            break;
          default: 
            System.out.println("Antworten Sie bitte nur mir 'j' oder 'n' (beim sonnig)");
        }
        break;
        
      case  'n': 
        switch (sonnig) {
          case  'j': 
            System.out.println("Badesachen");
            break;
          case  'n': 
            
            break;
          default: 
            System.out.println("Antworten Sie bitte nur mir 'j' oder 'n' (beim sonnig)");
        }
        break;
        
      default: 
        System.out.println("Antworten Sie bitte nur mir 'j' oder 'n' (beim regen)");
    }
    
    switch (heiss) {
      case  'j':
        switch (regen) {
          case  'n': 
            System.out.println("Wasserflasche");
            break;
          case  'j': 
            
            break;
          default: 
            System.out.println("Antworten Sie bitte nur mir 'j' oder 'n' (beim heiss)");
        } 
        switch (sonnig) {
          case  'n': 
            System.out.println("Schulsachen");
            break;
          case  'j': 
            
            break;
          default: 
            System.out.println("Antworten Sie bitte nur mir 'j' oder 'n' (beim sonnig)");
        }

        break;
      case  'n': 
        System.out.println("Schulsachen");
        break;
      default: 
        System.out.println("Antworten Sie bitte nur mir 'j' oder 'n' (beim heiss)");
    }
  }
}
