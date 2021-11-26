package address_book;

import java.awt.BorderLayout;

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


  public CreateContactDialog(Func<Contact> onCreate) {
    super();
    createButton.addActionListener((e) -> {
      onCreate.invoke(
        new Contact(
          nameField.getText(),
          surnameField.getText(),
          addressField.getText(),
          phoneField.getText()
        )
      );

      setVisible(false);
    });

    setLayout(new BorderLayout());
    populate();
    pack();
  }

  private void populate() {
    final var scrollPane = new JScrollPane(
      createCenterPanel()
    );
    
    add(scrollPane, BorderLayout.CENTER);
    add(createButton, BorderLayout.SOUTH);
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
}
