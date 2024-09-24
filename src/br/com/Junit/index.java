package br.com.Junit;

import java.util.Arrays;
import java.util.List;

import br.com.Junit.modelo.Funcionario;
import br.com.Junit.modelo.GestorDeFuncionarios;

public class index {
	
	public static void main(String[] args) {
	
		Funcionario funcionario1 = new Funcionario("TI", "Felipe", 19, 3454.43);
		Funcionario funcionario2 = new Funcionario("TI", "João", 20, 6234.64);
		Funcionario funcionario3 = new Funcionario("Gestor", "Ana", 23, 4144.49);
		Funcionario funcionario4 = new Funcionario("Gestor", "Lucas", 22, 6234.65);
		
		List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4);
		
		GestorDeFuncionarios gestorDeFuncionarios = new GestorDeFuncionarios(funcionarios);
		
		gestorDeFuncionarios.DepartamentoFuncionarios("TI");
		gestorDeFuncionarios.funcionarioMaiorSalario();
		gestorDeFuncionarios.mediaSalariosFuncionarios();
		
		/* gestorDeFuncionarios.funcionariosPorIdade(); */
	}
}
