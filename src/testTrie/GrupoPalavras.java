package testTrie;

import java.util.ArrayList;
import java.util.HashMap;

public class GrupoPalavras
{
	private HashMap<String, Boolean> index = new HashMap<String, Boolean>();
	private ArrayList<String> grupos = new ArrayList<String>();

	public GrupoPalavras() 
	{

	}

	public boolean contemPalavra(String palavras)
	{
		return index.containsKey(palavras);
	}

	public void adicionarPalavra(String palavras)
	{
		grupos.add(palavras);
		index.put(palavras, true);
	}

	public int tamanho()
	{
		return grupos.size();
	}

	public String getPalavra(int i)
	{
		return grupos.get(i);
	}

	public ArrayList<String> getPalavras()
	{
		return grupos;
	}

	public static GrupoPalavras[] criarGrupoPalavras(String[] palavras)
	{
		GrupoPalavras[] listaGrupos;
		int tamanhoMaximoPalavras = 0;
		for (int i = 0; i < palavras.length; i++)
		{
			if (palavras[i].length() > tamanhoMaximoPalavras)
			{
				tamanhoMaximoPalavras = palavras[i].length();
			}
		}

		listaGrupos = new GrupoPalavras[tamanhoMaximoPalavras];
		for (int i = 0; i < palavras.length; i++)
		{
			int tamanhoPalavra = palavras[i].length() - 1;
			if (listaGrupos[tamanhoPalavra] == null)
			{
				listaGrupos[tamanhoPalavra] = new GrupoPalavras();
			}
			listaGrupos[tamanhoPalavra].adicionarPalavra(palavras[i]);
		}
		return listaGrupos;
	}
}
