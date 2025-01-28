package library;

import entity.Book;
import entity.Type;
import person.Reader;

import java.util.Set;
import java.util.stream.Collectors;

public class Library {

    private Set<Book> books;
    private Set<Reader> readers;

    public Library(Set<Book> books, Set<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    public void addBook(Book book) {
        if (books.add(book)) {
            System.out.println("Kitap eklendi: " + book.getName());
        } else {
            System.out.println("Bu kitap zaten var! : " + book.getName());
        }
    }

    public boolean removeBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                books.remove(book);
                System.out.println("Kitap silindi: " + bookName);
                return true;
            }
        }
        System.out.println("Kitap: " + bookName + "kütüphanede bulunamadı!");
        return false;
    }

    public void listBooksByType(Type type) {
        Set<Book> typeBooks = books.stream()
                .filter(book -> book.getType() == type)
                .collect(Collectors.toSet());

        if (typeBooks.isEmpty()) {
            System.out.println("No books found in the category: " + type);
        } else {
            System.out.println("Books in the category " + type + ":");
            typeBooks.forEach(book -> System.out.println("- " + book.getName() + " by " + book.getAuthor()));
        }
    }



    public boolean updateBook(String bookName, String newBookName, String newAuthor, double newPrice, long newEdition) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                book.setName(newBookName);
                book.setAuthor(newAuthor);
                book.setPrice(newPrice);
                book.setEdition(newEdition);
                System.out.println("Kitap güncelleme tamamlandı : " + newBookName);
                return true;
            }
        }
        System.out.println("Kitap: " + bookName + " kütüphanede mevcut değil!");
        return false;
    }


    public void listBooksByAuthor(String authorName) {
        Set<Book> authorBooks = books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
                .collect(Collectors.toSet());

        if (authorBooks.isEmpty()) {
            System.out.println("Bu yazara ait kitap bulunamadı : " + authorName);
        } else {
            System.out.println(authorName + ":");
            authorBooks.forEach(book -> System.out.println("- " + book.getName()));
        }
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }
}
