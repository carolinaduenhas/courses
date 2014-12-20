package br.com.alura.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Map<String,Usuario> USUARIOS_LOGADOS = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha =request.getParameter("senha");
		Usuario user =new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer =response.getWriter();
		if (user==null){
			writer.println("<html><body>Usuario invalido</body></html>");
			
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", user);
			
			writer.println("<html><body>Usuario logado: "+user.getEmail()+" </body></html>");
		}
		
	}

}
