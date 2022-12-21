package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 추가
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");

            //            em.persist(member);

            // 찾기
//            Member findMember = em.find(Member.class, 1L);

            // 수정
//            findMember.setName("HelloJPA");

            // 특정 조건 찾기
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)  // 1번째부터
//                    .setMaxResults(10)  // 10번쨰까지
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            // 캐시조회 (영속)
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("result = " + (findMember1 == findMember2));

            // 엔티티등록 (영속)
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);

            // 엔티티 수정(영속)
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZZ");

            System.out.println("==========================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
