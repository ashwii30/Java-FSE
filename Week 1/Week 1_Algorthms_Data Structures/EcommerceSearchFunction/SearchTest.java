import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("A", "Widget", "Electronics"),
            new Product("B", "Gadget", "Electronics"),
            new Product("C", "Thingamajig", "Home")
        };
        
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

        Product searchResultLinear = SearchUtil.linearSearch(products, "Gadget");
        System.out.println("Linear Search Result: " + (searchResultLinear != null ? searchResultLinear.getProductName() : "Not Found"));

        Product searchResultBinary = BinarySearchUtil.binarySearch(products, "Gadget");
        System.out.println("Binary Search Result: " + (searchResultBinary != null ? searchResultBinary.getProductName() : "Not Found"));
    }
}
