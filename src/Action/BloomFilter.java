package Action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BloomFilter
{
	private static final String FUNCAO_HASH = "MD5";
	private int tamanho;
	private float percentualErroToleravel;
	private int tamanhoOtimo;
	private int numeroOtimoFuncoesHash;
	
	public BloomFilter(int tamanho, float percentualErroToleravel)
	{
		this.tamanho = tamanho;
		this.percentualErroToleravel = percentualErroToleravel;
	}
	
	private int calcularTamanhoOtimo()
	{
		return 1;
	}

	private static int calcularPosicaoBloomFilter(String entrada) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance(FUNCAO_HASH);
		md.update(entrada.getBytes());
		byte[] hashEntrada = md.digest();

		// na declaracao do big integer, o primeiro parametro eh o signum
		// -1 para negativo, 0 para zero ou 1 para positivo
		BigInteger numeroHashEntrada = new BigInteger(1,hashEntrada);
		int posicaoBloomFilter = numeroHashEntrada.mod(new BigInteger("1")).intValue();
		System.out.println(numeroHashEntrada.toString(16));
		System.out.println(numeroHashEntrada.mod(new BigInteger("2")));
		System.out.println(posicaoBloomFilter);
		
		return posicaoBloomFilter;
	}

	
	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		String teste = "batata";
		System.out.println(calcularPosicaoBloomFilter(teste));
	}
}
