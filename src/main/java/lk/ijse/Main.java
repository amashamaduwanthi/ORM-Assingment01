package lk.ijse;

import jakarta.persistence.Query;
import lk.ijse.Entity.Author;
import lk.ijse.Entity.Book;
import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
       /* Author Neil = new Author("1", "Neil","UK", null);
        Author Lee = new Author("2", "Lee","USA", null);

       Book book1 = new Book("1", "Book 1", 2000, 2000.0, Neil);
        Book book2 = new Book("2", "Book 2", 2005, 1000.0, Neil);
        Book book3 = new Book("3", "Book 3", 2001, 1500.0, Lee);

        List<Book>bookList=List.of(book1,book2);
        Neil.setBooks(bookList);

        Lee.setBooks(List.of(book3));

        session.save(Neil);
        session.save(Lee);

        session.save(book1);
        session.save(book2);
        session.save(book3);*/
        //01
     /*  Query query=session.createQuery("select title from Book where publicationYear>=2010");
        List result=query.getResultList();
        System.out.println(result.toString());*/
        //02
      /*  Query query = session.createQuery("update Book b set b.price = b.price * 1.1 where b.author.id = :authorId");
        query.setParameter("authorId", 1);
         int result = query.executeUpdate();
        System.out.println("Result: " + result);*/
        //04

      /*  Query query = session.createQuery("SELECT AVG(b.price) FROM Book b");
        Double averagePrice = (Double) query.getSingleResult();;
        System.out.println(averagePrice);*/

        //05
        Query query = session.createQuery("SELECT a.id, COUNT(b.id) FROM Author a JOIN Book b on a.id = b.author.id GROUP BY a.id");
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            System.out.println(objects[0] + " : " + objects[1]);
        }

        transaction.commit();
        session.close();
        }

}