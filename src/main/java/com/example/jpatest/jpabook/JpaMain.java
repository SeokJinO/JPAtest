package com.example.jpatest.jpabook;

import com.example.jpatest.Member;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static void main(String[] args) {

        Member member = createMember("memberE", "회원1");

        member.setUsername("회원명 변경"); // 준영속 상태에서 변경
        System.out.println(member);

        /*mergerMember(member);*/

    }

    static Member createMember(String id, String username) {

        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Member member = new Member();
        member.setId(id);
        member.setUsername(username);

        em1.persist(member);
        tx1.commit();

        em1.close();  // 영속성 컨텍스트1 종료,
                      // member 엔티티는 준영속 상태가 된다.

        return member;
    }
    static void mergerMember(Member member) {

        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        Member mergeMember = em2.merge(member);
        tx2.commit();

        //준영속 상태
        System.out.println("member = " + member.getUsername());

        //영속 상태
        System.out.println("mergeMember = " +
                mergeMember.getUsername());


        System.out.println("em2 contains member = " +
                em2.contains(member));
        System.out.println("em2 contains mergeMember = " +
                em2.contains(mergeMember));

        em2.close();
    }
}
