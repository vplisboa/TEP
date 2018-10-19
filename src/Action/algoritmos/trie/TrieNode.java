package Action.algoritmos.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	private final Map<Character,TrieNode> filho = new HashMap<>();
	private boolean fimDaPalavra;
	
	public boolean isFimDaPalavra() {
		return fimDaPalavra;
	}
	public void setFimDaPalavra(boolean fimDaPalavra) {
		this.fimDaPalavra = fimDaPalavra;
	}
	public Map<Character, TrieNode> getFilho() {
		return filho;
	}
	
	
	
}
