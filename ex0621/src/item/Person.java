package item;

public class Person {
    private String name;
    private String reg_num;
    private int grade;
    private float avg_point;
    public Person(String name, String reg_num,int grade, float avg_point)
    {
        this.name = name;
        this.reg_num = reg_num;
        this.grade = grade;
        this.avg_point = avg_point;
    }
    public Person(){
        this.name ="";
        this.reg_num = "";
        this.grade = 0;
        this.avg_point = 0.0f;
    }
    public String getName(){return  name;}
    public String getReg_num(){return reg_num;}
    public int getGrade(){return grade;}
    public float getAvg_point(){return avg_point;}
    public void setName(String name){this.name = name;}
    public void setReg_num(String regNum){this.reg_num = regNum;}
    public void setGrade(int grade){this.grade = grade;}
    public void setAvg_point(float avg_point){this.avg_point = avg_point;}
}
