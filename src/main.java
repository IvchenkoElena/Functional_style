
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
        if (order == null || order.packages == null) return sum;
        for (Package pack : order.packages) {
            if (pack != null && pack.items != null) {
                for (Item item : pack.items){
                    if (item.amount != null) {
                        sum += item.amount;
                    }
                }
            }
        }
        return sum;
    }

    private static Integer getItemsSumStream(Order order) {
        return order.packages.stream()
                .flatMap(pack -> pack.items.stream())
                .mapToInt(item -> item.amount)
                .sum();
    }
}