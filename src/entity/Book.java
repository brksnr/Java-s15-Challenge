package entity;

import person.Reader;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private long id;
    private String author;
    private String name;
    private Type type;
    private double price;
    private boolean status;
    private long edition;
    private Reader borrowedBy;
    private LocalDate dateOfPurchase;

    public Book(long id, String author, String name, Type type, double price, boolean status, long edition, Reader borrowedBy, LocalDate dateOfPurchase) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.type = type;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.borrowedBy = borrowedBy;
        this.dateOfPurchase = dateOfPurchase;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getEdition() {
        return edition;
    }

    public void setEdition(long edition) {
        this.edition = edition;
    }

    public Reader getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Reader borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", borrowedBy=" + borrowedBy +
                ", dateOfPurchase=" + dateOfPurchase +
                '}';
    }
}
