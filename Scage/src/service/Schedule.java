package service;

import model.Calendar;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Schedule implements ScheduleInterface {
    private List<Calendar> schedules;

    public Schedule() {
        this.schedules = new ArrayList<>();
    }

    @Override
    public void printAllDates() {
        System.out.println("일정있는 모든 날짜 출력");
        for (Calendar schedule : schedules) {
            System.out.println(schedule.getYear()+"년 " + schedule.getMonth() + "월 " + schedule.getDay()+ "일");
        }
    }

    @Override
    public void printMonthlySchedules(int month) {
        System.out.println(month + "월 일정");
        for (Calendar schedule : schedules) {
            if (Integer.parseInt(schedule.getMonth()) == month) {
                System.out.println(schedule.getDay() + "일 | " + schedule.getCategory() + " | " + schedule.getDate() );
            }
        }
    }

    @Override
    public void printDailySchedules(int month, int day) {
        System.out.println(month + "월 " + day + "일 일정");
        for (Calendar schedule : schedules) {
            if (Integer.parseInt(schedule.getMonth()) == month && Integer.parseInt(schedule.getDay()) == day) {
                System.out.println(schedule.getMonth() + "월 " + schedule.getDay() + "일 | " + schedule.getCategory()
                        + " | " + schedule.getDate());
            }
        }
    }

    @Override
    public void printCategorySchedules(String category) {
        System.out.println(category + " 카테고리 일정");
        for (Calendar schedule : schedules) {
            if (schedule.getCategory().equals(category)) {
                System.out.println(schedule.getDay() + "일 | " + schedule.getCategory() + " | " + schedule.getDate());
            }
        }
    }

    @Override
    public void searchSchedules(String keyword) {
        boolean found = false;
        for (Calendar schedule : schedules) {
            if (schedule.getDay().contains(keyword)) {
                System.out.println(schedule.getMonth() + "월 " + schedule.getDay() + "일 | " + schedule.getCategory()
                        + " | " + schedule.getDate());
                found = true;
            }
        }
        if (!found) {
            System.out.println("없습니다.");
        }
    }

    @Override
    public void addSchedule(Calendar schedule) {
        schedules.add(schedule);
        System.out.println("일정이 추가되었습니다.");
    }

    @Override
    public List<Calendar> loadSchedulesFromFile(String fileName) {
        schedules = FileUtil.readSchedulesFromFile(fileName);
        return schedules;
    }
}
