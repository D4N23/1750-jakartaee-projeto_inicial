package br.com.teste.servico;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailServico {
    
    public List<String> listar(){
        return List.of("daniilosam23@gmail.com");
    }
    
}
