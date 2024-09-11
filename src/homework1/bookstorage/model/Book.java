package homework1.bookstorage.model;

import java.util.Objects;

public class Book {
  private String id;
  private String title;
  private Author author;
  private double price;
  private int quantity;

  public Book(String id, String title, Author author, double price, int quantity) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.price = price;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Double.compare(price, book.price) == 0
        && Objects.equals(id, book.id)
        && Objects.equals(title, book.title)
        && Objects.equals(author, book.author)
        && Objects.equals(quantity, book.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, price, quantity);
  }

  @Override
  public String toString() {
    return "Book[" +
        "id='" + id + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", price=" + price + '\'' +
        ", quantity=" + quantity +
        ']';
  }
}
