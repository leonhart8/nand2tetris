/**
 * Class which defines translation for less than commands in assembly
 */
public class CommandLt extends CommandCompare {

    /**
     * Constructor of this greater than command
     */
    public CommandLt(int jumpIfCompareSucceeds, int jumpIfCompareNotSucceed){
        super("lt", jumpIfCompareSucceeds, jumpIfCompareNotSucceed);
    }

    /**
     * Gets the equality checking operator in assembly
     */
    public String getOp(){
        return "JLT";
    }

}