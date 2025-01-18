import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // 예제1
        System.out.println("예제 1) 정수를 입력하세요 : ");

        Scanner stdin = new Scanner(System.in);

        int a = stdin.nextInt();

        if(a%2 == 0 || a%3 == 0)
            {System.out.println("2 또는 3의 배수입니다.");}
        else if (a%2 == 0 && a%3 == 0)
            {System.out.println("2와 3의 배수입니다.");}
        else
            {System.out.println("2와 3의 배수가 아닙니다.");}

        System.out.println("");

        // 예제2
        System.out.println("예제 2) 0~100 사이의 숫자를 입력하세요 : ");

        int b = stdin.nextInt();

        if(0 > b && b > 100)
        {
            {System.out.println("입력 범위에서 벗어났습니다.");}
        }
        else if(b>=80)
            {System.out.println("합격");}
        else if(b>=60)
            System.out.println("재시험");
        else
            System.out.println("불합격");

        System.out.println("");

        // 예제3
        System.out.println("예제 3) 3개의 정수를 입력하세요 : ");

        int c = stdin.nextInt();
        int d = stdin.nextInt();
        int f = stdin.nextInt();

        int sum = c + d + f;    // 합계
        int mean = sum/3;       // 평균

        int Min, Max;           // 최소, 최대값

        // 최소값
        if(c<d && c<f)
            Min = c;
        else if (d<c && d<f)
            Min = d;
        else
            Min = f;

        // 최대값
        if(c>d && c>f)
            Max = c;
        else if (d>c && d>f)
            Max = d;
        else
            Max = f;

        System.out.println("입력 받은 수들의 최대값 : "+Max+", 최소값 : "+Min+", 합계 : "+sum+", 평균 : "+mean);

        System.out.println("");

        // 예제4
        System.out.println("예제 4) 구입할 사과의 개수를 입력하세요 : ");

        int apple = stdin.nextInt();

        if (apple < 10)
            System.out.println(apple*1200 + "원");
        else if (apple < 40)
            System.out.println(apple*1000 + "원");
        else
            System.out.println(apple*800 + "원");


    }
}