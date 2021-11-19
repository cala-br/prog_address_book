package address_book;

public interface ContactSearchEvent {
  public void invoke(String searchString);
}
