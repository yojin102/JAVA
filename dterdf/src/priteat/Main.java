package priteat;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in); //객체를 생성하는 문장
        int x;
        int y;
        int sum;

        System.out.print("첫 번째 숫자를 입력하시오: ");
        x = input.nextInt();    // input을 통해 nextInt() 메소드 호출

        System.out.print("두 번째 숫자를 입력하시오: ");
        y = input.nextInt();

        sum = x + y;

        System.out.println(sum);

        double w,h,area,perimeter;

        w = 10;
        h = 5;
        area = w * h;
        perimeter = 2*(w+h);

        // h = (double) w;    // 형변환

        System.out.println(" ");

        System.out.print("(1~3)달을 입력하세요: ");
        String month = input.nextLine();

        int monthNumber;

        switch (month){
            case "january": monthNumber = 1; break;
            case "february": monthNumber = 2; break;
            case "march": monthNumber = 3; break;
            default: monthNumber = 0; break;
        }
        System.out.println(monthNumber);

    }
}