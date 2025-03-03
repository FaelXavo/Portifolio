import java.util.Scanner;

class PQFormelA9{
  public static void main(String[] args){
    Scanner scann = new Scanner(System.in);
    System.out.println("Bitte geben Sie p ein");
    float p = scann.nextFloat();
    System.out.println("Bitte geben Sie q ein");
    float q = scann.nextFloat();
    //float ZweiterSchritt = (p*p/4) - q ;
    double wuerzel = Math.sqrt((p*p/4) - q );
    double X1 = (-p/2) + wuerzel;
    double X2 = (-p/2) - wuerzel;
    
    if (wuerzel < 0) {
     System.out.println("Es gibt keine Nullstelle"); 
    } else if(wuerzel == 0){
     System.out.println("Die Nullstelle liegt bei x1 = " + X1);  
    } else {
     System.out.println("Die Nullstellen liegen bein x1 = " + X1 + " und x2 = "+ X2);    
    }       
  }  
}
