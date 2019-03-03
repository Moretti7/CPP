package second;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Bookcase bookcase = null;
//        Bookcase bookcase = new Bookcase();
//        Book book = new Book("Название 1", new Author("Иван", "Иванов"), "Издатель 1", 2012, 400);
//        bookcase.addBook(book);
//        book = new Book("Название 2", new Author("Иван", "Иванов"), "Издатель 1", 2012, 400);
//        bookcase.addBook(book);
//        book = new Book("Название 3", new Author("Иван", "Иванов"), "Издатель 1", 2012, 400);
//        bookcase.addBook(book);
//        book = new Book("Название 4", new Author("Иван", "Иванов"), "Издатель 1", 2012, 400);
//        bookcase.addBook(book);
//
//        Book requestedBook = new Book("Название 1",new Author("Иван", "Иванов"),"Издатель 1", 2012, 400);
//        Customer customer = new Customer("Имя 1", "Фамилия 1", new LinkedList<>());
////        bookcase.getBook(requestedBook, customer);
//        requestedBook = new Book("Название 2",new Author("Иван", "Иванов"),"Издатель 1", 2012, 400);
//        customer = new Customer("Имя 2", "Фамилия 2", new LinkedList<>());
//        bookcase.getBook(requestedBook, customer);
//        requestedBook = new Book("Название 3",new Author("Иван", "Иванов"),"Издатель 1", 2012, 400);
//        customer = new Customer("Имя 3", "Фамилия 3", new LinkedList<>());
//        bookcase.getBook(requestedBook, customer);
////        requestedBook = new Book("Название 4",new Author("Иван", "Иванов"),"Издатель 1", 2012, 400);
////        customer = new Customer("Имя 4", "Фамилия 4", new LinkedList<>());
////        bookcase.getBook(requestedBook, customer);
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./files/second.books"))){
//            oos.writeObject(bookcase);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(bookcase);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./files/second.books"))){
            bookcase = (Bookcase) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(bookcase);
    }
}
