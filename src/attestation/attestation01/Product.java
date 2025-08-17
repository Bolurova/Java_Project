/* Характеристики Продукта: 
название и стоимость. 
Название продукта не может быть пустой строкой, оно должно быть.
Стоимость продукта не может быть отрицательным числом. 
Поля в классах должны быть private, доступ к полям осуществляется через геттеры и сеттеры или конструктор класса.

 */
package attestation.attestation01;

import java.util.Objects;

class Product {
    private String nameProduct;
    private double price;

    public Product( String nameProduct, double price) {
        if (nameProduct == null || nameProduct.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
        }
        this.nameProduct = nameProduct.trim();
        this.price = price;
    }
        public String getNameProduct () {
        return nameProduct;
    }

    public double getPrice () {
        return price;
    }



    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
 // Переопределение метода toString для удобного отображения продукта
    @Override
    public String toString() {
        return nameProduct + "(" + price + "руб.)";
    }
    // Переопределение метода equals для сравнения объектов Product
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(nameProduct, product.nameProduct);
    }

    // Переопределение метода hashCode для обеспечения консистентности с equals
    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price);
    }
}