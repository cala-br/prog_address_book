package address_book;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormField extends JPanel {
  private final JLabel label;
  private final JTextField field = new JTextField(10);
  
  public FormField(String labelText) {
    super();
    label = new JLabel(labelText);

    setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8));

    setLayout(new BorderLayout());
    add(label, BorderLayout.WEST);
    add(field, BorderLayout.EAST);
  }

  public String getText() {
    return field.getText();
  }
}
