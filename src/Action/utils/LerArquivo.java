package Action.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo {
	
	private final String nomeArquivo = "src/Action/utils/dataset.txt";
	
	private List<String> dataset = new ArrayList<String>();
	
	public LerArquivo() {
		String linha = null;
		try {
			FileReader arquivo = new FileReader(nomeArquivo);
			 BufferedReader bufferedReader = new BufferedReader(arquivo);
			 while((linha = bufferedReader.readLine()) != null) {
	                dataset.add(linha);
	            }   
	            bufferedReader.close();     
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getDataset() {
		return dataset;
	}

	public void setDataset(List<String> dataset) {
		this.dataset = dataset;
	}
}
