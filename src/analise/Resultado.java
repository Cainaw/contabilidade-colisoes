package analise;

import java.util.List;

import hash.*;
import util.VetorRandomico;

public class Resultado {

	public static void main(String[] args) {
		VetorRandomico vr = new VetorRandomico(1000);
		List<Integer> listaGerada = vr.getLista();
		
		Dobra dobra = new Dobra();
		Murmur murmur = new Murmur();
		
		int colisoes = murmur.calculoColisoes(listaGerada);
		
		//int colisoes = dobra.calculoColisoes(listaGerada);
		
		System.out.println("Total: " + colisoes);
	}

}
