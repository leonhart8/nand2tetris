import java.util.LinkedList;

/**
 * An abstract class which defines an interface for translating
 * binary operation vm commands
 */
public abstract class CommandBinaryOp extends CommandArithmetic {

    /**
     * Constructor of the command binary op class, only has a name
     */
    public CommandBinaryOp(String name){
        super(name);
    }

    /**
     * Translates this binary operator command
     */
    public LinkedList<String> translate(){
        LinkedList<String> assembly = super.translate();
        assembly.add("@SP");
        assembly.add("AM=M-1");
        assembly.add("D=M");
        assembly.add("A=A-1");
        assembly.add("M=M"+this.getOp()+"D");
        return assembly;
    }

}