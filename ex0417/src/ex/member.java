package ex;

public class member {
    // 객체의 모델링 -> 클래스로 정의
    // member 객체의 속성(멤버변수)으로 성명, 학번, 나이, 학년, 학점 정의
    //              기능(메소드)로 학번을 이용한 객체 검색 기능

    // member 클래스에 속성 정의
    // 접근제한자를 통해 속성에 대한 접근을 은닉화
    private String Name;        // 성명
    private String Hakbun;     // 학번
    private int Age;            // 나이
    private String Grade;          // 학년
    private double AVG;    // 학점

    // 생성 함수의 이름은 클래스의 이름과 동일
    // 전역 변수를 지역 변수로 넣어줌 this.전역변수 = 지역변수;
    member(String Hakbun, String Name, String Grade, int Age, double AVG){
        this.Hakbun = Hakbun;
        this.Name = Name;
        this.Grade = Grade;
        this.Age = Age;
        this.AVG = AVG;
    }
    member(){
        this.Hakbun = "";
        this.Name = "";
        this.Grade = "";
        this.Age = 0;
        this.AVG = 0.0;
    }

    // 인터페이스 getter - setter : 메서드 이름 앞에 get, set 이라는 접두어를 붙여서 지음.
    // 꼭 지켜야 하는 문법 사항은 아님. 통상적인 네이밍 관례.
    // 학년, 학점은 수정 가능하게 하고 학번, 성명은 정보를 보여줄 수 있게 설계.
    // 인터페이스 노출 한계
    // [접근 제한자] : private / public / protected / 생략(defualt)] 리턴형 메소드(파라미터)
    // 동일클래스/ 아무거나 / 상속받은 / 동일클래스, 패키지

    public String getHakbun(){
        return this.Hakbun;
    }
    public String getName(){
        return this.Name;
    }
    public double getAVG(){
        return this.AVG;
    }
    // 학점, 학년 변경 가능하게 setter 함수 설계
    public void setGrade(String _tmpGrade){
        this.Grade = _tmpGrade;
    }
    public void setAVG(double _tmpAVG){
        this.AVG = _tmpAVG;
    }

    // 학번이라는 키워드를 받아서, 인스턴스된 객체에 저장된 정보를 검색, 검색된 결과를 제공하는 메서드 설계
    public member searchMember(String _tmpHakbun, member[] var1)
    {
        member[] tmp = var1;
        member redata = new member();
        for(int cnt=0; cnt<tmp.length; cnt++)
        {
            if(tmp[cnt].Hakbun.equals(_tmpHakbun)){
                redata = tmp[cnt];
            }
        }
        // for(자료형 변수명 : 대상객체)
        /* for(member _tmp : tmp){
            if(_tmp.Hakbun.equals(_tmpHakbun)){
                redata = _tmp;
            }
        }*/
        return redata;
    }
}
