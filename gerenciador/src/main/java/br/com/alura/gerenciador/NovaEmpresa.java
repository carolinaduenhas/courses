package br.com.alura.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.EmpresaDAO;

/**
 * Servlet implementation class BuscaEmpresa
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	public String executa(HttpServletRequest request, HttpServletResponse response){
		
        EmpresaDAO empresaDAO = new EmpresaDAO();
        String nome = request.getParameter("nome");
        Empresa empresa = new Empresa(nome);
        empresaDAO.adiciona(empresa);
     request.setAttribute("empresa", empresa);
    return "/WEB-INF/paginas/novaEmpresa.jsp";
     
	}



}
