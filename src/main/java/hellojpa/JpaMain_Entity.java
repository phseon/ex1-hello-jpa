package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain_Entity {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        try {
//            Member_Entity member = new Member_Entity();
//            member.setId(1L);
//            member.setUsername("A");
//            member.setRoleType(RoleType.USER);
//            
//            em.persist(member);
//            
//            Member_Entity member1 = new Member_Entity();
//            member1.setId(2L);
//            member1.setUsername("B");
//            member1.setRoleType(RoleType.ADMIN);
//            
//            em.persist(member1);
            
            Member_Entity member2 = new Member_Entity();
            member2.setId(3L);
            member2.setUsername("C");
            member2.setRoleType(RoleType.GUEST);

            em.persist(member2);
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); 
        }
        emf.close();
    }
}
