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
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZZ");

            // 플러시
//            Member member = new Member(200L, "member200");
//            em.persist(member);

            // 준영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");

//            em.detach(member);  // 이것만 초기화
//            em.clear(); // 통채로 초기화

//            em.flush();

//            System.out.println("==========================");

//            Member member = new Member();
////            member.setId("ID_3L");
//            member.setUsername("C");
//            System.out.println("==========================");
//            em.persist(member);
//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("==========================");

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
////            member.setTeamId(team.getId());
//            member.changeTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            // team 조회
//            Member findMember = em.find(Member.class, member.getId());
////            Long findTeamId = findMember.getTeamId();
////            Team findTeam = em.find(Team.class, findTeamId);
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam.getName() = " + findTeam.getName());

            // 수정
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            team.addMember(member);
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();

//            System.out.println("==================");
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }
//            System.out.println("members = " + findTeam);
//            System.out.println("==================");

            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);

            em.persist(team);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
