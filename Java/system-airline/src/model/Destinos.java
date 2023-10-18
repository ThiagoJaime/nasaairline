package model;

public class Destinos {
    // Atributos
    private int idDestino;
    private String pais;
    private double preco;
    private int duracao;

    // Construtor para DAO
    public Destinos() {
    }

    // Construtor de Insert
    public Destinos(String pais, double preco, int duracao) {
        this.pais = pais;
        this.preco = preco;
        this.duracao = duracao;
    }

    // Construtor de Update
    public Destinos(int idDestino, String pais, double preco, int duracao) {
        this.idDestino = idDestino;
        this.pais = pais;
        this.preco = preco;
        this.duracao = duracao;
    }

    // Métodos Getter e Setter
    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
