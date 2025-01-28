package person;

import entity.Book;
import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {


    private Set<Book> borrowedBooks;
    private final int limit = 5;

    public Reader(String name) {
        super(name);
        this.borrowedBooks = new HashSet<>();
    }

    @Override
    public String whoYouAre() {
        return "Okuyucu!";
    }

    public int getLimit() {
        return limit;
    }


    public void borrowBook(Book book) {
        borrowedBooks.add(book);

    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);

    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
