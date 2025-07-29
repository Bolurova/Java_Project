package homework.TV;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Введите диагональ: ");
        int number = scanner.nextInt();  
        
     // новый экземпляр
        TV tv = new TV(number);
        System.out.println("TV have size: " + tv.getDiagonal() + "!");

        }
}
