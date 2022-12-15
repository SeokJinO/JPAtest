package com.example.jpatest.jpabook;

import com.example.jpatest.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //영속 엔티티 조회
        Member memberA = em.find(Member.class, "memberA");

        //영속 엔티티 데이터 수정
        memberA.setUsername("hi");
        memberA.setAge(10);

        transaction.commit();
    }
}
