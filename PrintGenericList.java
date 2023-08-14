import java.util.List;

public class PrintGenericList<T> {
    private List<T> list;

    public PrintGenericList(List<T> list) {
        this.list = list;
    }

    public void printList() {
        if (list.isEmpty()) {
            System.out.println("Daftar kosong.");
        } else {
            for (T item : list) {
                System.out.println(item.toString());
            }
        }
    }
}
