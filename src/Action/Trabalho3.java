package Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Trabalho3 {
	public static final List<String> LISTA_VOGAIS = Collections
			.unmodifiableList(Arrays.asList("a", "e", "i", "o", "u"));

	public static void main(String[] args) {
		String palavra = "paraguai";
		List<String> listaLetras = popularListaLetras(palavra);
		gerarAnagramas(listaLetras, "");
	}

	public static void gerarAnagramas(List<String> letrasDisponiveis, String palavra) {
		if (letrasDisponiveis.size() == 0) {
			System.out.println(palavra);
		}

		for (String letra : letrasDisponiveis) {
			palavra += letra;
			if (validaString(palavra)) {
				List<String> novaLista = new ArrayList<String>(letrasDisponiveis);
				int index = novaLista.indexOf(letra);
				novaLista.remove(index);
				gerarAnagramas(novaLista, palavra);
			}
			palavra = palavra.substring(0, palavra.length()-1);
		}
	}

	public static boolean validaString(String palavra) {
		if (verificarComecaComVogal(palavra) || verificarLetrasIguaisConsecutivas(palavra)
				|| !verificarOcorrenciaLetraPAntesDeG(palavra) || verificarTresConsoantesJuntas(palavra)) {
			return false;
		}
		return true;
	}

	public static List<String> popularListaLetras(String palavra) {

		List<String> listaLetras = new ArrayList<String>();
		
		for (char letra : palavra.toCharArray()) {
			listaLetras.add(String.valueOf(letra));
		}
		
		return listaLetras;
	}

	public static boolean verificarComecaComVogal(String palavra) {
		
		String charInicial = String.valueOf(palavra.charAt(0));
		
		if (LISTA_VOGAIS.contains(charInicial)) {
			return true;
		}
		return false;
	}

	public static boolean verificarTresConsoantesJuntas(String palavra) {
		
		String charAtual = "";
		int contadorConsoantes = 0;
		
		for (int i = 0; i < palavra.length(); i++) {
			charAtual = String.valueOf(palavra.charAt(i));
		
			if (!LISTA_VOGAIS.contains(charAtual)) {
				contadorConsoantes++;
			
				if (contadorConsoantes == 3) {
					return true;
				}
			}
			else {
				contadorConsoantes = 0;
			}
		}
		return false;
	}

	public static boolean verificarOcorrenciaLetraPAntesDeG(String palavra) {
		String charAtual = "";
		List<Integer> aparicoesP = new ArrayList<Integer>();
		List<Integer> aparicoesG = new ArrayList<Integer>();

		for (int i = 1; i < palavra.length() + 1; i++) {
			charAtual = String.valueOf(palavra.charAt(i - 1));
			
			if (charAtual.equals("p")) {
				aparicoesP.add(new Integer(i));
			} 
			else if (charAtual.equals("g")) {
				aparicoesG.add(new Integer(i));
			}
		}

		if(aparicoesG.isEmpty() && aparicoesP.isEmpty())
			return true;
		
		else if (aparicoesG.isEmpty() || aparicoesP.isEmpty() || aparicoesP.get(0) < aparicoesG.get(0)) {
			return true;
		}

		return false;
	}

	public static boolean verificarLetrasIguaisConsecutivas(String palavra) {
		String charAtual = "";
		String charAnterior = "";

		for (int i = 0; i < palavra.length(); i++) {
			charAnterior = charAtual;
			charAtual = String.valueOf(palavra.charAt(i));

			if (charAtual.equals(charAnterior)) {
				return true;
			}
		}
		return false;
	}

}