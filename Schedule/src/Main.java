//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Locale;
//import java.util.Scanner;
//public class Main {
//    static CategoryList mCate = new CategoryList();
//    static Scanner input = new Scanner(System.in);
//    static Admin admin = new Admin("Admin", "Admin1234");
//
//    public static void main(String[] args){
//        login();
//
//        boolean quit = false;
//        while (!quit){
//            System.out.println("--------------------------------------------");
//            System.out.println("1.일정있는 모든 리스트 출력");
//            System.out.println("2.월별 일정 리스트 출력");
//            System.out.println("3.일별 일정 리스트 출력");
//            System.out.println("4.카테고리별 확인");
//            System.out.println("5.일정 추가");
//            System.out.println("6.일정 검색");
//            System.out.println("7.종료");
//            System.out.println("");
//            System.out.println("1~7 중 원하는 옵션을 선택하세요.");
//            System.out.println("--------------------------------------------");
//            int n = input.nextInt();
//            if(n<1 || n>7){
//                System.out.println("1~7까지 입력 가능합니다.");
//            }else{
//                switch (n){
//                    case 1:
//                        System.out.println("1.일정있는 모든 날짜 출력");
//
//                        break;
//                    case 2:
//                        System.out.println("2.월별 일정 리스트 출력");
//                        break;
//                    case 3:
//                        System.out.println("3.일별 일정 리스트 출력");
//                        break;
//                    case 4:
//                        System.out.println("4.카테고리별 확인");
//                        break;
//                    case 5:
//                        System.out.println("5.일정 검색");
//                        break;
//                    case 6:
//                        System.out.println("6.일정 추가");
//                        break;
//                    case 7:
//                        System.out.println("7.종료");
//                        quit = true;
//                        break;
//                }
//            }
//        }
//
//    }
//    public static void login(){
//        while(true){
//            System.out.println("사용자 정보를 입력하세요.");
//            System.out.print("아이디: ");
//            String ID = input.nextLine();
//            System.out.print("비밀번호: ");
//            String PW = input.nextLine();
//            if(admin.getUserID().equals(ID)&&admin.getUserPW().equals(PW)){
//                System.out.println("로그인 성공");
//                break;
//            }
//            System.out.println("계정 정보가 일치하지 않습니다. 다시 입력해주세요.");
//        }
//    }
////    public static void CalendarList(Calendar[] clist){
////        setFileToCategoryList(clist);
////    }
//    public static int totalFileToCategoryList(){
//        try{
//            FileReader fr = new FileReader("./src/calendar.txt");
//            BufferedReader reader = new BufferedReader(fr);
//            String str;
//            int num = 0;
//            while((str = reader.readLine())!=null){
//                if(str.contains("2024"))
//                    ++num;
//            }
//            reader.close();
//            fr.close();
//            return num;
//        }catch (Exception e){
//            System.out.println(e);
//            System.out.println(System.getProperty("user.dir"));
//        }
//        return 0;
//    }
//    public static void setFileToCategoryList(CategoryList[] clist){
//        try{
//            FileReader fr = new FileReader("./src/calendar.txt");
//            BufferedReader reader = new BufferedReader(fr);
//            String str2;
//            String[] readCalendar = new String[5];
//            int count = 0;
//            while((str2=reader.readLine())!=null){
//                if(str2.contains("2024")){
//                    readCalendar[0] = str2;
//                    readCalendar[1] = reader.readLine();
//                    readCalendar[2] = reader.readLine();
//                    readCalendar[3] = reader.readLine();
//                    readCalendar[4] = reader.readLine();
//                }
////                clist[count++] = new Calendar(readCalendar[0],readCalendar[1],readCalendar[2],
////                        readCalendar[3],readCalendar[4]);
//            }
//            reader.close();
//            fr.close();
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }
//}
