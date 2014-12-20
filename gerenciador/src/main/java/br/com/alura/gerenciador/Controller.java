package br.com.alura.gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FazTudo
 */
@WebServlet("/executa")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tarefa= request.getParameter("tarefa");
		if(tarefa==null){
			new IllegalArgumentException(" vc esqueceu de passar o tarefa");
		}
		String caminho="br.alura.gerenciador.web."+tarefa;
		try {
			Class<?> tipo = Class.forName(caminho);
			Tarefa instancia =(Tarefa)tipo.newInstance();
			String pagina =instancia.executa(request,response);
			RequestDispatcher dispatcher= request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException|InstantiationException | IllegalAccessException e) {
			
			throw new ServletException(e);
		}
	}

	
}
