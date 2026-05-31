package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    public Usuario autenticar(String email, String senha){
        try {
            return new UsuarioDAO().autenticar(email, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
