package address_book;

import javax.swing.JTable;

public class ContactsTable extends JTable {
  private final Contact[] contacts;
  
  public ContactsTable(Contact ...contacts) {
    super(new ContactsTableModel());

    this.contacts = contacts;
    addContacts();
  }

  private void addContacts() {
    var model = 
      (ContactsTableModel)getModel();
    
    for (var contact : contacts) {
      model.addRow(
        contact.toArray()
      );
    }
  }
}
