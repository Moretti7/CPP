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

    public Book getBook(Book requestedBook, Customer customer) {
        for (Book book : books) {
            if (book.equals(requestedBook) && !book.isHasCustomer()) {
                book.setCustomer(customer);
                book.setHasCustomer(true);
                return book;
            }
        }
        return null;
    }

    public void returnBook(Book returnedBook) {
        for (Book book : books) {
            if (book.equals(returnedBook)) {
                book.setCustomer(null);
                book.setHasCustomer(false);
            }
        }
    }

    public String getBooksInfo() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book);
            sb.append("\n");
        }

        return sb.toString();
    }

    public void addBook(Book book) {
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

    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeInt(books.size());
            for (Book book : books) {
                oos.writeObject(book.getTitle());
                oos.writeObject(book.getAuthor().getName());
                oos.writeObject(book.getAuthor().getSurname());
                oos.writeObject(book.getPublisher());
                oos.writeInt(book.getYearOfPublishing());
                oos.writeInt(book.getPages());

                oos.writeBoolean(book.isHasCustomer());
                if (book.getCustomer() != null) {
                    oos.writeObject(book.getCustomer().getName());
                    oos.writeObject(book.getCustomer().getSurname());
                    oos.writeObject(book.getCustomer().getBooks());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois) {
        books = new LinkedList<>();
        try {
            ois.defaultReadObject();

            int numOfBooks = ois.readInt();
            for (int i = 0; i < numOfBooks; i++) {
                String bookTitle = (String) ois.readObject();
                String authorsName = (String) ois.readObject();
                String authorsSurname = (String) ois.readObject();
                String publisher = (String) ois.readObject();
                int yearOfPublishing = ois.readInt();
                int pages = ois.readInt();

                boolean hasCustomer = ois.readBoolean();
                if(hasCustomer) {
                    String customerName = (String) ois.readObject();
                    String customerSurName = (String) ois.readObject();
                    List<Book> customersBooks = (List<Book>) ois.readObject();
                    books.add(new Book(bookTitle,
                            new Author(authorsName, authorsSurname),
                            publisher, yearOfPublishing, pages,
                            new Customer(customerName, customerSurName, customersBooks),
                            hasCustomer));
                }else
                    books.add(new Book(bookTitle,
                            new Author(authorsName, authorsSurname),
                            publisher, yearOfPublishing, pages));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
