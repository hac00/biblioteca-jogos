package service;

import dao.JogoDAO;
import model.Jogo;

import java.util.List;

public class JogoService {

    private JogoDAO dao = new JogoDAO();

    public boolean inserir(Jogo j){
        return dao.inserir(j);
    }

    public void atualizar(Jogo j){
        dao.atualizar(j);
    }

    public void excluir(int id){
        dao.excluir(id);
    }

    public List<Jogo> listar(){
        return dao.listar();
    }

    public Jogo buscarId(int id){
        return dao.buscarId(id);
    }

    public Jogo buscarNome(String nome){
        return dao.buscarNome(nome);
    }

    public List<Jogo> buscarJogando(boolean jogando){
        return dao.buscarJogando(jogando);
    }

}
