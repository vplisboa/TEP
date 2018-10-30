package Action;

import Action.algoritmos.trie.Trie;

public class Retangulo {
	public int altura;
	public int largura;
	public char[][] matriz;
	
	public Retangulo(int largura)
	{
		this.largura = largura;
	}
	
	public Retangulo(int largura, int altura, char[][] palavras)
	{
		this.largura = palavras[0].length;
		this.altura = palavras.length;
		matriz = palavras;
	}
	
	public char getLetra(int linha, int coluna)
	{
		return matriz[linha][coluna];
	}
	
	public String getColuna(int coluna)
	{
		char[] colunas = new char[altura];
		for (int i = 0 ; i<altura; i++)
		{
			colunas[i] = getLetra(i,coluna);
		}
		return new String(colunas);
	}
	
	public boolean estaCompleto(int largura, int altura, GrupoPalavras grupoPalavras)
	{
		if(this.altura == altura)
		{
			for(int i = 0; i<largura ; i++)
			{
				String coluna = getColuna(i);
				if(!grupoPalavras.temPalavra(coluna))
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean ehValido(int largura, Trie trie)
	{
		if(altura == 0)
		{
			return true;
		}
		
		for(int i = 0; i<largura ; i++)
		{
			String coluna = getColuna(i);
			if(!trie.procurarPrefixo(coluna));
			{
				return false;
			}
		}
		return true;
	}
	
	public Retangulo adicionar(String palavra)
	{
		if(palavra.length() == largura)
		{
			char[][] novoRetangulo = new char[altura+1][largura];
			for(int i = 0 ; i < altura ; i++)
			{
				for(int j = 0 ; j < largura ; j++)
				{
					novoRetangulo[i][j] = matriz[i][j];
				}
			}
			palavra.getChars(0, largura, novoRetangulo[altura],0);
			return new Retangulo(largura,altura+1,novoRetangulo);
		}
		return null;
	}
	
	public void mostrarRetangulo()
	{
		int area = largura * altura;
		for(int i = 0; i < altura ; i++)
		{
			for (int j = 0; j < largura ; j++)
			{
				System.out.println(matriz[i][j]);
			}
		}
		System.out.println("O maior retangulo tem area: " + area);
	}
}
