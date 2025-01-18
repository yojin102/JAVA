import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // 예제1
        // 정수를 입력 받아 출력하기
        System.out.println("정수를 입력하세요 : ");
        System.out.println(stdin.nextInt());

        // 예제2
        // 두 정수를 입력 받아 출력하기
        System.out.println("두 정수를 입력하세요 : ");
        System.out.println(stdin.nextInt());
        System.out.println(stdin.nextInt());

        // 예제3
        // 두 정수를 입력 받아 변수에 저장하고 출력하기
        System.out.println("두 정수를 입력하세요 : ");
        int a = stdin.nextInt();
        int b= stdin.nextInt();
        System.out.println(a);
        System.out.println(b);

        // 예제4
        // 두 정수를 입력 받아 줄 바꿈 없이 출력하기
        System.out.println("두 정수를 입력하세요 : ");
        int c = stdin.nextInt();
        int d = stdin.nextInt();
        System.out.print(c);
        System.out.println(d);

        // 예제5
        // 두 정수를 입력 받아 변수에 저장하고, 저장된 두 변수의 값을 교환 후 출력하기
        System.out.println("두 정수를 입력하세요 : ");
        int e = stdin.nextInt();
        int f = stdin.nextInt();

        int tmp;
        tmp = e;

        e = f;
        f = tmp;

        System.out.println(e);
        System.out.println(f);

        // --------------------------------------------------------------------------------------0327

        // 예제 6
        // 정수를 입력 받아 비트 왼쪽 시프트 연산하기(이동 값은 임의 설정)
        System.out.println("예제 6) 정수를 입력하세요 : ");

        int g = stdin.nextInt();

        System.out.println(g + "=" + (g<<2) + "(" + Integer.toBinaryString(g<<2) + ")");

        // 예제7
        // 정수를 입력 받아 비트 오른쪽 시프트 연산하기(이동 값은 임의 설정)
        System.out.println("예제 7) 정수를 입력하세요 : ");

        int h = stdin.nextInt();

        System.out.println(h + "=" + (h>>2) + "(" + Integer.toBinaryString(h>>2) + ")");

    }
}