package second;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Bookcase implements Serializable {
    transient private List<Book> books;

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

    private void writeObject(ObjectOutputStream oos){
        try {
            oos.defaultWriteObject();
            for(Book book : books){
                oos.writeObject(book.getTitle());
                oos.writeObject(book.getAuthor().getName());
                oos.writeObject(book.getAuthor().getSurname());
                oos.writeObject(book.getPublisher());
                oos.writeInt(book.getYearOfPublishing());
                oos.writeInt(book.getPages());

                if(book.getCustomer() == null) {
                    oos.writeObject("");
                    oos.writeObject("");
                    oos.writeObject(new LinkedList<Book>());
                }

                oos.writeBoolean(book.isHasCustomer());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois){
        books = new LinkedList<>();
        try {
            ois.defaultReadObject();

            try {
                while (true){
                    String bookTitle = (String) ois.readObject();
                        System.err.println("\n" + bookTitle);
                    String authorsName = (String) ois.readObject();
                        System.err.println(authorsName);
                    String authorsSurname = (String) ois.readObject();
                        System.err.println(authorsSurname);
                    String publisher = (String) ois.readObject();
                        System.err.println(publisher);
                    int yearOfPublishing = ois.readInt();
                        System.err.println(yearOfPublishing);
                    int pages = ois.readInt();
                        System.err.println(pages);
                    String customerName = (String) ois.readObject();
                        System.err.println(customerName);
                    String customerSurName = (String) ois.readObject();
                        System.err.println(customerSurName);
                    List<Book> customersBooks = (List<Book>) ois.readObject();
                        System.err.println(customersBooks);
                    boolean hasCustomer = ois.readBoolean();
                        System.err.println(hasCustomer + "\nend");

                    books.add(new Book(bookTitle,
                            new Author(authorsName, authorsSurname),
                            publisher, yearOfPublishing, pages,
                            new Customer(customerName, customerSurName, customersBooks),
                            hasCustomer));
                }
            }catch (OptionalDataException e){/*End of File*/}

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
