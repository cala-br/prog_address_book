package address_book;

import java.util.List;

import javax.swing.JTable;

public class ContactsTable extends JTable {
  public final List<Contact> contacts;

  public ContactsTable(List<Contact> contacts) {
    super(new ContactsTableModel());

    this.contacts = contacts;
    addContacts();
  }


  public void addContact(Contact contact) {
    getCTModel().addRow(
      contact.toArray()
    );
    
    contacts.add(contact);
  }

  public void removeAllRows() {
    var model = getCTModel();
    var i = model.getRowCount() - 1;
    
    for (; i >= 0; i--) {
      removeRow(getCTModel(), i);
    }
  }

  public void removeSelectedContact() {    
    var row = getSelectedRow();
    if (row == -1) {
      return;
    }

    removeRow(getCTModel(), row);
  }

  private void removeRow(ContactsTableModel model, int i) {
    model.removeRow(i);
    contacts.remove(i);
  }


  private void addContacts() {
    var model = getCTModel();
    
    for (var contact : contacts) {
      model.addRow(
        contact.toArray()
      );
    }
  }


  private ContactsTableModel getCTModel() {
    return (ContactsTableModel)getModel(); 
  }
}
