package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //EntityManagerFactory: 애플리케이션 로딩 시점에 하나만 생성하여 애플리케이션 전체에서 공유함
        EntityManager em = emf.createEntityManager();
        //EntityManager: 트랜잭션마다 만들어 줘야 함. JPA에서 데이터를 변경하는 모든 작업은 트랜잭션 내부여야 함
        EntityTransaction tx = em.getTransaction();
        //em.getTransaction(): 트랜잭션 가져오기
        tx.begin();
        //트랜잭션 시작
        
        try {
            /*
            //1.회원 등록
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            
            em.persist(member);
            //DB에 저장하는 것이 아닌 엔티티를 영속화 함(영속성 컨텍스트에 저장)
            */

            Member findMember = em.find(Member.class, 1L);
            //EntityManager를 자바 컬렉션처럼 이해. 객체를 대신 저장해주는 역할
            //파라미터: entityClass, Object primaryKey
            
            /*
            //2.회원 단 건 조회
            System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getName());
            */
            
            /*
            //3.회원 삭제
            em.remove(findMember); 
            */
            
            /*
            //4.회원 수정
            findMember.setName("HelloJPA");
            //자바 컬렉션을 사용하는 것처럼 설계되어 em.persist()로 저장할 필요가 없음
            //트랜잭션을 커밋하는 시점에 엔티티 변경 여부를 체크해 업데이트 쿼리를 만듦
            */
            
            /*JPQL*/
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(2)   /*각 DB에 맞춰 Pagenation이 편리함*/
                    .getResultList();
            //JPA는 테이블이 아닌 멤버 객체를 대상으로 쿼리를 작성함. alias m -> 객체를 가리킴
            
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
            
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); 
        }

        emf.close();

    }
}
