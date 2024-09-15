package br.com.teste.servico;

import java.util.List;

import br.com.teste.dao.AgendamentoEmailDAO;
import br.com.teste.entity.AgendamentoEmail;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
@Stateless
public class AgendamentoEmailServico {
    
    @Inject
    private AgendamentoEmailDAO dao;

    public List<AgendamentoEmail> listar(){
        // AgendamentoEmailDAO dao = new AgendamentoEmailDAO();
        return dao.listar();
    }

    public void inserir(AgendamentoEmail agendamentoEmail){
        agendamentoEmail.setAgendado(false);
        dao.inserir(agendamentoEmail);
    }
    
}
