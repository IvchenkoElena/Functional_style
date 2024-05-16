
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
                    if (item != null && item.amount != null) {
                        sum += item.amount;
                    }
                }
            }
        }
        return sum;
    }

    private static Integer getItemsSumStream(Order order) {
        if (order == null || order.packages == null) return 0;
        return order.packages.stream()
                .filter(pack -> pack != null && pack.items != null)
                .flatMap(pack -> pack.items.stream())
                .filter(item -> item != null && item.amount != null)
                .mapToInt(item -> item.amount)
                .sum();
    }
}