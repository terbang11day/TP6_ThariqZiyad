import java.util.ArrayList;
import java.util.Scanner;

import customer.Customer;
import customer.GoldCustomer;
import product.Product;
import product.natural.Fruit;
import product.natural.Veggie;
import product.processed.Diary;

public class ShyourBox {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
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
            switch (choice){
                case 1:
                    System.out.println("Masukkan nama pengguna:");
                    String user = scanner.next();
                    //TODO: implement Login
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

    public void customerMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------Customer "+this.loginCustomer.getName()+ " Menu------------------" +
                    "\n1. Lihat Keranjang" +
                    "\n2. Tambah Produk ke Keranjang" +
                    "\n3. Checkout Keranjang" +
                    "\n4. Riwayat Pemebelian" +
                    "\n0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    //TODO : implement lihat keranjang
                    // use PrintGenericList for this feature
                    break;
                case 2:
                    //TODO : Implement add to cart
                    
                    break;
                case 3:
                    //TODO: Implement Checkout
                    break;
                case 4:
                   //TODO: Implement Order History
                   // use PrintGenericList for this feature

                    break;
                case 0:
                    System.err.println("Sampai Jumpa Kembali!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice !=0);
       
    }

    public void initProducts(){
        this.products.add(new Veggie("Bayam",1000, 20, false));
        this.products.add(new Veggie("Jamur",1000, 15, true));
        this.products.add(new Veggie("Wortel",1000, 15, true));

        this.products.add(new Fruit("Jeruk",10000, 20, false));
        this.products.add(new Fruit("Apel",13000, 50, true));
        this.products.add(new Fruit("Semangka",9000, 23, false));
        
        this.products.add(new Diary("Keju", 30000, 20, "06 08 2023"));
        this.products.add(new Diary("Yogurt", 15000, 10, "06 08 2026"));
    }

    public void initCustomers(){
        this.customers.add(new Customer("Hana"));
        this.customers.add(new Customer("Sakura"));
        this.customers.add(new Customer("Jennifer"));
        this.customers.add(new GoldCustomer("Anyujin"));
        this.customers.add(new GoldCustomer("Chaewon"));
    }


    /**
     * Method untuk mencari produk berdasarkan nama.
     * 
     * @param name
     * @return
     */
    public Product searchProduct(String name) {
        // TODO: Implement this method.

        return null;
    }

    public Customer searchCustomer(String name) {
        // TODO: Implement this method.

        return null;
    }

}

