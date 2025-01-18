package util;

import item.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static List<Person> readPersonFromFile(String fileName) {
        List<Person> plist = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = reader.readLine()) != null) {
                if (str.contains(" ")) {
                    String name = str;
                    String reg_num = reader.readLine();
                    String grade = reader.readLine();
                    String avg_point = reader.readLine();
                    plist.add(new Person(name, reg_num, Integer.parseInt(grade), Float.parseFloat(avg_point)));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return plist;
    }
}
