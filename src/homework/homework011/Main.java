/*2. Проверить работу в классе Main, методе main.
3. Создать объект Java Collections со списком автомобилей.
4. Используя Java Stream API, вывести (можно сделать любые 2 пункта
из 4):
1) Номера всех автомобилей, имеющих заданный в переменной цвет
colorToFind или нулевой пробег mileageToFind.
2) Количество уникальных моделей в ценовом диапазоне от n до m тыс.
*/
package homework.homework011;

import java.util.List;

public class Main {
  public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("a123me", "Mercedes", "White", 0, 8300000),
                new Car("b873of", "Volga", "Black", 0, 673000),
                new Car("w487mn", "Lexus", "Grey", 76000, 900000),
                new Car("p987hj", "Volga", "Red", 610, 704340),
                new Car("c987ss", "Toyota", "White", 254000, 761000),
                new Car("o983op", "Toyota", "Black", 698000, 740000),
                new Car("p146op", "BMW", "White", 271000, 850000),
                new Car("u893ii", "Toyota", "Purple", 210900, 440000),
                new Car("l097df", "Toyota", "Black", 108000, 780000),
                new Car("y876wd", "Toyota", "Black", 160000, 1000000)
        );

        // Вывод всех автомобилей
        System.out.println("Автомобили в базе:");
        cars.forEach(System.out::println);

        // Входные параметры для первых двух пунктов задачи
        String colorToFind = "Black";
        long mileageToFind = 0L;
        long priceLower = 700_000L;
        long priceUpper = 800_000L;


        // 1) Номера всех автомобилей, имеющих заданный цвет или нулевой пробег
        System.out.println("Номера автомобилей по цвету или пробегу:");
        cars.stream()
            .filter(car -> colorToFind.equals(car.getColor()) || car.getMileage() == mileageToFind)
            .map(Car::getNumber)
            .forEach(System.out::println);

        // 2) Количество уникальных моделей в ценовом диапазоне
        long uniqueModelsCount = cars.stream()
            .filter(car -> car.getCost() >= priceLower && car.getCost() <= priceUpper)
            .map(Car::getModel)
            .distinct()
            .count();
        System.out.println("Уникальные автомобили: " + uniqueModelsCount + " шт.");

    }
}
