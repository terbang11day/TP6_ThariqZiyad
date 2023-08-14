package product;

/**
 * Kelas abstrak Product merepresentasikan produk yang dapat dibeli oleh pelanggan.
 */
public abstract class Product {
    private String name;
    private int price;
    private int stock;

    /**
     * Konstruktor untuk membuat objek Product.
     *
     * @param name  Nama produk.
     * @param price Harga produk.
     * @param stock Stok produk.
     */
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Mendapatkan harga produk.
     *
     * @return Harga produk.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Mendapatkan stok produk.
     *
     * @return Stok produk.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Mendapatkan nama produk.
     *
     * @return Nama produk.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengurangi stok produk berdasarkan kuantitas pembelian.
     *
     * @param quantity Kuantitas produk yang dibeli.
     */
    public void decreaseStock(int quantity) {
        this.stock -= quantity;
    }

    /**
     * Metode abstrak untuk menghitung diskon yang diberikan berdasarkan kuantitas pembelian.
     *
     * @param quantity Kuantitas pembelian produk.
     * @return Jumlah diskon yang diberikan.
     */
    public abstract int checkDiscount(int quantity);
}
