package address_book;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import address_book.Util.Func;

public class SearchBarPanel extends JPanel {
  private final JTextField textField = new JTextField(20);
  private final JButton searchButton = new JButton("Search");

  public SearchBarPanel(Func<String> callback) {
    super();

    setLayout(new FlowLayout());
    add(textField);
    add(searchButton);

    searchButton.addActionListener((e) -> {
      callback.invoke(textField.getText());
    });
  }
}