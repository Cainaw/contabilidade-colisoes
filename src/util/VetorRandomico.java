package util;

import java.util.List;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class VetorRandomico {
	private List<Integer> lista;
	
	public VetorRandomico(Integer tamanho) {
		Random aleatorio = new Random();
		Set<Integer> listaTemporaria = new HashSet<>();
		
        while (listaTemporaria.size() < tamanho) {
            int valor = aleatorio.nextInt(tamanho * 10);
            listaTemporaria.add(valor);
        }
        
        lista = List.copyOf(listaTemporaria);
	}
	
	public List<Integer> getLista() {
		return this.lista;
	}
}