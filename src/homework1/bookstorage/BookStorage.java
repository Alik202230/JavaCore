package homework1.bookstorage;

public class BookStorage {
  private Book[] books;
  private int size;

  public BookStorage(Book[] books, int size) {
    this.books = books;
    this.size = size;
  }

  public void add(Book book) {
    if (size == books.length) {
      extend();
    }
    books[size++] = book;
  }

  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.println(books[i]);
    }
  }

  private void extend() {
    Book[] temp = new Book[size + 1];
    if (size >= 0) System.arraycopy(books, 0, temp, 0, size);
    books = temp;
  }

  public void searchByTitle(String keyword) {
    for (int i = 0; i < size; i++) {
      if (books[i].getTitle().equals(keyword)) {
        System.out.println(books[i]);
      }
    }
  }

  public Book getBookById(String id) {
    for (int i = 0; i < size; i++) {
      if (books[i].getId().equals(id)) {
        return books[i];
      }
    }
    return null;
  }

  public void deleteBookById(String id) {
    for (int i = 0; i < size; i++) {
      if (books[i].getId().equals(id)) {
        books[i] = books[i + 1];
      }
      books[size - 1] = null;
      size--;
    }
  }

  public void getBookByRange(double minRange, double maxRange) {
    for (int i = 0; i < size; i++) {
      if (books[i].getPrice() >= minRange && books[i].getPrice() <= maxRange) {
        System.out.println(books[i]);
      }
    }
  }

}
