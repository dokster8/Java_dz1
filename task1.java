//
//
//
// Задание 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
//
//
//

import java.util.Scanner;

public class task1 {
    static int[] taskOne(int n) {

        int sum = n * (n + 1) / 2;
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        System.out.printf("Сумма чисел от 1 до %d = %d; факториал: %d! = %d", n, sum, n, fac);
        return new int[] { sum, fac };
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введте число n: ");
        String num = iScanner.nextLine();
        iScanner.close();
        taskOne(Integer.parseInt(num));
    }
}
