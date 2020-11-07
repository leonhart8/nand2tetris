/**
 * Class which defines translation for equality commands in assembly
 */
public class CommandEq extends CommandCompare {

    /**
     * Constructor of this equality command
     */
    public CommandEq(int jumpIfCompareSucceeds, int jumpIfCompareNotSucceed){
        super("eq", jumpIfCompareSucceeds, jumpIfCompareNotSucceed);
    }

    /**
     * Gets the equality checking operator in assembly
     */
    public String getOp(){
        return "JEQ";
    }

}