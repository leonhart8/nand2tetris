/**
 * A class which defines the translation of not commands in assembly
 */
public class CommandNot extends CommandUnaryOp {

    /**
     * Constructor of a not command
     */
    public CommandNot(){
        super("not");
    }

    /**
     * Returns the operator of this not command
     */
    public String getOp(){
        return "!";
    }

}