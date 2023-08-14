import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import customer.Customer;
import customer.GoldCustomer;
import order.Order;
import order.OrderItem;
import product.Product;
import product.natural.Fruit;
import product.natural.Veggie;
import product.processed.Diary;
import product.Product;

public class ShyourBox {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Customer loginCustomer;

    public static void main(String[] args) {
        ShyourBox app = new ShyourBox();
        System.out.println("Welcome to ShyourBox! Yuk beli jangan shy shy!");

        app.initProducts();
        app.initCustomers();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu" +
                    "\n1. Login" +
                    "\n0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Masukkan nama pengguna:");
                    String userName = scanner.next();
                    app.loginCustomer = app.searchCustomer(userName);
                    if (app.loginCustomer != null) {
                        System.out.println("Selamat datang, " + app.loginCustomer.getName() + "!");
                        app.customerMenu();
                    } else {
                        System.out.println("Customer tidak ditemukan.");
                    }
                    break;
                case 0:
                    System.out.println("Sampai Jumpa!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }

        } while (choice != 0);
        scanner.close();

    }

    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------Customer " + this.loginCustomer.getName() + " Menu------------------" +
                    "\n1. Lihat Keranjang" +
                    "\n2. Tambah Produk ke Keranjang" +
                    "\n3. Checkout Keranjang" +
                    "\n4. Riwayat Pemebelian" +
                    "\n0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (!loginCustomer.getCart().isEmpty()) {
                        PrintGenericList<OrderItem> cartPrinter = new PrintGenericList<>(loginCustomer.getCart().getOrderList());
                        cartPrinter.printList();
                    } else {
                        System.out.println("Keranjang Anda Kosong.");
                    }
                    break;
                case 2:
                    if (loginCustomer != null) {
                        System.out.println("Daftar Produk:");
                        for (Product product : products) {
                                System.out.println("-produk "+  product.getName()+" Memiliki stok "+product.getStock());
                        } System.out.println("Pilih Nama produk :");
                        String productName = scanner.next();
                        Product productToAdd = searchProduct(productName);
                        if (productToAdd != null) {
                            System.out.println("Masukkan jumlah:");
                            int quantity = scanner.nextInt();
                            if (quantity <= productToAdd.getStock()){
                                loginCustomer.addToCart(productToAdd, quantity);
                            }else{System.out.println("Stok produk tidak mencukupi ");}    
                        } else {
                            System.out.println("Produk tidak ditemukan.");
                        }
                    } else {
                        System.out.println("Anda harus login terlebih dahulu.");
                    }
                    break;
                case 3:
                    if (loginCustomer != null) {
                        loginCustomer.checkout();
                    } else {
                        System.out.println("Anda harus login terlebih dahulu.");
                    }
                    break;
                case 4:
                    if (loginCustomer != null) {
                        PrintGenericList<Order> orderHistoryPrinter = new PrintGenericList<>(loginCustomer.getOrderHistory());
                        orderHistoryPrinter.printList();
                    } else {
                        System.out.println("Anda harus login terlebih dahulu.");
                    }
                    break;
                case 0:
                    System.err.println("Sampai Jumpa Kembali!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 0);
    }

    public void initProducts() {
        this.products.add(new Veggie("Bayam", 1000, 20, false));
        this.products.add(new Veggie("Jamur", 1000, 15, true));
        this.products.add(new Veggie("Wortel", 1000, 15, true));

        this.products.add(new Fruit("Jeruk", 10000, 20, false));
        this.products.add(new Fruit("Apel", 13000, 50, true));
        this.products.add(new Fruit("Semangka", 9000, 23, false));

        this.products.add(new Diary("Keju", 30000, 20, "2023-08-15"));
        this.products.add(new Diary("Yogurt", 15000, 10, "2023-12-31"));
    }

    public void initCustomers() {
        this.customers.add(new Customer("Hana"));
        this.customers.add(new Customer("Sakura"));
        this.customers.add(new Customer("Jennifer"));
        this.customers.add(new GoldCustomer("Anyujin"));
        this.customers.add(new GoldCustomer("Chaewon"));
    }

    public Product searchProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public Customer searchCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}
