class Lauf{
  public static void main(String[] args) {
    double geschwindigkeitA = 9.5;
    double geschwindigkeitB = 7;
    char gewinner = '/';
    int i = 0;
    System.out.println("Zeit(s)     A        B");
    while (gewinner != 'A' && gewinner != 'B'){
        double positionA = geschwindigkeitA * i;
        double positionB = geschwindigkeitB * i + 250;
        System.out.println(i + "         " + positionA + "       "+ positionB);
        if (positionA >= 1000){
          System.out.println("");
          gewinner = 'A';
        } 
        else if (positionB >= 1000) {
          System.out.println("");
          gewinner = 'B';    
        }
        else {
          i++;
        } 
    }
    System.out.println("Der gewinner ist: Sprinter "+ gewinner);
  }
}
