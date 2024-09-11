package homework1.bookstorage.storage;

import homework1.bookstorage.model.Author;

public class AuthorStorage {
  private Author[] authors = new Author[10];
  private int size;

  public void add(Author author) {
    if (size == authors.length) {
      extend();
    }
    authors[size++] = author;
  }

  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.println(authors[i]);
    }
  }

  private void extend() {
    Author[] temp = new Author[size + 1];
    if (size >= 0) System.arraycopy(authors, 0, temp, 0, size);
    authors = temp;
  }

  public Author getAuthorById(String id) {
    for (int i = 0; i < size; i++) {
      Author author = authors[i];
      if (author.getId().equals(id)) {
        return author;
      }
    }
    return null;
  }

  public void deleteAuthor(String id) {
    int index = getAuthorIndexById(id);
    if (index != -1) {
      for (int i = index; i < size; i++) {
        authors[i - 1] = authors[i];
      }
      size--;
    }
  }

  private int getAuthorIndexById(String id) {
    for (int i = 0; i < size; i++) {
      Author author = authors[i];
      if (author.getId().equals(id)) {
        return i;
      }
    }
    return -1;
  }

}
