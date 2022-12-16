package com.example.jpatest.jpabook;

import com.example.jpatest.Board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Board board = new Board();
        em.persist(board);
        tx.commit();
        em.close();
        emf.close();
        System.out.println("board.id = " + board.getId() );
    }
}
