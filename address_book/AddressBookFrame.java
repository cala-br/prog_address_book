package address_book;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddressBookFrame extends JFrame {
  private final Contact[] contacts;
  private final JLabel searchResult = new JLabel("...");
  
  public AddressBookFrame(Contact ...contacts) {
    super();
    this.contacts = contacts;

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
    addSearchBar(pane);
    pane.add(searchResult);
  }

  private void addContactsTable(Container pane) {
    pane.add(
      new TableScrollPane(
        new ContactsTable(contacts)
      )
    );
  }

  private void addSearchBar(Container pane) {
    pane.add(
      new SearchBarPanel(ss -> search(ss))
    );
  }


  private void search(String searchString) {
    var contact = findFirstOrNull(searchString);

    searchResult.setText(contact == null
      ? "No match..."
      : contact.toFullNameString()
    );
  }

  private Contact findFirstOrNull(String searchString) {
    for (var contact : contacts) {
      if (contact.matches(searchString)) {
        return contact;
      }
    }
    
    return null;
  }
}
