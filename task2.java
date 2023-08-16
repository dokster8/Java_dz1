//
//
//
// Задание 2. Вывести все простые числа от 1 до 1000.
//
//
//

import java.io.FileWriter;
import java.io.IOException;
// import java.util.Scanner;

public class task2 {
    static void isSimple(int n, int i, boolean a) {
        if (i == 1) {
            try (FileWriter fw = new FileWriter("simple.txt", true)) {
                fw.write(Integer.toString(n));
                fw.append('\n');
                fw.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return;
        }
        if (a)
            return;
        if (n == 4)
            return;

        if (n != i && n % i == 0)
            isSimple(n, i - 1, true);
        else
            isSimple(n, i - 1, false);

    }

    static void taskTwo(int n) throws Exception {
        String s = String.format("Простые числа от 1 до %d:\n", n);
        FileWriter fw = new FileWriter("simple.txt", false);
        fw.write(s);
        fw.close();
        for (int i = 1; i < n; i++) {
            isSimple(i, i, false);
        }

    }

    public static void main(String[] args) throws Exception {

        taskTwo(1000);
        System.out.println("Простые числа от 1 до 1000 можно увидеть в файле simple.txt");
    }
}
