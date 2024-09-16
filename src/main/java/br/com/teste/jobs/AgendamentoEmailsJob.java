package br.com.teste.jobs;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.teste.entity.AgendamentoEmail;
import br.com.teste.servico.AgendamentoEmailServico;
import java.util.List;

@Singleton
@TransactionManagement(TransactionManagementType.CONTAINER) //adicionando o contexto de transações CMT
public class AgendamentoEmailsJob {
    
    // private static AgendamentoEmailsJob instance;

    // private AgendamentoEmailsJob(){}
    
    // private synchronized static AgendamentoEmailsJob getInstance() {
    //     if(instance == null){
    //         instance = new AgendamentoEmailsJob();
    //     }return instance;
    // }

    @Inject
    private AgendamentoEmailServico agendamentoEmailServico;

    @Inject
    @JMSConnectionFactory("java:jboss/DeafultJMSConnectionFactpry")
    private JMSContext context;

    @Resource(mappedName = "java:/jms/queue/EmailQueue")
    private Queue queue;
    
    @Schedule(hour = "*", minute = "*", second = "*/10")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void enviarEmail(){
        List<AgendamentoEmail> listarNaoAgendado = agendamentoEmailServico.listarNaoAgendado();
          listarNaoAgendado.forEach( emailNaoAgendado -> {
                // agendamentoEmailServico.enviar(emailNaoAgendado);
                context.createProducer().send(queue, emailNaoAgendado); // Agora enviamos o email para a fila 
                agendamentoEmailServico.alterar(emailNaoAgendado);
            });
    }

}
