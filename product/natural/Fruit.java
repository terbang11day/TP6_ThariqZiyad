package product.natural;
import product.Product;

/**
 * Fruit adalah subkelas dari Product yang merepresentasikan produk buah.
 */
public class Fruit extends Product {
    private boolean isLocal;

    /**
     * Konstruktor untuk membuat objek Fruit.
     *
     * @param name    Nama produk buah.
     * @param price   Harga produk buah.
     * @param stock   Stok produk buah.
     * @param isLocal true jika buah lokal, false jika buah impor.
     */
    public Fruit(String name, int price, int stock, boolean isLocal) {
        super(name, price, stock);
        this.isLocal = isLocal;
    }

    /**
     * Menghitung jumlah diskon yang diberikan berdasarkan kuantitas pembelian.
     *
     * @param quantity Kuantitas pembelian produk.
     * @return Jumlah diskon yang diberikan.
     */
    @Override
    public int checkDiscount(int quantity) {
        int discount = 0;
        if (isLocal) {
            if (quantity >= 5) {
                discount = 30;
            } else if (quantity >= 3) {
                discount = 20;
            }
        } else {
            if (quantity >= 5) {
                discount = 20;
            } else if (quantity >= 3) {
                discount = 15;
            }
        }
        return discount;
    }
}
