package homework1.ecommerce.storage;

import com.sun.security.jgss.GSSUtil;
import homework1.ecommerce.entity.Product;

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

  public void print() {
    for (int i = 0; i < size; i++) {
      System.out.println(products[i]);
    }
  }

  public Product getProductById(String productId) {
    for (int i = 0; i < size; i++) {
      Product product = products[i];
      if (product.getId().equals(productId)) {
        return product;
      }
    }
    return null;
  }

  public void removeProductById(String productId) {
    int index = getProductIndex(productId);
    if (index != -1) {
      for (int i = index + 1; i < size; i++) {
        products[i - 1] = products[i];
      }
      size--;
    } else {
      System.out.println("No such product");
    }

  }

  private int getProductIndex(String productId) {
    for (int i = 0; i < size; i++) {
      if (products[i].getId().equals(productId)) {
        return i;
      }
    }
    return -1;
  }

  public boolean isEmpty() {
    return size == 0;
  }

}
