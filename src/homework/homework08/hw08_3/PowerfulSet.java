/*Реализовать класс PowerfulSet, в котором должны быть следующие методы:
● public <T> Set<T> intersection(Set<T> set1, Set<T> set2) – возвращает пересечение двух наборов.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}
● public <T> Set<T> union(Set<T> set1, Set<T> set2) – возвращает объединение двух наборов
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}
● public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) – возвращает элементы первого набора без тех, которые находятся также и во втором наборе.
Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}*/

package homework.homework08.hw08_3;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {

public <T> Set<T> intersection (Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2); // Оставляем только пересечения
        return result;
    }

    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2); // Добавляем все новые объекты из второй строки
        return result;
    }

    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2); // Удаляем все элементы из второй строки
        return result;
    }

    public static void main(String[] args) {
        PowerfulSet powerfulSet = new PowerfulSet();
// тестовые данные
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(0, 1, 2, 4);

// применяем методы к тестовым данным
        Set<Integer> intersectionResult = powerfulSet.intersection(set1, set2);
        Set<Integer> unionResult = powerfulSet.union(set1, set2);
        Set<Integer> relativeComplementResult = powerfulSet.relativeComplement(set1, set2);

        System.out.println("Пересечение: " + intersectionResult); 
        System.out.println("Объединение: " + unionResult); 
        System.out.println("Дополнение: " + relativeComplementResult);
    }
}
