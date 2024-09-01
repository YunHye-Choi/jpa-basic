package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 회원 추가
            Member member = new Member();
            member.setId(1L);
            member.setName("Anne");
            em.persist(member);

            // 회원 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("Joy");

            // 회원 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(member);

            // 회원 조회
//            Member findMember = em.find(Member.class, 1L);

        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
