package testTrie;

public class Retangulo
{

	public int altura;
	public int largura;
	public char[][] matriz;

	public Retangulo(int len) {
		this.largura = len;
	}

	public Retangulo(int largura, int altura, char[][] letras) {
		this.altura = letras.length;
		this.largura = letras[0].length;
		matriz = letras;
	}

	public char getLetra(int i, int j)
	{
		return matriz[i][j];
	}

	public String getColuna(int i)
	{
		char[] coluna = new char[altura];
		for (int j = 0; j < altura; j++)
		{
			coluna[j] = getLetra(j, i);
		}
		return new String(coluna);
	}

	public boolean estaCheio(int largura, int altura, GrupoPalavras listaGrupos)
	{
		if (this.altura == altura)
		{
			for (int i = 0; i < largura; i++)
			{
				String coluna = getColuna(i);
				if (!listaGrupos.contemPalavra(coluna))
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
		if (altura == 0)
		{
			return true;
		}
		for (int i = 0; i < largura; i++)
		{
			String coluna = getColuna(i);
			if (!trie.contemPrefixo(coluna))
			{
				return false;
			}
		}
		return true;
	}

	public Retangulo adicionar(String palavra)
	{
		if (palavra.length() == largura)

		{
			char retangulo[][] = new char[altura + 1][largura];
			for (int i = 0; i < altura; i++)
			{
				for (int j = 0; j < largura; j++)
				{
					retangulo[i][j] = matriz[i][j];
				}
			}
			palavra.getChars(0, largura, retangulo[altura], 0);

			return new Retangulo(largura, altura + 1, retangulo);
		}
		return null;
	}

	public void mostrarRetangulo()
	{
		int area = altura * largura;
		for (int i = 0; i < altura; i++)
		{
			for (int j = 0; j < largura; j++)
			{
				System.out.print(matriz[i][j]);
			}
			System.out.println("");
		}
		System.out.println("maior retangulo de area: " + area);
	}
}
