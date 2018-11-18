package tests;

import org.testng.annotations.Test;

import Action.BloomFilter;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class BloomFilterUnitTest
{
	private List<String> listaPalavrasAdicionar;
	private List<String> listaPalavrasBuscar;
	private BloomFilter bloomFilter;
	
	@BeforeClass
	public void beforeClass()
	{
		bloomFilter = new BloomFilter(0.156f);
		listaPalavrasAdicionar = new ArrayList<String>();
		listaPalavrasBuscar = new ArrayList<String>();
		
		prePopularListaPalavrasASeremAdicionadas();
		prePopularListaPalavrasASeremBuscadas();

	}

	private void prePopularListaPalavrasASeremAdicionadas()
	{
		listaPalavrasAdicionar.add("Abacaxi");
		listaPalavrasAdicionar.add("banana");
		listaPalavrasAdicionar.add("paralelepipedo");
		listaPalavrasAdicionar.add("oie");
		listaPalavrasAdicionar.add("topicos");
		listaPalavrasAdicionar.add("especiais");
		listaPalavrasAdicionar.add("em");
		listaPalavrasAdicionar.add("programacao");
		listaPalavrasAdicionar.add("inconstitucionalissimamente");
	}
	
	private void prePopularListaPalavrasASeremBuscadas()
	{
		listaPalavrasBuscar.add("paralelepipedo");
		listaPalavrasBuscar.add("topicos");
		listaPalavrasBuscar.add("em");
		listaPalavrasBuscar.add("programacao");
		listaPalavrasBuscar.add("inconstitucionalissimamente");
		listaPalavrasBuscar.add("jujuba");
		listaPalavrasBuscar.add("batata");
		listaPalavrasBuscar.add("deuruim");
		listaPalavrasBuscar.add("foragido");
	}
	
	@Test
	public void testBloomFilter_variandoNumeroFuncoesHash() throws NoSuchAlgorithmException
	{
		bloomFilter.calcularQuantidadeOtimaDeFuncoesHash(listaPalavrasAdicionar.size());
		bloomFilter.calcularProbabilidadeFalsosPositivosAlterandoQuantidadeFuncoesHash();

		int quantidadeFalsoNegativo = 0;
		int quantidadeFalsoPositivo = 0;
		int quantidadeNegativo = 0;
		int quantidadePositivo = 0;
		
		popularBloomFilter();
		
		for (String palavraASerBuscada : listaPalavrasBuscar)
		{
			boolean encontrei = bloomFilter.buscarNaSet(palavraASerBuscada);
			if(encontrei && listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadePositivo++;
			}
			else if(encontrei && !listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeFalsoPositivo++;
			}
			else if(!encontrei && listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeFalsoNegativo++;
			}
			else if(!encontrei && !listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeNegativo++;
			}
		}
		Assert.assertEquals(quantidadeFalsoNegativo, 0);
		Assert.assertEquals(quantidadeFalsoPositivo, 3);
		Assert.assertEquals(quantidadeNegativo, 1);
		Assert.assertEquals(quantidadePositivo, 5);
	}

	@Test
	public void testBloomFilter_variandoTamanhoDoFiltro() throws NoSuchAlgorithmException
	{
		bloomFilter.calcularQuantidadeOtimaDeFuncoesHash(listaPalavrasAdicionar.size());
		bloomFilter.calcularProbabilidadeFalsosPositivosAlterandoTamanhoFiltro();
		popularBloomFilter();
		
		int quantidadeFalsoNegativo = 0;
		int quantidadeFalsoPositivo = 0;
		int quantidadeNegativo = 0;
		int quantidadePositivo = 0;
		
		for (String palavraASerBuscada : listaPalavrasBuscar)
		{
			boolean encontrei = bloomFilter.buscarNaSet(palavraASerBuscada);
			if(encontrei && listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadePositivo++;
			}
			else if(encontrei && !listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeFalsoPositivo++;
			}
			else if(!encontrei && listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeFalsoNegativo++;
			}
			else if(!encontrei && !listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeNegativo++;
			}
		}
		Assert.assertEquals(quantidadeFalsoNegativo, 0);
		Assert.assertEquals(quantidadeFalsoPositivo, 2);
		Assert.assertEquals(quantidadeNegativo, 2);
		Assert.assertEquals(quantidadePositivo, 5);
	}
	
	@Test
	public void testBloomFilter_calculandoValoresOtimosBaseadosNoTamanhoDaEntrada() throws NoSuchAlgorithmException
	{
		bloomFilter.calcularQuantidadeOtimaDeFuncoesHash(listaPalavrasAdicionar.size());
		popularBloomFilter();
		
		int quantidadeFalsoNegativo = 0;
		int quantidadeFalsoPositivo = 0;
		int quantidadeNegativo = 0;
		int quantidadePositivo = 0;
		
		for (String palavraASerBuscada : listaPalavrasBuscar)
		{
			boolean encontrei = bloomFilter.buscarNaSet(palavraASerBuscada);
			if(encontrei && listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadePositivo++;
			}
			else if(encontrei && !listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeFalsoPositivo++;
			}
			else if(!encontrei && listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeFalsoNegativo++;
			}
			else if(!encontrei && !listaPalavrasAdicionar.contains(palavraASerBuscada))
			{
				quantidadeNegativo++;
			}
		}
		Assert.assertEquals(quantidadeFalsoNegativo, 0);
		Assert.assertEquals(quantidadeFalsoPositivo, 4);
		Assert.assertEquals(quantidadeNegativo, 0);
		Assert.assertEquals(quantidadePositivo, 5);
	}
	
	private void popularBloomFilter() throws NoSuchAlgorithmException
	{
		for (String elemento : listaPalavrasAdicionar)
		{
			bloomFilter.adicionarNaSet(elemento);
		}
	}
	
}
