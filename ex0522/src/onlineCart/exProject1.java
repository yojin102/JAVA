package onlineCart;

import cart.Cart;
import bookitem.Books;
import exception.CartException;
import member.Admin;
import member.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class exProject1 {
    static final int NUM_BOOK = 3;
    static final int NUM_ITEM = 7;
    static Cart mCart = new Cart();
    static User mUser;
    public static void main(String[] args){
        Books[] mBookList;
        int mTotalBook = 0;
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
            try{
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
                            mTotalBook = totalFileToBookList();
                            mBookList = new Books[mTotalBook];
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
                            menuAdminLogin();
                            break;
                    }
                }
            }
            catch(Exception ex){
                System.out.println("올바르지 않은 메뉴 선택으로 종료");
                quit = true;
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
    public static void menuCartClear() throws CartException {
        if(mCart.mCartCount == 0)
            // System.out.println("장바구니에 항목이 없습니다");
            throw new CartException("장바구니에 항목이 없습니다. ");
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
        setFileToBookList(booklist);
    }
    public static int totalFileToBookList(){
        try{
            FileReader fr = new FileReader("./src/book.txt");   // 상대경로(./ <- 실행되고 있는 경로)
            BufferedReader reader = new BufferedReader(fr);
            String str;
            int num = 0;
            while ((str = reader.readLine()) != null){
                if(str.contains("ISBN"))
                    ++num;
            }
            reader.close();
            fr.close();
            return num;
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println(System.getProperty("user.dir")); // 실행되고 있는 경로 출력
        }
        return 0;
    }
    public static void setFileToBookList(Books[] booklist){
        try{
            FileReader fr = new FileReader("./src/book.txt");
            BufferedReader reader = new BufferedReader(fr);
            String str2;
            String[] readBook = new String[7];
            int count = 0;
            while ((str2 = reader.readLine()) != null){
                if(str2.contains("ISBN")){
                    readBook[0] = str2;
                    readBook[1] = reader.readLine();
                    readBook[2] = reader.readLine();
                    readBook[3] = reader.readLine();
                    readBook[4] = reader.readLine();
                    readBook[5] = reader.readLine();
                    readBook[6] = reader.readLine();
                }
                booklist[count++] = new Books(readBook[0], readBook[1], Integer.parseInt(readBook[2]),readBook[3],
                        readBook[4], readBook[5], readBook[6]);
            }
            reader.close();
            fr.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public static void menuAdminLogin(){
        System.out.println("관리자 정보를 입력하시오.");

        Scanner input = new Scanner(System.in);
        System.out.print("아이디 : ");
        String adminId = input.next();

        System.out.print("비밀번호 : ");
        String adminPw = input.next();

        Admin admin = new Admin(mUser.getName(), mUser.getPhone());
        if(adminId.equals(admin.getId()) && adminPw.equals(admin.getPassword())){
            String[] writeBook = new String[7];
            System.out.println("도서정보를 추가하시겠습니까?   Y | N ");
            String str = input.next();
            if(str.toUpperCase().equals("Y")){
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
                String strDate = formatter.format(date);
                writeBook[0] = "ISBN" + strDate;
                System.out.println("도서ID : " + writeBook[0]);
                String st1 = input.nextLine();
                System.out.print("도서명 : ");
                writeBook[1] = input.nextLine();
                System.out.print("가격 : ");
                writeBook[2] = input.nextLine();
                System.out.print("저자 : ");
                writeBook[3] = input.nextLine();
                System.out.print("설명 : ");
                writeBook[4] = input.nextLine();
                System.out.print("분야 : ");
                writeBook[5] = input.nextLine();
                System.out.print("출판일 : ");
                writeBook[6] = input.nextLine();
                try{
                    FileWriter fw = new FileWriter("./src/book.txt", true);
                    for(int i = 0; i < 7; i++)
                        fw.write(writeBook[i] + "\n");
                    fw.close();
                    System.out.println("새 도서 정보가 저장되었습니다.");
                } catch (Exception e){
                    System.out.println(e);
                }
            }else {
                System.out.println("이름 " + admin.getName() + " 연락처 " + admin.getPhone());
                System.out.println("아이디 " + admin.getId() + " 비밀번호 " + admin.getPassword());
            }
        }else
            System.out.println("관리자 정보가 일치하지 않습니다.");
    }
}
