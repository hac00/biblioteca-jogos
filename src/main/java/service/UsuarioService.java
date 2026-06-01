package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

    UsuarioDAO dao = new UsuarioDAO();

    public boolean inserir(Usuario u){
        return dao.inserir(u);
    }

}
