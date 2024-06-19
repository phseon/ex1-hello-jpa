package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain_Entity {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        try {
            Member member = new Member();
            member.setId(102L);
            member.setName("HelloJPA");

            em.persist(member);

            System.out.println("===============");
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); 
        }
        emf.close();
    }
}
