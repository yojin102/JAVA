package onlineCart;

import cart.Cart;
import bookitem.Books;
import member.User;

import java.util.Scanner;

public class exProject1 {
    static final int NUM_BOOK = 3;
    static final int NUM_ITEM = 7;
    static Cart mCart = new Cart();
    static User mUser;
    public static void main(String[] args){
        Books[] mBookList = new Books[NUM_BOOK];
        Scanner input = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요 : ");
        String userName = input.next();
        System.out.print("연락처를 입력하세요 : ");
        int userMobile = input.nextInt();
        mUser = new User(userName, userMobile);
        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market!";
        boolean quit = false;
        while (!quit){
            System.out.println("*****************************************");
            System.out.println("\t" + greeting);
            System.out.println("\t" + tagline);
            menuIntroduction();
            System.out.print("메뉴 번호를 선택하세요. ");
            int n = input.nextInt();
            if(n<1 || n >9){
                System.out.println("1~9번까지 입력 가능합니다.");
            }
            else{
                switch (n){
                    case 1:
                        System.out.println("고객정보 확인");
                        menuGuestInfo(userName, userMobile);
                        break;
                    case 2:
                        System.out.println("장바구니 상품 목록 보기");
                        menuCartItemList();
                        break;
                    case 3:
                        System.out.println("장바구니 비우기");
                        menuCartClear();
                        break;
                    case 4:
                        System.out.println("장바구니 항목 추가");
                        menuCartAddItem(mBookList);
                        break;
                    case 5:
                        System.out.println("장바구니 항목 수량 줄이기");
                        break;
                    case 6:
                        System.out.println("장바구니 항목 삭제");
                        break;
                    case 7:
                        System.out.println("영수증 표시");
                        break;
                    case 8:
                        System.out.println("종료");
                        quit = true;
                        break;
                    case 9:
                        break;
                }
            }
        }
    }
    public static void menuIntroduction(){
        System.out.println("*****************************************");
        System.out.println(" 1. 고객 정보 확인하기 \t\t5. 장바구니에 항목수량 줄이기");
        System.out.println(" 2. 장바구니 상품 목록 보기 \t6. 장바구니의 항목 삭제하기");
        System.out.println(" 3. 장바구니 비우기 \t\t\t7. 영수증 표시하기");
        System.out.println(" 4. 장바구니에 항목 추가하기 \t8. 종료");
        System.out.println(" 9. 관리자 로그인");
        System.out.println("*****************************************");
    }
    public static void menuGuestInfo(String name, int mobile){
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 : " + mUser.getName() + "     연락처 : " + mUser.getPhone());
    }
    public static void menuCartItemList(){
        if(mCart.mCartCount >= 0){
            mCart.printCart();
        }
    }
    public static void menuCartClear(){
        if(mCart.mCartCount == 0)
            System.out.println("장바구니에 항목이 없습니다");
        else{
            System.out.println("장바구니에 모든 항목을 삭제하겠습니까? Y | N ");
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();

            if(str.toUpperCase().equals("Y")){
                System.out.println("장바구니에 모든 항목을 삭제했습니다");
                mCart.deleteBook();
            }
        }
    }
    public static void menuCartAddItem(Books[] booklist){
        BookList(booklist);
        mCart.printBookList(booklist);
        boolean quit = false;
        while (!quit){
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            boolean flag = false;
            int numID = -1;
            for(int i = 0; i<NUM_BOOK; i++){
                if(str.equals(booklist[i].getBookId())){
                    numID = i;
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.print("장바구니에 추가하겠습니까? Y | N ");
                str = input.nextLine();
                if (str.toUpperCase().equals("Y")){
                    System.out.println(booklist[numID].getBookId() + " 도서가 장바구니에 추가되었습니다.");
                    if(!isCartInBook(booklist[numID].getBookId())){
                        mCart.insertBook(booklist[numID]);
                    }
                }
                quit = true;
            }else
                System.out.println("다시 입력해 주세요");
        }
    }
    public static boolean isCartInBook(String bookId){
        return mCart.isCartInBook(bookId);
    }
    public static void BookList(Books[] booklist){
        booklist[0] = new Books("ISBN1234","Java Script",27000);
        booklist[0].setAuthor("김춘자");
        booklist[0].setDescription("java script 3.0 최신");
        booklist[0].setCategory("프로그래밍 언어");
        booklist[0].setReleaseDate("2018/10/08");

        booklist[1] = new Books("ISBN1235","PYTHON",33000);
        booklist[1].setAuthor("김길자");
        booklist[1].setDescription("PYTHON 중고급");
        booklist[1].setCategory("프로그래밍 언어");
        booklist[1].setReleaseDate("2022/01/22");

        booklist[2] = new Books("ISBN1236","Java",22000);
        booklist[2].setAuthor("홍길동");
        booklist[2].setDescription("java 입문서");
        booklist[2].setCategory("프로그래밍 언어");
        booklist[2].setReleaseDate("2019/06/10");
    }
}
