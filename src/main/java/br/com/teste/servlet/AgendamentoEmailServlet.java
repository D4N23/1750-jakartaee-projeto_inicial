package br.com.teste.servlet;

import java.io.IOException;

import br.com.teste.entity.AgendamentoEmail;
import br.com.teste.servico.AgendamentoEmailServico;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.BufferedReader;

@WebServlet("/emails")
public class AgendamentoEmailServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    
    @Inject
    private AgendamentoEmailServico servico;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setContentType("text/plain");
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
