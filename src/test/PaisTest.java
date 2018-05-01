package test;

import static org.junit.Assert.assertEquals;

import model.Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PaisTest {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Austrália");
		pais.setPopulacao(24130000);
		pais.setArea(7692000.00);
		copia = new Pais();
		copia.setId(id);
		copia.setNome("Austrália");
		copia.setPopulacao(24130000);
		copia.setArea(7692000.00);
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Pais copia = new Pais();
		copia.setId(1);
		copia.setNome("Austrália");
		copia.setPopulacao(24130000);
		copia.setArea(7692000.0);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, copia);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setArea(999999.0);
		copia.setArea(999999.0);		
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0.00);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}
	
	@Test
	public void test04MaiorPopulacao() {
		System.out.println("Maior");
		Pais copia = new Pais();
		copia.setId(0);
		copia.setNome(null);
		copia.setPopulacao(1);
		copia.setArea(0.0);
		PaisService novoService = new PaisService();
		Pais novo = novoService.maiorPopulacao(1);
		assertEquals("testa inclusao", novo, copia);
	}
	
	@Test
	public void test05MenorArea() {
		System.out.println("menor");
		Pais copia = new Pais();
		copia.setId(0);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(1.0);
		PaisService novoService = new PaisService();
		Pais novo = novoService.menorArea(1.0);
		assertEquals("testa inclusao", novo, copia);
	}
	
	@Test
	public void test06Aleatorio() {
		System.out.println("3 paises");
		Pais copia = new Pais();
		copia.setId(1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0.0);
		PaisService novoService = new PaisService();
		Pais novo = novoService.aleatorio(1);
		assertEquals("testa inclusao", novo, copia);
	}
	
}
