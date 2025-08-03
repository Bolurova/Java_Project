/* Для введенной с клавиатуры буквы английского алфавита нужно вывести слева стоящую букву на стандартной клавиатуре. 
При этом клавиатура замкнута,т.е. справа от буквы «p» стоит буква «a»,а слева от "а" буква "р",также соседними считаются буквы «l» и буква «z»,а буква «m» с буквой «q».
 Входные данные: строка входного потока содержит один символ — маленькую букву английского алфавита.
Выходные данные: следует вывести букву стоящую слева от заданной буквы, с учетом замкнутости клавиатуры*/

package homework.HW5;

import java.util.Scanner;

public class Letters {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите маленькую букву английского алфавита");
        String input=scanner.next();
        String order="qwertyuiopasdfghjklzxcvbnm"; //Порядок букв
        char letter=input.charAt(0); //Введенная буква
        int index=order.indexOf(letter); //Индекс введенной буквы

        int preindex=(index-1+order.length()) % order.length(); //Вычисляем индекс предыдущей буквы
        char preLetter=order.charAt(preindex);
        System.out.println("Предыдущая буква: "+preLetter);

    }
}
