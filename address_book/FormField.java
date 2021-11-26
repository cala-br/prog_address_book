package address_book;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormField extends JPanel {
  private final JLabel label;
  private final JTextField field = new JTextField(20);
  
  public FormField(String label) {
    super();
    this.label = new JLabel(label);
  
    setLayout(new FlowLayout());
    add(this.label);
    add(field);
  }

  public String getText() {
    return field.getText();
  }
}
