package Action.algoritmos.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	private final Map<Character, TrieNode> filho;
	private boolean fimDaPalavra;
	private char character;

	public TrieNode()
	{
		filho = new HashMap<Character, TrieNode>();
	}
	
	public TrieNode(char character) {
		this();
		this.character = character;
	}

	public char getChar() {
		return character;
	}

	public void adicionarPalavra(String palavra) {
		if (palavra == null || palavra.isEmpty()) {
			return;
		}

		char firstChar = palavra.charAt(0);

		TrieNode child = getFilho(firstChar);
		if (child == null) {
			child = new TrieNode(firstChar);
			filho.put(firstChar, child);
		}

		if (palavra.length() > 1) {
			child.adicionarPalavra(palavra.substring(1));
		} else {
			child.setFimDaPalavra(true);
		}
	}
	
	public TrieNode getFilho(char c) {
    	return filho.get(c);
}

	public boolean isFimDaPalavra() {
		return fimDaPalavra;
	}

	public void setFimDaPalavra(boolean fimDaPalavra) {
		this.fimDaPalavra = fimDaPalavra;
	}
}
