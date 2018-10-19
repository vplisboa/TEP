package Action.algoritmos.trie;

public class Trie {
	private TrieNode raiz;
	
	public Trie()
	{
		raiz = new TrieNode();
	}
	
	public void adicionar(String palavra)
	{
		TrieNode noAtual = raiz;
		for (int i = 0; i < palavra.length(); i++) 
		{
			noAtual = noAtual.getFilho().computeIfAbsent(palavra.charAt(i), c -> new TrieNode());
		}
		noAtual.setFimDaPalavra(true);
	}
	
	public boolean procurarNo(String palavra)
	{
		TrieNode atual = raiz;
		for(int i = 0; i<palavra.length();i++)
		{
			char caractere = palavra.charAt(i);
			TrieNode no = atual.getFilho().get(caractere);
			if(no == null)
			{
				return false;
			}
			atual = no;
		}
		return atual.isFimDaPalavra();
	}
}
