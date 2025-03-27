package analise;

import java.util.List;

import hash.*;
import util.VetorRandomico;

public class Resultado {

	public static void main(String[] args) {
		VetorRandomico vr = new VetorRandomico();
		vr.setLista(1000);
		List<Integer> listaGerada = vr.getLista();
		
		Dobra dobra = new Dobra();
		Murmur murmur = new Murmur();
		
		int colisoesDobra = dobra.calculoColisoes(listaGerada);
		int colisoesMurmur = murmur.calculoColisoes(listaGerada);
		
		//int colisoes = dobra.calculoColisoes(listaGerada);
		
		System.out.println("Total: ");
		System.out.println("Dobra: " + colisoesDobra);
		System.out.println("Murmur: " + colisoesMurmur);
		
	}

}
