package util;

import java.util.List;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class VetorRandomico {
	private List<Integer> lista;
	
	public Boolean setLista(int tamanho) {
		if (tamanho <= 0)
			return false;
		if (tamanho >= Integer.MAX_VALUE)
			return null;
		
		Random aleatorio = new Random();
		Set<Integer> listaTemporaria = new HashSet<>();
		
        while (listaTemporaria.size() < tamanho) {
            int valor = aleatorio.nextInt(Integer.MAX_VALUE);
            listaTemporaria.add(valor);
        }
        
        lista = List.copyOf(listaTemporaria);
        return true;
	}
	
	public List<Integer> getLista() {
		return this.lista;
	}
}