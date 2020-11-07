/**
 * Class which handles the writing of assemby code which retrieves an element
 * from the this segment and pushes it to the top of the stack
 */
public class CommandPushThis extends CommandPushToSegmentRef {

    /**
     * Constructor of a push local command 
     */
    public CommandPushThis(String index){
        super("this", index);
    }

    /**
     * Gets the reference to the segment from which to push
     */
    public String getSegmentRef(){
        return "THIS";
    }

}