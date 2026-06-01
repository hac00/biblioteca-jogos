package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.UsuarioService;

import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private UsuarioService service = new UsuarioService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario u = new Usuario(nome, email, senha);

        boolean sucesso = service.inserir(u);

        if (sucesso){
            resp.sendRedirect("index.jsp");
        }else{
            req.setAttribute("erro", "Erro ao cadastrar usuario");
            req.getRequestDispatcher("WEB-INF/pages/cadastro.jsp").forward(req, resp);
        }
    }

}
