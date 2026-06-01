package model;

public class Jogo {

    private int id;
    private int usuarioId;
    private String nome;
    private String genero;
    private String plataforma;
    private double horas;
    private int nota;
    private boolean jogando;
    private String capa;

    public Jogo(){}

    public Jogo(int usuarioId, String nome, String genero, String plataforma, double horas, int nota, boolean jogando, String capa) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.genero = genero;
        this.plataforma = plataforma;
        this.horas = horas;
        this.nota = nota;
        this.jogando = jogando;
        this.capa = capa;
    }

    public Jogo(int id, int usuarioId, String nome, String genero, String plataforma, double horas, int nota, boolean jogando, String capa){
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.genero = genero;
        this.plataforma = plataforma;
        this.horas = horas;
        this.nota = nota;
        this.jogando = jogando;
        this.capa = capa;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUsuarioId(){
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId){
        this.usuarioId = usuarioId;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isJogando() {
        return jogando;
    }

    public void setJogando(boolean jogando) {
        this.jogando = jogando;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }
}
