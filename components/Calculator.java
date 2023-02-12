package FirstProgamInJava.components; // define pacote filho
import FirstProgamInJava.components.IO; // importa classe-mãe de arquivo-irmão
import java.io.IOException; // importa exceção especial de I/O
public class Calculator extends IO{ // classe herdeira de IO
	private final int MIN_CALCULABLE = 0; // piso de cálculo
	private final int MAX_CALCULABLE = 10; // teto de cálculo
    private double[] results = new double[11];
    protected String operator;
    public Calculator() throws IOException{ // método construtor
		super(); // executa construtor de classe-mãe
		super.init(); // executa método init da classe-mãe
    }
    public void execute() {
        switch(super.operator){ // define a operação desejada
            case "+":
                this.sum();
                break;
            case "-":
                this.sub();
                break;
            case "x":
                this.mult();
                break;
            case "/":
                this.div();
                break;
        }
    }
    private void sum(){ // soma
        for(int count=MIN_CALCULABLE; count<=MAX_CALCULABLE; count++){
            this.results[count] = super.number + count;
        }
    }
    private void sub(){ // subtração
        for(int count=MIN_CALCULABLE; count<=MAX_CALCULABLE; count++){
            this.results[count] = super.number - count;
        }
    }
    private void mult(){ // multiplicação
        for(int count=MIN_CALCULABLE; count<=MAX_CALCULABLE; count++){
            this.results[count] = super.number * count ;
        }
    }
    private void div(){ // divisão
    	this.results = new double[10]; // redimensiona array ( não existe n/0)
        for(int count=MIN_CALCULABLE+1; count<=MAX_CALCULABLE; count++){
            this.results[count-1] = super.number / count;
        }
    }
    public void printResults(){
    	super.output.print("\n\n");
    	int count = super.operator == "/" ? 1 : 0; // define início da contagem
    	for(double result : this.results){ // itera array como foreach()
    		super.output.println(super.number+" "+super.operator+" "+count+" = "+ super.decFormat.format(result));
    		 count++;
    	}
    }
}
