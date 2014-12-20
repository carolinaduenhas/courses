package br.com.alura.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns="/logout")
public class Logout implements Tarefa {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public String executa(HttpServletRequest request, HttpServletResponse response){
	
		
		
		HttpSession session=request.getSession();
	
		Usuario usuario =(Usuario)session.getAttribute("usuarioLogado");
		if(usuario!=null){
		
			session.removeAttribute("usuarioLogado");	
		}
		return "/WEB-INF/paginas/logout.html";
			
	}
		
	

}
