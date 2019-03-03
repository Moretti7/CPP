package third;

import java.io.*;
import java.util.Objects;

public class Book implements Externalizable {
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
        boolean result = yearOfPublishing == book.yearOfPublishing &&
                pages == book.pages &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publisher, book.publisher);
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher, yearOfPublishing, pages);
    }

    @Override
    public String toString() {
        return String.format("Title: %s\tAuthor: %s\tPublishing: %s\t Year of publisher: %d Pages: %d p Customer: %s",
                this.title, this.author, this.publisher, this.yearOfPublishing, this.pages, this.customer);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeObject(author);
        out.writeObject(publisher);
        out.writeInt(yearOfPublishing);
        out.writeInt(pages);
        out.writeObject(customer);
        out.writeBoolean(hasCustomer);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        author = (Author) in.readObject();
        publisher = (String) in.readObject();
        yearOfPublishing = in.readInt();
        pages = in.readInt();
        customer = (Customer) in.readObject();
        hasCustomer = in.readBoolean();
    }
}
