package br.edu.projeto.model;

public class Cliente {

	private Integer id_clientes;

    private String nome;
    private String nome_social;

    private Integer cpf;
    private Float altura;
    private Integer massa;
    private String genero;
    private Integer idade;
    private Integer celular;
    private Integer telefone;
    private String endereco;
    
    private String email;

	public Integer getId_clientes() {
		return id_clientes;
	}

	public void setId_clientes(Integer id_clientes) {
		this.id_clientes = id_clientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_social() {
		return nome_social;
	}

	public void setNome_social(String nome_social) {
		this.nome_social = nome_social;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Integer getMassa() {
		return massa;
	}

	public void setMassa(Integer massa) {
		this.massa = massa;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
