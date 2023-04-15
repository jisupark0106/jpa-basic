package jpa.basic;

import jakarta.persistence.*;
import jpa.basic.shop.domain.Address;
import jpa.basic.shop.domain.Member;
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

            Member member = new Member();
            member.setName("박지수");
            member.setAddress(new Address("서울시","노원구","아파트"));
            em.persist(member);

            // code
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}