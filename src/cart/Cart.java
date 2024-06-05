package cart;

import bookitem.Books;

public class Cart implements CartInterface{
    static final int NUM_BOOK = 3;
    CartItem[] mCartItems = new CartItem[NUM_BOOK];
    public static int mCartCount = 0;
    public Cart(){

    }
    @Override
    public void printBookList(Books[] p) {
        for(int i = 0; i<p.length; i++){
            System.out.print(p[i].getBookId() + " | ");
            System.out.print(p[i].getName() + " | ");
            System.out.print(p[i].getUintPrice() + " | ");
            System.out.print(p[i].getAuthor() + " | ");
            System.out.print(p[i].getDescription() + " | ");
            System.out.print(p[i].getCategory() + " | ");
            System.out.print(p[i].getReleaseDate() + " | ");
            System.out.println("");
        }
    }

    @Override
    public boolean isCartInBook(String id) {
        boolean flag = false;
        for(int i = 0; i<mCartCount; i++){
            if(id == mCartItems[i].getBookID()){
                mCartItems[i].setQuantity(mCartItems[i].getQuantity()+1);
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void insertBook(Books p) {
        mCartItems[mCartCount++] = new CartItem(p);
    }

    @Override
    public void removeCart(int numId) {
        CartItem[] cartItem = new CartItem[NUM_BOOK];
        int num = 0;
        for(int i = 0; i<mCartCount; i++){
            if(numId != i)
                cartItem[num++] = mCartItems[i];
        }
        mCartCount = num;
        mCartItems = cartItem;
    }

    @Override
    public void deleteBook() {
        mCartItems = new CartItem[NUM_BOOK];
        mCartCount = 0;
    }
    public void printCart(){
        System.out.println("장바구니 상품 목록:");
        System.out.println("-----------------------------------------");
        System.out.println("    도서ID \t|    수량 \t|      합계");
        for(int i = 0; i<mCartCount; i++){
            System.out.print("  " + mCartItems[i].getBookID() + " \t| ");
            System.out.print("  " + mCartItems[i].getQuantity() + " \t| ");
            System.out.print("  " + mCartItems[i].getTotalPrice() + " \t| ");
            System.out.println(" ");
        }
        System.out.println("-----------------------------------------");
    }
}
