package br.com.alura.gerenciador;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.Filter;
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
@WebServlet("/busca")
public class BuscaEmpresa implements Tarefa {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public String executa(HttpServletRequest request, HttpServletResponse response)  {
		
        EmpresaDAO empresaDAO = new EmpresaDAO();
        String filtro = request.getParameter("filtro");
        Collection<Empresa> empresas =empresaDAO.buscaPorSimilaridade(filtro);
       request.setAttribute("empresas", empresas);
       return "/WEB-INF/paginas/buscaEmpresa.jsp";
      
	}

	

}
