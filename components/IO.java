package FirstProgamInJava.components; // define pacote-filho
import java.util.Scanner; // importa leitor de input (primitivo e String)
import java.text.DecimalFormat; // importa formatador de decimais
import java.util.Random; // importa classe de sorteio
import java.io.*; // importa todas as classes de I/O
public class IO {
	protected double number;
	protected String operator;
    private Scanner input; // objeto de leitura
    protected PrintStream output; // objeto de impressão
    protected DecimalFormat decFormat; // objeto de formatação decimal
    private final String[][] listOfOperators = { // operação suportadas e seus operadores
    	{"Soma","+"},
    	{"Subtração","-"},
    	{"Multilicação","x"},
    	{"Divisão","/"}
    };
    protected IOException NaN; // objeto de exceção de Not a Number
    protected IOException NaO; // objeto de exceção de Not an Operator
    protected IO (){ // inicia todos os objetos utéis
    	NaN = new IOException("Valor númerico inserido incorretamente");
    	NaO = new IOException("Operador inserido incorretamente");
    	this.input = new Scanner(System.in);
    	this.output = new PrintStream(System.out);
    	this.decFormat = new DecimalFormat("#.##");
    }
    protected void init() throws IOException{ // executa inputs
        this.setNumber();
        this.setOperator();
    }
    private final void setNumber() throws IOException{
        this.output.print("Digite um número: ");// lé tipos não primitivos (classe String)
        String number = this.input.nextLine().replaceAll(",","\\."); // substitui todos caracteres "," por "."
        if(this.isNumeric(number)){ // checa se valor inserido é um número
        	this.number = Double.parseDouble(number); // retorna valor convertido em double;
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
			if(item.intern() != "." && (item.compareTo("0")<0 && item.compareTo("9") > 0)){
				return false; // "5.25/2" não suportado
			}
		}
		return true;
    }
    private final void printOperators(){ // lista operadores
    	int index = 1;
    	for(String[] list : this.listOfOperators){ // itera array
    		this.output.println(index + " => "+ list[0]);
    		index++;
    	}
    	return;
    }
    private void setOperator() throws IOException{
		this.printOperators();
		this.output.print("Digite um operador: ");
		int index = 0;
		try{
			index = this.input.nextInt(); // lê chave identificadora
		}
		catch(Exception e){ // captura entrada de não int
			Random random = new Random();
			index = random.nextInt(4)+1;
			this.output.println("\nIdentificador não inteiro. Valor número aleatório definido = " +index+".");
		}
		finally{
			if(index > this.listOfOperators.length){ //checa se chave inesperada foi inserida
				throw NaO; // cria exceção
			}
			this.operator = this.listOfOperators[index-1][1]; // define operador
		}
	}
}
