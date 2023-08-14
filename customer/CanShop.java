package customer;

import product.Product;

/**
 * Antarmuka CanShop mendefinisikan metode-metode yang memungkinkan pelanggan berbelanja produk.
 */
public interface CanShop {

    /**
     * Menambahkan produk dengan kuantitas tertentu ke dalam keranjang belanja pelanggan.
     *
     * @param product  Produk yang akan ditambahkan ke dalam keranjang.
     * @param quantity Kuantitas produk yang akan ditambahkan.
     */
    void addToCart(Product product, int quantity);

    /**
     * Melanjutkan untuk proses pembayaran atas item-item di dalam keranjang belanja.
     */
    void checkout();
}
