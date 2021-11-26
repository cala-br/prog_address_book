package address_book;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ManageContactsPanel extends JPanel {
  private final JButton newContactButton = new JButton("New contact");
  private final JButton deleteContactButton = new JButton("Delete contact");
  private final JButton deleteAllButton = new JButton("Delete all");

  public ManageContactsPanel(
    ActionListener onNew,
    ActionListener onDelete,
    ActionListener onDeleteAll
  ) {
    super();

    setLayout(new FlowLayout());
    newContactButton.addActionListener(onNew);
    deleteContactButton.addActionListener(onDelete);
    deleteAllButton.addActionListener(onDeleteAll);

    populate();
  }

  void populate() {
    add(newContactButton);
    add(deleteContactButton);
    add(deleteAllButton);
  }
}
