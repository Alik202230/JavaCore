package homework1;

public class Sort {
  public static void main(String[] args) {
    int[] array = {4,7,1,3,9,0,2};
    System.out.println("Before Sorting: ");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    System.out.println("After Sorting: ");
    for (int i = 0; i < array.length; i++) {
      for (int j = i+1; j < array.length; j++) {
        if (array[i] > array[j]) {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
      System.out.print(array[i] + " ");
    }
  }
}
