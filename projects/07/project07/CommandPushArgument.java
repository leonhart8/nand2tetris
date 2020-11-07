/**
 * Class which handles the writing of assemby code which retrieves an element
 * from the argument segment and pushes it to the top of the stack
 */
public class CommandPushArgument extends CommandPushToSegmentRef {

    /**
     * Constructor of a push local command 
     */
    public CommandPushArgument(String index){
        super("argument", index);
    }

    /**
     * Gets the reference to the segment from which to push
     */
    public String getSegmentRef(){
        return "ARG";
    }

}