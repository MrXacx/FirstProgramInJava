package FirstProgramInJava.components; // define pacote filho
import FirstProgramInJava.components.IO; // importa classe-mãe de arquivo-irmão
import java.io.IOException; // importa exceção especial de I/O
import java.text.DecimalFormat;
public class Calculator extends IO{ // classe herdeira de IO
	private final int MIN_CALCULABLE = 1; // piso de cálculo
	private final int MAX_CALCULABLE = 10; // teto de cálculo
    public String results = "";
    private DecimalFormat formatter;
    public Calculator() throws IOException{ // método construtor
		super(); // executa construtor de classe-mãe
		super.init(); // executa método init da classe-mãe
		formatter = new DecimalFormat("#.##");
    }
    public void execute() {
        switch(super.operator){ // define a operação desejada
            case "+":
                this.addition();
                break;
            case "-":
                this.subtraction();
                break;
            case "x":
                this.multiplication();
                break;
            case "/":
                this.division();
                break;
        }
    }
    private void addition(){
        for(int count=MIN_CALCULABLE; count<=MAX_CALCULABLE; count++){
            this.results += this.number + " + " + count + " = " + formatter.format(this.number+count) +"\n";
        }
    }
    private void subtraction(){
        for(int count=MIN_CALCULABLE; count<=MAX_CALCULABLE; count++){
            this.results += formatter.format(this.number+count) + " - " + this.number + " = " + count  +"\n";
        }
    }
    private void multiplication(){
        for(int count=MIN_CALCULABLE; count<=MAX_CALCULABLE; count++){
            this.results += this.number + " x " + count + " = " + formatter.format(this.number*count) +"\n";
        }
    }
    private void division(){
        for(int count=MIN_CALCULABLE; count<=MAX_CALCULABLE; count++){
            this.results += formatter.format(this.number*count) + " / " + this.number + " = " + count  +"\n";
        }
    }
}
