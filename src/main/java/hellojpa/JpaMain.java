package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUsername("userA");

            System.out.println("==== start calling nextval of seq ====");
            em.persist(member);
            System.out.println("==== end calling nextval of seq ====");

            System.out.println("==== COMMIT! start executing insert query ==== ");
            tx.commit(); // 이 시점에 쿼리가 날아감!
            System.out.println("==== end executing insert query ==== ");

        } catch (Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
