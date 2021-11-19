package address_book;

import javax.swing.table.DefaultTableModel;

public class ContactsTableModel extends DefaultTableModel {
  public ContactsTableModel() {
    super();

    this.addColumn("Name");
    this.addColumn("Surname");
    this.addColumn("Address");
    this.addColumn("Tel");
  }
}
