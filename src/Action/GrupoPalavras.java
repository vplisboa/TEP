package Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrupoPalavras {

	private Map<String, Boolean> index = new HashMap<String,Boolean>(); 
	private List<String> grupo = new ArrayList<String>();
	
	public GrupoPalavras() {

	}
	
	public boolean temPalavra(String coluna) {
		return index.containsKey(coluna);
	}
	
	public void adicionar(String palavra)
	{
		grupo.add(palavra);
		index.put(palavra, true);
	}
	
	public int tamanho()
	{
		return grupo.size();
	}
	
	public String getPalavra(int i)
	{
		return grupo.get(i);
	}
	
	public List<String> getPalavras()
	{
		return grupo;
	}
	public static GrupoPalavras[] criarGrupos(List<String> palavras)
	{
		int maiorPalavra = procurarMaiorPalavra(palavras);
		GrupoPalavras[] grupo = new GrupoPalavras[maiorPalavra];
		for (int i = 0; i < palavras.size() ; i++) 
		{
			int tamanhoPalavra = palavras.get(i).length() - 1;
			if(grupo[tamanhoPalavra] == null)
			{
				grupo[tamanhoPalavra] = new GrupoPalavras();
			}
			grupo[tamanhoPalavra].adicionar(palavras.get(i));
		}
		return grupo;
	}

	private static int procurarMaiorPalavra(List<String> palavras) {
		int maiorPalavra = 0;
		for(int i = 0 ; i < palavras.size() ; i++)
		{
			if(palavras.get(i).length() > maiorPalavra)
			{
				String palavra = palavras.get(i);
				maiorPalavra = palavra.length();
			}
		}
		return maiorPalavra;
	}
	
}
