package address_book;

import java.awt.Container;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddressBookFrame extends JFrame {
  private final JLabel searchResult = new JLabel("...");
  private final ContactsTable contactsTable;
  

  public AddressBookFrame(List<Contact> contacts) {
    super();
    contactsTable = new ContactsTable(contacts);

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    addElements();
    pack();
  }


  private void addElements() {
    var pane = getContentPane();
    pane.setLayout(
      new BoxLayout(pane, BoxLayout.Y_AXIS)
    );
    
    addContactsTable(pane);
    pane.add(searchResult);
    addSearchBar(pane);
    addManageContactsBar(pane);
  }

  private void addContactsTable(Container pane) {
    pane.add(
      new TableScrollPane(contactsTable)
    );
  }

  private void addSearchBar(Container pane) {
    pane.add(
      new SearchBarPanel(ss -> search(ss))
    );
  }

  private void addManageContactsBar(Container pane) {
    pane.add(
      new ManageContactsPanel(
        (e) -> { showCreateContactDialog(); },
        (e) -> { contactsTable.removeSelectedContact(); },
        (e) -> { contactsTable.removeAllRows(); }
      )
    );
  }

  private void showCreateContactDialog() {
    var dialog = new CreateContactDialog((c) -> {
      contactsTable.addContact(c);
    });
    
    dialog.setVisible(true);
  }


  private void search(String searchString) {
    var contact = findFirstOrNull(searchString);

    searchResult.setText(contact == null
      ? "No match..."
      : contact.tel
    );
  }

  private Contact findFirstOrNull(String searchString) {
    for (var contact : contactsTable.contacts) {
      if (contact.surname.contains(searchString)) {
        return contact;
      }
    }
    
    return null;
  }
}
