package address_book;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ContactsTableModel extends DefaultTableModel {
  public ContactsTableModel() {
    super();

    this.addColumn("Name");
    this.addColumn("Surname");
    this.addColumn("Address");
    this.addColumn("Tel");
  }

  
  public void addContacts(List<Contact> contacts) {
    for (var contact : contacts) {
      addContact(contact);
    }
  }

  public void addContact(Contact contact) {
    addRow(contact.toArray());
  }

  public void removeAllContacts() {
    var i = getRowCount() - 1;
    
    for (; i >= 0; i--) {
      removeRow(i);
    }
  }
}
