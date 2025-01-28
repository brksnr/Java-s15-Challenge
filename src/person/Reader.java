package person;

import entity.Book;
import java.util.HashSet;
import java.util.Set;

public class Reader {

    private String name;
    private Set<Book> borrowedBooks;

    public Reader(String name) {
        this.name = name;
        this.borrowedBooks = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed the book: " + book.getName());
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(name + " returned the book: " + book.getName());
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
