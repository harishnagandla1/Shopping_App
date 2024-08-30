// Payload Class for 'Pet'

public class PetPayload {

  private String name;
  private String type;
  private int age;

  public PetPayload(Builder builder) {
    this.name = builder.name;
    this.type = builder.type;
    this.age = builder.age;
  }

  public static class Builder {

    private String name;
    private String type;
    private int age;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public PetPayload build() {
      return new PetPayload(this);
    }
  }
}