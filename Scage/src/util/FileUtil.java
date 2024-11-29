package util;

import model.Calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<Calendar> readSchedulesFromFile(String fileName) {
        List<Calendar> schedules = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = reader.readLine()) != null) {
//                if (str.contains("2024")) {
                    String year = str;
                    String month = reader.readLine();
                    String day = reader.readLine();
                    String category = reader.readLine();
                    String date = reader.readLine();
                    schedules.add(new Calendar(year, month, day, category, date));
//                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return schedules;
    }
}
