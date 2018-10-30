package testTrie;

import java.util.ArrayList;

public class Trie
{
	private TrieNode raiz;

	public Trie(ArrayList<String> palavras) {
		raiz = new TrieNode();
		for (String palavra : palavras)
		{
			raiz.adicionarPalavra(palavra);
		}
	}

	public Trie(String[] palavras) {
		raiz = new TrieNode();
		for (String palavra : palavras)
		{
			raiz.adicionarPalavra(palavra);
		}
	}

	public boolean contemNo(String prefix, boolean exact)
	{
		TrieNode lastNode = raiz;
		int i = 0;
		for (i = 0; i < prefix.length(); i++)
		{
			lastNode = lastNode.getChild(prefix.charAt(i));
			if (lastNode == null)
			{
				return false;
			}
		}
		return !exact || lastNode.isFimDaPalavra();
	}

	public boolean contemPrefixo(String prefix)
	{
		return contemNo(prefix, false);
	}

	public TrieNode getRoot()
	{
		return raiz;
	}
}
