package address_book;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

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

    initLayout();
    populate();
    pack();
  }

  private void initLayout() {
    var pane = getContentPane();
    pane.setLayout(
      new BorderLayout()
    );
  }

  private void populate() {
    var centerPanel = new JPanel();
    centerPanel.setLayout(
      new BoxLayout(centerPanel, BoxLayout.Y_AXIS)
    );

    centerPanel.add(nameField);
    centerPanel.add(surnameField);
    centerPanel.add(addressField);
    centerPanel.add(phoneField);

    add(new JScrollPane(centerPanel), BorderLayout.CENTER);
    add(createButton, BorderLayout.SOUTH);
  }
}
