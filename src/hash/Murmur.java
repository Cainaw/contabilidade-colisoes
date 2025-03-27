package hash;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Murmur implements Modelo {
	public int calculoColisoes(List<Integer> lista) {
		if (lista != null) {
			Set<Integer> listaTeste = new HashSet<>();
			String indice = String.valueOf(lista.size());
            int tamanho = indice.length() - 1;
			
			int contador = 0;
			for (Integer valor : lista) {
				if (!listaTeste.add(calculoIndice(valor, tamanho)))
					contador++;
			}
			return contador;
		}
		return -1;
	}
	
	public int calculoIndice(Integer valor, int tamanho) {
		if (valor == null)
			return -1;
		
		byte [] data = new byte[4];
		data[0] = (byte) (valor & 0xFF);
		data[1] = (byte) ((valor >> 8) & 0xFF);
		data[2] = (byte) ((valor >> 16) & 0xFF);
		data[3] = (byte) ((valor >> 24) & 0xFF);
		
		final int CONST1 = 0xcc9e2d51;
		final int CONST2 = 0x1b873593;
		final int ROL1 = 15;
		final int ROL2 = 13;
		final int MULT = 5;
		final int SOMA = 0xe6546b64;
		
		int semente = new Random().nextInt(1000000);
		
		int i = 0;
		while (i + 4 <= data.length) {
			int bloco = ((data[i] & 0xFF) | ((data[i+1] & 0xFF) << 8) | ((data[i+2] & 0xFF) << 16) | ((data[i+3] & 0xFF) << 24));
			i += 4;
			
			bloco *= CONST1;
			bloco = Integer.rotateLeft(bloco, ROL1);
			bloco *= CONST2;
			
			semente ^= bloco;
			semente = Integer.rotateLeft(semente, ROL2);
			semente *= MULT + SOMA;
		}
		semente ^= data.length;
		semente = mixagem(semente) % (int) Math.pow(10, tamanho);
		
		if (semente < 0)
			semente = -semente;
		
		return semente;
	}
	
	private int mixagem(int semente) {
		semente ^= semente >>> 16;
		semente *= 0x85ebca6b;
		semente ^= semente >>> 13;
		semente *= 0xc2b2ae35;
		semente ^= semente >>> 16;
		return semente;
	}
}
