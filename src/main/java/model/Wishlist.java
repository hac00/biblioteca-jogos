package model;

public class Wishlist {
    private int id;
    private int usuarioId;
    private String nome;
    private String plataforma;
    private double precoMaximo;

    public Wishlist() {}

    public Wishlist(int usuarioId, String nome, String plataforma, double precoMaximo) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.plataforma = plataforma;
        this.precoMaximo = precoMaximo;
    }

    public Wishlist(int id, int usuarioId, String nome, String plataforma, double precoMaximo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.plataforma = plataforma;
        this.precoMaximo = precoMaximo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public double getPrecoMaximo() { return precoMaximo; }
    public void setPrecoMaximo(double precoMaximo) { this.precoMaximo = precoMaximo; }
}
