/**
 * Class which defines translation of add commands in assembly
 */
public class CommandAdd extends CommandBinaryOp {

    /**
     * Constructor of the add command 
     */
    public CommandAdd(){
        super("add");
    }

    /**
     * Returns the add operator in assembly
     */
    public String getOp(){
        return "+";
    }

}