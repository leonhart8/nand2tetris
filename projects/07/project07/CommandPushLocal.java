/**
 * Class which handles the writing of assemby code which retrieves an element
 * from the local segment and pushes it to the top of the stack
 */
public class CommandPushLocal extends CommandPushToSegmentRef {

    /**
     * Constructor of a push local command 
     */
    public CommandPushLocal(String index){
        super("local", index);
    }

    /**
     * Gets the reference to the segment from which to push
     */
    public String getSegmentRef(){
        return "LCL";
    }

}