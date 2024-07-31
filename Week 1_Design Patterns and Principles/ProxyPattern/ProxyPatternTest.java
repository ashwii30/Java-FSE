public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image is loaded and displayed
        image1.display();
        // Image is displayed from cache
        image1.display();
        
        // Image is loaded and displayed
        image2.display();
    }
}
