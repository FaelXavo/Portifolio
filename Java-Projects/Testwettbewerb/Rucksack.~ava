import java.util.*;

public class Rucksack{
  public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  List<String> rucksack = new ArrayList(); //Hier herstelle ich eine Liste (array), wo alle die GegenStände eingepackt werden.
  rucksack.add("Schulsachen");
    
  System.out.println("Regnet es? (j/n)");  //Frage über das Wetter
  char regen = s.next().charAt(0);  //Die Antwort speichern
  if (regen == 'j') {
    rucksack.add("Regenschirm");  //Hinzufügen des Artikels zum Rucksack  
  }
    
  System.out.println("Ist es Sonnig? (j/n)");
  char sonnig = s.next().charAt(0);
  if (sonnig == 'j') {
    rucksack.add("Badesachen");
  } 
    
  System.out.println("Ist es heiß? (j/n)");
  char heiss = s.next().charAt(0);
  if (heiss == 'j') {
    rucksack.add("Wasserflasche");
  } 
    
  
  System.out.println("Ist es Stürmisch? (j/n)");
  char stuermisch = s.next().charAt(0);  
    
  //hier fangen wir mit den Konditionen an
  if (regen == 'j' && sonnig == 'j') {
    rucksack.add("Spaten");
  }
  if (regen == 'j' && stuermisch == 'j') {
    rucksack.add("Autoschlüssel");
    rucksack.remove("Regenschirm");
  }
  if (regen == 'j' && heiss == 'j'){
    rucksack.remove("Wasserflasche");
  }
  if (sonnig == 'j' && heiss == 'j') {
    rucksack.remove("Schulsachen");
  }
  System.out.println("Die Artikel, die Sie einpacken solle, sind: " + rucksack);
  }
  }
