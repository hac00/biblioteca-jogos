package dao;

import model.Jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    public Jogo map(ResultSet rs) throws SQLException {
        Jogo j = new Jogo();
        j.setId(rs.getInt("id"));
        j.setNome(rs.getString("nome"));
        j.setGenero(rs.getString("genero"));
        j.setPlataforma(rs.getString("plataforma"));
        j.setHoras(rs.getDouble("horas"));
        j.setNota(rs.getInt("nota"));
        j.setJogando(rs.getBoolean("jogando"));
        j.setCapa(rs.getString("capa"));
        return j;
    }

    public boolean inserir(Jogo j){
        String sql = "INSERT INTO jogos (nome, genero, plataforma, horas, nota, jogando, capa) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = ConexaoDB.getConexao();
            PreparedStatement stmt =  conn.prepareStatement(sql)){

            stmt.setString(1, j.getNome());
            stmt.setString(2, j.getGenero());
            stmt.setString(3, j.getPlataforma());
            stmt.setDouble(4, j.getHoras());
            stmt.setInt(5, j.getNota());
            stmt.setBoolean(6, j.isJogando());
            stmt.setString(7, j.getCapa());
            return stmt.executeUpdate() > 0;

        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir jogo");
        }
    }

    public void atualizar(Jogo j){
        String sql = "UPDATE jogos SET nome = ?, genero = ?, plataforma = ?, horas = ?, nota = ?, jogando = ?, capa = ? WHERE id = ?";

        try(Connection conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, j.getNome());
            stmt.setString(2, j.getGenero());
            stmt.setString(3, j.getPlataforma());
            stmt.setDouble(4, j.getHoras());
            stmt.setInt(5, j.getNota());
            stmt.setBoolean(6, j.isJogando());
            stmt.setString(7, j.getCapa());
            stmt.setInt(8, j.getId());
            stmt.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar jogo");
        }
    }

    public void excluir(int id){
        String sql = "DELETE FROM jogos WHERE id = ?";

        try(Connection conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException("Erro ao excluir jogo");
        }
    }

    public List<Jogo> listar(Jogo j){
        String sql = "SELECT * FROM jogos";
        List<Jogo> lista = new ArrayList<>();

        try(Connection conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                lista.add(map(rs));
            }

        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar os jogos");
        }

        return lista;
    }

    public Jogo buscarNome(String nome){
        String sql = "SELECT * FROM jogos WHERE nome ILIKE ?";

        try(Connection conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome + "%");
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return map(rs);
            }

        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar o jogo por nome");
        }

        return null;
    }

    public List<Jogo> buscarJogando(boolean jogando){
        String sql = "SELECT * FROM jogos WHERE jogando = ?";
        List<Jogo> lista = new ArrayList<>();

        try(Connection conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setBoolean(1, jogando);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                lista.add(map(rs));
            }

        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar os jogos que estao sendo jogados");
        }

        return lista;
    }

}
