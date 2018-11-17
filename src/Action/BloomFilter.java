package Action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BloomFilter
{
	private static final String FUNCAO_HASH = "MD5";
	private static String tamanho;
	private static float percentualErroToleravel;
	private static int tamanhoOtimo;
	private static int numeroOtimoFuncoesHash;
	
	public BloomFilter(String tamanho, float percentualErroToleravel)
	{
		this.tamanho = tamanho;
		this.percentualErroToleravel = percentualErroToleravel;
	}
	
	private static void calcularProbabilidadeFalsosPositivosAlterandoQuantidadeFuncoesHash()
	{

	}
	
	private static void calcularProbabilidadeFalsosPositivosAlterandoTamanhoFiltro()
	{
		
	}

	private static void calcularQuantidadeOtimaDeFuncoesHash(int n)
	{
		Double m = Math.ceil(((n * Math.log(percentualErroToleravel)) / Math.log(1 / Math.pow(2, Math.log(2)))));
		long k = Math.round((m/n) * Math.log(2));
		System.out.println(m.toString());
		System.out.println(k);
	}
	
	private static int calcularPosicaoBloomFilter(String entrada) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance(FUNCAO_HASH);
		md.update(entrada.getBytes());
		byte[] hashEntrada = md.digest();

		// na declaracao do big integer, o primeiro parametro eh o signum
		// -1 para negativo, 0 para zero ou 1 para positivo
		BigInteger numeroHashEntrada = new BigInteger(1,hashEntrada);
		int posicaoBloomFilter = numeroHashEntrada.mod(new BigInteger(tamanho)).intValue();
		
		//System.out.println(numeroHashEntrada.toString(16));
		//System.out.println(numeroHashEntrada.mod(new BigInteger("2")));
		//System.out.println(posicaoBloomFilter);
		
		return posicaoBloomFilter;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		String teste = "batata";
		
		BloomFilter bloomFilter = new BloomFilter("95", 0.150746464f);
		
		calcularQuantidadeOtimaDeFuncoesHash(4000);
		System.out.println(calcularPosicaoBloomFilter(teste));
	}
}
