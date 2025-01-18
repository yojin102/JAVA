package ex;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        // member obj = new member("215646","김철수","2",21,4.1);
        // String stmp = obj.setHakbun("123587");
        // System.out.println(obj.getHakbun());

        // 3개의 인스턴스(object)를 생성
        // 3개의 동일 Object를 저장하기 위한 저장 객체를 만들어야함.
        // 배열을 이용함.
        // 배열의 선언 방식 : 자료형[] 변수명;
        // 배열의 선언-생성 동시 : 자료형[] 변수명 = new 자료형[크기];
        // 자료형 --> 방금 선언한 member의 구조에 따라 만들어야 한다.
        // 자료형 --> member
        member[] _dbMember = new member[3]; // 틀 3개 만듦. 인스턴스x
        // 각 인스턴스 수행
        _dbMember[0] = new member("21345","신동엽","2",21,3.9);
        _dbMember[1] = new member("22012","강호동","1",20,4.2);
        _dbMember[2] = new member("20072","유재석","3",22,4.1);

        // 사용자가 검색할 수 있도록 인터페이스 제공
        System.out.printf(String.format("검색어 입력(학번): "));
        Scanner sc = new Scanner(System.in);    // Scanner 등록
        String keyword = sc.nextLine();         // 입력 처리

        // 검색 기능을 처리하고, 해당 결과를 출력
        // 검색 기능은 member 클래스에 정의된 객체 검색 메소드를 활용
        // 검색 기능을 담당할 object를 생성
        member _search = new member();
        member _result = new member();
        // _result = _search.searchMember(keyword, _dbMember);

        System.out.printf(String.format("학번 : %s \n", _result.getHakbun()));
    }

}
