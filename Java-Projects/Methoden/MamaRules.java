/*
  Diese Methode ergbit eine String wenn ihre Parameter True other False ist. 
  Es antwortet ob ein Stecker gezogen ist.
          
  @returns die Antwort des Kinds an seine Mutter als eine String
  
  @parameter is ein boolean, die eingegeben sein soll
**/

public class MamaRules {
    public static String raeumDeinZimmerAuf(boolean steckerVomPcGezogen){
      if (steckerVomPcGezogen) 
         return "Ja mach ich :(";  
      else 
         return "Nicht jeeeetzt";
  }
}
  
