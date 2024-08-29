package homework1.bookstorage;

import java.util.Scanner;

public class Library {
  private static final BookStorage bookStorage = new BookStorage(new Book[10], 0);
  private static final Scanner scanner = new Scanner(System.in);
  private static int count = 0;
  public static void main(String[] args) {
    boolean isRun = true;

    while (isRun) {
      printCommands();
      String command = scanner.nextLine();
      switch (command) {
        case CommandConstant.ZERO:
          isRun = false;
          break;
        case CommandConstant.ONE:
          addBook();
          break;
        case CommandConstant.TWO:
          bookStorage.print();
          break;
        case CommandConstant.THREE:
          searchBook();
          break;
        case CommandConstant.FOUR:
          updateBook();
          break;
        case CommandConstant.FIVE:
          deleteBook();
          break;
        case CommandConstant.SIX:
          bookByRange();
          break;
        default:
          System.out.println(CommandConstant.INVALID_COMMAND);
      }
    }
  }

  private static void bookByRange() {
    System.out.println("Please enter min range");
    double minRange = Double.parseDouble(scanner.nextLine());
    System.out.println("Please enter max range");
    double maxRange = Double.parseDouble(scanner.nextLine());
    bookStorage.getBookByRange(minRange, maxRange);
  }

  private static void deleteBook() {
    System.out.println("Please enter book id");
    String id = scanner.nextLine();
    bookStorage.deleteBookById(id);
    count--;
    System.out.println("Book deleted");
  }

  private static void addBook() {
    System.out.println("Please enter book id");
    String id = scanner.nextLine();
    Book bookId = bookStorage.getBookById(id);
    if (bookId != null) {
      System.out.println("The id " + id + " already exists");
    } else {
      System.out.println("Please enter book title");
      String title = scanner.nextLine();
      System.out.println("Please enter book author name");
      String author = scanner.nextLine();
      System.out.println("Please enter book price");
      double price = Double.parseDouble(scanner.nextLine());
      System.out.println("Please enter book quantity");
      int quantity = Integer.parseInt(scanner.nextLine());
      Book book = new Book(id, title, author, price, quantity);
      bookStorage.add(book);
      count++;
      System.out.println("Book added successfully and book quantity is " + count);
    }
  }

  private static void searchBook() {
    System.out.println("Please enter book keyword");
    String keyword = scanner.nextLine();
    bookStorage.searchByTitle(keyword);
  }

  private static void updateBook() {
    bookStorage.print();
    System.out.println("Please enter book id");
    String id = scanner.nextLine();
    Book bookId = bookStorage.getBookById(id);

    if (bookId != null) {
      System.out.println("Please enter book's new  title");
      String title = scanner.nextLine();
      System.out.println("Please enter book author's new  name");
      String author = scanner.nextLine();
      System.out.println("Please enter book new  price");
      String priceStr = scanner.nextLine();
      if (title != null && !title.isEmpty()) {
        bookId.setTitle(title);
      }
      if (author != null && !author.isEmpty()) {
        bookId.setAuthor(author);
      }
      if (priceStr != null && !priceStr.isEmpty()) {
        bookId.setPrice(Double.parseDouble(priceStr));
      }
      System.out.println("Book updated successfully");
    }

  }

  private static void printCommands() {
    System.out.println(CommandConstant.INPUT + " " + CommandConstant.ZERO + " for " + BookConstant.EXIT);
    System.out.println(CommandConstant.INPUT + " " + CommandConstant.ONE + " for " + BookConstant.ADD_BOOK);
    System.out.println(CommandConstant.INPUT + " " + CommandConstant.TWO + " for " + BookConstant.PRINT_ALL_BOOK);
    System.out.println(CommandConstant.INPUT + " " + CommandConstant.THREE + " for " + BookConstant.SEARCH_BY_BOOK_TITLE);
    System.out.println(CommandConstant.INPUT + " " + CommandConstant.FOUR + " for " + BookConstant.UPDATE_BOOK);
    System.out.println(CommandConstant.INPUT + " " + CommandConstant.FIVE + " for " + BookConstant.DELETE_BOOK);
    System.out.println(CommandConstant.INPUT + " " + CommandConstant.SIX + " for " + BookConstant.BOOK_BY_RANGE);
  }

}
