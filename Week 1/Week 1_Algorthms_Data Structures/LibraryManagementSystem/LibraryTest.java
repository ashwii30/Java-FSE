public class LibraryTest {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager(10);

        Book book1 = new Book("B1", "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("B2", "To Kill a Mockingbird", "Harper Lee");

        manager.addBook(book1);
        manager.addBook(book2);
        manager.sortBooksByTitle();

        System.out.println("Linear search for 'The Great Gatsby':");
        Book b = manager.linearSearchByTitle("The Great Gatsby");
        if (b != null) {
            System.out.println(b.getBookId() + ": " + b.getTitle() + ", " + b.getAuthor());
        }

        System.out.println("\nBinary search for 'To Kill a Mockingbird':");
        b = manager.binarySearchByTitle("To Kill a Mockingbird");
        if (b != null) {
            System.out.println(b.getBookId() + ": " + b.getTitle() + ", " + b.getAuthor());
        }
    }
}
