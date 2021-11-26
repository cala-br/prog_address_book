package address_book;

public class Util {
  public interface Action {
    public void invoke();
  }

  public interface Func<T> {
    public void invoke(T param);
  }
}
