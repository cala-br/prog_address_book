package address_book;

import java.util.List;

import javax.swing.JTable;

public class ContactsTable extends JTable {
  public final List<Contact> contacts;
  private final ContactsTableModel model;

  public ContactsTable(List<Contact> contacts) {
    super(new ContactsTableModel());

    this.contacts = contacts;
    model = (ContactsTableModel)getModel();
    initContacts();
  }


  public void addContact(Contact contact) {
    model.addContact(contact);
    contacts.add(contact);
  }

  public void removeAllRows() {
    model.removeAllContacts();
    contacts.clear();
  }

  public void removeSelectedContact() {    
    var row = getSelectedRow();
    if (row == -1) {
      return;
    }

    model.removeRow(row);
    contacts.remove(row);
  }


  private void initContacts() {
    model.addContacts(contacts);
  }
}
