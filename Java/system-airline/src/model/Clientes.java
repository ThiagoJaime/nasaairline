package model;

public class Clientes {
    // Atributos
    private int idCliente;
    private String nome, email, senha, telefone;
    
    // Construtor padrão
    public Clientes() {
    }

    // Construtor para inserção de dados
    public Clientes(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

	// Construtor para atualização de dados
    public Clientes(int idCliente, String nome, String email, String senha, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    // Métodos Getter e Setter
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getTelefone() {
 		return telefone;
 	}
 	public void setTelefone(String telefone) {
 		this.telefone = telefone;
 	}
}
