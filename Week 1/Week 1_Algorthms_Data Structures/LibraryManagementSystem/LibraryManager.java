import java.util.Arrays;

public class LibraryManager {
    private Book[] books;
    private int size;

    public LibraryManager(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        }
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return books[mid];
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }
}
