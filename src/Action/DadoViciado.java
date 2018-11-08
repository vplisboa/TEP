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

	private static void formatarProbabilidades(String... probabilidades)
	{
		
		intervaloChancesFace1 = Integer.parseInt(probabilidades[0].split("/")[0]);
		intervaloChancesFace2 = Integer.parseInt(probabilidades[1].split("/")[0]) + intervaloChancesFace1;
		intervaloChancesFace3 = Integer.parseInt(probabilidades[2].split("/")[0]) + intervaloChancesFace2;
		intervaloChancesFace4 = Integer.parseInt(probabilidades[3].split("/")[0]) + intervaloChancesFace3;
		intervaloChancesFace5 = Integer.parseInt(probabilidades[4].split("/")[0]) + intervaloChancesFace4;
		intervaloChancesFace6 = Integer.parseInt(probabilidades[5].split("/")[0]) + intervaloChancesFace5;

	}

	private static int escolherValor()
	{
		Random rand = new Random();
		int valorLancado = rand.nextInt(intervaloChancesFace6+1);
		
		return valorLancado;
	}
	
	private static void lancarDado()
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
	private static void tresLancamentosTresResultadosIguais()
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
	private static void quatroLancamentosDoisParesSeguidos()
	{
		int numeroTentativas = 4;
		int valor1 = escolherValor();
		int valor2 = escolherValor();
		int valor3 = escolherValor();
		int valor4 = escolherValor();
		while(true)
		{
			if(valor1 == valor2 && valor3 == valor4)
			{
				System.out.println("Resultado foi encontrado em " + numeroTentativas + " tentativas");	
				break;
			}
			valor1 = valor2;
			valor2 = valor3;
			valor3 = valor4;
			valor4 = escolherValor();
			numeroTentativas++;
			System.out.println(valor1 + " - " + valor2 + " - " + valor3 + " - " + valor4);
		}
	}
	
	public static void main(String[] args)
	{
		String pesoFace1 = "1/6";
		String pesoFace2 = "1/6";
		String pesoFace3 = "1/6";
		String pesoFace4 = "1/6";
		String pesoFace5 = "1/6";
		String pesoFace6 = "1/6";
		formatarProbabilidades(pesoFace1,pesoFace2,pesoFace3,pesoFace4,pesoFace5,pesoFace6);
		//lancarDado();
		tresLancamentosTresResultadosIguais();
		quatroLancamentosDoisParesSeguidos();
		
	}
}
