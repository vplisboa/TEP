package Action;

import java.util.Random;

/*Simulador de lancamento de moedas, com o objetivo de comparar o numero de lancamentos medio em duas situacoes
 *  - ate se obter 5 caras
 *  - ate se obter 2 caras seguidas, 2 vezes.
 */

public class MoedaInjusta
{
	private static final String CARA = "Cara";
	private static final String COROA = "Coroa";

	private static int chancesCara;
	private static int chancesCoroa;
	private static int quantidadeLancamentos;

	protected static void formatarProbabilidades(String chance, int totalLancamentos)
	{
		String[] chanceFormatada = chance.split("/");
		chancesCara = Integer.parseInt(chanceFormatada[0]);
		chancesCoroa = Integer.parseInt(chanceFormatada[1]);
		quantidadeLancamentos = totalLancamentos;
	}

	protected static int escolherValor()
	{
		Random rand = new Random();
		int lancamento = rand.nextInt(chancesCoroa);// escolhe um numero entre 0 e chances de coroa - 1
		return lancamento;
	}

	protected static String lancarMoeda()
	{
		int lancamento = escolherValor();
		if (lancamento < chancesCara)
		{
			return CARA;
		}
		else
		{
			return COROA;
		}
	}

	protected static int obterCincoCaras()
	{
		int quantidadeCaras = 0;
		int quantidadeLancamentos = 0;
		while (quantidadeCaras < 5)
		{
			String faceLancada = lancarMoeda();
			quantidadeLancamentos++;
			if (faceLancada.equals(CARA))
			{
				quantidadeCaras++;
			}
		}
		return quantidadeLancamentos;
	}

	protected static int obterDuasCarasSeguidasDuasVezes()
	{
		int quantidadeCaras = 0;
		int quantidadeLancamentos = 0;
		int parCarasSeguidos = 0;

		while (parCarasSeguidos < 2)
		{
			String faceLancada = lancarMoeda();
			quantidadeLancamentos++;

			if (faceLancada.equals(CARA))
			{
				quantidadeCaras++;
			}
			else
			{
				quantidadeCaras = 0;
			}

			if (quantidadeCaras == 2)
			{
				quantidadeCaras = 0;
				parCarasSeguidos++;
			}

		}
		return quantidadeLancamentos;
	}

	protected static int calcularMediaLancamentos(int totalDeLancamentos)
	{
		return totalDeLancamentos / quantidadeLancamentos;
	}

	protected static void gerarSimulacao()
	{

		int somaLancamentos2Caras2Vezes = 0;
		int somaLancamentos5Caras = 0;
		

		somaLancamentos5Caras = simular5Caras();
		somaLancamentos2Caras2Vezes = simular2Caras2Vezes();

		int mediaLancamentos2Caras2Vezes = calcularMediaLancamentos(somaLancamentos2Caras2Vezes);
		int mediaLancamentos5Caras = calcularMediaLancamentos(somaLancamentos5Caras);

		mostrarResultado(mediaLancamentos5Caras, mediaLancamentos2Caras2Vezes);

	}

	protected static void mostrarResultado(int mediaLancamentos5Caras, int mediaLancamentos2Caras2Vezes)
	{
		System.out.println("A simulacao gerou o seguinte resultado para " + quantidadeLancamentos + " execucoes");
		System.out.println("A media de lancamentos para se obter 5 caras foi: "+ mediaLancamentos5Caras);
		System.out.println("A media de lancamentos para se obter 2 caras 2 vezes foi: "+ mediaLancamentos2Caras2Vezes);
	}
	
	protected static int simular5Caras()
	{
		int somaLancamentos = 0;
		int lancamentos = 0;
		while (lancamentos < quantidadeLancamentos)
		{
			somaLancamentos += obterCincoCaras();
			lancamentos++;
		}
		return somaLancamentos;
	}

	protected static int simular2Caras2Vezes()
	{
		int somaLancamentos = 0;
		int lancamentos = 0;
		while (lancamentos < quantidadeLancamentos)
		{
			somaLancamentos += obterDuasCarasSeguidasDuasVezes();
			lancamentos++;
		}
		return somaLancamentos;
	}

	public static void main(String[] args)
	{
		// probabilidade de se obter caras p=2/3
		String probabilidade = "2/3";

		// quantidadeDeLancamentos
		int totalLancamentos = 10;

		formatarProbabilidades(probabilidade, totalLancamentos);

		gerarSimulacao();
	}
}
