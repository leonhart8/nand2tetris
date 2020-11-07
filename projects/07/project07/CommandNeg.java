/**
 * A class which defines the translation of negation commands in assembly
 */
public class CommandNeg extends CommandUnaryOp {

    /**
     * Constructor of a negation command
     */
    public CommandNeg(){
        super("neg");
    }

    /**
     * Returns the operator of this negation command
     */
    public String getOp(){
        return "-";
    }

}