//
//
//
// Задание 3. Простой калькулятор.
//
//
//

import java.util.Scanner;

public class task3 {
    static String taskThree(double a, double b, String doing) {

        if (doing.charAt(0) == '+')
            return String.valueOf(a + b);
        if (doing.charAt(0) == '-')
            return String.valueOf(a - b);
        if (doing.charAt(0) == '*')
            return String.valueOf(a * b);
        if (doing.charAt(0) == '/')
            return String.valueOf(a / b);
        return "Неверный ввод";
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введте число a: ");
        String a = iScanner.nextLine();
        System.out.printf("Введите необходимое действие (+,-,*,/): ");
        String doing = iScanner.nextLine();
        System.out.printf("Введте число b: ");
        String b = iScanner.nextLine();
        iScanner.close();
        System.out.printf("%s %s %s = %s", a, doing, b, taskThree(Integer.parseInt(a), Integer.parseInt(b), doing));
    }
}
