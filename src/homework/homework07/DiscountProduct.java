/*
Расширить программу из задания с промежуточной аттестации. Добавить механизм наследования.
В программе должно быть два класса – один для обычных продуктов – Product, а другой для специальных – DiscountProduct.
• Product - представляет обычный продукт из прошлого домашнего задания. 
Характеристики Продукта: название и стоимость. 
Название продукта не может быть пустой строкой, оно должно быть. Стоимость продукта не может быть отрицательным числом.
• Скидочный продукт — специальный продукт, цена которого снижена на размер скидки. 
У скидки есть также срок действия. После завершения срока действия скидка меняется.
Ограничения в классах для продуктов:
- Название продукта не должно содержать только цифры;
- Если название продукта короче, чем 3 символа, то такое название недействительно;
- Если стоимость продукта или скидочного продукта 0 или отрицательная, то такая цена неправильная. Должна быть ошибка валидации.
Программа реализуется в отдельной ветке git homeworks/homework07.
При сохранении состояния программы (коммиты) пишется сообщение с описанием хода работы по задаче.
В корне папки с программой должен быть файл .gitignore.
 */
package homework.homework07;

import java.time.LocalDate;

class DiscountProduct extends Product {

    private double discountSize;
    LocalDate termDate;

    public DiscountProduct(String nameProduct, double price, double discountSize, LocalDate termDate) {
        super(nameProduct, price);
        
        this.discountSize=discountSize;
        this.termDate=termDate;

          if (discountSize < 0 || discountSize >= getPrice()) {
            throw new IllegalArgumentException("Скидка должна быть больше 0 и меньше стоимости продукта");
        }
    }


    public LocalDate getTermDate() {
        return termDate;
    }

    public void setTermDate(LocalDate termDate) {
        this.termDate = termDate;
    }

    public double getDiscountSize() {
        return discountSize;
    }

    public void setDiscountSize(int discountSize) {
        this.discountSize = discountSize;
    }
// Метод для получения актуальной цены с учетом скидки
    @Override
    public double getPrice() {
        if (termDate != null && LocalDate.now().isBefore(termDate)) {
            return super.getPrice() - (super.getPrice()*(discountSize/100));
        }
        return super.getPrice(); 
    }
 @Override
    public String toString() {
        if (termDate != null && LocalDate.now().isBefore(termDate)) {
            return super.getNameProduct() + " (Цена со скидкой: " + getPrice() +")";
        }
        return super.toString();
    }
}
