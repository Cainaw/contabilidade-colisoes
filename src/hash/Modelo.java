package hash;

import java.util.List;

public interface Modelo {
	public int calculoColisoes(List<Integer> lista);
	public int calculoIndice(Integer valor, int tamanho);
}
