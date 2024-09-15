package br.com.teste.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.util.List;

import br.com.teste.entity.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // public AgendamentoEmailDAO() {
    // EntityManagerFactory entityManagerFactory =
    // Persistence.createEntityManagerFactory("AgendamentoEmailDS");
    // this.entityManager = entityManagerFactory.createEntityManager();
    // }

    public List<AgendamentoEmail> listar() {
        String query = "SELECT ae FROM AgendamentoEmail ae";
        // entityManager.getTransaction().begin();
        // List<AgendamentoEmail> resultado = entityManager.createQuery(sqlString,
        // AgendamentoEmail.class).getResultList();
        // entityManager.getTransaction().commit();
        // entityManager.close();
        // return resultado;
        return entityManager.createQuery(query, AgendamentoEmail.class).getResultList();
    }

    public void inserir(AgendamentoEmail agendamentoEmail) {
        entityManager.persist(agendamentoEmail);
    }

    public List<AgendamentoEmail> listarNaoAgendados() {
        String query = "SELECT ae FROM AgendamentoEmail ae WHERE.agendado = false";
        return entityManager
                .createQuery(query, AgendamentoEmail.class)
                .getResultList();
    }

    public void alterar(AgendamentoEmail agendamentoEmail){
        entityManager.merge(agendamentoEmail);
    }

}
