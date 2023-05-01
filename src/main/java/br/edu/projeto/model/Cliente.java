package br.edu.projeto.model;

public class Cliente {

	private Integer id_clientes;

    private String nome;
    private String nome_social;

    private String cpf;
    private Float altura;
    private Float massa;
    private String genero;
    private Integer idade;
    private String celular;
    private String telefone;
    private String endereco;

    private String senha;
    
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getMassa() {
		return massa;
	}

	public void setMassa(Float massa) {
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
