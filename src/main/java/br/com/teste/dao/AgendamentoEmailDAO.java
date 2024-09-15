package br.com.teste.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import br.com.teste.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // public AgendamentoEmailDAO() {
    //     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendamentoEmailDS");
    //     this.entityManager = entityManagerFactory.createEntityManager();
    // }

    public List<AgendamentoEmail> listar() {
        String sqlString = "SELECT ae FROM AgendamentoEmail ae";
        // entityManager.getTransaction().begin();
        // List<AgendamentoEmail> resultado = entityManager.createQuery(sqlString, AgendamentoEmail.class).getResultList();
        // entityManager.getTransaction().commit();
        // entityManager.close();
        // return resultado;
        return entityManager.createQuery(sqlString, AgendamentoEmail.class).getResultList();
    }

    public void inserir(AgendamentoEmail agendamentoEmail){
        entityManager.persist(agendamentoEmail);
    }

}
