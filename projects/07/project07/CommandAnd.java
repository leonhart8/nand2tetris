/**
 * Class which defines translation of and commands in assembly
 */
public class CommandAnd extends CommandBinaryOp {

    /**
     * Constructor of the and command 
     */
    public CommandAnd(){
        super("and");
    }

    /**
     * Returns the and operator in assembly
     */
    public String getOp(){
        return "&";
    }

}