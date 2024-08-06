public class SearchUtil {
    public static Product linearSearch(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null;
    }
}
