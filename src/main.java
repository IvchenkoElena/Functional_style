
import java.util.Set;

public class main {
    static class Order {
        Set<Package> packages;
    }

    static class Package {
        Set<Item> items;
    }

    static class Item {
        Double weight;
        Double x;
        Double y;
        Double z;
        Integer amount;
    }

    private static Integer getItemsSum(Order order) {
        int sum = 0;
        for (Package pack : order.packages) {
            for (Item item : pack.items){
                sum += item.amount;
            }
        }
        return sum;
    }

    private static Integer getItemsSumStream(Order order) {
        return order.packages.stream()
                .mapToInt(pack -> pack.items.stream()
                        .mapToInt(item -> item.amount)
                        .sum())
                .sum();
    }
}