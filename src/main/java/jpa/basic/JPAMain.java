package jpa.basic;

import jakarta.persistence.*;
import jpa.basic.shop.domain.Movie;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            Movie movie = new Movie();
            movie.setName("킬링로맨스");
            movie.setPrice(20000);
            movie.setDirector("박지수");
            movie.setActor("이하늬");

            em.persist(movie);
            // code
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}