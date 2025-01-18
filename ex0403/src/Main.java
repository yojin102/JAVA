import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner stdin= new Scanner(System.in);

        // 예제1

        System.out.print("숫자를 입력하세요 ");

        int num = stdin.nextInt();



        // 예제2

        for(int i = 1; i<=7; i++)
        {
            for(int j=i; j<=7; j++){
                System.out.print("*");
            }
            System.out.printf("\n");
        }

        // 예제3

        for (int i = 1; i <= 73; i++) {
            if (i % 10 == 3) {
                System.out.println(i);
            }
        }

        // 예제4




    }
}