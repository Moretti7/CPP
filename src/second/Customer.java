package second;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private List<Book> books;

    public Customer() {
    }

    public void obtainBook(Bookcase bookcase, Book book){
        books.add(bookcase.getBook(book, this));
    }

    public void returnBook(Bookcase bookcase, Book book){
        books.remove(book);
        bookcase.returnBook(book);
    }

    public Customer(String name, String surname, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\tSurname: %s\t",this.name, this.surname);
    }

    private void writeObject(ObjectOutputStream oos){
        try {
            oos.writeObject(name);
            oos.writeObject(surname);
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
