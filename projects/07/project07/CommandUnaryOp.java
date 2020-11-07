import java.util.LinkedList;

/**
 * An abstract class which defines a common interface for unary
 * operator commands
 */
public abstract class CommandUnaryOp extends CommandArithmetic {

    /**
     * Constructor of a unary operator command, requires nothing other
     * than its name
     */
    public CommandUnaryOp(String name){
        super(name);
    }

    /**
     * Method used to translate this unary op command
     */
    public LinkedList<String> translate(){
        LinkedList<String> assembly = super.translate();
        assembly.add("@SP");
        assembly.add("A=M-1");
        assembly.add("M="+this.getOp()+"M");
        return assembly;
    }

}