package br.com.teste.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.teste.servico.AgendamentoEmailServico;

import java.io.PrintWriter;

public class AgendamentoEmailServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    
    @Inject
    private AgendamentoEmailServico servico;

    // @Override
    //  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //  }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        servico.listar().forEach(resultado -> pw.print("Os emails disponiveis são: " + resultado));
    }
}
