package library;

import entity.Book;
import person.Person;
import person.Reader;

public class Librarian extends Person {

    private Library library;

    public Librarian(String name, Library library) {
        super(name);
        this.library = library;
    }

    @Override
    public String whoYouAre() {
        return "Kütüphaneci!";
    }

    public boolean borrowBook(String bookName, Reader reader) {
        for (Book book : library.getBooks()) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                if (!book.isStatus()) {
                   if(reader.getBorrowedBooks().size() == reader.getLimit()){
                       System.out.println("kullanıcı :" + reader.getName() +", maksimum kitap sayısına ulaştı");
                   } else {
                       book.setStatus(true);
                       book.setBorrowedBy(reader);
                       reader.borrowBook(book);
                       System.out.println(reader.getName() + " kitabı kiraladı : " + bookName);
                       generateInvoice(reader, book);
                       return true;
                   }
                } else {
                    System.out.println("Kitap : " + bookName + "zaten kiralanmış. kiralayan : " + book.getBorrowedBy().getName() + ".");
                    return false;
                }
            }
        }
        System.out.println("maksimum kitap sayısına ulaştığın için bu kitabı ekleyemiyorsun : " + bookName);
        return false;
    }


    public boolean takeBackBook(String bookName, Reader reader) {
        for (Book book : library.getBooks()) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                if (book.isStatus()) {
                    book.setStatus(false);
                    book.setBorrowedBy(null);
                    reader.returnBook(book);
                    System.out.println(bookName + "Kitap iade edildi. Ücret iadesi yapıldı : " + book.getPrice() + "TL");
                    refund(reader, book);
                    return true;
                } else {
                    System.out.println("The book '" + bookName + "' was not borrowed.");
                    return false;
                }
            }
        }
        System.out.println("Kitap :" + bookName + " kütüphanede mevcut değil");
        return false;
    }


    private void generateInvoice(Reader reader, Book book) {

        System.out.println("fatura oluşturulan kullanıcı : " + reader.getName() + ", aldığı kitap : " + book.getName() + " Fiyatı :" + book.getPrice() + "TL");
    }


    private void refund(Reader reader, Book book) {

        System.out.println("kullanıcı : " + reader.getName() + ", kitap : " + book.getName());
    }


    public boolean checkBookLimit(Reader reader) {
        if (reader.getBorrowedBooks().size() >= 5) {
            System.out.println(reader.getName() + " maksimum kitap limitine ulaştı.");
            return false;
        }
        return true;
    }
}
