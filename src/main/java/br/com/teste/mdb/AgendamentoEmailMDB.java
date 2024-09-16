package br.com.teste.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

import br.com.teste.entity.AgendamentoEmail;
import br.com.teste.servico.AgendamentoEmailServico;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class AgendamentoEmailMDB implements MessageListener {

    @Inject
    private AgendamentoEmailServico agendamentoEmailServico;

    @Override
    public void onMessage(Message message) {
        try {
          AgendamentoEmail agendamentoEmail =  message.getBody(AgendamentoEmail.class);
            agendamentoEmailServico.enviar(agendamentoEmail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
