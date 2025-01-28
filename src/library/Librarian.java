package library;

import entity.Book;
import person.Reader;

public class Librarian {

    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }


    public boolean borrowBook(String bookName, Reader reader) {
        for (Book book : library.getBooks()) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                if (!book.isStatus()) {
                    book.setStatus(true);
                    book.setBorrowedBy(reader);
                    reader.borrowBook(book);
                    System.out.println(reader.getName() + " borrowed the book: " + bookName);
                    generateInvoice(reader, book);
                    return true;
                } else {
                    System.out.println("The book '" + bookName + "' is already borrowed by " + book.getBorrowedBy().getName() + ".");
                    return false;
                }
            }
        }
        System.out.println("The book '" + bookName + "' is not available in the library.");
        return false;
    }


    public boolean takeBackBook(String bookName, Reader reader) {
        for (Book book : library.getBooks()) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                if (book.isStatus()) {
                    book.setStatus(false);
                    book.setBorrowedBy(null);
                    reader.returnBook(book);
                    System.out.println("The book '" + bookName + "' has been returned.");
                    refund(reader, book);
                    return true;
                } else {
                    System.out.println("The book '" + bookName + "' was not borrowed.");
                    return false;
                }
            }
        }
        System.out.println("The book '" + bookName + "' is not available in the library.");
        return false;
    }


    private void generateInvoice(Reader reader, Book book) {

        System.out.println("Invoice generated for " + reader.getName() + " for borrowing " + book.getName());
    }


    private void refund(Reader reader, Book book) {

        System.out.println("Refund issued for " + reader.getName() + " for returning " + book.getName());
    }


    public boolean checkBookLimit(Reader reader) {
        if (reader.getBorrowedBooks().size() >= 5) {
            System.out.println(reader.getName() + " has reached the limit of 5 books.");
            return false;
        }
        return true;
    }
}
