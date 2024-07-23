package homework1;

public class ArrayHomeWork {
  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 6, 6, 4, 3, 3, 3, 3};
    boolean[] isVisited = new boolean[arr.length];

    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (!isVisited[i]) {
        boolean isFound = false;
        for (int j = i + 1; j < arr.length; j++) {
          if (arr[i] == arr[j]) {
            isFound = true;
            isVisited[j] = true;
          }
        }
        if (isFound) {
          count++;
        }
      }
    }

    int n = 6;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (n == arr[i]) {
        sum++;
      }
    }

    System.out.println(sum);

    for (int i = arr.length - 1; i > 0; i--) {
      System.out.print(arr[i] + " ");
    }

    System.out.println(sum);
    System.out.println("The total number of duplicate elements are " + count);

    char[] chars = {'բ', 'ա', 'ր', 'և', 'ա', 'շ', 'խ', 'ա', 'ր', 'հ'};
    char[] vowels = {'ա', 'է', 'ը', 'ի', 'օ', 'ո','ւ'};
    int counter = 0;
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < vowels.length; j++) {
        if (chars[i] == vowels[j]) {
          counter++;
        }
      }
    }
    System.out.println("Vowels " + counter);
  }
}
