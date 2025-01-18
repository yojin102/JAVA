package cart;

import bookitem.Books;

public interface CartInterface {
    void printBookList(Books[] p);
    boolean isCartInBook(String id);
    void insertBook(Books p);
    void removeCart(int numId);
    void deleteBook();
}
