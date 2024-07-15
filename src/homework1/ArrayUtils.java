package homework1;

public class ArrayUtils {
  public static void main(String[] args) {
    int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
    }

    System.out.println();
    System.out.println("=============== Exercise 2 ================");
    System.out.println();

    int first = numbers[0];
    System.out.println("The first element of an array is " + first);

    System.out.println();
    System.out.println("=============== Exercise 3 ================");
    System.out.println();

    int last = numbers[numbers.length - 1];
    System.out.println("The last element of an array is " + last);

    System.out.println();
    System.out.println("=============== Exercise 4 ================");
    System.out.println();

    int length = numbers.length;
    System.out.println("The length of array is " + length);

    System.out.println();
    System.out.println("=============== Exercise 5 ================");
    System.out.println();

    int min = numbers[0];
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] < min) {
        min = numbers[i];
      }
    }
    System.out.println("The smallest number of an array is " + min);

    System.out.println();
    System.out.println("=============== Exercise 6 ================");
    System.out.println();

    int middle = numbers[numbers.length / 2];
    int next = numbers[numbers.length / 2 + 1];

    if (numbers.length <= 2) {
      System.out.println("Cannot print middle value");
    } else if (numbers.length % 2 == 0) {
      System.out.println("The middle element is " + middle);
    } else {
      System.out.println("The middle element is " + middle + " and the following id " + next);
    }


    // Same as above just used by BITWISE operators
//    int middle = numbers[numbers.length >>  1];
//    int next = numbers[(numbers.length >> 1) + 1];
//    if (numbers.length <= 2) {
//      System.out.println("Can't print middle value");
//    } else if ((numbers.length & 1) == 0) {
//      System.out.println("The middle element is " + middle);
//    } else {
//      System.out.println("The middle element is " + middle + " and the following id " + next);
//    }


    System.out.println();
    System.out.println("=============== Exercise 7 ================");
    System.out.println();

    int count = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] % 2 == 0) {
        count++;
      }
    }
    System.out.println("There are " + count + " even digits in an array");

    System.out.println();
    System.out.println("=============== Exercise 8 ================");
    System.out.println();

    int counter = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] % 2 != 0) {
        counter++;
      }
    }
    System.out.println("There are " + counter + " odd digits in an array");

    System.out.println();
    System.out.println("=============== Exercise 9 ================");
    System.out.println();

    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      sum += numbers[i];
    }
    System.out.println("The sum is " + sum);

    System.out.println();
    System.out.println("=============== Exercise 10 ================");
    System.out.println();

    int average = 0;
    for (int i = 0; i < numbers.length; i++) {
      average += numbers[i] / numbers.length;
    }
    System.out.println("The average is " + average);
  }
}
