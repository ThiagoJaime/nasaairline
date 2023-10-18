package model;

import java.time.LocalDateTime;

public class Reserva {
	// Atributos
	private int idReserva;
	private Clientes cliente;
	private Promocoes promocao;
	private Destinos destino;
	private double valor;
	private LocalDateTime dataIda;
	private LocalDateTime dataRetorno;

	
	public Reserva() {
		
	}
	
	// Construtor de Insert
	public Reserva(Clientes cliente, Promocoes promocao, Destinos destino, double valor, LocalDateTime dataIda, LocalDateTime dataRetorno) {
		
		this.cliente = cliente;
		this.promocao = promocao;
		this.destino = destino;
		this.valor = valor;
		this.dataIda = dataIda;
		this.dataRetorno = dataRetorno;
	}

	// Construtor de Update
	public Reserva(int idReserva, Clientes cliente, Promocoes promocao, Destinos destino, double valor, LocalDateTime dataIda, LocalDateTime dataRetorno) {
		
		this.idReserva = idReserva;
		this.cliente = cliente;
		this.promocao = promocao;
		this.destino = destino;
		this.valor = valor;
		this.dataIda = dataIda;
		this.dataRetorno = dataRetorno;
	}


	// Métodos Getter e Setter
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Promocoes getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocoes promocao) {
		this.promocao = promocao;
	}

	public Destinos getDestino() {
		return destino;
	}

	public void setDestino(Destinos destino) {
		this.destino = destino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataIda() {
		return dataIda;
	}

	public void setDataIda(LocalDateTime dataIda) {
		this.dataIda = dataIda;
	}

	public LocalDateTime getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(LocalDateTime dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
}