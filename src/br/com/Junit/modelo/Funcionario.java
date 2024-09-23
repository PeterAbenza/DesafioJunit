package br.com.Junit.modelo;

public class Funcionario {

	private String Departamento;
	private String nome;
	private int idade;
	private double Salario;

	public Funcionario(String Departamento, String nome, int idade, double Salario) {
		this.Departamento = Departamento;
		this.nome = nome;
		this.idade = idade;
		this.Salario = Salario;
	}

	// getters
	public String getDepartamento() {
		return Departamento;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public double getSalario() {
		return Salario;
	}

	@Override
	public String toString() {
		return "Departamento: " + Departamento + ", nome: " + nome + ", idade: " + idade + ", Salário: "
				+ Salario;
	}
	
	
}
