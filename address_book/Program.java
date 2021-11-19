package address_book;

public class Program {
  public static void main(String[] args) {
    var contacts = new Contact[] {
      new Contact("Giacomo", "Cabri", "via Vignolese", "+39 012 345 6789"),
      new Contact("Mario", "Rossi", "via Vignolese", "+39 012 345 6789"),
      new Contact("Carlo", "Bianchi", "via Vignolese", "+39 012 345 6789"),
      new Contact("Luca", "Abete", "via Vignolese", "+39 012 345 6789"),
      new Contact("Gianni", "Giusti", "via Vignolese", "+39 012 345 6789"),
      new Contact("Gigi", "Bagigi", "via Vignolese", "+39 012 345 6789"),
    };

    var mainFrame = new AddressBookFrame(contacts);
    mainFrame.setVisible(true);
  }
}