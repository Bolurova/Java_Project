/* Реализовать метод, который на вход принимает ArrayList<T>, а возвращает набор уникальных элементов этого массива. Решить, используя коллекции */

package homework.homework08.hw08_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Unique {
    public static <T> Set<T> getUnique(ArrayList<T> list) {
        return new HashSet<>(list);
    }

    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
        ArrayList<String> InputElements = new ArrayList<>();

        System.out.println("Введите элементы массива. Введите 'END' для завершения:");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("END")) {
                break;
            }

            InputElements.add(input);
        }

        Set<String> uniqueElements = getUnique(InputElements);

        System.out.println("Уникальные элементы: " + uniqueElements);

        scanner.close();
    }



    }
