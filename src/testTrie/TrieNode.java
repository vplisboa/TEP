package testTrie;

import java.util.HashMap;

public class TrieNode
{
	private HashMap<Character, TrieNode> filho;
	private boolean fimDaPalavra = false;

	private char character;

	public TrieNode() {
		filho = new HashMap<Character, TrieNode>();
	}

	public TrieNode(char character) {
		this();
		this.character = character;
	}

	public char getChar()
	{
		return character;
	}

	public void adicionarPalavra(String palavra)
	{
		if (palavra == null || palavra.isEmpty())
		{
			return;
		}

		char primeiroCharactere = palavra.charAt(0);

		TrieNode filho = getChild(primeiroCharactere);
		if (filho == null)
		{
			filho = new TrieNode(primeiroCharactere);
			this.filho.put(primeiroCharactere, filho);
		}

		if (palavra.length() > 1)
		{
			filho.adicionarPalavra(palavra.substring(1));
		}
		else
		{
			filho.setFimDaPalavra(true);
		}
	}

	public TrieNode getChild(char c)
	{
		return filho.get(c);
	}

	public boolean isFimDaPalavra()
	{
		return fimDaPalavra;
	}

	public void setFimDaPalavra(boolean fimDaPalavra)
	{
		this.fimDaPalavra = fimDaPalavra;
	}

}
