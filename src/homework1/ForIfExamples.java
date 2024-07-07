package homework1;

public class ForIfExamples {
  public static void main(String[] args) {
    for(int i = 1; i <= 10; i++) {
      System.out.println(i);
    }

    int sum = 0;
    for(int i = 1; i <= 100; i++) {
      sum += i;
    }
    System.out.println(sum);

    for(int i = 50; i >= 0; i--) {
      System.out.println(i);
    }


    for(int i = 0; i <= 20; i += 2) {
      if (i == 0) i++;
      System.out.println(i);
    }

    // Fide odd number with the help of BITWISE AND operator
    for(int i = 0; i <= 20; i++) {
      if ((i & 1) != 0) {
        System.out.println(i);
      }
    }


    int count = 0;
    for (int i = 0; i <= 100; i += 2) {
      count++;
    }
    System.out.println(count);
  }
}
