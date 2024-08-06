public class SortTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("A", "Alice", 200.0),
            new Order("B", "Bob", 150.0),
            new Order("C", "Charlie", 300.0)
        };

        BubbleSortUtil.bubbleSort(orders);
        System.out.println("Bubble Sort Result:");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
        }

        Order[] ordersForQuickSort = {
            new Order("A", "Alice", 200.0),
            new Order("B", "Bob", 150.0),
            new Order("C", "Charlie", 300.0)
        };
        QuickSortUtil.quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        System.out.println("Quick Sort Result:");
        for (Order order : ordersForQuickSort) {
            System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
        }
    }
}
