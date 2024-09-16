package br.com.teste.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import java.util.List;

import br.com.teste.entity.AgendamentoEmail;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN) //Passando o controle das transações para a aplicação  BMT
public class AgendamentoEmailDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private UserTransaction userTransaction;

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
        try {
            userTransaction.begin();
            entityManager.persist(agendamentoEmail);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AgendamentoEmail> listarNaoAgendados() {
        String query = "SELECT ae FROM AgendamentoEmail ae WHERE.agendado = false";
        return entityManager
                .createQuery(query, AgendamentoEmail.class)
                .getResultList();
    }

    public void alterar(AgendamentoEmail agendamentoEmail){

        try {
            userTransaction.begin();
            entityManager.merge(agendamentoEmail);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
