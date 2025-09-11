/* С консоли на вход подается две строки s и t. Необходимо вывести true, если одна строка является валидной анаграммой другой строки, и false – если это не так.
Анаграмма – это слово, или фраза, образованная путем перестановки букв другого слова или фразы, обычно с использованием всех исходных букв ровно один раз.
Для проверки:
● Бейсбол – бобслей
● Героин – регион
● Клоака – околка*/

package homework.homework08.hw08_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
 public static boolean checkAnagrams(String s, String t) {

        Map<Character, Integer> charCountMap = new HashMap<>();

        // Подсчитываем количество каждой буквы в первой строке
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Проверяем каждую букву во второй строке
        for (char c : t.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false; // Если буквы нет в первой строке, это не анаграмма
            }
            charCountMap.put(c, charCountMap.get(c) - 1); // Уменьшаем счетчик для буквы
            if (charCountMap.get(c) == 0) {
                charCountMap.remove(c); // Удаляем букву, если больше не встречается
            }
        }

        return charCountMap.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую строку s:");
        String s = scanner.nextLine();

        System.out.println("Введите вторую строку t:");
        String t = scanner.nextLine();

        boolean result = checkAnagrams(s, t);

        System.out.println("Анаграмма: " + result);

        scanner.close();
    }
}
