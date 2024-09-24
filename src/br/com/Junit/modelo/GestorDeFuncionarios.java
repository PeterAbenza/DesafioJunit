package br.com.Junit.modelo;

import java.util.stream.Collectors;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@SuppressWarnings("deprecation")
public class GestorDeFuncionarios {
	private List<Funcionario> funcionarios;

	public GestorDeFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	// Métodos para realizar as operações com Stream, como filtragem, ordenação etc.

	public boolean DepartamentoFuncionarios(String Departamento) {

		// 'anyMatch' ao menos um elemento no stream corresponde a uma condição.
		boolean temFuncionarioDoDepartamento = funcionarios.stream()
				.anyMatch(f -> f.getDepartamento().equalsIgnoreCase(Departamento));

		if (temFuncionarioDoDepartamento) {
			System.out.println(Departamento + "? " + temFuncionarioDoDepartamento);
			return true;
		} else {
			System.out.println(Departamento + "? " + temFuncionarioDoDepartamento);
			return false;
		}
	}

	 public Funcionario funcionarioMaiorSalario() {
	        return funcionarios.stream()
	                .max(Comparator.comparing(Funcionario::getSalario))
	                .orElse(null); // Retorna null se não houver funcionários
	 }
	 
	 public List<Funcionario> funcionariosPorIdade() {
		  List<Funcionario> funcionariosIdades = funcionarios.stream()
                 .sorted(Comparator.comparing(Funcionario::getIdade)) // Ordenação natural (crescente) || Ordenando por idade
                 .collect(Collectors.toList());
		  
		  System.out.println(funcionariosIdades);
		 
		  return funcionariosIdades;
	 }

	public double mediaSalariosFuncionarios() {
		double mediaSalarios = funcionarios.stream()
				                           .mapToDouble(Funcionario::getSalario) // transforma os elementos do stream em valores primitivos do tipo double.
				                           .average() // calcula a média dos valores no stream.
				                           .orElse(0.0); // fornece um valor padrão caso o OptionalDouble esteja vazio.
		
		/* Formatação do valor em R$
		 * 'NumberFormat' uma classe que permite formatar números, incluindo a formatação de moedas, percentuais e números em geral.
		 * 'Locale' define a localidade específica para a formatação
		*/ 
		
		NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		// Este método formata o número mediaSalarios (que é um double) como uma string representando uma quantia em moeda.
		String mediaFormatada = formato.format(mediaSalarios);
       
		
        System.out.println("Média salarial " + mediaFormatada);
		return mediaSalarios;
	}
}
