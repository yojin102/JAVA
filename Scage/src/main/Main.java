//package main;
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static List<Calendar1> schedules = new ArrayList<>();
//    static Scanner input = new Scanner(System.in);
//    static Admin admin = new Admin("Admin", "Admin1234");
//
//    public static void main(String[] args) {
//        login();
//
//        boolean quit = false;
//        while (!quit) {
//            System.out.println("--------------------------------------------");
//            System.out.println("1~7 중 원하는 옵션을 선택하세요.");
//            System.out.println("1. 일정있는 모든 날짜 출력");
//            System.out.println("2. 월별 일정 리스트 출력");
//            System.out.println("3. 일별 일정 리스트 출력");
//            System.out.println("4. 카테고리별 확인");
//            System.out.println("5. 일정 검색");
//            System.out.println("6. 일정 추가");
//            System.out.println("7. 종료");
//            System.out.println("--------------------------------------------");
//            int n = input.nextInt();
//            input.nextLine(); // Enter key 처리
//
//            switch (n) {
//                case 1:
//                    printAllDates();
//                    break;
//                case 2:
//                    printMonthlySchedules();
//                    break;
//                case 3:
//                    printDailySchedules();
//                    break;
//                case 4:
//                    printCategorySchedules();
//                    break;
//                case 5:
//                    searchSchedules();
//                    break;
//                case 6:
//                    addSchedule();
//                    break;
//                case 7:
//                    quit = true;
//                    break;
//                default:
//                    System.out.println("1~7까지 입력 가능합니다.");
//                    break;
//            }
//        }
//    }
//
//    public static void login() {
//        while (true) {
//            System.out.println("사용자 정보를 입력하세요.");
//            System.out.print("아이디: ");
//            String ID = input.nextLine();
//            System.out.print("비밀번호: ");
//            String PW = input.nextLine();
//            if (admin.getUserID().equals(ID) && admin.getUserPW().equals(PW)) {
//                System.out.println("로그인 성공!");
//                break;
//            }
//            System.out.println("계정 정보가 일치하지 않습니다. 다시 입력해주세요.");
//        }
//    }
//
//    public static void printAllDates() {
//        System.out.println("일정있는 모든 날짜 출력");
//        Set<String> dates = new HashSet<>();
//        for (Calendar1 schedule : schedules) {
//            dates.add(schedule.getDate());
//        }
//        for (String date : dates) {
//            System.out.println(date);
//        }
//    }
//
//    public static void printMonthlySchedules() {
//        System.out.println("보고 싶은 월(month)을 입력하세요. (예: 7)");
//        int month = input.nextInt();
//        input.nextLine(); // Enter key 처리
//        System.out.println(month + "월 일정");
//        for (Calendar1 schedule : schedules) {
//            if (Integer.parseInt(schedule.getMonth()) == month) {
//                System.out.println(schedule.getDate() + " | " + schedule.getCategory() + " | " + schedule.getDay());
//            }
//        }
//    }
//
//    public static void printDailySchedules() {
//        System.out.println("보고 싶은 일정의 날짜를 입력하세요.");
//        System.out.print("월(month): ");
//        int month = input.nextInt();
//        System.out.print("일(day): ");
//        int day = input.nextInt();
//        input.nextLine(); // Enter key 처리
//
//        System.out.println(month + "월 " + day + "일 일정");
//        for (Calendar1 schedule : schedules) {
//            if (Integer.parseInt(schedule.getMonth()) == month && Integer.parseInt(schedule.getDay()) == day) {
//                System.out.println(schedule.getDate() + " | " + schedule.getCategory() + " | " + schedule.getDay());
//            }
//        }
//    }
//
//    public static void printCategorySchedules() {
//        System.out.println("확인하고 싶은 카테고리 옵션을 선택하세요.(일상: 1, 중요: 2)");
//        int categoryOption = input.nextInt();
//        input.nextLine(); // Enter key 처리
//        String category = categoryOption == 1 ? "일상" : "중요";
//
//        for (Calendar1 schedule : schedules) {
//            if (schedule.getCategory().equals(category)) {
//                System.out.println(schedule.getDate() + " | " + schedule.getCategory() + " | " + schedule.getDay());
//            }
//        }
//    }
//
//    public static void searchSchedules() {
//        System.out.println("검색하고자 하는 키워드를 입력하세요(예: 독서)");
//        String keyword = input.nextLine();
//        boolean found = false;
//
//        for (Calendar1 schedule : schedules) {
//            if (schedule.getDay().contains(keyword)) {
//                System.out.println(schedule.getDate() + " | " + schedule.getCategory() + " | " + schedule.getDay());
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("없습니다. 다시 입력하시겠습니까? (Y/N)");
//            String response = input.nextLine();
//            if (response.equalsIgnoreCase("Y")) {
//                searchSchedules();
//            }
//        }
//    }
//
//    public static void addSchedule() {
//        System.out.println("추가");
//
//        System.out.print("연도 입력(예:2024): ");
//        String year = input.nextLine();
//        System.out.print("월 입력(예: 8): ");
//        String month = input.nextLine();
//        System.out.print("일 입력(예: 26): ");
//        String day = input.nextLine();
//        System.out.print("카테고리(일상, 중요 중 하나) 입력: ");
//        String category = input.nextLine();
//        System.out.print("일정 내용 입력: ");
//        String date = input.nextLine();
//
//        schedules.add(new Calendar1(year, month, day, category, date));
//        System.out.println("일정이 추가되었습니다.");
//    }
//}
package main;

