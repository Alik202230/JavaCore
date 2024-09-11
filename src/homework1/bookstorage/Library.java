package homework1.bookstorage;

import homework1.bookstorage.constant.CommandConstant;
import homework1.bookstorage.model.Author;
import homework1.bookstorage.model.Book;
import homework1.bookstorage.storage.AuthorStorage;
import homework1.bookstorage.storage.BookStorage;

import java.util.Scanner;

public class Library implements CommandConstant {

  private static final BookStorage bookStorage = new BookStorage();
  private static final AuthorStorage authorStorage = new AuthorStorage();
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean isRun = true;

    while (isRun) {
      CommandConstant.printCommands();
      String command = scanner.nextLine();
      switch (command) {
        case CommandConstant.ZERO:
          isRun = false;
          break;
        case CommandConstant.ONE:
          addBook();
          break;
        case CommandConstant.TWO:
          addAuthor();
          break;
        case CommandConstant.THREE:
          bookStorage.print();
          break;
        case CommandConstant.FOUR:
          authorStorage.print();
          break;
        case CommandConstant.FIVE:
          searchBook();
          break;
        case CommandConstant.SIX:
          updateBook();
          break;
        case CommandConstant.SEVEN:
          deleteBook();
          break;
        case CommandConstant.EIGHT:
          bookByRange();
        case CommandConstant.NINE:
          searchBookByAuthor();
        default:
          System.out.println(CommandConstant.INVALID_COMMAND);
      }
    }
  }

  private static void searchBookByAuthor() {
    authorStorage.print();
    System.out.println("Please choose author id");
    String authorId = scanner.nextLine();
    Author author = authorStorage.getAuthorById(authorId);

    if (author != null) {
      bookStorage.searchByAuthor(author);
    }

  }

  private static void addAuthor() {
    System.out.println("Please input id, name, surname, phone, age");
    String authorData = scanner.nextLine();
    String[] authors = authorData.split(",");
    if (authors.length == 5) {
      String id = authors[0];
      if (id != null && !id.isEmpty()) {
        Author author = new Author(
            id,
            authors[1],
            authors[2],
            authors[3],
            Integer.parseInt(authors[4])
        );
        authorStorage.add(author);
        System.out.println("Author added successfully");
      } else {
        System.out.println("Author with id " + id + " already exists");
      }
    } else {
      System.out.println("-----------------------------------------------");
      System.out.println("   All field are required: Please try again!!");
      System.out.println("-----------------------------------------------");
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
    System.out.println("Book deleted");
  }

  private static void addBook() {
    authorStorage.print();
    System.out.println("Please choose author id");
    String authorId = scanner.nextLine();
    Author author = authorStorage.getAuthorById(authorId);
    if (author != null) {
      System.out.println("Please enter book id");
      String id = scanner.nextLine();
      Book bookId = bookStorage.getBookById(id);
      if (bookId != null) {
        System.out.println("The id " + id + " already exists");
      } else {
        System.out.println("Please enter book title");
        String title = scanner.nextLine();
        System.out.println("Please enter book price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter book quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        Book book = new Book(id, title, author, price, quantity);
        bookStorage.add(book);
        System.out.println("Book added successfully");
      }
    } else {
      System.out.println("Author with id " + authorId + " does not exist");
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
      String authorId = scanner.nextLine();
      Author author = authorStorage.getAuthorById(authorId);
      if (author != null) {
        System.out.println("Please enter book new  price");
        String priceStr = scanner.nextLine();
        if (title != null && !title.isEmpty()) {
          bookId.setTitle(title);
        }
        bookId.setAuthor(author);
        if (priceStr != null && !priceStr.isEmpty()) {
          bookId.setPrice(Double.parseDouble(priceStr));
        }
        System.out.println("Book updated successfully");
      }
    }
  }
}
