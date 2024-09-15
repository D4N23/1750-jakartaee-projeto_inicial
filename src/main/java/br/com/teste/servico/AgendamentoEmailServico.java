package br.com.teste.servico;

import java.util.List;
import java.util.logging.Logger;

import br.com.teste.dao.AgendamentoEmailDAO;
import br.com.teste.entity.AgendamentoEmail;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AgendamentoEmailServico {

    private static final Logger LOGGER = Logger.getLogger(AgendamentoEmailServico.class.getName());

    @Inject
    private AgendamentoEmailDAO dao;

    public List<AgendamentoEmail> listar() {
        // AgendamentoEmailDAO dao = new AgendamentoEmailDAO();
        return dao.listar();
    }

    public void inserir(AgendamentoEmail agendamentoEmail) {
        agendamentoEmail.setAgendado(false);
        dao.inserir(agendamentoEmail);
    }

    public List<AgendamentoEmail> listarNaoAgendado() {
        return dao.listarNaoAgendados();
    }

    public void alterar(AgendamentoEmail agendamentoEmail) {
        agendamentoEmail.setAgendado(true);
        dao.alterar(agendamentoEmail);
    }

    public void enviar(AgendamentoEmail agendamentoEmail){
        String msg = "O e-mail do(a) usuario " + agendamentoEmail.getEmail() + " foi enviado.";
        try{
            Thread.sleep(5000);
            LOGGER.info(msg);
        }catch(Exception e){
            LOGGER.warning(e.getMessage());
        }
    }


}
