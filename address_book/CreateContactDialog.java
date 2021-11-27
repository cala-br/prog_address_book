package address_book;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import address_book.Util.Func;

public class CreateContactDialog extends JDialog {
  private final FormField nameField = new FormField("Name");
  private final FormField surnameField = new FormField("Surname");
  private final FormField addressField = new FormField("Address");
  private final FormField phoneField = new FormField("Phone number");
  private final JButton createButton = new JButton("Create");
  private final Func<Contact> onCreate;

  public CreateContactDialog(Func<Contact> onCreate) {
    super();

    this.onCreate = onCreate;
    createButton.addActionListener((e) -> createContact());

    setLayout(new BorderLayout());
    populate();
    pack();
  }

  private void populate() {
    final var container = createButtonContainer();
    final var scrollPane = new JScrollPane(
      createCenterPanel()
    );

    
    add(scrollPane, BorderLayout.CENTER);
    add(container, BorderLayout.SOUTH);
  }

  private JPanel createCenterPanel() {
    final var centerPanel = new JPanel();
    centerPanel.setLayout(
      new BoxLayout(centerPanel, BoxLayout.Y_AXIS)
    );

    centerPanel.add(nameField);
    centerPanel.add(surnameField);
    centerPanel.add(addressField);
    centerPanel.add(phoneField);

    return centerPanel;
  }

  private JPanel createButtonContainer() {
    final var container = new JPanel();
    container.setLayout(new BorderLayout());
    container.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
    container.add(createButton, BorderLayout.EAST);

    return container;
  }


  private void createContact() {
    final var contact = new Contact(
      nameField.getText(),
      surnameField.getText(),
      addressField.getText(),
      phoneField.getText()
    );

    if (contact.toFullNameString().isBlank()) {
      return;
    }
    
    onCreate.invoke(contact);
    setVisible(false);
  }
}
