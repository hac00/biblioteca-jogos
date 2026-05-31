package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

    public boolean inserir(Usuario u){
        return new UsuarioDAO().inserir(u);
    }

}
