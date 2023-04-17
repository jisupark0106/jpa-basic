package jpa.basic;

import jakarta.persistence.*;
import jpa.basic.shop.domain.*;

import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            Member m1 = new Member();
            m1.setName("박지수");
            em.persist(m1);

            Member m2 = new Member();
            m2.setName("애니");
            em.persist(m2);

            Book b = new Book();
            b.setAuthor("b.author");
            b.setName("b.name");
            b.setPrice(1000);
            em.persist(b);

            Movie m = new Movie();
            m.setDirector("m.author");
            m.setName("m.name");
            m.setPrice(5000);
            em.persist(m);

            Order o1 = new Order();
            o1.setMember(m1);
            o1.addOrderItem(b);
            o1.addOrderItem(m);
            em.persist(o1);

            em.flush();
            em.clear();

            String q = "select o from Order o join o.member";
            List<Order> resultList = em.createQuery(q, Order.class).getResultList();
            for (Order order : resultList) {
                System.out.println(order.getMember().getName());
            }

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