package service;

import model.Calendar;
import java.util.List;

public interface ScheduleInterface {
    void printAllDates();
    void printMonthlySchedules(int month);
    void printDailySchedules(int month, int day);
    void printCategorySchedules(String category);
    void searchSchedules(String keyword);
    void addSchedule(Calendar schedule);
    List<Calendar> loadSchedulesFromFile(String fileName);
}
