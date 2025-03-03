import java.util.ArrayList;

class ArrayHelperTest{
  public static void main(String[] args) {
    ArrayList<Integer> zahlen = new ArrayList<>();
    for(int i = 0; i < 10; i++){
      zahlen.add(i, i); 
    }
      zahlen.set(2, 222);
      zahlen.set(3, 333);
      zahlen.set(5, 555);
      zahlen.set(7, 777);
    System.out.println( "array: " + ArrayHelper.convertArrayToString(zahlen));
    
  }
}
