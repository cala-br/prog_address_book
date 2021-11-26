package address_book;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends ArrayList<Contact> {
  public ContactList(List<Contact> contacts) {
    super(contacts);
  }

  public ContactList() {
    super();
  }
}
