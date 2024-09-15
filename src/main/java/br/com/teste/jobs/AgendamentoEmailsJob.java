package br.com.teste.jobs;

import javax.ejb.Schedule;
import javax.inject.Inject;

import br.com.teste.entity.AgendamentoEmail;
import br.com.teste.servico.AgendamentoEmailServico;
import java.util.List;

public class AgendamentoEmailsJob {
    
    @Inject
    private AgendamentoEmailServico agendamentoEmailServico;

    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void enviarEmail(){
        List<AgendamentoEmail> listarNaoAgendado = agendamentoEmailServico.listarNaoAgendado();
          listarNaoAgendado.forEach( emailNaoAgendado -> {
                agendamentoEmailServico.enviar(emailNaoAgendado);
                agendamentoEmailServico.alterar(emailNaoAgendado);
            });
    }

}
