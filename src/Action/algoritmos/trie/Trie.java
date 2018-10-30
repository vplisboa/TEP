package Action.algoritmos.trie;

import java.util.List;

public class Trie {
	private TrieNode raiz;
	
	public Trie(List<String> listaPalavras)
	{
		raiz = new TrieNode();
		for (String palavra : listaPalavras) 
		{
			raiz.adicionarPalavra(palavra);
		}
	}
	
	public boolean procurarPrefixo(String prefixo)
	{
		TrieNode atual = raiz;
		for(int i = 0; i<prefixo.length();i++)
		{
			char caractere = prefixo.charAt(i);
			TrieNode no = atual.getFilho(caractere);
			if(no == null)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean procurarPalavra(String palavra)
	{
		TrieNode atual = raiz;
		for(int i = 0; i<palavra.length();i++)
		{
			char caractere = palavra.charAt(i);
			TrieNode no = atual.getFilho(caractere);
			if(no == null)
			{
				return false;
			}
			atual = no;
		}
		
		return false || atual.isFimDaPalavra();
	}

	public TrieNode getRaiz() {
		return raiz;
	}
	
}
