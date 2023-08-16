//
//
//
// Задание 4. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
//
//          !!!Работает только максимум с одним знаком ? для каждого из чисел.!!!
//
//
//

import java.util.Scanner;

public class task4 {

    static void arrOutStr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ", arr[i]);
        }
    }

    static String[] razbienie(String s) {
        String[] arr = new String[] { s.split("\\+")[0], s.split("=")[0].split("\\+")[1], s.split("=")[1] };
        return arr;
    }

    static int posQ(String s, boolean f, int pos) { // Возвращает индекс позиции "?" , или "-1", если символа нет.
        if (f == true)
            return -1;
        if (pos == s.length() - 1)
            f = true;
        if (s.charAt(pos) == '?') {
            return pos;
        }

        return posQ(s, f, pos + 1);
    }

    static void podbor(String a, String b, String c, // Подбор возможных чисел.
            int numA, int numB, int numC,
            int posA, int posB, int posC) {
        a = posA != -1 ? a.substring(0, posA) + Integer.toString(numA) + a.substring(posA + 1) : a;
        b = posB != -1 ? b.substring(0, posB) + Integer.toString(numB) + b.substring(posB + 1) : b;
        c = posC != -1 ? c.substring(0, posC) + Integer.toString(numC) + c.substring(posC + 1) : c;
        if (Integer.parseInt(a) + Integer.parseInt(b) == Integer.parseInt(c)) {
            System.out.printf("Есть решение: %s + %s = %s", a, b, c);
            return;
        }
        if (numA < 9) {
            if (numB < 9) {
                if (numC < 9) {
                    podbor(a, b, c, numA, numB, ++numC, posA, posB, posC);

                } else {
                    numC = 0;
                    ++numB;
                    podbor(a, b, c, numA, numB, numC, posA, posB, posC);
                }
            } else {
                numB = 0;
                ++numA;
                podbor(a, b, c, numA, numB, numC, posA, posB, posC);
            }

        } else {

            System.out.println("Нет решений.");
            return;
        }

    }

    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите выражение с неизвестными (Пример: 2?+?5=69): ");
        String name = iScanner.nextLine();
        iScanner.close();
        int posA = posQ(razbienie(name)[0], false, 0);
        int posB = posQ(razbienie(name)[1], false, 0);
        int posC = posQ(razbienie(name)[2], false, 0);

        podbor(razbienie(name)[0], razbienie(name)[1], razbienie(name)[2], 0, 0, 0, posA, posB, posC);
    }
}
