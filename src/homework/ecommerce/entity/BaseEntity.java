package homework.ecommerce.entity;

public abstract class BaseEntity {
  protected String id;
  protected String name;

  public BaseEntity() {}

  public BaseEntity(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public BaseEntity(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
