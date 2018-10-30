package Action;

/*Trabalho: Simular um dado desonesto, onde cada face pode ou nao ter um peso diferente, deseja-se simular a probabilidade de :
 *  
 *  - tres resultados iguais em 3 lancamentos seguidos
 *  - dois pares seguidos em quatro lancamentos, exemplo: A = B, C = D
 *  
 *   Analisar o que acontece quando mudamos os pesos das faces
 * 
 */
import java.util.Random;

public class DadoViciado
{
	private static int intervaloChancesFace1;
	private static int intervaloChancesFace2;
	private static int intervaloChancesFace3;
	private static int intervaloChancesFace4;
	private static int intervaloChancesFace5;
	private static int intervaloChancesFace6;

	protected static void formatarProbabilidades(String... probabilidades)
	{
		
		intervaloChancesFace1 = Integer.parseInt(probabilidades[0].split("/")[0]);
		intervaloChancesFace2 = Integer.parseInt(probabilidades[1].split("/")[0]) + intervaloChancesFace1;
		intervaloChancesFace3 = Integer.parseInt(probabilidades[2].split("/")[0]) + intervaloChancesFace2;
		intervaloChancesFace4 = Integer.parseInt(probabilidades[3].split("/")[0]) + intervaloChancesFace3;
		intervaloChancesFace5 = Integer.parseInt(probabilidades[4].split("/")[0]) + intervaloChancesFace4;
		intervaloChancesFace6 = Integer.parseInt(probabilidades[5].split("/")[0]) + intervaloChancesFace5;

	}

	protected static int escolherValor()
	{
		Random rand = new Random();
		int valorLancado = rand.nextInt(intervaloChancesFace6+1);
		
		return valorLancado;
	}
	
	protected static void lancarDado()
	{
		int lancamento = escolherValor();
		if(lancamento < intervaloChancesFace1)
		{
			System.out.println("Face 1");
		}
		else if(lancamento < intervaloChancesFace2)
		{
			System.out.println("Face 2");
		}
		else if(lancamento < intervaloChancesFace3)
		{
			System.out.println("Face 3");
		}
		else if(lancamento < intervaloChancesFace4)
		{
			System.out.println("Face 4");	
		}
		else if(lancamento < intervaloChancesFace5)
		{
			System.out.println("Face 5");
		}
		else if(lancamento < intervaloChancesFace6)
		{
			System.out.println("Face 6");
		}
	}

	//- tres resultados iguais em 3 lancamentos seguidos
	protected static void tresResultadosIguaisTresLancamentos()
	{
		int numeroTentativas = 0;
		int valorAnterior = intervaloChancesFace6 + 2; //variavel inicializada com um valor que nao pode ser encontrado pela funcao escolheValor()
		int contagemRepetidos = 0;
		
		while(contagemRepetidos < 3)
		{
			int valor = escolherValor();
			if(valor == valorAnterior)
			{
				contagemRepetidos++;
				numeroTentativas++;
			}
			else
			{
				contagemRepetidos = 0;
				numeroTentativas++;
				valorAnterior = valor;
			}
		}
		System.out.println("Resultado foi encontrado em " + numeroTentativas + " tentativas");
	}
	
	//- dois pares seguidos em quatro lancamentos, exemplo: A = B, C = D
	protected static void doisParesSeguidosQuatroLancamentos()
	{
		int numeroTentativas = 0;
		int valorAnterior = intervaloChancesFace6 + 2; //variavel inicializada com um valor que nao pode ser encontrado pela funcao escolheValor()
		int contagemRepetidos = 0;
		int quantidadePares = 0;
		while(quantidadePares < 2)
		{
			int valor = escolherValor();
			if(valor == valorAnterior)
			{
				numeroTentativas++;
				contagemRepetidos++;
			}
			else
			{
				numeroTentativas++;
				contagemRepetidos = 0;
				valorAnterior = valor;
			}
			
			if(contagemRepetidos == 2)
			{
				quantidadePares++;
				contagemRepetidos = 0;
			}
			else if( quantidadePares == 1 && contagemRepetidos == 0)
			{
				quantidadePares = 0;
			}
			System.out.println(valor + " :  " + contagemRepetidos + " :    " + quantidadePares);
		}
		System.out.println("Resultado foi encontrado em " + numeroTentativas + " tentativas");
	}
	
	public static void main(String[] args)
	{
		String pesoFace1 = "1/6";
		String pesoFace2 = "1/6";
		String pesoFace3 = "5/6";
		String pesoFace4 = "1/6";
		String pesoFace5 = "1/6";
		String pesoFace6 = "1/6";
		formatarProbabilidades(pesoFace1,pesoFace2,pesoFace3,pesoFace4,pesoFace5,pesoFace6);
		//lancarDado();
		tresResultadosIguaisTresLancamentos();
		doisParesSeguidosQuatroLancamentos();
		
	}
}
