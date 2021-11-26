package address_book;

import java.util.List;
import java.util.Vector;

public class ContactVector extends Vector<Contact> {
  public ContactVector(List<Contact> contacts) {
    super(contacts);
  }
}
