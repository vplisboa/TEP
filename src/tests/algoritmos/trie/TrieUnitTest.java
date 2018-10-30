package tests.algoritmos.trie;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Action.algoritmos.trie.Trie;

public class TrieUnitTest 
{

	protected Trie prePopularTrie()
	{
		Trie trie = new Trie();
		trie.adicionar("topicos");
		trie.adicionar("especiais");
		trie.adicionar("em");
		trie.adicionar("programacao");
		
		return trie;
	}
	
	@Test
	public void testAdicionar_dadaUmaTrie_deveRetornarQueNaoEstaVazia()
	{
		Trie trie = prePopularTrie();
		assertFalse(trie == null);
	}
	
	@Test
	public void testProcurarNo_dadaUmaTrie_deveRetornarSeElementoExisteOuNao()
	{
		Trie trie = prePopularTrie();
		
		assertTrue(trie.procurarNo("topicos"));
		assertTrue(trie.procurarNo("especiais"));
		assertTrue(trie.procurarNo("em"));
		
		assertFalse(trie.procurarNo("so"));
		assertFalse(trie.procurarNo("testando"));
	}
}
