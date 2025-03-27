package hash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Dobra implements Modelo {
    public int calculoColisoes(List<Integer> lista) {
    	// Caso a lista seja nula, retorna -1
    	if (lista != null) {
    		// Calcula o tamanho da dobra
            String indice = String.valueOf(lista.size());
            int tamanho = indice.length() - 1;
            
            // Cria uma lista que não aceita duplicatas
            Set<Integer> listaTeste = new HashSet<>();
            
            // Operação de contagem
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
    	
    	// Converte para string
        String numero = valor.toString();
        
        // Adiciona zeros à esquerda, de acordo com o tamanho EX: tam = 2, então 1 => 0001
        while (numero.length() < tamanho * 2)
        	numero = "0" + numero;
        
        // Caso o numero seja maior que o dobro do tamanho minimo EX: tam = 2, entao 12345 => 012345
        if (numero.length() % tamanho != 0) {
        	for (int i = 0, limite = tamanho - (numero.length() % tamanho); i < limite; i++)
        		numero = "0" + numero;
        }
         
        String total = "";
        while (numero.length() != tamanho) {
        	String valor1, valor2;
        	
        	// Pega os valores para soma EX: tam = 3, numero = 123456, valor1 = 321 e valor2 = 456
            valor1 = new StringBuilder(numero.substring(0, tamanho)).reverse().toString();
            valor2 = numero.substring(tamanho, 2 * tamanho);
            
            // Pega cada unidade e soma, depois adiciona ao total
            total = "";
            for (int i = 0, soma; i < tamanho; i++) {
                soma = Integer.parseInt(String.valueOf(valor1.charAt(i))) + Integer.parseInt(String.valueOf(valor2.charAt(i)));
                if (soma > 9) {
                    soma -= 10;
                }

                total += String.valueOf(soma);
            }

            numero = total + numero.substring(2 * tamanho);
        }
        return Integer.parseInt(numero);
    }
}