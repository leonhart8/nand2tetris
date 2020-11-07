/**
 * Class which defines translation for greater than commands in assembly
 */
public class CommandGt extends CommandCompare {

    /**
     * Constructor of this greater than command
     */
    public CommandGt(int jumpIfCompareSucceeds, int jumpIfCompareNotSucceed){
        super("gt", jumpIfCompareSucceeds, jumpIfCompareNotSucceed);
    }

    /**
     * Gets the equality checking operator in assembly
     */
    public String getOp(){
        return "JGT";
    }

}