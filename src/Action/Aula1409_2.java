package Action;
/* 
 * Trabalho 2 - SubGrupos, de tamanho k, de um conjunto de tamanho n
 * TEP 2018.2
 * Victor Pedro Rodrigues Lisboa
 * 113102692
 * */

public class Aula1409_2 {

	public static void main(String[] args) 
	{
		int n = 8;//tamanho do conjunto
		int k = 4; // tamanho dos subgrupos
		int conjunto[] = popularLista(n);
		int subGrupos[] = new int[k];

		combinacao(conjunto, subGrupos, 0, n - 1, 0, k);

	}

	protected static void combinacao(int conjunto[], int data[], int numeroInicio, int ultimoNumero,
											int index, int tamanhoSubconjunto) 
	{
		if (index == tamanhoSubconjunto) 
		{
			for (int j = 0; j < tamanhoSubconjunto; j++)
			{
				System.out.print(data[j] + " ");
			}
			System.out.println("");
			return;
		}

		for (int i = numeroInicio; i <= ultimoNumero && ultimoNumero - i + 1 >= tamanhoSubconjunto - index; i++) 
		{
			data[index] = conjunto[i];
			combinacao(conjunto, data, i + 1, ultimoNumero, index + 1, tamanhoSubconjunto);
		}
	}
	
	protected static int[] popularLista(int n)
	{
		int[] resultado = new int[n];
		for(int i=1; i<=n;i++)
		{
			resultado[i-1] = i;
		}
		return resultado;
	}
}