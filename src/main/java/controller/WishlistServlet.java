package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import model.Wishlist;
import service.WishlistService;

import java.io.IOException;
import java.util.List;

@WebServlet("/wishlist")
public class WishlistServlet extends HttpServlet {

    private WishlistService service = new WishlistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        Usuario logado = (Usuario) session.getAttribute("usuario");

        String acao = req.getParameter("acao");

        if ("editar".equals(acao)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Wishlist w = service.buscarId(id, logado.getId());
            req.setAttribute("itemWishlist", w);
        }
        if ("excluir".equals(acao)) {
            int id = Integer.parseInt(req.getParameter("id"));
            service.excluir(id, logado.getId());
            resp.sendRedirect("wishlist?msg=excluido");
            return;
        }

        List<Wishlist> lista = service.listarPorUsuario(logado.getId());
        req.setAttribute("itensWishlist", lista);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/wishlist.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        Usuario logado = (Usuario) session.getAttribute("usuario");
        String idParam = req.getParameter("id");
        String nome = req.getParameter("nome");
        String plataforma = req.getParameter("plataforma");

        double precoMaximo = 0.0;
        if (req.getParameter("precoMaximo") != null && !req.getParameter("precoMaximo").isEmpty()) {
            precoMaximo = Double.parseDouble(req.getParameter("precoMaximo"));
        }

        Wishlist w = new Wishlist(logado.getId(), nome, plataforma, precoMaximo);

        try {
            if (idParam != null && !idParam.isEmpty()) {
                w.setId(Integer.parseInt(idParam));
                service.atualizar(w);
                resp.sendRedirect("wishlist?msg=editado");
            } else {
                service.inserir(w);
                resp.sendRedirect("wishlist?msg=salvo");
            }
        } catch (IllegalArgumentException e) {
            req.setAttribute("erroValidacao", e.getMessage());
            req.setAttribute("itemWishlist", w);
            doGet(req, resp);
        }
    }
}
