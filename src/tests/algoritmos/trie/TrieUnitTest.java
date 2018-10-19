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
		trie.adicionar("Topicos");
		trie.adicionar("Especiais");
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
		
		assertTrue(trie.procurarNo("Topicos"));
		assertTrue(trie.procurarNo("Especiais"));
		assertTrue(trie.procurarNo("em"));
		
		assertFalse(trie.procurarNo("Em"));
		assertFalse(trie.procurarNo("so"));
		assertFalse(trie.procurarNo("testando"));
	}
}
