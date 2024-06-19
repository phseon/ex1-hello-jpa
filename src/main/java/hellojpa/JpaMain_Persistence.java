package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain_Persistence {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        try {
/*
            //비영속(객체를 생성한 상태)
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속(객체를 저장한 상태)
            System.out.println("=== BEFORE ====");
            em.persist(member);
            System.out.println("=== AFTER ====");
            
            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());
            //member가 1차 캐시에 저장되어 있으므로 select 쿼리 없이 조회됨  
                      
                        //준영속(회원 엔티티를 영속성 컨텍스트에서 분리)
            //            em.detach(member);

                        //삭제(객체를 삭제한 상태, DB에서 삭제)
            //            em.detach(member);
*/

            /*
            //영속 엔티티의 동일성 보장
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);
            
            System.out.println("result = " + (findMember1 == findMember2)); //true
            */
            
            /*
            //트랜잭션을 지원하는 쓰기 지연
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");
            
            em.persist(member1);
            em.persist(member2);
            //DB가 아닌 영속성 컨텍스트에 쌓임
            //이후 commit() 시 쿼리가 실행됨
            */
            
            /*
            //변경 감지(Dirty Checking)
            //값을 바꾸면 트랜잭션이 커밋되는 시점에 변경을 반영함
            Member member = em.find(Member.class, 150L);
            member.setName("zzzz");
            
//            em.persist(member);   호출할 필요없이 값만 바꾸면 반영됨
            */
            
            /*
            //flush()
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();
            //DB에 미리 반영하거나 쿼리를 미리 볼 경우 호출
            */
            
            /*
            //준영속 상태
            Member member = em.find(Member.class, 150L);
            //가져온 member는 영속성 컨텍스트에 없으므로 영속성 컨텍스트에 올림 
            member.setName("AAAAA");
            //변경 내역을 추적해 업데이트 쿼리를 보냄
            
            //1
            em.detach(member);
            //이제 member를 영속성 컨텍스트에서 관리하지 않아 UPDATE 쿼리가 실행되지 않음
           
            //2
            em.clear();
            //엔티티 매니저 내의 영속성 컨텍스트를 전부 지움
            
            Member member2 = em.find(Member.class, 150L);
            //em.clear()로 Member가 영속성 컨텍스트에 없으므로 같은 멤버 조회 시에도 다시 SELECT 쿼리 실행
            
            //3
            em.close()
            //영속성 컨텍스트 종료
            */
            
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
