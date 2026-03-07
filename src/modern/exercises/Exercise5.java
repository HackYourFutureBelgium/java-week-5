/**
 * 1. Create a class Product with fields: name, price, inStock.
 * 2. Implement a static inner Builder class for Product.
 * 3. Use chained builder calls in main to create one Product object.
 * 4. Print the created object.
 */

package modern.exercises;

public class Exercise5
{
    public static void main(String[] args)
    {
        Product product = new Product.Builder()
                .name("socks")
                .price(22d)
                .inStock(true)
                .build();
        System.out.printf("%s Price: %.2f %s", product.getName().toUpperCase(), product.getPrice(), product.isInStock()? "in stock":"not in stock");

    }
}

class Product{
    String name;
    Double price;
    boolean inStock;
    public Product(Builder builder){
        this.name = builder.name;
        this.price = builder.price;
        this.inStock = builder.inStock;
    }
    // GETTERS

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    // BUILDER
    public static class Builder{
        String name;
        Double price;
        boolean inStock;
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder price(Double price){
            this.price = price;
            return this;
        }
        public Builder inStock(boolean inStock){
            this.inStock = inStock;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }
}
