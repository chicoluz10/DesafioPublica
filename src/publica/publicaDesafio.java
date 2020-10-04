package publica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class publicaDesafio {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int x = -1;
		int a = 0;
		int jogo = 0;
		ArrayList<Integer> placares = new ArrayList<Integer>();
		ArrayList<Integer> recordes = new ArrayList<Integer>();
		ArrayList<Integer> tabela = new ArrayList<Integer>();
		int minScore = 0;
		int maxScore = 0;
		
		while (a != 2) {
			System.out.println();
			System.out.println("Selecione o que voc� deseja fazer: (0 - Inserir; 1 - Consultar; 2 - Sair)");
			a = input.nextInt();
			switch (a) {
				/* No case 0, � onde o placar � definido e
				 * as informa��es s�o adicionadas na tabela */
				case 0: {
					System.out.println("Por favor inserir valor.");
					int placar = input.nextInt(); // usuario insere o valor
					placares.add(placar); // adiciona o valor no ArrayList placares
					tabela.add(jogo + 1); // adiciona o numero na tabela
					tabela.add(placar); // adiciona o placar na tabela
					if (minScore(placares) == placar) { // se for o menor valor at� ent�o, adiciona esse valor na tabela
						tabela.add(placar);
						minScore = placar;
					}
					else {
						tabela.add(minScore); // se n�o for, adiciona o antigo menor numero
					}
					if (maxScore(placares) == placar) { // se for o maior valro at� ent�o, adiciona esse valor na tabela
						tabela.add(placar);
						recordes.add(placar);
						maxScore = placar;
						x++;
					}
					else {
						tabela.add(maxScore); // se n�o for, adiciona o antigo maior numero
					}
					if (recordes.get(0) != null) { // define o numero minimo de quebra de recordes
						tabela.add(1);
					}
					if (recordes.get(x) != null) { // define o numero maximo de quebra de recordes
						tabela.add(x + 1);
					}
					
					
					jogo++;
					break;
				}
				case 1: {
					printTabela(tabela);
				}
			}
		}
	}
	
	/***
	 * Esse m�todo recebe o parametro arr, que � qualquer ArrayList<Integer>
	 * e assim, o m�todo traz qual � o maior n�mero desse ArrayList.
	 * @param arr
	 * @return
	 */
	private static int maxScore(ArrayList<Integer> arr){	
		return Collections.max(arr);
	}
	
	/***
	 * Esse m�todo recebe o parametro arr, que � qualquer ArrayList<Integer>
	 * e assim, o m�todo traz qual � o menor n�mero desse ArrayList.
	 * @param arr
	 * @return
	 */
	private static int minScore(ArrayList<Integer> arr) {
		return Collections.min(arr);
	}
	
	/***
	 * Esse m�todo recebe o parametro arr, que � qualquer ArrayList<Integer>
	 * e assim, o m�todo transforma o ArrayList em Array, e print os indices
	 * do array, de forma coerente e de facil leitura.
	 * @param arr
	 * @return
	 */
	private static void printTabela(ArrayList<Integer> arr) {
		int a[] = new int[arr.size()];
		for (int i = 0; i < a.length;  i++) {
				a[i] = arr.get(i);
		}
		for (int i = 0; i < a.length; i++) {
			if (i % 6 == 0) {
				System.out.println();
			}
			System.out.print(a[i]);
			System.out.print("|");
		}
	}
}