import model.Admin;
import model.Calendar;
import service.ScheduleInterface;
import service.Schedule;

import java.util.Scanner;

public class Main {
    static ScheduleInterface scheduleService = new Schedule();
    static Admin admin = new Admin("Admin", "Admin1234");
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        scheduleService.loadSchedulesFromFile("./src/calendar.txt");

        login();

        boolean quit = false;
        while (!quit) {
            System.out.println("--------------------------------------------");
            System.out.println("1. 일정있는 모든 날짜 출력");
            System.out.println("2. 월별 일정 리스트 출력");
            System.out.println("3. 일별 일정 리스트 출력");
            System.out.println("4. 카테고리별 확인");
            System.out.println("5. 일정 검색");
            System.out.println("6. 일정 추가");
            System.out.println("7. 종료");
            System.out.println("--------------------------------------------");
            System.out.println("1~7 중 원하는 옵션을 선택하세요.");
            System.out.print("선택 : ");
            int n = input.nextInt();
            input.nextLine();

            switch (n) {
                case 1:
                    scheduleService.printAllDates();
                    break;
                case 2:
                    System.out.println("보고 싶은 월(month)을 입력하세요. (예: 7)");
                    int month = input.nextInt();
                    input.nextLine();
                    scheduleService.printMonthlySchedules(month);
                    break;
                case 3:
                    System.out.println("보고 싶은 일정의 날짜를 입력하세요.");
                    System.out.print("월(month): ");
                    month = input.nextInt();
                    System.out.print("일(day): ");
                    int day = input.nextInt();
                    input.nextLine();
                    scheduleService.printDailySchedules(month, day);
                    break;
                case 4:
                    System.out.println("확인하고 싶은 카테고리 옵션을 선택하세요.(일상: 1, 중요: 2)");
                    int categoryOption = input.nextInt();
                    input.nextLine();
                    String category = categoryOption == 1 ? "일상" : "중요";
                    scheduleService.printCategorySchedules(category);
                    break;
                case 5:
                    System.out.println("검색하고자 하는 키워드를 입력하세요(예: 독서)");
                    String keyword = input.nextLine();
                    scheduleService.searchSchedules(keyword);
                    break;
                case 6:
                    addSchedule();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("1~7까지 입력 가능합니다.");
                    break;
            }
        }
    }

    public static void login() {
        while (true) {
            System.out.println("사용자 정보를 입력하세요.");
            System.out.print("아이디: ");
            String ID = input.nextLine();
            System.out.print("비밀번호: ");
            String PW = input.nextLine();
            if (admin.getUserID().equals(ID) && admin.getUserPW().equals(PW)) {
                System.out.println("로그인 성공!");
                break;
            }
            System.out.println("계정 정보가 일치하지 않습니다. 다시 입력해주세요.");
        }
    }

    public static void addSchedule() {
        System.out.println("추가");

        System.out.print("연도 입력(예:2024): ");
        String year = input.nextLine();
        System.out.print("월 입력(예: 8): ");
        String month = input.nextLine();
        System.out.print("일 입력(예: 26): ");
        String day = input.nextLine();
        System.out.print("카테고리(일상, 중요 중 하나) 입력: ");
        String category = input.nextLine();
        System.out.print("일정 내용 입력: ");
        String date = input.nextLine();

        Calendar schedule = new Calendar(year, month, day, category, date);
        scheduleService.addSchedule(schedule);
    }
}