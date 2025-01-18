package date;
import item.Person;

import java.util.List;

public interface DateInterface {
    void printAllPersons();
    void printOnePerson(String reg_num);
    void addNewPerson(Person newperson);
    List<Person> loadPersonFromFile(String fileName);
}
