/*Характеристики Покупателя:
имя, сумма денег и пакет с продуктами (массив объектов типа Продукт).
Имя не может быть пустой строкой и не может быть короче 3 символов.
Деньги не могут быть отрицательным числом.
Если Покупатель может позволить себе Продукт, то Продукт добавляется в пакет. 
Если у Покупателя недостаточно денег, то добавление не происходит.
Поля в классах должны быть private, доступ к полям осуществляется через геттеры и сеттеры или конструктор класса.
   */

package homework.homework07;

import java.util.ArrayList;
import java.util.Objects;


class Person {
    private String nameCustomer;
    private double money;
    private ArrayList <Product> products;
// конструктор для создания покупателя
    public Person ( String nameCustomer, double money) {
         if (nameCustomer == null || nameCustomer.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (nameCustomer.trim().length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
      this.nameCustomer=nameCustomer.trim();
      this.money=money;
      this.products= new ArrayList<>();

    }

    public Person() {
    }

    public String getnameCustomer(){
      return nameCustomer;
    }
    public double getMoney(){
      return money;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    // Метод для покупки продукта
    public boolean buyProduct(Product product) {
        if (money >= product.getPrice()) {
            products.add(product);
            money -= product.getPrice();
            return true;
        }
        return false;
    }
     @Override
      public String toString() {
        if (products.isEmpty()) {
            return  nameCustomer + " ничего не купил";
        }
        return nameCustomer  + " купил(а) " + products;
        
          
    }

    // Переопределение метода equals для сравнения объектов Person
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.money, money) == 0 && Objects.equals(nameCustomer, person.nameCustomer) && Objects.equals(products, person.products);
    }

    // Переопределение метода hashCode для обеспечения консистентности с equals
    @Override
    public int hashCode() {
        return Objects.hash(nameCustomer, money, products);
    }
 }
  