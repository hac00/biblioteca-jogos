package service;

import dao.WishlistDAO;
import model.Wishlist;

import java.util.List;

public class WishlistService {

    private WishlistDAO dao = new WishlistDAO();

    public void validarWishlist(Wishlist w) {
        if (w.getNome() == null || w.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do jogo desejado é obrigatório.");
        }
        if (w.getPrecoMaximo() < 0) {
            throw new IllegalArgumentException("O preço máximo não pode ser um valor negativo.");
        }
    }

    public boolean inserir(Wishlist w) {
        validarWishlist(w);
        return dao.inserir(w);
    }

    public void atualizar(Wishlist w) {
        validarWishlist(w);
        dao.atualizar(w);
    }

    public void excluir(int id, int usuarioId) {
        dao.excluir(id, usuarioId);
    }

    public List<Wishlist> listarPorUsuario(int usuarioId) {
        return dao.listarPorUsuario(usuarioId);
    }

    public Wishlist buscarId(int id, int usuarioId) {
        return dao.buscarId(id, usuarioId);
    }
}
