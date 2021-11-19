package address_book;

public class Contact {
  public final String name;
  public final String surname;
  public final String address;
  public final String tel;

  public Contact(
    String name,
    String surname,
    String address,
    String tel
  ) {
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.tel = tel;
  }


  public String toFullNameString() {
    return String.format("%s %s", name, surname);
  }

  public boolean matches(String searchTerm) {
    return 
      name.contains(searchTerm) ||
      surname.contains(searchTerm) ||
      address.contains(searchTerm) ||
      tel.contains(searchTerm);
  }

  public Object[] toArray() {
    return new Object[] {
      name,
      surname,
      address,
      tel,
    };
  }
}
