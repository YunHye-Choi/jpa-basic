package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 비영속 상태
            Member member = new Member();
            member.setId(1L);
            member.setName("Anne");

            // 영속 상태 - 이 시점에는 쿼리가 실행되지 않음!
            em.persist(member);

            tx.commit(); // 이 시점에 쿼리가 날아감!

            // 준영속 - 회원 엔티티를 영속성 컨텍스트에서 분리
            em.detach(member);

            // 삭제 - 객체를 삭제한 상태
            em.remove(member);

        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
