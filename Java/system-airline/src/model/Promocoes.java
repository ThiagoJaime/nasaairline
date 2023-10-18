package model;

import java.time.LocalDateTime;


public class Promocoes {
    // Atributos
    private int idPromocao;
    private double precoPromo;
    private LocalDateTime validade;

    
    public Promocoes() {
 		// TODO Auto-generated constructor stub
 	}

    
    // Construtor de Insert
    public Promocoes(double precoPromo, LocalDateTime validadePromo) {
        this.precoPromo = precoPromo;
        this.validade = validadePromo;
    }

    // Construtor de Update
    public Promocoes(int idPromocao, double precoPromo, LocalDateTime validade) {
        this.idPromocao = idPromocao;
        this.precoPromo = precoPromo;
        this.validade = validade;
    }

 

	// Métodos Getter e Setter
    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }

    public double getPrecoPromo() {
        return precoPromo;
    }

    public void setPrecoPromo(double precoPromo) {
        this.precoPromo = precoPromo;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }
}
