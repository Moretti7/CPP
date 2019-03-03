package second;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Bookcase bookcase = null;
//        Bookcase bookcase = new Bookcase();

//        for (int i = 1; i <= 10; i++) {
//            bookcase.addBook(new Book("Название " + i,new Author("Иван", "Иванов"), "Издатель", 2012, 400));
//        }
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./files/second.books"))){
//            oos.writeObject(bookcase);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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
