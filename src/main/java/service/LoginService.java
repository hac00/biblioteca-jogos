package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario autenticar(String email, String senha){
        try {
            return dao.autenticar(email, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
