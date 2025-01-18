package main;

import item.Person;
import util.File;
import date.DateInterface;
import date.DateInterfaceImp;

import java.util.Scanner;

public class Main {
    static DateInterface mDate = new DateInterfaceImp();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        mDate.loadPersonFromFile("./src/person.txt");

        System.out.println("학생 평점 관리 프로그램");
        System.out.println("저장된 학생 정보가 총 3개가 있습니다.");
        boolean quit = false;
        while (!quit){
            menuIntroduction();
            try{
                int n = input.nextInt();
                input.nextLine(); // 이벤트 key처리
                if(n<1 || n >4){
                    System.out.println("1~4번까지 입력 가능합니다.");
                }
                else{
                    switch (n){
                        case 1:
                            mDate.printAllPersons();
                            break;
                        case 2:
                            System.out.println("등록 학생 학번 조회");
                            System.out.println("학번: ");
                            String num = input.nextLine();
                            mDate.printOnePerson(num);
                            break;
                        case 3:
                            System.out.println("새로운 학생 정보 등록");
                            addNewPerson();
                            System.out.println("학생 정보를 추가하였습니다.");
                            break;
                        case 4:
                            System.out.println("종료");
                            quit = true;
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
        System.out.println("1. 등록 학생 리스트 보기");
        System.out.println("2. 등록 학생 학번 조회");
        System.out.println("3. 새로운 학생 정보 등록");
        System.out.println("4. 종료");
        System.out.print("선택 : ");
    }
    public static void addNewPerson() {
        System.out.print("학생명: ");
        String name = input.nextLine();
        System.out.print("학 번: ");
        String reg_num = input.nextLine();
        System.out.print("학 년: ");
        String grade = input.nextLine();
        System.out.print("평 점: ");
        String avg_point = input.nextLine();

        Person person = new Person(name, reg_num, Integer.parseInt(grade), Float.parseFloat(avg_point));
        mDate.addNewPerson(person);
    }
}
