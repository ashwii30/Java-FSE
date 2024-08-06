import java.util.Arrays;

public class BinarySearchUtil {
    public static Product binarySearch(Product[] products, String searchTerm) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(searchTerm);
            if (comparison == 0) {
                return products[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
