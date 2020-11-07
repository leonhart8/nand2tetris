/**
 * Class which handles the writing of assemby code which retrieves an element
 * from the that segment and pushes it to the top of the stack
 */
public class CommandPushThat extends CommandPushToSegmentRef {

    /**
     * Constructor of a push local command 
     */
    public CommandPushThat(String index){
        super("that", index);
    }

    /**
     * Gets the reference to the segment from which to push
     */
    public String getSegmentRef(){
        return "THAT";
    }

}