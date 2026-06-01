package service;

import dao.JogoDAO;
import model.Estatisticas;
import model.Jogo;

import java.util.List;

public class JogoService {

    private JogoDAO dao = new JogoDAO();

    public void validarJogo(Jogo j) {
        if (j.getNome() == null || j.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do jogo é obrigatório.");
        }
        if (j.getHoras() < 0) {
            throw new IllegalArgumentException("A quantidade de horas não pode ser negativa.");
        }
        if (j.getNota() < 0 || j.getNota() > 10) {
            throw new IllegalArgumentException("A nota precisa estar estritamente entre 0 e 10.");
        }
    }

    public boolean inserir(Jogo j){
        validarJogo(j);
        return dao.inserir(j);
    }

    public void atualizar(Jogo j){
        validarJogo(j);
        dao.atualizar(j);
    }

    public void excluir(int id, int usuarioId){
        dao.excluir(id, usuarioId);
    }

    public List<Jogo> listarUsuario(int usuarioId){
        return dao.listarUsuario(usuarioId);
    }

    public Jogo buscarId(int id, int usuarioId){
        return dao.buscarId(id, usuarioId);
    }

    public Jogo buscarNome(String nome){
        return dao.buscarNome(nome);
    }

    public List<Jogo> buscarJogando(boolean jogando){
        return dao.buscarJogando(jogando);
    }

    public Estatisticas calcularEstatisticas(List<Jogo> lista) {
        int totalJogos = lista.size();
        double totalHoras = 0.0;
        double somaNotas = 0.0;
        int jogosAvaliados = 0;
        int jogando = 0;
        int backlog = 0;

        for (Jogo jogo : lista) {
            totalHoras += jogo.getHoras();
            if (jogo.getNota() > 0) {
                somaNotas += jogo.getNota();
                jogosAvaliados++;
            }
            if (jogo.isJogando()) {
                jogando++;
            } else {
                backlog++;
            }
        }

        double mediaNotas = jogosAvaliados > 0 ? (somaNotas / jogosAvaliados) : 0.0;
        String mediaFormatada = String.format("%.1f", mediaNotas);

        return new Estatisticas(totalJogos, totalHoras, mediaFormatada, jogando, backlog);
    }

}
