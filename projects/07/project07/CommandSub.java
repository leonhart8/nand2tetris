/**
 * Class which defines translation of substraction commands in assembly
 */
public class CommandSub extends CommandBinaryOp {

    /**
     * Constructor of the substraction command 
     */
    public CommandSub(){
        super("sub");
    }

    /**
     * Returns the substraction operator in assembly
     */
    public String getOp(){
        return "+";
    }

}