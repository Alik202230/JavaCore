package homework1;

public class Figure {
  public static void main(String[] args) {
    int height = 7;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < height * 2; j++) {
        if (j == height - 1 - i || j == height + i || (i == height / 2 && j >= height - 1 - i && j <= height + i)) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }

      System.out.print("  ");
      for (int j = 0; j < height; j++) {
        if ((j == height - 1 - i && i <= 3) || (j == i && j <= 3) || j == 0 || j == height - 1) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }

      for (int j = 0; j < height * 2; j++) {
        if (j == height - 1 - i || j == height + i || (i == height / 2 && j >= height - 1 - i && j <= height + i)) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }

      System.out.print(" ");
      for (int j = 0; j < height; j++) {
        if (j == 0 || i == 6) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }

      for (int j = 0; j < height; j++) {
        if (j == 3) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }

      for (int j = 0; j < height; j++) {
        if (j == 0 || j == height - 3 - i || j == i - 2) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }

      System.out.println();
    }
  }
}
