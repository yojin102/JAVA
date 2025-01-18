package Member;

public class member {
    private String name;        // 이름
    private int age;            // 나이
    private String phoneNumber;    // 전화번호
    private String cosmetics;   // 화장품
    private int price;          // 가격

    member(String name, int age, String phoneNumber, String cosmetics){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cosmetics = cosmetics;
    }
    member(){
        this.name = "";
        this.age = 0;
        this.phoneNumber = "";
        this.cosmetics = "";
    }
    public member getMember(String phoneNumber, member[] var1){
        member[] tmp = var1;
        member redate = new member();
        for(int cnt=0; cnt<tmp.length; cnt++){
            if(tmp[cnt].phoneNumber.equals(phoneNumber)){
                redate = tmp[cnt];
            }
        }
        return redate;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getCosmetics(){
        return cosmetics;
    }
}
