package dao;

import model.Wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishlistDAO {

    public Wishlist map(ResultSet rs) throws SQLException {
        Wishlist w = new Wishlist();
        w.setId(rs.getInt("id"));
        w.setUsuarioId(rs.getInt("usuario_id"));
        w.setNome(rs.getString("nome"));
        w.setPlataforma(rs.getString("plataforma"));
        w.setPrecoMaximo(rs.getDouble("preco_maximo"));
        return w;
    }

    public boolean inserir(Wishlist w) {
        String sql = "INSERT INTO wishlist (usuario_id, nome, plataforma, preco_maximo) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, w.getUsuarioId());
            stmt.setString(2, w.getNome());
            stmt.setString(3, w.getPlataforma());
            stmt.setDouble(4, w.getPrecoMaximo());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir na wishlist");
        }
    }

    public void atualizar(Wishlist w) {
        String sql = "UPDATE wishlist SET nome = ?, plataforma = ?, preco_maximo = ? WHERE id = ? AND usuario_id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, w.getNome());
            stmt.setString(2, w.getPlataforma());
            stmt.setDouble(3, w.getPrecoMaximo());
            stmt.setInt(4, w.getId());
            stmt.setInt(5, w.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar wishlist");
        }
    }

    public void excluir(int id, int usuarioId) {
        String sql = "DELETE FROM wishlist WHERE id = ? AND usuario_id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, usuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir da wishlist");
        }
    }

    public List<Wishlist> listarPorUsuario(int usuarioId) {
        String sql = "SELECT * FROM wishlist WHERE usuario_id = ?";
        List<Wishlist> lista = new ArrayList<>();
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(map(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar wishlist");
        }
        return lista;
    }

    public Wishlist buscarId(int id, int usuarioId) {
        String sql = "SELECT * FROM wishlist WHERE id = ? AND usuario_id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar item da wishlist");
        }
        return null;
    }
}
