package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Jogo;
import service.JogoService;

import java.io.IOException;
import java.util.List;

@WebServlet("/jogo")
public class JogoServlet extends HttpServlet {

    private JogoService service = new JogoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("usuario") == null){
            resp.sendRedirect("index.jsp");
            return;
        }
        String acao = req.getParameter("acao");
        if ("editar".equals(acao)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Jogo j = service.buscarId(id);
            req.setAttribute("jogo", j);
        }
        if ("excluir".equals(acao)) {
            int id = Integer.parseInt(req.getParameter("id"));
            service.excluir(id);
            resp.sendRedirect("jogo?msg=excluido");
            return;
        }

        List<Jogo> lista = service.listar();
        req.setAttribute("jogos", lista);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/jogos.jsp");

        rd.forward(req, resp);
    };

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect("index.jsp");
            return;
        }
        String idParam = req.getParameter("id");
        String nome = req.getParameter("nome");
        String genero = req.getParameter("genero");
        String plataforma = req.getParameter("plataforma");
        double horas = 0.0;
        if(req.getParameter("horas") != null && !req.getParameter("horas").isEmpty()){
            horas = Double.parseDouble(req.getParameter("horas"));
        }
        int nota = 0;
        if(req.getParameter("nota") != null && !req.getParameter("nota").isEmpty()){
            nota = Integer.parseInt(req.getParameter("nota"));
        }
        //Boolean jogando = Boolean.valueOf(req.getParameter("jogando"));
        Boolean jogando = req.getParameter("jogando") != null && (req.getParameter("jogando").equals("true") ||
                                                                     req.getParameter("jogando").equals("on"));
        String capa = req.getParameter("capa");

        Jogo j = new Jogo(nome, genero, plataforma, horas, nota, jogando, capa);

        if(idParam != null && !idParam.isEmpty()){
            j.setId(Integer.parseInt(idParam));
            service.atualizar(j);
            resp.sendRedirect("jogo?msg=editado");
        }else{
            service.inserir(j);
            resp.sendRedirect("jogo?msg=salvo");
        }

    };

}
