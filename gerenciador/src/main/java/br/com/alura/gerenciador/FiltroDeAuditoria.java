package br.com.alura.gerenciador;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroDeAuditoria
 */
@WebFilter(urlPatterns ="/*")
public class FiltroDeAuditoria implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroDeAuditoria() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("metodo destroy chamado");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		System.out.println("URI requisitada "+req.getRequestURI());
		// a cada requisição o tempo do login é renovado
		HttpSession session=req.getSession();
		
		Usuario usuario =(Usuario)session.getAttribute("usuarioLogado");
		if(usuario!=null){
		
		System.out.println("Usuario  "+usuario.getEmail()+" acessando a URI");
		// pass the request along the filter chain
		}
		chain.doFilter(request, response);
	}

	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
