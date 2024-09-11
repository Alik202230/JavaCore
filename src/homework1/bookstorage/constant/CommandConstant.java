package homework1.bookstorage.constant;

public interface CommandConstant {
  String EXIT = "EXIT";
  String ADD_BOOK = "ADD BOOK";
  String ADD_AUTHOR = "ADD AUTHOR";
  String PRINT_ALL_BOOKS = "PRINT ALL BOOKS";
  String PRINT_ALL_AUTHORS = "PRINT ALL AUTHORS";
  String SEARCH_BOOK_BY_NAME = "SEARCH BOOK BY NAME";
  String UPDATE_BOOK = "UPDATE BOOK";
  String DELETE_BOOK = "DELETE BOOK";
  String SEARCH_BY_PRICE = "SEARCH BY PRICE";
  String SEARCH_BY_AUTHOR = "SEARCH BY AUTHOR";

  String INPUT = "Please enter";
  String INVALID_COMMAND = "Invalid command";
  String ZERO = "0";
  String ONE = "1";
  String TWO = "2";
  String THREE = "3";
  String FOUR = "4";
  String FIVE = "5";
  String SIX = "6";
  String SEVEN = "7";
  String EIGHT = "8";
  String NINE = "9";


  static void printCommands() {
    System.out.println(INPUT + " " + ZERO + " for " + EXIT);
    System.out.println(INPUT + " " + ONE + " for " + ADD_BOOK);
    System.out.println(INPUT + " " + TWO + " for " + ADD_AUTHOR);
    System.out.println(INPUT + " " + THREE + " for " + PRINT_ALL_BOOKS);
    System.out.println(INPUT + " " + FOUR + " for " + PRINT_ALL_AUTHORS);
    System.out.println(INPUT + " " + FIVE + " for " + SEARCH_BOOK_BY_NAME);
    System.out.println(INPUT + " " + SIX + " for " + UPDATE_BOOK);
    System.out.println(INPUT + " " + SEVEN + " for " + DELETE_BOOK);
    System.out.println(INPUT + " " + EIGHT + " for " + SEARCH_BY_PRICE);
    System.out.println(INPUT + " " + NINE + " for " + SEARCH_BY_AUTHOR);
  }

}
