package cart;

import bookitem.Books;

public class CartItem {
    private Books itemBook;
    private String bookID;
    private int quantity;
    private int totalPrice;
    public CartItem(){

    }
    public CartItem(Books booklist){
        this.itemBook = booklist;
        this.bookID = booklist.getBookId();
        this.quantity = 1;
        updateTotalPrice();
    }
    public void updateTotalPrice(){totalPrice = this.itemBook.getUintPrice() * this.quantity;}
    public Books getItemBook(){return itemBook;}
    public void setItemBook(Books itemBook){this.itemBook = itemBook;}
    public void setTotalPrice(int totalPrice){this.totalPrice = totalPrice;}
    public String getBookID(){return bookID;}
    public void setBookID(String bookID){
        this.bookID = bookID;
        this.updateTotalPrice();
    }
    public int getQuantity(){return quantity;}
    public void setQuantity(int quantity){
        this.quantity = quantity;
        this.updateTotalPrice();
    }
    public int getTotalPrice(){
        return totalPrice;
    }
}
