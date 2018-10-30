package Action;

import java.util.List;

import Action.algoritmos.trie.Trie;
import Action.utils.LerArquivo;

public class WordRectangle 
{

	private int tamanhoMaiorPalavra;
	private GrupoPalavras[] grupos;
	private Trie trielist[];

	public WordRectangle(List<String> dataset) 
	{
		grupos = GrupoPalavras.criarGrupos(dataset);
		tamanhoMaiorPalavra = grupos.length;
		trielist = new Trie[tamanhoMaiorPalavra];
	}
	
	public Retangulo maiorRetangulo()
	{
		int maiorTamanho = tamanhoMaiorPalavra * tamanhoMaiorPalavra;
		for(int i = maiorTamanho ; i > 0 ; i--)
		{
			for(int j = 1; j < tamanhoMaiorPalavra ; j++ )
			{
				System.out.println("Montando retangulo");
				if(i % j == 0)
				{
					int razao = i / j;
					if(razao <= tamanhoMaiorPalavra)
					{
						Retangulo retangulo = montarRetangulo(j,razao);
						if(retangulo != null)
						{
							return retangulo;
						}
					}
				}
			}
		}
		return null;
	}
	
	private Retangulo montarRetangulo(int largura, int altura) {
		if(grupos[largura - 1] == null || grupos[altura -1 ] == null)
		{
			return null;
		}
		if(trielist[altura - 1] == null)
		{
			List<String> palavras = grupos[altura - 1].getPalavras();
			trielist[altura - 1] = new Trie(palavras);
		}
		return tentarMontarRetangulo(largura, altura, new Retangulo(largura));
	}

	private Retangulo tentarMontarRetangulo(int largura, int altura, Retangulo retangulo) {
		if(retangulo.altura == altura)
		{
			if(retangulo.estaCompleto(largura, altura, grupos[altura - 1]))
			{
				return retangulo;
			}
			else
			{
				return null;
			}
		}
		if(!retangulo.ehValido(largura, trielist[altura - 1]))
		{
			return null;
		}
		
		for(int i = 0; i < grupos[largura - 1].tamanho(); i++)
		{
			Retangulo retanguloAvalidar = retangulo.adicionar(grupos[largura-1].getPalavra(i));
			Retangulo retanguloNovo = tentarMontarRetangulo(largura, altura, retanguloAvalidar);
			if(retanguloNovo != null)
			{
				return retanguloNovo;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		
		LerArquivo arquivo = new LerArquivo();
		List<String> dataset = arquivo.getDataset();
		
		WordRectangle wordRectangle = new WordRectangle(dataset);
		Retangulo retangulo = wordRectangle.maiorRetangulo();
		if(retangulo != null)
		{
			retangulo.mostrarRetangulo();
		}
		else
		{
			System.out.println("Nao eh possivel montar um retangulo com as palavras dadas");
		}
	}
}
