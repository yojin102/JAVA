package date;
import item.Person;
import util.File;

import java.util.List;

public class DateInterfaceImp implements DateInterface{
    private List<Person> personList;

    @Override
    public void printAllPersons() {
        System.out.println("등록 학생 정보");
        for (Person personList : personList) {
            for(int i =0; i<personList.getName().length(); i++)
                System.out.println(i+". "+ personList.getName() + personList.getReg_num() + personList.getGrade()
            + personList.getAvg_point());
        }
    }

    @Override
    public void printOnePerson(String reg_num) {
        for (Person personList : personList) {
            System.out.print("검색결과");
            for(int i =0; i<personList.getName().length(); i++)
                System.out.println(i+". "+ personList.getName() + personList.getReg_num() + personList.getGrade()
                        + personList.getAvg_point());
        }
    }

    @Override
    public void addNewPerson(Person newperson) {
        personList.add(newperson);
        System.out.println("학생 정보를 추가하였습니다.");
    }

    @Override
    public List<Person> loadPersonFromFile(String fileName) {
        personList = File.readPersonFromFile(fileName);
        return personList;
    }
}
