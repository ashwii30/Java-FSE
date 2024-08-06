public class InventoryTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        
        Product p1 = new Product("A", "Widget", 10, 19.99);
        Product p2 = new Product("B", "Gadget", 5, 29.99);
        manager.addProduct(p1);
        manager.addProduct(p2);
        
        Product retrievedProduct = manager.getProduct("A");
        System.out.println("Retrieved Product: " + retrievedProduct.getProductName());
        
        Product updatedProduct = new Product("A", "Widget", 15, 19.99);
        manager.updateProduct("A", updatedProduct);
        
        manager.deleteProduct("B");
    }
}
