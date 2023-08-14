package product.processed;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import product.Product;

public class Diary extends Product {
    private LocalDate expiredDate;

    public Diary(String name, int price, int stock, String date) {
        super(name, price, stock);
        this.expiredDate = LocalDate.parse(date);
    }

    @Override
    public int checkDiscount(int quantity) {
        long daysToExpiration = ChronoUnit.DAYS.between(LocalDate.now(), expiredDate);
        if (daysToExpiration < 30) {
            return 20; 
        } else {
            return 0;
        }
    }
}
