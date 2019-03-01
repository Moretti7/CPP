package first;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String title;
    private Author author;
    private String publisher;
    private int yearOfPublishing;
    private int pages;
    private Customer customer;
    private boolean hasCustomer;

    public Book() {
    }

    public Book(String title, Author author, String publisher, int yearOfPublishing, int pages) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublishing = yearOfPublishing;
        this.pages = pages;
        this.customer = null;
        this.hasCustomer = false;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isHasCustomer() {
        return hasCustomer;
    }

    public void setHasCustomer(boolean hasCustomer) {
        this.hasCustomer = hasCustomer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublishing == book.yearOfPublishing &&
                pages == book.pages &&
                hasCustomer == book.hasCustomer &&
                Objects.equals(author, book.author) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(customer, book.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, publisher, yearOfPublishing, pages, customer, hasCustomer);
    }

    @Override
    public String toString() {
        return String.format("Title: %s\tAuthor: %s\tPublishing: %s\t Year of publisher: %d Pages: %d p",
                this.title, this.author, this.publisher, this.yearOfPublishing, this.pages);
    }
}
