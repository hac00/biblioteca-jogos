package model;

public class Estatisticas {
    private int totalJogos;
    private double totalHoras;
    private String mediaNotas;
    private int jogando;
    private int backlog;

    public Estatisticas(int totalJogos, double totalHoras, String mediaNotas, int jogando, int backlog) {
        this.totalJogos = totalJogos;
        this.totalHoras = totalHoras;
        this.mediaNotas = mediaNotas;
        this.jogando = jogando;
        this.backlog = backlog;
    }

    public int getTotalJogos() {
        return totalJogos;
    }

    public double getTotalHoras() {
        return totalHoras;
    }

    public String getMediaNotas() {
        return mediaNotas;
    }

    public int getJogando() {
        return jogando;
    }

    public int getBacklog() {
        return backlog;
    }
}
