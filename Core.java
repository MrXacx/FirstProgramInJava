/*
	* Título: Tabuada
	* Autor: MrXacx (Ariel Santos)
	* Data de publicação: 12/02/2023 (DD/MM/YYYY)
	* Descrição: Este código receberá um valor numérico e uma operação matemática básica. Então, serão exibidas as contas entre o valor inserido e o intervalo [0-10]
	* Requisitos: Java 11.0.2
*/

package FirstProgramInJava; // define pacote raíz
import FirstProgramInJava.components.Calculator; // importa class de cálculo
import java.io.IOException; // importa exceção expeciaal de I/O
public class Core{ // núcleo de execução
	public static void main(String[] args){
		try{
			Calculator calculator = new Calculator();
			calculator.execute(); // executa cálculos
			calculator.print(calculator.results);
		}
		catch(Exception e){ // controla exceções
			System.out.print("\n\n*** " +e+" ***\n\n"); // exibe exceção
		}
	}
}
