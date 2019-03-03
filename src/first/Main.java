package first;

import second.Bookcase;

import java.io.*;

public class Main {
//    добавление книг +
//    вывод информации по книгам +
//    взятие книг +
//    возврат книг +
    public static void main(String[] args) {
        Bookcase bookcase = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./files/first.books"))){
            bookcase = (Bookcase) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\n" + bookcase);
    }
}
