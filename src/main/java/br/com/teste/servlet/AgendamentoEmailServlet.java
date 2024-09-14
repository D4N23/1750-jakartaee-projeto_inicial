package br.com.teste.servlet;

import java.io.IOException;

import br.com.teste.servico.AgendamentoEmailServico;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class AgendamentoEmailServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    
    @Inject
    private AgendamentoEmailServico servico;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        servico.listar().forEach(resultado -> pw.print("Os emails disponiveis são: " + resultado));
    }
}
