package homework1.shop.storage;

import homework1.shop.entity.Product;

public class ProductStorage {
  private Product[] products = new Product[10];
  private int size;

  public void add(Product product) {
    if (size == products.length) {
      extend();
    }
    products[size++] = product;
  }

  private void extend() {
    Product[] newProducts = new Product[products.length * 2];
    System.arraycopy(products, 0, newProducts, 0, products.length);
    products = newProducts;
  }

  public void display() {
    for (int i = 0; i < size; i++) {
      Product product = products[i];
      System.out.println(product);
    }
  }

  public Product getProductById(int id) {
    for (int i = 0; i < size; i++) {
      Product product = products[i];
      if (product.getId() == id) {
        return product;
      }
    }
    return null;
  }

  public boolean isEmpty() {
    return size == 0;
  }

}
