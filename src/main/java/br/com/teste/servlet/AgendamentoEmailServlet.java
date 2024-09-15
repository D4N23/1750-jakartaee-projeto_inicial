package br.com.teste.servlet;

import java.io.IOException;

import br.com.teste.entity.AgendamentoEmail;
import br.com.teste.servico.AgendamentoEmailServico;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.BufferedReader;

public class AgendamentoEmailServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    
    @Inject
    private AgendamentoEmailServico servico;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        servico.listar().forEach(resultado -> pw.print("Os emails disponiveis são: " + resultado.getEmail()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         BufferedReader reader = req.getReader();
         String[] email = reader.readLine().split(",");

         AgendamentoEmail agendamentoEmail = new AgendamentoEmail();
         agendamentoEmail.setEmail(email[0]);
         agendamentoEmail.setAssunto(email[1]);
         agendamentoEmail.setMenssagem(email[2]);
         
         servico.inserir(agendamentoEmail);
    }
}
