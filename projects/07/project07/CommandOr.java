/**
 * Class which defines translation of or commands in assembly
 */
public class CommandOr extends CommandBinaryOp {

    /**
     * Constructor of the and command 
     */
    public CommandOr(){
        super("or");
    }

    /**
     * Returns the and operator in assembly
     */
    public String getOp(){
        return "|";
    }

}