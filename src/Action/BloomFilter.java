package Action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BloomFilter
{
	private static final String FUNCAO_HASH = "MD5";
	private static String tamanho;
	private static float percentualErroToleravel;
	private static int tamanhoOtimo;
	private static long numeroOtimoFuncoesHash;
	private static int[] set;

	private static void calcularProbabilidadeFalsosPositivosAlterandoQuantidadeFuncoesHash()
	{
		numeroOtimoFuncoesHash = numeroOtimoFuncoesHash - 1;
	}
	
	private static void calcularProbabilidadeFalsosPositivosAlterandoTamanhoFiltro()
	{
		tamanhoOtimo = tamanhoOtimo - 1;
		set = new int[tamanhoOtimo];
	}

	private static void calcularQuantidadeOtimaDeFuncoesHash(int n)
	{
		Double numeroBits = Math.ceil(((n * Math.log(percentualErroToleravel)) / Math.log(1 / Math.pow(2, Math.log(2)))));
		long numeroFuncoesHash = Math.round((numeroBits/n) * Math.log(2));
		numeroOtimoFuncoesHash = numeroFuncoesHash;
		tamanhoOtimo = numeroBits.intValue();
		set = new int[tamanhoOtimo];
//		System.out.println(numeroBits.intValue());
//		System.out.println(numeroFuncoesHash);
	}
	
	private static int calcularPosicaoBloomFilter(String entrada, int contador) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance(FUNCAO_HASH);
		md.update(entrada.getBytes());
		md.update(String.valueOf(contador).getBytes());
		byte[] hashEntrada = md.digest();

		// na declaracao do big integer, o primeiro parametro eh o signum
		// -1 para negativo, 0 para zero ou 1 para positivo
		BigInteger numeroHashEntrada = new BigInteger(1,hashEntrada);
		int posicaoBloomFilter = numeroHashEntrada.mod(new BigInteger(String.valueOf(tamanhoOtimo))).intValue();
		
		return posicaoBloomFilter;
	}

	private static void adicionarNaSet(String teste) throws NoSuchAlgorithmException
	{
		for(int i = 0;i<numeroOtimoFuncoesHash;i++)
		{
			int a = calcularPosicaoBloomFilter(teste,i);
			set[a] = 1;
		}
	}
	
	private static String buscarNaSet(String teste) throws NoSuchAlgorithmException
	{
		for(int i = 0;i<numeroOtimoFuncoesHash;i++)
		{
			int a = calcularPosicaoBloomFilter(teste,i);
			if(set[a] == 1)
			{
				return teste + " pode estar presente";
			}
		}
		return teste+" nao esta presente.";
	}

	private static List<String> prePopularListaPalavras()
	{
		List<String> lista = new ArrayList<String>();
		lista.add("palavra1");
		lista.add("palavra2");
		lista.add("palavra3");
		
		return lista;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		List<String> lista = prePopularListaPalavras();
		
		percentualErroToleravel = 0.156f;
		
		calcularQuantidadeOtimaDeFuncoesHash(lista.size());
		
		for (String elemento : lista)
		{
			adicionarNaSet(elemento);
		}
		
		String palavraASerBuscada = "jujuba";
		
		System.out.println(buscarNaSet(palavraASerBuscada));
		
		System.out.println("\nAlterando quantidade funcoes hash");
		calcularProbabilidadeFalsosPositivosAlterandoQuantidadeFuncoesHash();
		for (String elemento : lista)
		{
			adicionarNaSet(elemento);
		}
		System.out.println(buscarNaSet(palavraASerBuscada));
		
		System.out.println("\nAlterando tamanho do filtro");
		calcularProbabilidadeFalsosPositivosAlterandoTamanhoFiltro();
		for (String elemento : lista)
		{
			adicionarNaSet(elemento);
		}
		System.out.println(buscarNaSet(palavraASerBuscada));
	}
}
