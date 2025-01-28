import entity.Book;
import entity.Type;
import library.Librarian;
import library.Library;
import person.Reader;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Book> books = new HashSet<>();
        Set<Reader> readers = new HashSet<>();


        Reader Berk = new Reader("BERK ŞENER");
        Reader Gizem = new Reader("GİZEM ŞENER");
        readers.add(Berk);
        readers.add(Gizem);


        books.add(new Book(1, "George Orwell", "1984", Type.STUDYBOOK, 50.0, false, 1, null, LocalDate.of(2021, 5, 15)));
        books.add(new Book(2, "Anton Pavloviç Çehov", "Altıncı Koğuş", Type.STUDYBOOK, 60.0, false, 2, null, LocalDate.of(2022, 3, 20)));
        books.add(new Book(3, "Emily Bronte", "Uğultulu Tepeler", Type.MAGAZINES, 10.0, false, 1, null, LocalDate.of(2023, 1, 10)));
        books.add(new Book(4, "Jose Mauro de Vasconcelos", "Şeker Portakalı", Type.MAGAZINES, 10.0, false, 1, null, LocalDate.of(2023, 1, 10)));
        books.add(new Book(5, "Yaşar Kemal", "İnce Memed", Type.MAGAZINES, 10.0, false, 1, null, LocalDate.of(2023, 1, 10)));
        books.add(new Book(5, "Dostoyevski", "Suç ve Ceza", Type.MAGAZINES, 10.0, false, 1, null, LocalDate.of(2023, 1, 10)));

        Library library = new Library(books, readers);
        Librarian librarian = new Librarian("Mehmet",library);


        System.out.println("1- Kitap ekleme ----------------------------------------------------------");
        Book newBook = new Book(6, "Anthony Burgess", "Otomatik Portakal", Type.JOURNALS, 45.0, false, 1, null, LocalDate.of(2024, 2, 5));
        library.addBook(newBook);
        System.out.println("-----------------------------------------------------------------");



        System.out.println("2- Kitap Silme ----------------------------------------------------------");
        library.removeBook("Şeker Portakalı");
        System.out.println("-----------------------------------------------------------------");



        System.out.println("3- Kitap Güncelleme ----------------------------------------------------------");
        library.updateBook("1984", "Fareler ve İnsanlar", "John Steinbeck", 55.0, 2);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("4- Kitap Türüne Göre Listeleme ----------------------------------------------------------");
        library.listBooksByType(Type.STUDYBOOK);
        library.listBooksByType(Type.MAGAZINES);

        System.out.println("4- Kitap Yazarına Göre Listeleme ----------------------------------------------------------");
        library.listBooksByAuthor("Yaşar Kemal");
        library.listBooksByAuthor("Emily Bronte");
        System.out.println("-----------------------------------------------------------------");

        System.out.println("5- Kitap Ödünç Alma ----------------------------------------------------------");
        if (librarian.checkBookLimit(Berk)) {
            librarian.borrowBook("Uğultulu Tepeler", Berk);
            librarian.borrowBook("Uğultulu Tepeler", Gizem);
        }
        System.out.println("-----------------------------------------------------------------");

        System.out.println("6- Kitabı Geri İade Etme ----------------------------------------------------------");
        librarian.takeBackBook("Uğultulu Tepeler", Berk);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("7 Kitap Limit Aşımı Kontrolü -----------------------------------------------------------");
        if (librarian.checkBookLimit(Gizem)) {
            librarian.borrowBook("Uğultulu Tepeler", Gizem);
            librarian.borrowBook("Fareler ve İnsanlar", Gizem);
            librarian.borrowBook("Otomatik Portakal", Gizem);
            librarian.borrowBook("Suç ve Ceza", Gizem);
            librarian.borrowBook("İnce Memed", Gizem);
            librarian.borrowBook("Altıncı Koğuş", Gizem);
        }
        System.out.println("-----------------------------------------------------------------");

    }
}
