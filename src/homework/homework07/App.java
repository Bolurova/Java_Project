/*Промежуточная аттестация Модуль 1 «Введение в разработку/Введение в Java».
Формулировка задания: Необходимо реализовать приложение, принимающее список пользователей, продуктов и обрабатывающее покупку пользователя.
Подробное описание функционала приложения:
1. Создать классы Покупатель (Person) и Продукт (Product).
    Характеристики Покупателя:имя, сумма денег и пакет с продуктами(массив объектов типа Продукт).Имя не может быть пустой строкой и не может быть короче 3 символов. Деньги не могут быть отрицательным числом.
        Если Покупатель может позволить себе Продукт, то Продукт добавляется в пакет. Если у Покупателя недостаточно денег, то добавление не происходит.
    Характеристики Продукта: название и стоимость. Название продукта не может быть пустой строкой, оно должно быть.Стоимость продукта не может быть отрицательным числом. 
2. Поля в классах должны быть private, доступ к полям осуществляется через геттеры и сеттеры или конструктор класса.
3. В классах переопределены методы toString(), equals(), hashcode().
4. Создать в классе App метод main и проверить работу приложения. 
Данные Покупателей и Продукты вводятся с клавиатуры, для считывания данных потребуется использовать класс Scanner и его метод nextLine(). 
Продукты в цикле выбираются покупателями по очереди и, пока не введено слово END, наполняется пакет.
5. Обработать следующие ситуации:
    а. Если покупатель не может позволить себе продукт, то напечатайте соответствующее сообщение ("[Имя человека] не может позволить себе [Название продукта]").
    б. Если ничего не куплено, выведите имя человека, за которым следует "Ничего не куплено".
    в. В случае неверного ввода-сообщение:"Деньги не могут быть отрицательными",пустого имени-сообщение:"Имя не может быть пустым",длины имени<3 симв–сообщение:"Имя не может быть короче 3 символов".
Программа реализуется в отдельной ветке git attestation/attestation01. При сохранении состояния программы (коммиты) пишется сообщение с описанием хода работы по задаче. 
В корне папки с программой должен быть файл .gitignore. Программа локально коммитится и публикуется в репозиторий GitHub на проверку.    */

package homework.homework07;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        // Ввод данных о покупателях
        System.out.println("Введите данные покупателей (формат: имя1 = сумма; имя2=сумма), для завершения нажмите кнопку Enter:");
        String input_persons = scanner.nextLine();
            String[] parts_persons = input_persons.split(";");
            for (String part_pe : parts_persons) {
                String[] info_pe = part_pe.split("=");
                String name_pe = info_pe[0];
                double money_pe = Double.parseDouble(info_pe[1]);
                customers.add(new Person(name_pe, money_pe));
        }

        // Ввод данных о продуктах
        System.out.println("Введите данные продуктов (формат: продукт 1 = стоимость; продукт 2 = стоимость), для завершения нажмите кнопку Enter:");
        String input_product = scanner.nextLine();
            String[] parts_product = input_product.split(";");
            for (String part_pr : parts_product) {
                String[] info_pr = part_pr.split("=");
                String name_pr = info_pr[0];
                double price_pr = Double.parseDouble(info_pr[1]);
                products.add(new Product(name_pr, price_pr));
        }
        // System.out.println("Покупатели: " + customers);
        // System.out.println(products);

        // Вводим кто что купил
        System.out.println("Введите покупки (формат: имя1 - продукт; имя 2-продукт), для завершения введите 'END':");
        String input;
        while (!(input = scanner.nextLine()).equals("END")) {
            String[] parts_bag = input.split("-");
            String buyerName = parts_bag[0];
            String productName = parts_bag[1];


            // Поиск покупателя и продукта
            Person buyers = null;
            Product productToBuy = null;
            for (Person person : customers) {
                if (person.getnameCustomer().trim().equals(buyerName.trim())) {
                    buyers = person;
                    break;
                }
            }

            for (Product product : products) {
                if (product.getNameProduct().trim().equals(productName.trim())) {
                    productToBuy = product;
                    break;
                }
            }
            
          // Обработка покупки
            if (buyers != null && productToBuy != null) {
                if (buyers.buyProduct(productToBuy)) {
                    System.out.println(buyerName + " купил(а) " + productName);
                } else {
                    System.out.println(buyerName + " не может позволить себе " + productName);
                }
            }
        }

        // Печать покупок
        for (Person person : customers) {
           if (person.getProducts().isEmpty()) {
               System.out.println(person.getnameCustomer() + " - ничего не купил");
            } else 
            { System.out.println(person);
             }

            }
        }

    }

