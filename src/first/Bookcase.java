package first;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Bookcase implements Serializable {
    private List<Book> books;

    public Bookcase() {
        books = new LinkedList<>();
    }

    public Bookcase(List<Book> books) {
        this.books = books;
    }

    public Book getBook(Book requestedBook, Customer customer){
        for(Book book : books){
            if(book.equals(requestedBook) && !book.isHasCustomer()) {
                book.setCustomer(customer);
                book.setHasCustomer(true);
                return book;
            }
        }
        return null;
    }

    public void returnBook(Book returnedBook){
        for(Book book : books){
            if(book.equals(returnedBook)){
                book.setCustomer(null);
                book.setHasCustomer(false);
            }
        }
    }

    public String getBooksInfo(){
        StringBuilder sb = new StringBuilder();
        for(Book book : books){
            sb.append(book);
            sb.append("\n");
        }

        return sb.toString();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return getBooksInfo();
    }
}
