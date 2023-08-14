package product;

public abstract class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public void decreaseStock(int quantity) {
        stock -= quantity;
    }

    public abstract int checkDiscount(int quantity);
}
