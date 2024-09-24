package br.com.Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.Junit.modelo.Funcionario;
import br.com.Junit.modelo.GestorDeFuncionarios;

class TesteFuncionarios {

	GestorDeFuncionarios gestorDeFuncionarios;
	Funcionario funcionario1 = new Funcionario("TI", "Felipe", 19, 3454.43);
	Funcionario funcionario2 = new Funcionario("TI", "João", 20, 6234.64);
	Funcionario funcionario3 = new Funcionario("Gestor", "Ana", 23, 4144.49);

	List<Funcionario> funcionarios = Arrays.asList(funcionario1, funcionario2, funcionario3);

	@BeforeEach // pra cada metodo ele vai chamar essa função;
	void iniciarFuncionarios() {
		gestorDeFuncionarios = new GestorDeFuncionarios(funcionarios);
	}

	@Test
	void DepartamentoFuncionarios() {
		assertTrue(gestorDeFuncionarios.DepartamentoFuncionarios("TI"));
	}

	@Test
	void funcionarioMaiorSalario() {
		Optional<Funcionario> funcionarioComMaiorSalario = Optional
				.ofNullable(gestorDeFuncionarios.funcionarioMaiorSalario());

		assertEquals("João", funcionarioComMaiorSalario.get().getNome());
		assertTrue(funcionarioComMaiorSalario.isPresent());

	}

	@Test
	void mediaSalariosFuncionarios() {
		double mediaEsperada = (3454.43 + 6234.64 + 4144.49) / 3;

		// O terceiro argumento é a margem de erro permitida
		assertEquals(mediaEsperada, gestorDeFuncionarios.mediaSalariosFuncionarios(), 0.01);
	}
	
	@Test
	void funcionariosPorIdade() {
		 List<Funcionario> funcionariosEsperados = funcionarios.stream()
	                .sorted(Comparator.comparing(Funcionario::getIdade)).toList(); // Ordenando por idadE
		
		assertEquals(funcionariosEsperados, gestorDeFuncionarios.funcionariosPorIdade());
		//assertTrue(gestorDeFuncionarios.funcionariosPorIdade().get(0).getIdade() < gestorDeFuncionarios.funcionariosPorIdade().get(1).getIdade());
	}
}
