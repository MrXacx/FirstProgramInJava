package FirstProgramInJava.components; // define pacote-filho

import javax.swing.JOptionPane;
import java.util.Random; // importa classe de sorteio
import java.io.*; // importa todas as classes de I/O

public class IO {
	
	protected float number;
	protected String operator;
   
    private final String[][] listOfOperators = { // operação suportadas e seus operadores
    	{"Soma","+"},
    	{"Subtração","-"},
    	{"Multilicação","x"},
    	{"Divisão","/"}
    };
    private final String TITLE = "Tabuada";
    private static JOptionPane io;
    protected IOException NaN; // objeto de exceção de Not a Number
    protected IOException NaO; // objeto de exceção de Not an Operator
    protected IO (){ // inicia todos os objetos utéis
    	NaN = new IOException("Valor númerico inserido incorretamente");
    	NaO = new IOException("Operador inserido incorretamente");
    	io = new JOptionPane();
    }
    protected void init() throws IOException{ // executa inputs
        this.setNumber();
        this.setOperator();
    }
    public void print(String message){
    	io.showMessageDialog(null,message,TITLE,1);
    }
    private final void setNumber() throws IOException{
        String number = JOptionPane.showInputDialog(null,"Digite um número:", "Tabuada", 1);
        if(this.isNumeric(number)){ // checa se valor inserido é um número
        	this.number = Float.parseFloat(number.replaceAll(",","\\.")); // retorna valor convertido em double;
        	return;
        }
        throw NaN; // cria exceção em caso de number não númerico
    }
    private boolean isNumeric(String number){
    	if(number.split("\\.").length > 2){ // checa número de delimitadores adicionados
    		return false; //"5.3.2" não suportado
    	}
		for(String item : number.split("")){ // itera number
			//	valor definido no pool			String[] fora do intervalo 0-9
			if(item.equals("\\.") && (item.compareTo("0")<0 && item.compareTo("9") > 0)){
				return false; // "5.25/2" não suportado
			}
		}
		return true;
    }
    private final String printOperators(){ // lista operadores
    	int index = 1;
    	String message = "";
    	for(String[] list : this.listOfOperators){ // itera array
    		message += index + " --> "+ list[0] + "\n";
    		index++;
    	}
    	return message;
    }
    private void setOperator() throws IOException{
		int index=0;
		try{
			index = Integer.parseInt(JOptionPane.showInputDialog(null, this.printOperators()+"\nDigite um operador:",TITLE,1)); // lê chave identificadora
		}
		catch(Exception e){ // captura entrada de não int
			Random random = new Random();
			index = random.nextInt(4)+1;
			io.showMessageDialog(null,"Identificador não inteiro. Valor número aleatório definido = " +index+".", TITLE, 0);
		}
		finally{
			if(index > this.listOfOperators.length || index<=0){ //checa se chave inesperada foi inserida
				throw NaO; // cria exceção
			}
			this.operator = this.listOfOperators[index-1][1]; // define operador
		}
	}
}
