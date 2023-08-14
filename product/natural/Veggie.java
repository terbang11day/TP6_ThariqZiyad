package product.natural;
import product.Product;

/**
 * Veggie adalah subkelas dari Product yang merepresentasikan produk sayuran.
 */
public class Veggie extends Product {
    private boolean isOrganic;

    /**
     * Konstruktor untuk membuat objek Veggie.
     *
     * @param name      Nama produk sayuran.
     * @param price     Harga produk sayuran.
     * @param stock     Stok produk sayuran.
     * @param isOrganic true jika sayuran organik, false jika tidak.
     */
    public Veggie(String name, int price, int stock, boolean isOrganic) {
        super(name, price, stock);
        this.isOrganic = isOrganic;
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
        if (isOrganic) {
            if (quantity >= 5) {
                discount = 20;
            } else if (quantity >= 3) {
                discount = 10;
            }
        } else {
            if (quantity >= 5) {
                discount = 25;
            } else if (quantity >= 3) {
                discount = 20;
            }
        }
        return discount;
    }
}

