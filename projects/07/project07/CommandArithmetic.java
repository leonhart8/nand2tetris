import java.util.LinkedList;

/**
 * An abstract class which defines a common interface for arithmetic
 * commands
 */
public abstract class CommandArithmetic implements Command {

    // Name of the arithmetic command
    protected String name;

    /**
     * Constructor an arithmetic command, only requires a name
     */
    public CommandArithmetic(String name){
        this.name = name;
    }

    /**
     * Builds a comment for this arithmetic command
     */
    public String getComment(){
        return "// " + this.name;
    }

    /**
     * Returns the operator used by the arithmetic command in assembly
     */
    public abstract String getOp();

    /**
     * Method used to translate this arithmetic command, abstract for now
     */
    public LinkedList<String> translate(){
        LinkedList<String> assembly = new LinkedList<String>();
        assembly.add(this.getComment());
        return assembly;
    }

}