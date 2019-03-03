package third;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Bookcase bookcase = new Bookcase();

//        bookcase.addBook(new Book("Название 1",new Author("Иван", "Иванов"),"Какой-то издатель", 2012, 400));
//        bookcase.addBook(new Book("Название 2",new Author("Иван", "Иванов"),"Какой-то издатель", 2012, 400));
//        bookcase.addBook(new Book("Название 3",new Author("Иван", "Иванов"),"Какой-то издатель", 2012, 400));
//        bookcase.addBook(new Book("Название 4",new Author("Иван", "Иванов"),"Какой-то издатель", 2012, 400));
//
//        Book requestedBook = new Book("Название 1",new Author("Иван", "Иванов"),"Какой-то издатель", 2012, 400);
//        Customer customer = new Customer("Имя 1", "Фамилия 1", new LinkedList<>());
//        bookcase.getBook(requestedBook, customer);
//
////        requestedBook = new Book("Название 2",new Author("Иван", "Иванов"),"Какой-то издатель", 2012, 400);
////        customer = new Customer("Имя 2", "Фамилия 2", new LinkedList<>());
////        bookcase.getBook(requestedBook, customer);
//
////        requestedBook = new Book("Название 3",new Author("Иван", "Иванов"),"Какой-то издатель", 2012, 400);
////        customer = new Customer("Имя 3", "Фамилия 3", new LinkedList<>());
////        bookcase.getBook(requestedBook, customer);
//
//        requestedBook = new Book("Название 4",new Author("Иван", "Иванов"),"Какой-то издатель", 2012, 400);
//        customer = new Customer("Имя 4", "Фамилия 4", new LinkedList<>());
//        bookcase.getBook(requestedBook, customer);
//
//
//        bookcase.writeExternal(new ObjectOutputStream(new FileOutputStream("./files/third.books")));

        bookcase.readExternal(new ObjectInputStream(new FileInputStream("./files/third.books")));
        System.out.println(bookcase);
    }
}
